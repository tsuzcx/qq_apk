package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.miniapp.widget.CanvasView.DrawActionCommand;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import com.tencent.smtt.sdk.CookieManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeViewContainer
  extends FrameLayout
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "NativeViewContainer";
  private static String mCurWhiteListConfig;
  private static String mWhiteHostConfig;
  private static ArrayList<String> needCookieAppIdList;
  private static ArrayList<String> needCookieHostList;
  private SparseArray<MiniAppTextArea> appTextAreaSparseArray = new SparseArray();
  protected float density;
  private InnerWebView innerWebView;
  private View keyBoardConfirmView;
  private long lastShowInputTime = 0L;
  private final List<NativeViewContainer.IConfirmListerner> mConfirmListeners = new ArrayList();
  private SparseArray<CoverView> mCoverViewSparseArray = new SparseArray();
  private int mCurInput = -1;
  private WebInputHandler mInputHandler;
  private IMiniAppContext mMiniAppContext;
  private PageWebviewContainer mWebviewContainer;
  
  @Deprecated
  public NativeViewContainer(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
  }
  
  public NativeViewContainer(IMiniAppContext paramIMiniAppContext, PageWebviewContainer paramPageWebviewContainer)
  {
    super(paramIMiniAppContext.getContext());
    this.density = DisplayUtil.getDensity(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
    this.mWebviewContainer = paramPageWebviewContainer;
    this.mInputHandler = new WebInputHandler(this);
    initKeyBoardConfirmView();
  }
  
  private boolean doInsertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("NativeViewContainer", "insertHTMLWebView htmlId=" + paramInt1 + ",innerWebView=" + this.innerWebView);
    }
    if ((this.innerWebView != null) || (this.mWebviewContainer == null) || (this.mWebviewContainer.getAttachActivity() == null)) {
      return false;
    }
    float f = DisplayUtil.getDensity(this.mMiniAppContext.getContext());
    int i = (int)(paramInt4 * f + 0.5F);
    paramInt4 = (int)(paramInt5 * f + 0.5F);
    paramInt5 = (int)(paramInt2 * f + 0.5F);
    int j = (int)(f * paramInt3 + 0.5F);
    if (QMLog.isColorLevel()) {
      QMLog.d("NativeViewContainer", "insertHTMLWebView htmlId=" + paramInt1 + ",left=" + paramInt5 + ",top=" + j + ",w=" + i + ",h=" + paramInt4);
    }
    paramInt2 = paramInt4;
    if (this.mWebviewContainer.isCustomNavibar())
    {
      paramInt3 = paramInt4 - (ViewUtils.dpToPx(44.0F) + DisplayUtil.getStatusBarHeight(this.mMiniAppContext.getContext()));
      paramInt2 = paramInt3;
      if (this.mWebviewContainer.getNaviBar() != null)
      {
        this.mWebviewContainer.getNaviBar().setBarStyle("default");
        paramInt2 = paramInt3;
      }
    }
    this.innerWebView = new InnerWebView(this.mWebviewContainer.getAttachActivity());
    this.innerWebView.htmlId = paramInt1;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, paramInt2);
    localLayoutParams.leftMargin = paramInt5;
    localLayoutParams.topMargin = j;
    this.innerWebView.setVisibility(8);
    addView(this.innerWebView, localLayoutParams);
    return true;
  }
  
  private boolean doRemoveHTMLWebView(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("NativeViewContainer", "removeHTMLWebView htmlId=" + paramInt);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt)) {
      return false;
    }
    this.innerWebView.loadUrl("about:blank");
    this.innerWebView.clearView();
    this.innerWebView.destroy();
    removeView(this.innerWebView);
    this.innerWebView = null;
    return true;
  }
  
  private ArrayList<String> getNeedCookieAppIdList()
  {
    try
    {
      if (needCookieAppIdList == null)
      {
        String str1 = WnsConfig.getConfig("qqminiapp", "MiniAppCookieWhiteAppIdList", "1108164955,1108291530,1109544007");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QMLog.i("NativeViewContainer", "Default white appid:" + str1);
          needCookieAppIdList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(",");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  needCookieAppIdList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str1;
          }
        }
      }
      return needCookieAppIdList;
    }
    finally {}
  }
  
  private void getNeedCookieHostList()
  {
    if (needCookieHostList == null)
    {
      String str1 = WnsConfig.getConfig("qqminiapp", "MiniAppCookieWhiteHostList", "https://open.mp.qq.com");
      if ((str1 != null) && (!str1.equals(mWhiteHostConfig)))
      {
        QMLog.i("NativeViewContainer", "Default white host:" + str1);
        needCookieHostList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!TextUtils.isEmpty(str2)) {
                needCookieHostList.add(str2);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          mWhiteHostConfig = str1;
        }
      }
    }
  }
  
  private void handleCanvasGetImageData(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
      ((CanvasView)localCoverView).getImageData(localJSONObject, paramNativeViewRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void handleCanvasPutImageData(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        this.mWebviewContainer.callbackJsEventFail(paramNativeViewRequestEvent.event, null, paramNativeViewRequestEvent.callbackId);
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("method", paramNativeViewRequestEvent.event);
        localJSONObject.put("data", localObject);
        localJSONObject.put("callbackId", paramNativeViewRequestEvent.callbackId);
        localJSONArray.put(localJSONObject);
        localObject = new CanvasView.DrawActionCommand(true, localJSONArray, false);
        ((CanvasView)localCoverView).addDrawActionCommand((CanvasView.DrawActionCommand)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.mWebviewContainer.callbackJsEventFail(paramNativeViewRequestEvent.event, null, paramNativeViewRequestEvent.callbackId);
    }
  }
  
  private void handleCanvasToTempFilePath(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
      ((CanvasView)localCoverView).saveBitmap(this, paramNativeViewRequestEvent, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void handleDrawCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      drawCanvas(localJSONObject.optInt("canvasId"), localJSONObject.optBoolean("reserve", false), localJSONObject.optBoolean("useHardwareAccelerate"), localJSONObject.optJSONArray("actions"), paramNativeViewRequestEvent);
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (JSONException paramNativeViewRequestEvent)
    {
      paramNativeViewRequestEvent.printStackTrace();
    }
  }
  
  private void handleHideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.3(this, paramNativeViewRequestEvent));
  }
  
  private void handleInsertCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("canvasId");
      int j = localJSONObject1.optInt("parentId");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("position");
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.10(this, localJSONObject1, i, j, localJSONObject2, localJSONObject1.optString("data"), paramNativeViewRequestEvent, localJSONObject3));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void handleInsertTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.6(this, i, localJSONObject1, paramNativeViewRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void handleRemoveCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.12(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("canvasId"), paramNativeViewRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void handleRemoveTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("inputId");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("inputId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.8(this, i, paramNativeViewRequestEvent, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void handleSetInputValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.5(this, paramNativeViewRequestEvent));
  }
  
  private void handleUpdateCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject2.optInt("canvasId");
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("position");
      boolean bool = localJSONObject2.optBoolean("hide", false);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.11(this, i, localJSONObject1, bool, paramNativeViewRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void handleUpdateInput(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.4(this, paramNativeViewRequestEvent));
  }
  
  private void handleUpdateTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.7(this, localJSONObject1, paramNativeViewRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
    }
  }
  
  private void initKeyBoardConfirmView()
  {
    this.keyBoardConfirmView = LayoutInflater.from(getContext().getApplicationContext()).inflate(R.layout.mini_sdk_keyboard_confirm, null);
    this.keyBoardConfirmView.setVisibility(8);
    ((TextView)this.keyBoardConfirmView.findViewById(R.id.mini_app_keyboard_confirm_botton)).setOnClickListener(new NativeViewContainer.9(this));
    if (this.mWebviewContainer != null) {
      this.mWebviewContainer.addViewOnPage(this.keyBoardConfirmView);
    }
  }
  
  private void inputShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent, long paramLong)
  {
    if (System.currentTimeMillis() - paramLong > 1000L)
    {
      this.lastShowInputTime = System.currentTimeMillis();
      AppBrandTask.runTaskOnUiThreadDelay(new NativeViewContainer.1(this, paramNativeViewRequestEvent), 200L);
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    if (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt))
      {
        if (localCoverView1.getParentId() != 0) {
          break label70;
        }
        removeView(localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
        if (localCoverView2 != null) {
          localCoverView2.removeView(localCoverView1);
        }
      }
    }
  }
  
  private void showErrorPage(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    String str2 = WnsConfig.getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str2 = str2.replace("{url}", paramString);
      str1 = str2;
      if (paramMiniAppInfo != null) {
        str1 = str2.replace("{appid}", paramMiniAppInfo.appId);
      }
    }
    doUpdateHTMLWebView(paramInt, str1);
    QMLog.e("NativeViewContainer", "updateHTMLWebView domain valid : " + paramString);
    paramNativeViewRequestEvent.fail("domain valid");
  }
  
  private void textareaShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent, int paramInt)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.2(this, paramInt, paramNativeViewRequestEvent));
  }
  
  public boolean addConfirmListener(NativeViewContainer.IConfirmListerner paramIConfirmListerner)
  {
    synchronized (this.mConfirmListeners)
    {
      if (!this.mConfirmListeners.contains(paramIConfirmListerner))
      {
        boolean bool = this.mConfirmListeners.add(paramIConfirmListerner);
        return bool;
      }
      return false;
    }
  }
  
  public boolean addCoverView(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    QMLog.d("NativeViewContainer", "addCoverView(). parentViewId = " + paramInt1 + ", coverViewId = " + paramInt2 + ", coverView = " + paramCoverView);
    new StringBuilder("addCoverView(). ").append("parentViewId = ").append(paramInt1).append("coverViewId = ").append(paramInt2).append("coverView = ").append(paramCoverView).append("fixed = ").append(paramBoolean);
    if (paramCoverView == null)
    {
      QMLog.w("NativeViewContainer", "Failed to add coverView, coverView is null");
      return false;
    }
    this.mCoverViewSparseArray.put(paramInt2, paramCoverView);
    if (paramInt1 == 0) {
      if (paramBoolean) {
        this.mWebviewContainer.addView(paramCoverView);
      }
    }
    for (;;)
    {
      return true;
      addView(paramCoverView);
      continue;
      CoverView localCoverView = getCoverView(paramInt1);
      if (localCoverView != null) {
        localCoverView.addView(paramCoverView);
      }
    }
  }
  
  public void addViewOnPage(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mWebviewContainer != null) {
      this.mWebviewContainer.addViewOnPage(paramView, paramLayoutParams);
    }
  }
  
  public void callbackLineChange(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = getTextArea(paramInt);
    if (localMiniAppTextArea != null) {
      localMiniAppTextArea.callbackLineChange();
    }
  }
  
  public void destroy()
  {
    int j = 0;
    if (this.innerWebView != null)
    {
      removeView(this.innerWebView);
      this.innerWebView.loadUrl("about:blank");
      this.innerWebView.clearView();
      this.innerWebView.destroy();
      this.innerWebView = null;
    }
    Object localObject;
    if ((this.appTextAreaSparseArray != null) && (this.appTextAreaSparseArray.size() > 0))
    {
      i = 0;
      while (i < this.appTextAreaSparseArray.size())
      {
        localObject = (MiniAppTextArea)this.appTextAreaSparseArray.valueAt(i);
        if (localObject != null)
        {
          ((MiniAppTextArea)localObject).removeKeyboardListener();
          ((MiniAppTextArea)localObject).removeGlobalLayoutListener();
        }
        i += 1;
      }
    }
    this.appTextAreaSparseArray.clear();
    int i = j;
    if (i < this.mCoverViewSparseArray.size())
    {
      localObject = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localObject instanceof CoverVideoView))
      {
        ((CoverVideoView)localObject).stop();
        ((CoverVideoView)localObject).release();
        removeView((View)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof CoverLiveView))
        {
          ((CoverLiveView)localObject).release();
          removeView((View)localObject);
        }
        else if ((localObject instanceof CoverPusherView))
        {
          ((CoverPusherView)localObject).release();
          removeView((View)localObject);
        }
        else if ((localObject instanceof CoverCameraView))
        {
          ((CoverCameraView)localObject).closeCamera();
        }
      }
    }
    this.mCoverViewSparseArray.clear();
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("NativeViewContainer", "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",src=" + paramString);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (this.mWebviewContainer == null)
    {
      QMLog.d("NativeViewContainer", "container is null");
      return false;
    }
    if ((this.mWebviewContainer.getMiniAppContext() != null) && (this.mWebviewContainer.getMiniAppContext().getMiniAppInfo() != null)) {}
    for (Object localObject = this.mWebviewContainer.getMiniAppContext().getMiniAppInfo();; localObject = null)
    {
      if ((localObject != null) && (needCookieAppIdList != null) && (needCookieAppIdList.contains(((MiniAppInfo)localObject).appId)))
      {
        localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if (localObject != null) {
          ((ChannelProxy)localObject).setWebviewCookie(this.mWebviewContainer.getAttachActivity(), paramString);
        }
      }
      if (needCookieHostList == null) {
        break;
      }
      localObject = needCookieHostList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        QMLog.i("NativeViewContainer", "setCookie : " + str);
        ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if (localChannelProxy != null) {
          localChannelProxy.setWebviewCookie(this.mWebviewContainer.getAttachActivity(), str);
        }
      }
    }
    this.innerWebView.init(this.mWebviewContainer.getMiniAppContext());
    this.innerWebView.setVisibility(0);
    if (QMLog.isColorLevel())
    {
      localObject = CookieManager.getInstance().getCookie(paramString);
      QMLog.e("NativeViewContainer", "cookie : " + (String)localObject);
    }
    this.innerWebView.loadUrl(paramString);
    try
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("NativeViewContainer", "innerWebView.hasFocus() : " + this.innerWebView.hasFocus());
      }
      if (!this.innerWebView.hasFocus()) {
        this.innerWebView.requestFocus();
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QMLog.e("NativeViewContainer", "innerWebView requestFocuserror,", paramString);
      }
    }
    return true;
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("NativeViewContainer", "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",position=" + paramJSONObject);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt) || (paramJSONObject == null)) {
      return false;
    }
    float f = DisplayUtil.getDensity(getContext());
    paramInt = (int)(paramJSONObject.optInt("width") * f + 0.5F);
    int i = (int)(paramJSONObject.optInt("height") * f + 0.5F);
    int j = (int)(paramJSONObject.optInt("left") * f + 0.5F);
    int k = (int)(f * paramJSONObject.optInt("top") + 0.5F);
    paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
    paramJSONObject.leftMargin = j;
    paramJSONObject.topMargin = k;
    this.innerWebView.setLayoutParams(paramJSONObject);
    return true;
  }
  
  public void drawCanvas(int paramInt, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView))
    {
      QMLog.e("NativeViewContainer", "updateCanvas failed! appCanvas return null! canvasId: " + paramInt);
      paramNativeViewRequestEvent.fail();
      return;
    }
    paramJSONArray = new CanvasView.DrawActionCommand(paramBoolean1, paramJSONArray, paramBoolean2);
    ((CanvasView)localCoverView).addDrawActionCommand(paramJSONArray);
  }
  
  public CoverView getCoverView(int paramInt)
  {
    return (CoverView)this.mCoverViewSparseArray.get(paramInt);
  }
  
  public int getCurInputId()
  {
    return this.mCurInput;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    if (this.mWebviewContainer != null) {
      return this.mWebviewContainer.getCurrentPageWebview();
    }
    return null;
  }
  
  public int getNaviBarHeight()
  {
    if (this.mWebviewContainer != null) {
      return this.mWebviewContainer.getNaviBarHeight();
    }
    return 0;
  }
  
  public PageWebviewContainer getPageWebviewContainer()
  {
    return this.mWebviewContainer;
  }
  
  public MiniAppTextArea getTextArea(int paramInt)
  {
    if ((this.appTextAreaSparseArray != null) && (this.appTextAreaSparseArray.size() > 0))
    {
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
      if (localMiniAppTextArea != null) {
        return localMiniAppTextArea;
      }
    }
    return null;
  }
  
  public int getWebviewId()
  {
    if (this.mWebviewContainer != null) {
      return this.mWebviewContainer.getWebViewId();
    }
    return 0;
  }
  
  public boolean handleBackPressed()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.innerWebView != null) && (this.innerWebView.canGoBack()))
    {
      this.innerWebView.goBack();
      bool1 = true;
    }
    Object localObject;
    do
    {
      do
      {
        return bool1;
        int i = 0;
        while (i < this.mCoverViewSparseArray.size())
        {
          localObject = (CoverView)this.mCoverViewSparseArray.valueAt(i);
          if ((localObject instanceof CoverVideoView))
          {
            if (((CoverVideoView)localObject).isFullScreen())
            {
              ((CoverVideoView)localObject).smallScreen();
              return true;
            }
          }
          else if (((localObject instanceof CoverLiveView)) && (((CoverLiveView)localObject).isFullScreen()))
          {
            ((CoverLiveView)localObject).smallScreen();
            return true;
          }
          i += 1;
        }
        localObject = getCurrentPageWebview();
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (!((PageWebview)localObject).handleBackPressed());
    return true;
  }
  
  public void handleInsertHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.14(this, paramNativeViewRequestEvent));
  }
  
  public String handleNativeUIEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("NativeViewContainer", "event = " + paramNativeViewRequestEvent.event + ", params = " + paramNativeViewRequestEvent.jsonParams);
    if ("showKeyboard".equals(paramNativeViewRequestEvent.event)) {
      handleShowKeyboard(paramNativeViewRequestEvent);
    }
    for (;;)
    {
      return null;
      if ("hideKeyboard".equals(paramNativeViewRequestEvent.event)) {
        handleHideKeyboard(paramNativeViewRequestEvent);
      } else if ("updateInput".equals(paramNativeViewRequestEvent.event)) {
        handleUpdateInput(paramNativeViewRequestEvent);
      } else if ("setKeyboardValue".equals(paramNativeViewRequestEvent.event)) {
        handleSetInputValue(paramNativeViewRequestEvent);
      } else if ("insertTextArea".equals(paramNativeViewRequestEvent.event)) {
        handleInsertTextArea(paramNativeViewRequestEvent);
      } else if ("updateTextArea".equals(paramNativeViewRequestEvent.event)) {
        handleUpdateTextArea(paramNativeViewRequestEvent);
      } else if ("removeTextArea".equals(paramNativeViewRequestEvent.event)) {
        handleRemoveTextArea(paramNativeViewRequestEvent);
      } else if ("insertCanvas".equals(paramNativeViewRequestEvent.event)) {
        handleInsertCanvas(paramNativeViewRequestEvent);
      } else if ("updateCanvas".equals(paramNativeViewRequestEvent.event)) {
        handleUpdateCanvas(paramNativeViewRequestEvent);
      } else if ("removeCanvas".equals(paramNativeViewRequestEvent.event)) {
        handleRemoveCanvas(paramNativeViewRequestEvent);
      } else if ("drawCanvas".equals(paramNativeViewRequestEvent.event)) {
        handleDrawCanvas(paramNativeViewRequestEvent);
      } else if ("canvasToTempFilePath".equals(paramNativeViewRequestEvent.event)) {
        handleCanvasToTempFilePath(paramNativeViewRequestEvent);
      } else if ("canvasPutImageData".equals(paramNativeViewRequestEvent.event)) {
        handleCanvasPutImageData(paramNativeViewRequestEvent);
      } else if ("canvasGetImageData".equals(paramNativeViewRequestEvent.event)) {
        handleCanvasGetImageData(paramNativeViewRequestEvent);
      } else if ("insertHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
        handleInsertHtmlWebview(paramNativeViewRequestEvent);
      } else if ("updateHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
        handleUpdateHtmlWebview(paramNativeViewRequestEvent);
      } else if ("removeHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
        handleRemoveHtmlWebview(paramNativeViewRequestEvent);
      }
    }
  }
  
  public void handleRemoveHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.16(this, paramNativeViewRequestEvent));
  }
  
  void handleShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("inputId");
      if (i > 0)
      {
        textareaShowKeyboard(paramNativeViewRequestEvent, i);
        return;
      }
      inputShowKeyboard(paramNativeViewRequestEvent, this.lastShowInputTime);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("NativeViewContainer", paramNativeViewRequestEvent.event + " error.", localException);
    }
  }
  
  public void handleUpdateHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    getNeedCookieAppIdList();
    getNeedCookieHostList();
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.15(this, paramNativeViewRequestEvent));
  }
  
  public void hideKeyBoardConfirmView()
  {
    if ((this.keyBoardConfirmView != null) && (this.keyBoardConfirmView.getVisibility() == 0)) {
      this.keyBoardConfirmView.setVisibility(8);
    }
  }
  
  public void insertCanvas(int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3, IJsService paramIJsService)
  {
    int j = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
    int k = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
    Object localObject = getCurrentPageWebview();
    if (localObject != null) {}
    for (int i = ((PageWebview)localObject).getMeasuredHeight();; i = 0)
    {
      QMLog.i("NativeViewContainer", "insertCanvas currentWebview.getMeasuredHeight: " + i + "---canvas height----" + paramJSONObject.optInt("height") + "---" + k + "---canvasId---" + paramInt1);
      i = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
      paramJSONObject = (JSONObject)localObject;
      if (localObject == null)
      {
        paramJSONObject = new CanvasView(this.mMiniAppContext, this, paramIJsService, this.mWebviewContainer.getApkgInfo(), paramString, paramInt1, paramBoolean2, paramBoolean, paramBoolean3);
        this.mCoverViewSparseArray.put(paramInt1, paramJSONObject);
        addView(paramJSONObject);
        paramJSONObject.setParentId(paramInt2);
      }
      if ((paramJSONObject instanceof CanvasView))
      {
        paramJSONObject.setContentDescription("CanvasView " + paramInt1);
        if (paramBoolean1) {
          paramJSONObject.setVisibility(8);
        }
        paramString = new FrameLayout.LayoutParams(j, k);
        paramString.leftMargin = i;
        paramString.topMargin = m;
        paramJSONObject.setLayoutParams(paramString);
      }
      return;
    }
  }
  
  public void insertTextArea(int paramInt, JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject2 = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    int i = paramJSONObject.optInt("parentId");
    boolean bool = paramJSONObject.optBoolean("fixed", false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new MiniAppTextArea(getContext(), paramInt, this);
      ((MiniAppTextArea)localObject1).setFixed(bool);
      this.appTextAreaSparseArray.put(paramInt, localObject1);
      if (i == 0) {
        break label120;
      }
      localObject2 = (FrameLayout)this.mCoverViewSparseArray.get(i);
      if (localObject2 != null)
      {
        ((FrameLayout)localObject2).addView((View)localObject1);
        ((MiniAppTextArea)localObject1).setParentId(i);
      }
    }
    for (;;)
    {
      ((MiniAppTextArea)localObject1).setAttributes(paramJSONObject, false, paramNativeViewRequestEvent);
      return;
      label120:
      if (bool) {
        getPageWebviewContainer().addView((View)localObject1);
      } else {
        addView((View)localObject1);
      }
    }
  }
  
  public boolean isCustomNavibar()
  {
    if (this.mWebviewContainer != null) {
      return this.mWebviewContainer.isCustomNavibar();
    }
    return false;
  }
  
  public void notifyOnColorNoteAnimStart()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onAddColorNote();
      }
      i += 1;
    }
  }
  
  public void notifyOnPageWebViewDestory()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewDestory();
      }
      i += 1;
    }
  }
  
  public void notifyOnPageWebViewPause()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewPause();
      }
      i += 1;
    }
    if (this.innerWebView != null)
    {
      QMLog.d("NativeViewContainer", "innerWebView pause");
      this.innerWebView.onPause();
    }
  }
  
  public void notifyOnPageWebViewResume()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewResume();
      }
      i += 1;
    }
    if (this.innerWebView != null)
    {
      QMLog.d("NativeViewContainer", "innerWebView resume & requestFocus");
      this.innerWebView.onResume();
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.13(this));
    }
  }
  
  public void notifyPageBackground()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageBackground();
      }
      i += 1;
    }
  }
  
  public void notifyPageForeground()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageForeground();
      }
      i += 1;
    }
  }
  
  public void onPause()
  {
    notifyPageBackground();
  }
  
  public void onResume()
  {
    notifyPageForeground();
  }
  
  public void removeCanvas(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        this.mWebviewContainer.removeView(localCoverView);
      } else {
        removeView(localCoverView);
      }
    }
  }
  
  public boolean removeConfirmListener(NativeViewContainer.IConfirmListerner paramIConfirmListerner)
  {
    synchronized (this.mConfirmListeners)
    {
      if (this.mConfirmListeners.contains(paramIConfirmListerner))
      {
        boolean bool = this.mConfirmListeners.remove(paramIConfirmListerner);
        return bool;
      }
      return false;
    }
  }
  
  public boolean removeCoverView(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localCoverView == null) {
      return false;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0)
    {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
      this.mCoverViewSparseArray.remove(paramInt);
      if (!(localCoverView instanceof CoverLiveView)) {
        break label108;
      }
      ((CoverLiveView)localCoverView).release();
    }
    for (;;)
    {
      return true;
      if (localCoverView.isFixed())
      {
        this.mWebviewContainer.removeView(localCoverView);
        break;
      }
      removeView(localCoverView);
      break;
      label108:
      if ((localCoverView instanceof CoverPusherView)) {
        ((CoverPusherView)localCoverView).release();
      }
    }
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if (this.mWebviewContainer != null) {
      this.mWebviewContainer.removeSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void removeTextArea(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    this.appTextAreaSparseArray.remove(paramInt);
    int i = localMiniAppTextArea.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localMiniAppTextArea);
      }
    }
    for (;;)
    {
      this.appTextAreaSparseArray.remove(paramInt);
      return;
      if (localMiniAppTextArea.isFixed()) {
        getPageWebviewContainer().removeView(localMiniAppTextArea);
      } else {
        removeView(localMiniAppTextArea);
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if (this.mWebviewContainer != null) {
      this.mWebviewContainer.setCurInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if (this.mWebviewContainer != null) {
      this.mWebviewContainer.setSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void showKeyBoardConfirmView(int paramInt)
  {
    if (this.keyBoardConfirmView != null)
    {
      if (this.keyBoardConfirmView.getVisibility() == 8) {
        this.keyBoardConfirmView.setVisibility(0);
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 50.0F));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = paramInt;
      this.keyBoardConfirmView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void updateCanvas(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      QMLog.e("NativeViewContainer", "updateCanvas failed! appCanvas return null! canvasId: " + paramInt);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        localCoverView.setVisibility(8);
      }
      while (paramJSONObject != null)
      {
        paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
        int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
        int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
        int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
        paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
        paramJSONObject.leftMargin = j;
        paramJSONObject.topMargin = k;
        localCoverView.setLayoutParams(paramJSONObject);
        return;
        localCoverView.setVisibility(0);
      }
    }
  }
  
  public void updateTextArea(JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = paramJSONObject.optInt("inputId");
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(i);
      if (localMiniAppTextArea == null) {
        return;
      }
      localMiniAppTextArea.setAttributes(paramJSONObject, true, paramNativeViewRequestEvent);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QMLog.e("NativeViewContainer", "updateTextArea error.", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer
 * JD-Core Version:    0.7.0.1
 */