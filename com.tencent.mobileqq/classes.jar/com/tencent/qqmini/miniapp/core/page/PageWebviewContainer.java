package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings.System;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.widget.MiniSwipeRefreshLayout;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, CoverView.JsRuntimeListener
{
  private static final int ACCELEROMETER_ROTATION_OPENED = 1;
  public static final String EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH = "onPullDownRefresh";
  public static final String TAG = "PageWebviewContainer";
  private boolean disableScroll = false;
  private boolean enableRefresh = false;
  private AbsAppBrandPage mBrandPage;
  private BrandPageWebview mBrandPageWebview;
  private IMiniAppContext mMiniAppContext;
  private NativeViewContainer mNaitveViewLayout;
  public int mNaitveViewScrollY = 0;
  private PageWebviewContainer.RotationObserver mRotationObserver;
  private MiniSwipeRefreshLayout mSwipeRefreshLayout;
  private String pageOrientation = WindowInfo.ORIENTATION_PORTRAIT;
  public int refreshStyleColor = -1;
  
  @Deprecated
  public PageWebviewContainer(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
  }
  
  public PageWebviewContainer(IMiniAppContext paramIMiniAppContext, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(paramIMiniAppContext.getContext());
    this.mBrandPage = paramAbsAppBrandPage;
    this.mMiniAppContext = paramIMiniAppContext;
    this.mNaitveViewLayout = new NativeViewContainer(paramIMiniAppContext, this);
    ViewCompat.setImportantForAccessibility(this.mNaitveViewLayout, 4);
    this.mSwipeRefreshLayout = new MiniSwipeRefreshLayout(getContext());
    this.mSwipeRefreshLayout.setOnRefreshListener(this);
    this.mSwipeRefreshLayout.setTouchSlop(100);
    addView(this.mSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    notifyChangePullDownRefreshStyle(this.refreshStyleColor);
    this.mRotationObserver = new PageWebviewContainer.RotationObserver(this);
    this.mRotationObserver.registerObserver();
  }
  
  private void handleDisableScrollBounce(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      if (localJSONObject.has("disable"))
      {
        AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.6(this, localJSONObject.optBoolean("disable", false), paramNativeViewRequestEvent));
        return;
      }
      QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
      paramNativeViewRequestEvent.fail("params error");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EVENT_DISABLE_SROLL_BOUNCE error,");
      localStringBuilder.append(localException);
      QMLog.e("PageWebviewContainer", localStringBuilder.toString());
      paramNativeViewRequestEvent.fail("params error");
    }
  }
  
  private void handleOpenDocument(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.5(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optString("filePath"), paramNativeViewRequestEvent));
      return;
    }
    catch (JSONException paramNativeViewRequestEvent)
    {
      paramNativeViewRequestEvent.printStackTrace();
    }
  }
  
  private void handlePageScrollTo(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      long l = ((JSONObject)localObject).optLong("duration", 300L);
      int i = (int)(DisplayUtil.getDensity(this.mMiniAppContext.getContext()) * ((JSONObject)localObject).optInt("scrollTop") + 0.5F);
      localObject = getCurrentPageWebview();
      if (localObject != null)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject).getView().getScrollY(), i }).setDuration(l);
        ((ValueAnimator)localValueAnimator).addUpdateListener(new PageWebviewContainer.3(this, (PageWebview)localObject));
        localValueAnimator.addListener(new PageWebviewContainer.4(this, paramNativeViewRequestEvent));
        localValueAnimator.start();
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("PageWebviewContainer", localException.getMessage(), localException);
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void handleStartPullDownRefresh(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.8(this, paramNativeViewRequestEvent));
  }
  
  private void handleStopPullDownRefresh(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new PageWebviewContainer.7(this, paramNativeViewRequestEvent));
  }
  
  private void parsePageConfigByUrl(String paramString)
  {
    Boolean localBoolean = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.enablePullDownRefresh;
    boolean bool;
    if (localBoolean == null) {
      bool = false;
    } else {
      bool = localBoolean.booleanValue();
    }
    this.enableRefresh = bool;
    this.pageOrientation = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.pageOrientation;
    paramString = getApkgInfo().getAppConfigInfo().getPageInfo(paramString);
    if (paramString != null)
    {
      localBoolean = paramString.windowInfo.enablePullDownRefresh;
      if (localBoolean == null) {
        bool = this.enableRefresh;
      } else {
        bool = localBoolean.booleanValue();
      }
      this.enableRefresh = bool;
      localBoolean = paramString.windowInfo.disableScroll;
      if (localBoolean == null) {
        bool = this.disableScroll;
      } else {
        bool = localBoolean.booleanValue();
      }
      this.disableScroll = bool;
      paramString = paramString.windowInfo.pageOrientation;
      if (!TextUtils.isEmpty(paramString)) {
        this.pageOrientation = paramString;
      }
    }
  }
  
  private void updateOrientation()
  {
    ContentResolver localContentResolver = this.mMiniAppContext.getAttachedActivity().getContentResolver();
    int i = 0;
    int j = Settings.System.getInt(localContentResolver, "accelerometer_rotation", 0);
    if ((WindowInfo.ORIENTATION_AUTO.equals(this.pageOrientation)) && (j == 1)) {
      i = 4;
    } else if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(this.pageOrientation)) {
      i = 1;
    }
    this.mMiniAppContext.getAttachedActivity().setRequestedOrientation(i);
  }
  
  public void addViewOnPage(View paramView)
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if (localAbsAppBrandPage != null) {
      localAbsAppBrandPage.addView(paramView);
    }
  }
  
  public void addViewOnPage(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if (localAbsAppBrandPage != null) {
      localAbsAppBrandPage.addView(paramView, paramLayoutParams);
    }
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mBrandPageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackFail(paramString, paramJSONObject);
      if (paramString != null) {
        paramString = paramString.toString();
      } else {
        paramString = "";
      }
      this.mBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mBrandPageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString != null) {
        paramString = paramString.toString();
      } else {
        paramString = "";
      }
      this.mBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void cleanUp()
  {
    Object localObject = this.mBrandPageWebview;
    if (localObject != null) {
      ((BrandPageWebview)localObject).cleanUp();
    }
    localObject = this.mNaitveViewLayout;
    if (localObject != null)
    {
      ((NativeViewContainer)localObject).destroy();
      this.mNaitveViewLayout.removeAllViews();
      this.mNaitveViewLayout = null;
    }
    localObject = this.mRotationObserver;
    if (localObject != null) {
      ((PageWebviewContainer.RotationObserver)localObject).unregisterObserver();
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    BrandPageWebview localBrandPageWebview = this.mBrandPageWebview;
    if (localBrandPageWebview != null) {
      localBrandPageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2)
  {
    BrandPageWebview localBrandPageWebview = this.mBrandPageWebview;
    if (localBrandPageWebview != null) {
      localBrandPageWebview.evaluateSubscribeJS(paramString1, paramString2, getWebViewId());
    }
  }
  
  public ApkgInfo getApkgInfo()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getMiniAppInfo() != null)) {
      return (ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo;
    }
    return null;
  }
  
  public Activity getAttachActivity()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      return localIMiniAppContext.getAttachedActivity();
    }
    return null;
  }
  
  public AppBrandPage getBrandPage()
  {
    return (AppBrandPage)this.mBrandPage;
  }
  
  public BrandPageWebview getBrandPageWebview()
  {
    return this.mBrandPageWebview;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getCurrentPageWebview();
    }
    return null;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public NativeViewContainer getNativeViewContainer()
  {
    return this.mNaitveViewLayout;
  }
  
  public int getNativeViewScrollY()
  {
    return this.mNaitveViewScrollY;
  }
  
  public NavigationBar getNaviBar()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getNaviBar();
    }
    return null;
  }
  
  public int getNaviBarHeight()
  {
    if (getNaviBar() != null) {
      return getNaviBar().getHeight();
    }
    return 0;
  }
  
  public String getPageOrientation()
  {
    return this.pageOrientation;
  }
  
  public int getWebViewId()
  {
    BrandPageWebview localBrandPageWebview = this.mBrandPageWebview;
    if ((localBrandPageWebview != null) && (localBrandPageWebview.getRealView() != null)) {
      return this.mBrandPageWebview.getRealView().getPageWebViewId();
    }
    return -1;
  }
  
  public boolean handleBackPressed()
  {
    NativeViewContainer localNativeViewContainer = this.mNaitveViewLayout;
    return (localNativeViewContainer != null) && (localNativeViewContainer.handleBackPressed());
  }
  
  public String handleNativeUIEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event = ");
    localStringBuilder.append(paramNativeViewRequestEvent.event);
    localStringBuilder.append(", params = ");
    localStringBuilder.append(paramNativeViewRequestEvent.jsonParams);
    QMLog.d("PageWebviewContainer", localStringBuilder.toString());
    if ("startPullDownRefresh".equals(paramNativeViewRequestEvent.event)) {
      handleStartPullDownRefresh(paramNativeViewRequestEvent);
    } else if ("stopPullDownRefresh".equals(paramNativeViewRequestEvent.event)) {
      handleStopPullDownRefresh(paramNativeViewRequestEvent);
    } else if ("disableScrollBounce".equals(paramNativeViewRequestEvent.event)) {
      handleDisableScrollBounce(paramNativeViewRequestEvent);
    } else if ("openDocument".equals(paramNativeViewRequestEvent.event)) {
      handleOpenDocument(paramNativeViewRequestEvent);
    } else if ("scrollWebviewTo".equals(paramNativeViewRequestEvent.event)) {
      handlePageScrollTo(paramNativeViewRequestEvent);
    }
    return null;
  }
  
  public boolean isCustomNavibar()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.isCustomNavibar();
    }
    return false;
  }
  
  public void notifyChangePullDownRefreshStyle(int paramInt)
  {
    this.refreshStyleColor = paramInt;
    this.mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(paramInt);
    if (paramInt == -1)
    {
      this.mSwipeRefreshLayout.setColorSchemeColors(new int[] { -16777216 });
      return;
    }
    this.mSwipeRefreshLayout.setColorSchemeColors(new int[] { -1 });
  }
  
  public void onCallbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramString, paramJSONObject, paramInt);
  }
  
  public void onCallbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventOK(paramString, paramJSONObject, paramInt);
  }
  
  public void onEvaluateSubscribeJS(String paramString1, String paramString2)
  {
    evaluateSubscribeJS(paramString1, paramString2);
  }
  
  public void onRefresh()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onPullDownRefresh", new JSONObject().toString(), getWebViewId()));
    }
  }
  
  public void refreshOrientation()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getAttachedActivity() != null) && (!this.mMiniAppContext.getAttachedActivity().isFinishing())) {
      updateOrientation();
    }
  }
  
  public void removeBrandPageWebview()
  {
    MiniSwipeRefreshLayout localMiniSwipeRefreshLayout = this.mSwipeRefreshLayout;
    if (localMiniSwipeRefreshLayout != null) {
      localMiniSwipeRefreshLayout.removeAllViews();
    }
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().removeSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void setBrandPageWebview(BrandPageWebview paramBrandPageWebview)
  {
    if (paramBrandPageWebview != null)
    {
      this.mBrandPageWebview = paramBrandPageWebview;
      if (this.mBrandPageWebview.getRealView() != null)
      {
        this.mBrandPageWebview.getRealView().addView(this.mNaitveViewLayout, new FrameLayout.LayoutParams(-1, -1));
        this.mSwipeRefreshLayout.addView(this.mBrandPageWebview.getRealView(), new ViewGroup.LayoutParams(-1, -1));
        this.mBrandPageWebview.getRealView().setOnWebviewScrollListener(new PageWebviewContainer.2(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    AbsAppBrandPage localAbsAppBrandPage = this.mBrandPage;
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.getRootContainer() != null)) {
      this.mBrandPage.getRootContainer().setSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void updateContainerConfig(String paramString)
  {
    if (getApkgInfo() != null)
    {
      parsePageConfigByUrl(paramString);
      paramString = this.mSwipeRefreshLayout;
      if (paramString != null) {
        paramString.setEnabled(this.enableRefresh);
      }
      if (this.disableScroll)
      {
        this.mBrandPageWebview.getRealView().setVerticalScrollBarEnabled(false);
        this.mBrandPageWebview.getRealView().setHorizontalScrollBarEnabled(false);
        if ((this.mBrandPageWebview.getRealView().getView() != null) && (this.mBrandPageWebview.getRealView().getView().getViewTreeObserver() != null) && (this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().isAlive())) {
          this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().addOnScrollChangedListener(new PageWebviewContainer.1(this));
        }
      }
      refreshOrientation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */