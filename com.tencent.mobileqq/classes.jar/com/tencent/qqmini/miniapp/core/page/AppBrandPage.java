package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.action.LoadSubPkgAppService;
import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;
import com.tencent.qqmini.miniapp.core.page.pool.PageWebviewPool;
import com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.Callback;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.NavigationBar.NavBarBackListener;
import com.tencent.qqmini.sdk.widget.TabBar;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements SwipeBackLayout.Callback, NavigationBar.NavBarBackListener
{
  public static final String TAG = "AppBrandPage";
  private FrameLayout centerLayout;
  private PageWebviewContainer mCurPageWebviewContainer;
  private IMiniAppContext mMiniAppContext;
  private NavigationBar mNavigationBar;
  private String mNavigationStyle = "default";
  private String mPageUrl;
  private PageWebviewContainer mPageWebviewContainer;
  private AppBrandPageContainer mRootContainer;
  private RelativeLayout mRootView;
  private TabBar mTabBar;
  private boolean mTabBarState = false;
  private Map<String, PageWebviewContainer> mTabPageCache;
  private MiniAIOEntranceProxy miniAIOEntryView;
  private ToastView toastView;
  
  public AppBrandPage(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
    this.mRootContainer = paramAppBrandPageContainer;
    init();
  }
  
  private ApkgInfo getApkgInfo()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getMiniAppInfo() != null)) {
      return (ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo;
    }
    return null;
  }
  
  private BrandPageWebview getBrandPageWebviewByUrl(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    if (!isTabBarPage())
    {
      if (paramString.equals(this.mPageUrl)) {
        return getBrandPageWebview();
      }
      return null;
    }
    String str = AppBrandUtil.getUrlWithoutParams(paramString);
    Iterator localIterator = this.mTabPageCache.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      paramString = localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!str.equals(localEntry.getKey()));
    paramString = localObject;
    if (localEntry.getValue() != null) {
      paramString = ((PageWebviewContainer)localEntry.getValue()).getBrandPageWebview();
    }
    return paramString;
  }
  
  private void handleLoadedPage(String paramString1, String paramString2, PageEventListener paramPageEventListener)
  {
    Iterator localIterator = this.mTabPageCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      PageWebviewContainer localPageWebviewContainer = (PageWebviewContainer)localEntry.getValue();
      if (((String)localEntry.getKey()).equals(paramString1))
      {
        if (localPageWebviewContainer.getParent() == null) {
          this.centerLayout.addView(localPageWebviewContainer, new FrameLayout.LayoutParams(-1, -1));
        }
        localPageWebviewContainer.setVisibility(0);
        this.mCurPageWebviewContainer = localPageWebviewContainer;
        if (isPageWebViewReady(paramString1)) {
          paramPageEventListener.onWebViewReady(paramString2, this.mPageUrl, this.mRootContainer.getShowingPageWebViewId());
        }
      }
      else
      {
        localPageWebviewContainer.setVisibility(8);
      }
    }
  }
  
  private void handleNewPage(String paramString1, String paramString2, PageEventListener paramPageEventListener, boolean paramBoolean)
  {
    this.mMiniAppContext.performAction(LoadSubPkgAppService.obtain(this.mPageUrl));
    Object localObject2 = this.mPageWebviewContainer;
    this.mPageWebviewContainer = null;
    this.mCurPageWebviewContainer = ((PageWebviewContainer)localObject2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new PageWebviewContainer(this.mMiniAppContext, this);
      this.mCurPageWebviewContainer = ((PageWebviewContainer)localObject1);
    }
    localObject2 = this.mRootContainer.getAppBrandPagePool().getPageWebviewPool().getAppBrandPage(this.mRootContainer);
    ((BrandPageWebview)localObject2).setWebViewEventListener(paramPageEventListener);
    ((BrandPageWebview)localObject2).setApkgInfo(getApkgInfo());
    ((BrandPageWebview)localObject2).loadUrl(paramString1, paramString2);
    ((PageWebviewContainer)localObject1).setBrandPageWebview((BrandPageWebview)localObject2);
    ((PageWebviewContainer)localObject1).updateContainerConfig(paramString1);
    if (((PageWebviewContainer)localObject1).getParent() == null) {
      this.centerLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    }
    if (paramBoolean) {
      this.mTabPageCache.put(AppBrandUtil.getUrlWithoutParams(paramString1), localObject1);
    }
  }
  
  private void handlePageScrollTo(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      long l = ((JSONObject)localObject).optLong("duration", 300L);
      int i = (int)(DisplayUtil.getDensity(getContext()) * ((JSONObject)localObject).optInt("scrollTop") + 0.5F);
      localObject = getCurrentPageWebview();
      if (localObject != null)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject).getView().getScrollY(), i }).setDuration(l);
        ((ValueAnimator)localValueAnimator).addUpdateListener(new AppBrandPage.2(this, (PageWebview)localObject));
        localValueAnimator.addListener(new AppBrandPage.3(this, paramNativeViewRequestEvent));
        localValueAnimator.start();
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandPage", localException.getMessage(), localException);
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void hideNavbarLoading(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new AppBrandPage.5(this, paramNativeViewRequestEvent));
  }
  
  private void hideRedDot(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.8(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("index", -1)));
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void hidetabbar(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.14(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optBoolean("animation", false), paramNativeViewRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_HIDE_TABBAR error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void init()
  {
    this.mTabPageCache = new HashMap();
    this.mPageWebviewContainer = new PageWebviewContainer(this.mMiniAppContext, this);
    this.mPageWebviewContainer.setContentDescription("PageWebviewContainer");
    this.centerLayout = new FrameLayout(getContext());
    this.centerLayout.setContentDescription("centerLayout");
    this.centerLayout.setBackgroundColor(-1);
    this.mNavigationBar = new NavigationBar(getContext());
    this.mNavigationBar.setContentDescription("NavigationBar");
    this.mNavigationBar.setId(R.id.mini_sdk_navigation_bar);
    this.mTabBar = new TabBar(getContext());
    this.mTabBar.setContentDescription("TabBar");
    this.mTabBar.setId(R.id.mini_sdk_tab_bar);
    this.mTabBar.setOnTabItemClickListener(this.mRootContainer);
    updateViewStyle(this.mNavigationStyle);
    setSwipeBackCallback(this);
  }
  
  private boolean isPageWebViewReady(String paramString)
  {
    paramString = getBrandPageWebviewByUrl(paramString);
    if (paramString != null) {
      return paramString.isReady();
    }
    return false;
  }
  
  private boolean isReadyLoadUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (this.mMiniAppContext != null) && (getApkgInfo() != null);
  }
  
  private boolean needCloseTopRightCapsule()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    boolean bool = true;
    int i;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getMiniAppInfo() != null) && (this.mMiniAppContext.getMiniAppInfo().appMode != null) && (this.mMiniAppContext.getMiniAppInfo().appMode.closeTopRightCapsule)) {
      i = 1;
    } else {
      i = 0;
    }
    localIMiniAppContext = this.mMiniAppContext;
    int j;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getMiniAppInfo() != null) && (this.mMiniAppContext.getMiniAppInfo().firstPage != null) && (this.mMiniAppContext.getMiniAppInfo().firstPage.pagePath != null) && (this.mMiniAppContext.getMiniAppInfo().firstPage.pagePath.startsWith("__wx__/functional-page.html?name=loginAndGetUserInfo&"))) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void realLoadUrl(String paramString1, String paramString2, PageEventListener paramPageEventListener)
  {
    this.mPageUrl = paramString1;
    Object localObject = getApkgInfo();
    int i = 1;
    boolean bool;
    if ((localObject != null) && (getApkgInfo().isTabBarPage(paramString1))) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = this.mTabPageCache;
    if ((localObject == null) || (!((Map)localObject).containsKey(AppBrandUtil.getUrlWithoutParams(paramString1)))) {
      i = 0;
    }
    if (i != 0)
    {
      handleLoadedPage(paramString1, paramString2, paramPageEventListener);
      return;
    }
    handleNewPage(paramString1, paramString2, paramPageEventListener, bool);
  }
  
  private void removeTabbarBadge(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.10(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("index", -1)));
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void setNavbarBgColor(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
        String str1 = ((JSONObject)localObject1).optString("frontColor");
        String str2 = ((JSONObject)localObject1).optString("backgroundColor");
        localObject1 = ((JSONObject)localObject1).optJSONObject("animation");
        if (localObject1 != null)
        {
          l = ((JSONObject)localObject1).optLong("duration");
          localObject1 = ((JSONObject)localObject1).optString("timingFunc");
          if (this.mNavigationBar != null)
          {
            AppBrandTask.runTaskOnUiThread(new AppBrandPage.4(this, str1, (String)localObject1, str2, l, paramNativeViewRequestEvent));
            return;
          }
          paramNativeViewRequestEvent.fail("native view error");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("AppBrandPage", "SET_NAV_BAR_BG_COLOR error.", localThrowable);
        paramNativeViewRequestEvent.fail("native exception");
        return;
      }
      Object localObject2 = null;
      long l = 0L;
    }
  }
  
  private void setNavbarTitle(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramNativeViewRequestEvent.jsonParams).optString("title");
      if (this.mNavigationBar != null)
      {
        AppBrandTask.runTaskOnUiThread(new AppBrandPage.7(this, str, paramNativeViewRequestEvent));
        return;
      }
      paramNativeViewRequestEvent.fail("native view error");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "SET_NAV_BAR_TITLE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void setShowRedDot(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.9(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("index", -1)));
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void setTabbarBadge(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.11(this, localJSONObject.optString("type"), localJSONObject.optInt("index", -1), localJSONObject.optString("text")));
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void setTabbarStyle(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.12(this, localJSONObject.optString("color"), localJSONObject.optString("selectedColor"), localJSONObject.optString("backgroundColor"), localJSONObject.optString("borderStyle", "black")));
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_STYLE error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void setTbabarItem(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("index", -1);
      if ((i >= 0) && (i <= 3))
      {
        String str1 = ((JSONObject)localObject).optString("text");
        String str2 = ((JSONObject)localObject).optString("iconPath");
        localObject = ((JSONObject)localObject).optString("selectedIconPath");
        AppBrandTask.runTaskOnUiThread(new AppBrandPage.13(this, i, str1, ImageUtil.getLocalBitmap(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getChildFileAbsolutePath(str2)), ImageUtil.getLocalBitmap(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getChildFileAbsolutePath((String)localObject))));
        paramNativeViewRequestEvent.ok();
        return;
      }
      paramNativeViewRequestEvent.fail("invalid index");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SET_TABBAR_ITEM error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void showNabbarLoading(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new AppBrandPage.6(this, paramNativeViewRequestEvent));
  }
  
  private void showTabbar(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPage.15(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optBoolean("animation", false), paramNativeViewRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandPage", "API_SHOW_TABBAR error.", localThrowable);
      paramNativeViewRequestEvent.fail("native exception");
    }
  }
  
  private void switchTab(String paramString)
  {
    if ((getApkgInfo() != null) && (getApkgInfo().isTabBarPage(paramString)))
    {
      if (this.mTabBar.getNeedShow()) {
        this.mTabBar.setVisibility(0);
      }
      this.mTabBar.setTabSelected(paramString);
      return;
    }
    paramString = this.mTabBar;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  private void updateNavigationBar(String paramString)
  {
    int i = this.mRootContainer.getPageCount();
    if ((this.mMiniAppContext != null) && (getApkgInfo() != null) && (getApkgInfo().getAppConfigInfo() != null)) {
      paramString = getApkgInfo().getAppConfigInfo().getPageInfo(paramString).windowInfo;
    } else {
      paramString = null;
    }
    this.mNavigationBar.setClickBackListener(this);
    this.mNavigationBar.setWindowInfo(paramString, this.mMiniAppContext.getAttachedActivity());
    paramString = this.mNavigationBar;
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    paramString.setEnableBackIcon(bool);
    this.mNavigationBar.getCapsuleButton().updateRedDotVisible();
    this.mNavigationBar.getCapsuleButton().setListener(new CapsuleButtonClickListener(this.mMiniAppContext));
    if (needCloseTopRightCapsule())
    {
      if (this.mNavigationBar.getCapsuleButton() != null) {
        this.mNavigationBar.getCapsuleButton().setVisibility(8);
      }
    }
    else if (this.mNavigationBar.getCapsuleButton() != null) {
      this.mNavigationBar.getCapsuleButton().setVisibility(0);
    }
  }
  
  private void updatePageStyle(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    boolean bool2 = false;
    boolean bool1;
    if ((localObject != null) && (getApkgInfo() != null) && (getApkgInfo().getAppConfigInfo() != null))
    {
      localObject = getApkgInfo().getAppConfigInfo().getPageInfo(paramString).windowInfo.navigationBarInfo.style;
      bool1 = bool2;
      paramString = (String)localObject;
      if (getApkgInfo().getAppConfigInfo().tabBarInfo != null)
      {
        bool1 = bool2;
        paramString = (String)localObject;
        if (!getApkgInfo().getAppConfigInfo().tabBarInfo.custom)
        {
          bool1 = true;
          paramString = (String)localObject;
        }
      }
    }
    else
    {
      paramString = null;
      bool1 = bool2;
    }
    if ((!this.mNavigationStyle.equals(paramString)) || (this.mTabBarState != bool1))
    {
      updateViewStyle(paramString);
      this.mTabBarState = bool1;
      this.mNavigationStyle = paramString;
    }
  }
  
  private void updateSwipeBack()
  {
    int i = this.mRootContainer.getPageCount();
    boolean bool2 = false;
    int j = 1;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1;
    if ((getApkgInfo() != null) && (getApkgInfo().mMiniAppInfo != null)) {
      bool1 = getApkgInfo().mMiniAppInfo.isLimitedAccessApp();
    } else {
      bool1 = false;
    }
    if ((i != 0) && (bool1)) {
      bool1 = bool2;
    } else {
      bool1 = true;
    }
    setSwipeBackEnable(bool1);
    if (i != 0) {
      setViewDragHelper(this.mRootContainer, this);
    } else {
      setViewDragHelper(this, this.mContentView);
    }
    if (i != 0) {
      j = 2;
    }
    setScrollDirection(j);
    if ((this.mPageGuestProxy != null) && (this.mMiniAppContext != null)) {
      this.mPageGuestProxy.onLoadUrl(this.mMiniAppContext);
    }
  }
  
  private void updateTabBar(RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2)
  {
    if (this.mTabBar.getNeedShow()) {
      this.mTabBar.setVisibility(0);
    }
    this.mTabBar.setInfo(getApkgInfo().getAppConfigInfo().tabBarInfo);
    if ("top".equals(getApkgInfo().getAppConfigInfo().tabBarInfo.position))
    {
      if ("default".equals(this.mNavigationStyle))
      {
        this.mRootView.addView(this.centerLayout);
        this.mRootView.addView(this.mTabBar);
        this.mRootView.addView(this.mNavigationBar);
        paramLayoutParams1.addRule(3, this.mTabBar.getId());
        return;
      }
      if ("custom".equals(this.mNavigationStyle))
      {
        addView(this.centerLayout);
        addView(this.mTabBar);
        addView(this.mNavigationBar);
      }
    }
    else
    {
      if ("default".equals(this.mNavigationStyle))
      {
        this.mRootView.addView(this.centerLayout);
        this.mRootView.addView(this.mTabBar);
        this.mRootView.addView(this.mNavigationBar);
        paramLayoutParams1.addRule(3, this.mNavigationBar.getId());
        paramLayoutParams1.addRule(2, this.mTabBar.getId());
        paramLayoutParams2.addRule(12, -1);
        return;
      }
      if ("custom".equals(this.mNavigationStyle))
      {
        this.mRootView.addView(this.centerLayout);
        this.mRootView.addView(this.mTabBar);
        this.mRootView.addView(this.mNavigationBar);
        paramLayoutParams1.addRule(2, this.mTabBar.getId());
        paramLayoutParams2.addRule(12, -1);
      }
    }
  }
  
  public void cleanUp()
  {
    Object localObject = this.mTabPageCache.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ((PageWebviewContainer)((Map.Entry)((Iterator)localObject).next()).getValue()).cleanUp();
      ((Iterator)localObject).remove();
    }
    localObject = this.mCurPageWebviewContainer;
    if (localObject != null)
    {
      ((PageWebviewContainer)localObject).cleanUp();
      this.mCurPageWebviewContainer = null;
    }
    removeAllViews();
    this.mRootView = null;
    this.mPageUrl = null;
  }
  
  public View createContentView()
  {
    if (this.mRootView == null)
    {
      this.mRootView = new RelativeLayout(getContext());
      this.mRootView.setContentDescription("rootview");
      this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.getRealHeight(getContext())));
    }
    return this.mRootView;
  }
  
  public BrandPageWebview getBrandPageWebview()
  {
    if (getPageWebviewContainer() != null) {
      return getPageWebviewContainer().getBrandPageWebview();
    }
    return null;
  }
  
  public BrandPageWebview getBrandPageWebviewById(int paramInt)
  {
    if (!isTabBarPage())
    {
      if (getPageWebviewId() == paramInt) {
        return getBrandPageWebview();
      }
      return null;
    }
    Iterator localIterator = this.mTabPageCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      PageWebviewContainer localPageWebviewContainer = (PageWebviewContainer)((Map.Entry)localIterator.next()).getValue();
      if (localPageWebviewContainer.getWebViewId() == paramInt) {
        return localPageWebviewContainer.getBrandPageWebview();
      }
    }
    return null;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    NavigationBar localNavigationBar = this.mNavigationBar;
    if (localNavigationBar != null) {
      return localNavigationBar.getCapsuleButton();
    }
    return null;
  }
  
  public FrameLayout getCenterLayout()
  {
    return this.centerLayout;
  }
  
  public String getCurShowingUrl()
  {
    return this.mPageUrl;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    BrandPageWebview localBrandPageWebview = getBrandPageWebview();
    if (localBrandPageWebview != null) {
      return localBrandPageWebview.getRealView();
    }
    return null;
  }
  
  public NavigationBar getNavBar()
  {
    return this.mNavigationBar;
  }
  
  public NavigationBar getNaviBar()
  {
    return this.mNavigationBar;
  }
  
  public PageWebviewContainer getPageWebviewContainer()
  {
    return this.mCurPageWebviewContainer;
  }
  
  public int getPageWebviewId()
  {
    if (getPageWebviewContainer() != null) {
      return getPageWebviewContainer().getWebViewId();
    }
    return -1;
  }
  
  public AppBrandPageContainer getRootContainer()
  {
    return this.mRootContainer;
  }
  
  public TabBar getTabBar()
  {
    return this.mTabBar;
  }
  
  public boolean handleBackPressed()
  {
    PageWebviewContainer localPageWebviewContainer = this.mCurPageWebviewContainer;
    return (localPageWebviewContainer != null) && (localPageWebviewContainer.handleBackPressed());
  }
  
  public String handleNativeUIEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event = ");
    localStringBuilder.append(paramNativeViewRequestEvent.event);
    localStringBuilder.append(", params = ");
    localStringBuilder.append(paramNativeViewRequestEvent.jsonParams);
    QMLog.d("AppBrandPage", localStringBuilder.toString());
    if ("showTabBar".equals(paramNativeViewRequestEvent.event)) {
      showTabbar(paramNativeViewRequestEvent);
    } else if ("hideTabBar".equals(paramNativeViewRequestEvent.event)) {
      hidetabbar(paramNativeViewRequestEvent);
    } else if ("setTabBarItem".equals(paramNativeViewRequestEvent.event)) {
      setTbabarItem(paramNativeViewRequestEvent);
    } else if ("setTabBarStyle".equals(paramNativeViewRequestEvent.event)) {
      setTabbarStyle(paramNativeViewRequestEvent);
    } else if ("setTabBarBadge".equals(paramNativeViewRequestEvent.event)) {
      setTabbarBadge(paramNativeViewRequestEvent);
    } else if ("removeTabBarBadge".equals(paramNativeViewRequestEvent.event)) {
      removeTabbarBadge(paramNativeViewRequestEvent);
    } else if ("showTabBarRedDot".equals(paramNativeViewRequestEvent.event)) {
      setShowRedDot(paramNativeViewRequestEvent);
    } else if ("hideTabBarRedDot".equals(paramNativeViewRequestEvent.event)) {
      hideRedDot(paramNativeViewRequestEvent);
    } else if ("setNavigationBarTitle".equals(paramNativeViewRequestEvent.event)) {
      setNavbarTitle(paramNativeViewRequestEvent);
    } else if ("showNavigationBarLoading".equals(paramNativeViewRequestEvent.event)) {
      showNabbarLoading(paramNativeViewRequestEvent);
    } else if ("hideNavigationBarLoading".equals(paramNativeViewRequestEvent.event)) {
      hideNavbarLoading(paramNativeViewRequestEvent);
    } else if ("setNavigationBarColor".equals(paramNativeViewRequestEvent.event)) {
      setNavbarBgColor(paramNativeViewRequestEvent);
    } else if ("scrollWebviewTo".equals(paramNativeViewRequestEvent.event)) {
      handlePageScrollTo(paramNativeViewRequestEvent);
    }
    return null;
  }
  
  public void hideMiniAIOEntrance()
  {
    MiniAIOEntranceProxy localMiniAIOEntranceProxy = this.miniAIOEntryView;
    if (localMiniAIOEntranceProxy != null)
    {
      localMiniAIOEntranceProxy.setVisibility(8);
      this.miniAIOEntryView.onDestroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public boolean isCustomNavibar()
  {
    String str = this.mNavigationStyle;
    if (str != null) {
      return str.equals("custom");
    }
    return false;
  }
  
  public boolean isHomePage()
  {
    if ((this.mMiniAppContext != null) && (getApkgInfo() != null)) {
      return getApkgInfo().isHomePage(this.mPageUrl);
    }
    return false;
  }
  
  public boolean isTabBarPage()
  {
    if (getApkgInfo() != null) {
      return getApkgInfo().isTabBarPage(this.mPageUrl);
    }
    return false;
  }
  
  public void loadUrl(String paramString1, String paramString2, PageEventListener paramPageEventListener)
  {
    if (!isReadyLoadUrl(paramString1))
    {
      QMLog.e("AppBrandPage", "loadurl not ready, return.");
      return;
    }
    if (paramString1.equals(this.mPageUrl))
    {
      if (isPageWebViewReady(this.mPageUrl))
      {
        paramPageEventListener.onWebViewReady(paramString2, this.mPageUrl, this.mRootContainer.getShowingPageWebViewId());
        onResume();
      }
      return;
    }
    this.mRootContainer.hideSoftInput(this);
    realLoadUrl(paramString1, paramString2, paramPageEventListener);
    updatePageStyle(paramString1);
    updateNavigationBar(paramString1);
    updateSwipeBack();
    switchTab(paramString1);
    onResume();
  }
  
  public void notifyChangePullDownRefreshStyle(int paramInt)
  {
    Object localObject = this.mTabPageCache;
    if (localObject == null)
    {
      QMLog.d("AppBrandPage", "No need to notifyChangePullDownRefreshStyle. tab page cache is null");
      return;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageWebviewContainer)((Map.Entry)((Iterator)localObject).next()).getValue()).notifyChangePullDownRefreshStyle(paramInt);
    }
  }
  
  public void onClickBack(NavigationBar paramNavigationBar)
  {
    paramNavigationBar = this.mMiniAppContext;
    if ((paramNavigationBar != null) && (paramNavigationBar.getAttachedActivity() != null) && (!this.mMiniAppContext.getAttachedActivity().isFinishing())) {
      this.mMiniAppContext.getAttachedActivity().onBackPressed();
    }
  }
  
  public void onMoveAppBrandToBack()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getAttachedActivity() != null) && (!this.mMiniAppContext.getAttachedActivity().isFinishing())) {
      this.mMiniAppContext.getAttachedActivity().moveTaskToBack(true);
    }
  }
  
  public void onPause()
  {
    if (getCurrentPageWebview() != null) {
      getCurrentPageWebview().onPause();
    }
    Object localObject = this.mCurPageWebviewContainer;
    if ((localObject != null) && (((PageWebviewContainer)localObject).getNativeViewContainer() != null)) {
      this.mCurPageWebviewContainer.getNativeViewContainer().onPause();
    }
    localObject = this.miniAIOEntryView;
    if (localObject != null) {
      ((MiniAIOEntranceProxy)localObject).onPause();
    }
  }
  
  public void onResume()
  {
    if (getCurrentPageWebview() != null) {
      getCurrentPageWebview().onResume();
    }
    Object localObject = this.mCurPageWebviewContainer;
    if ((localObject != null) && (((PageWebviewContainer)localObject).getNativeViewContainer() != null)) {
      this.mCurPageWebviewContainer.getNativeViewContainer().onResume();
    }
    localObject = this.miniAIOEntryView;
    if (localObject != null) {
      ((MiniAIOEntranceProxy)localObject).onResume();
    }
  }
  
  public void onSwipeFinish()
  {
    AppBrandTask.runTaskOnUiThread(new AppBrandPage.1(this));
  }
  
  public void refreshOrientation()
  {
    PageWebviewContainer localPageWebviewContainer = this.mCurPageWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.refreshOrientation();
    }
  }
  
  public boolean showMiniAIOEntrance(JSONObject paramJSONObject)
  {
    int j = -10;
    int i;
    if (paramJSONObject != null)
    {
      j = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("x", -10) + 0.5F);
      i = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("y", -10) + 0.5F);
      paramJSONObject = paramJSONObject.optString("style");
    }
    else
    {
      paramJSONObject = "";
      i = -10;
    }
    if ((j >= 0) && (i >= 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = i;
      MiniAIOEntranceProxy localMiniAIOEntranceProxy = this.miniAIOEntryView;
      if (localMiniAIOEntranceProxy == null)
      {
        this.miniAIOEntryView = ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMiniAIOEntranceView(this.mMiniAppContext.getAttachedActivity(), paramJSONObject);
        this.mRootView.addView(this.miniAIOEntryView, localLayoutParams);
      }
      else
      {
        localMiniAIOEntranceProxy.setMiniAIOStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams(localLayoutParams);
        requestLayout();
      }
      return true;
    }
    return false;
  }
  
  public void updateViewStyle(String paramString)
  {
    this.mNavigationStyle = paramString;
    if (this.mRootView.getChildCount() > 0) {
      this.mRootView.removeAllViews();
    }
    paramString = new RelativeLayout.LayoutParams(-1, -1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, NavigationBar.getDefaultNaviBarHeight(this.mMiniAppContext.getContext()));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, TabBar.getDefaultTabBarHeight(this.mMiniAppContext.getContext()));
    if ((this.mMiniAppContext != null) && (getApkgInfo() != null) && (getApkgInfo().getAppConfigInfo() != null) && (getApkgInfo().getAppConfigInfo().tabBarInfo != null) && (!getApkgInfo().getAppConfigInfo().tabBarInfo.custom))
    {
      updateTabBar(paramString, localLayoutParams2);
    }
    else if ("default".equals(this.mNavigationStyle))
    {
      this.mRootView.addView(this.mNavigationBar);
      this.mRootView.addView(this.centerLayout);
      paramString.addRule(12);
      paramString.addRule(3, this.mNavigationBar.getId());
    }
    else if ("custom".equals(this.mNavigationStyle))
    {
      this.mRootView.addView(this.centerLayout);
      this.mRootView.addView(this.mNavigationBar);
    }
    this.centerLayout.setLayoutParams(paramString);
    this.mTabBar.setLayoutParams(localLayoutParams2);
    this.mNavigationBar.setLayoutParams(localLayoutParams1);
    this.mNavigationBar.setBarStyle(this.mNavigationStyle);
    this.mNavigationBar.getCapsuleButton().setVisibility(0);
  }
  
  public void updateWidowInfo(Activity paramActivity)
  {
    if (TextUtils.isEmpty(this.mPageUrl)) {
      return;
    }
    if ((this.mMiniAppContext != null) && (getApkgInfo() != null) && (getApkgInfo().getAppConfigInfo() != null))
    {
      WindowInfo localWindowInfo = getApkgInfo().getAppConfigInfo().getPageInfo(this.mPageUrl).windowInfo;
      NavigationBar localNavigationBar = this.mNavigationBar;
      if ((localNavigationBar != null) && (localWindowInfo != null)) {
        localNavigationBar.setWindowInfo(localWindowInfo, paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */