package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import bbkk;
import bgyi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgInfo.PageHtmlContent;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BaseAppBrandWebview
{
  private static final String PREF_HTML_URL = "https://appservice.qq.com/";
  private static final String TAG = PageWebview.class.getSimpleName();
  public AppBrandRuntime appBrandRuntime;
  private byte[] contentBytes;
  public FrameLayout customContainer;
  public IX5WebChromeClient.CustomViewCallback customViewCallback;
  WebViewEventListener eventListener;
  public int fromShareMenuBtn = -1;
  private boolean hasFLoad;
  private boolean hasLoadApkgJs;
  private boolean hasLoadHtml;
  private boolean hasLoadHtmlFinish;
  private boolean hasLoadWAWebviewJs;
  private boolean hasPageJsLoaded;
  public boolean isFullScreen;
  PageWebview.PageWebViewListener listener;
  private String mAppWxss;
  Context mContext;
  private boolean mEnableNativeBuffer;
  private boolean mEnableShowBackHome = true;
  public View mFullscreenView;
  String mRouteUrl;
  private String mWARemoteDebugStr;
  private String mWAWebviewStr;
  String openType;
  private String pageFrameHtmlJsStr;
  public int scrollY;
  public int shareCallbackId = -1;
  public ShareChatModel shareChatModel;
  public String shareEvent;
  public SwipeRefreshLayout swipeRefreshLayout;
  WebviewContainer webviewContainer;
  public ArrayList<PageWebview.OnWebviewScrollListener> webviewScrollListenerList;
  public boolean withShareQQ;
  public boolean withShareQzone;
  public boolean withShareTicket;
  public boolean withShareWeChatFriend;
  public boolean withShareWeChatMoment;
  
  public PageWebview(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PageWebview(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ApkgInfo paramApkgInfo, String paramString1, String paramString2, PageWebview.PageWebViewListener paramPageWebViewListener, WebViewEventListener paramWebViewEventListener)
  {
    super(paramContext, paramApkgInfo);
    this.appBrandRuntime = paramAppBrandRuntime;
    this.mContext = paramContext;
    this.mRouteUrl = paramString1;
    this.openType = paramString2;
    this.listener = paramPageWebViewListener;
    this.eventListener = paramWebViewEventListener;
    init();
  }
  
  public PageWebview(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    init();
  }
  
  private void initEnableDebug()
  {
    if (this.apkgInfo.getDebug()) {
      MiniLog.setEnableDebug(this.apkgInfo.appId, true);
    }
    for (;;)
    {
      if (StorageUtil.getPreference().getBoolean(this.apkgInfo.appId + "_debug", false)) {
        evaluteJs(this.apkgInfo.getWaConsoleJsStr(), null);
      }
      return;
      MiniLog.setEnableDebug(this.apkgInfo.appId, false);
    }
  }
  
  private void onWebViewReady(ApkgInfo paramApkgInfo)
  {
    if (bbkk.a(this.pageFrameHtmlJsStr))
    {
      String str = paramApkgInfo.getPageFrameJSStr(this.mRouteUrl);
      if (!TextUtils.isEmpty(str)) {
        evaluteJs(str);
      }
    }
    paramApkgInfo = paramApkgInfo.getPageJsStr(this.mRouteUrl);
    if (!TextUtils.isEmpty(paramApkgInfo)) {
      evaluteJs(paramApkgInfo);
    }
    this.hasPageJsLoaded = true;
    if (this.listener != null) {
      this.listener.onWebViewReady(this.openType, this.mRouteUrl);
    }
  }
  
  private void reportAppQualityEvent(int paramInt)
  {
    if ((this.appBrandRuntime != null) && (this.apkgInfo != null))
    {
      MiniReportManager.reportEventType(this.appBrandRuntime.apkgInfo.appConfig, paramInt, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.appBrandRuntime), null, null, 0);
      return;
    }
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), paramInt, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.appBrandRuntime), null, null, 0);
  }
  
  public void addView(WebviewContainer paramWebviewContainer, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.webviewContainer = paramWebviewContainer;
    addView(paramView, paramLayoutParams);
  }
  
  public void clearUp()
  {
    removeJavascriptInterface("WeixinJSCore");
  }
  
  public void destroy()
  {
    if (this.customViewCallback != null) {
      this.customViewCallback.onCustomViewHidden();
    }
    if (this.customContainer != null) {
      this.customContainer.setVisibility(8);
    }
    try
    {
      this.customContainer.removeAllViews();
      label39:
      this.customContainer = null;
      this.mFullscreenView = null;
      this.customViewCallback = null;
      super.destroy();
      if (this.webviewContainer != null) {
        this.webviewContainer.notifyOnPageWebViewDestory();
      }
      return;
    }
    catch (Exception localException)
    {
      break label39;
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.isFullScreen) && (this.mFullscreenView != null) && (this.customContainer != null) && (this.customContainer.getVisibility() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      QLog.d("miniapp-embedded", 1, "KEYCODE_BACK");
      this.isFullScreen = false;
      evaluateSubcribeJS("onXWebVideoExitFullscreen", null, this.pageWebviewId);
      return true;
    }
    return false;
  }
  
  public void doInitApkgJs()
  {
    if (this.apkgInfo == null) {
      return;
    }
    reportAppQualityEvent(106);
    QLog.i("miniapp-start", 1, "---PageWebView start initApkgJs ---  webviewid:" + this.pageWebviewId);
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "---PageWebView begin load app-config ---  webviewid:" + this.pageWebviewId);
    }
    initJSGlobalConfig();
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "---PageWebView begin init debug ---  webviewid:" + this.pageWebviewId);
    }
    initEnableDebug();
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "---PageWebView end load wawebview ---   webviewid:" + this.pageWebviewId);
    }
    if (bbkk.a(this.mAppWxss)) {
      this.mAppWxss = this.apkgInfo.getRootWxssJsContent();
    }
    if (!TextUtils.isEmpty(this.mAppWxss)) {
      evaluteJs(this.mAppWxss);
    }
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "---PageWebView begin load pageFrameHtmlJsStr --- webviewid:" + this.pageWebviewId);
    }
    if (!bbkk.a(this.pageFrameHtmlJsStr)) {
      evaluteJs(this.pageFrameHtmlJsStr);
    }
    for (;;)
    {
      QLog.i("miniapp-start", 1, "---PageWebView end load pageFrameHtmlJsStr --- webviewid:" + this.pageWebviewId);
      loadPageWebviewJs(this.apkgInfo);
      reportAppQualityEvent(107);
      QLog.i("miniapp-start", 1, "---PageWebView end initApkgJs ---   webviewid:" + this.pageWebviewId);
      return;
      this.pageFrameHtmlJsStr = this.apkgInfo.getPageHtmlContent().jsStr;
      if (!bbkk.a(this.pageFrameHtmlJsStr))
      {
        QLog.i("miniapp-start", 1, "--- PageWebView load pageFrameHtmlJsStr --- webviewid:" + this.pageWebviewId);
        evaluteJs(this.pageFrameHtmlJsStr);
      }
      else
      {
        QLog.i("miniapp-start", 1, "--- PageWebView load pageFrameHtmlJsStr rerror --- webviewid:" + this.pageWebviewId);
      }
    }
  }
  
  public boolean enableShowBackHome()
  {
    return this.mEnableShowBackHome;
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("USER_DATA_PATH", MiniAppGlobal.STR_WXFILE + "usr");
      localJSONObject.put("env", localObject);
      localJSONObject.put("preload", paramBoolean);
      StringBuilder localStringBuilder = new StringBuilder().append("var window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');Object.assign(__qqConfig, __tempConfig);");
      if (this.mEnableNativeBuffer) {}
      for (localObject = "__qqConfig.nativeBufferEnabled = true;";; localObject = "")
      {
        localObject = String.format((String)localObject + "__qqConfig.QUA='" + bgyi.a() + "';__qqConfig.platform = 'android';", new Object[] { localJSONObject });
        localObject = (String)localObject + "__qqConfig.useXWebVideo=" + this.enableEmbeddedVideo + ";";
        localObject = (String)localObject + "__qqConfig.XWebVideoMinVersion=045100;";
        QLog.d("miniapp-embedded", 1, "page enableEmbeddedVideo : " + this.enableEmbeddedVideo);
        QLog.d("miniapp-start", 2, "getJsDefaultConfig pageWebview String: " + (String)localObject);
        return localObject;
      }
      return "";
    }
    catch (Exception localException)
    {
      QLog.e("miniapp-start", 1, "getJsDefaultConfig failed: " + localException);
    }
  }
  
  public String getRouteUrl()
  {
    return this.mRouteUrl;
  }
  
  public boolean handleBackPressed()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleBackPressed : ");
    if (this.mFullscreenView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("miniapp-embedded", 1, bool);
      if (this.mFullscreenView == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void init()
  {
    addJavascriptInterface(this, "WeixinJSCore");
    setWebChromeClient(new PageWebview.1(this));
    setWebViewClient(new PageWebview.2(this));
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
  }
  
  public void initApkgJs()
  {
    if ((!this.hasLoadWAWebviewJs) || (this.apkgInfo == null)) {}
    while (this.hasLoadApkgJs) {
      return;
    }
    this.hasLoadApkgJs = true;
    doInitApkgJs();
    runDelayedEvent();
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      QLog.i(TAG, 1, paramString1 + " webviewid:" + this.pageWebviewId);
      return "";
    }
    if (this.eventListener != null) {
      return this.eventListener.onWebViewNativeRequest(paramString1, paramString2, this, paramInt);
    }
    return "";
  }
  
  public boolean isReady()
  {
    return (this.hasLoadWAWebviewJs) && (this.hasPageJsLoaded);
  }
  
  public void loadApkg() {}
  
  /* Error */
  public void loadHtml()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 514	com/tencent/mobileqq/mini/appbrand/page/PageWebview:hasLoadHtml	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 514	com/tencent/mobileqq/mini/appbrand/page/PageWebview:hasLoadHtml	Z
    //   19: ldc_w 325
    //   22: iconst_1
    //   23: ldc_w 516
    //   26: invokestatic 313	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: sipush 623
    //   33: invokespecial 126	com/tencent/mobileqq/mini/appbrand/page/PageWebview:reportAppQualityEvent	(I)V
    //   36: aload_0
    //   37: ldc_w 518
    //   40: invokevirtual 521	com/tencent/mobileqq/mini/appbrand/page/PageWebview:loadUrl	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: sipush 624
    //   47: invokespecial 126	com/tencent/mobileqq/mini/appbrand/page/PageWebview:reportAppQualityEvent	(I)V
    //   50: goto -39 -> 11
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	PageWebview
    //   6	2	1	bool	boolean
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   14	50	53	finally
  }
  
  public void loadPageWebviewJs(ApkgInfo paramApkgInfo)
  {
    if (bbkk.a(this.mRouteUrl)) {}
    while ((this.hasFLoad) || (!this.hasLoadHtmlFinish)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "----loadPageWebviewJs---- webviewid:" + this.pageWebviewId);
    }
    onWebViewReady(paramApkgInfo);
    this.hasFLoad = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.webviewContainer != null) {
      this.webviewContainer.onPause();
    }
  }
  
  public void onPause(boolean paramBoolean)
  {
    super.onPause(paramBoolean);
    if ((paramBoolean) && (this.webviewContainer != null)) {
      this.webviewContainer.notifyOnPageWebViewPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.webviewContainer != null) {
      this.webviewContainer.onResume();
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if ((paramBoolean) && (this.webviewContainer != null)) {
      this.webviewContainer.notifyOnPageWebViewResume();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.webviewScrollListenerList != null) && (this.webviewScrollListenerList.size() > 0))
    {
      Iterator localIterator = this.webviewScrollListenerList.iterator();
      while (localIterator.hasNext()) {
        ((PageWebview.OnWebviewScrollListener)localIterator.next()).onVerticalScroll(paramInt2);
      }
    }
    this.scrollY = paramInt2;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.d(TAG, 1, "onSizeChanged -- w : " + paramInt1 + "; h : " + paramInt2);
    if (isReady())
    {
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject2.put("windowWidth", (int)(paramInt1 / DisplayUtil.getDensity(getContext())));
        localJSONObject2.put("windowHeight", (int)(paramInt2 / DisplayUtil.getDensity(getContext())));
        localJSONObject1.put("size", localJSONObject2);
        this.appBrandRuntime.evaluateServiceSubcribeJS("onViewDidResize", localJSONObject1.toString());
        evaluateSubcribeJS("onViewDidResize", localJSONObject1.toString(), this.pageWebviewId);
        QLog.d(TAG, 1, "onSizeChanged isReady true, already send to js");
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          QLog.e(TAG, 1, "onSizeChanged, JSONException!");
        }
      }
    }
    QLog.d(TAG, 1, "onSizeChanged isReady false, do nothing.");
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    if (this.eventListener != null) {
      this.eventListener.onWebViewEvent(paramString1, paramString2, paramString3, this.apkgInfo.appId, this.pageWebviewId);
    }
  }
  
  public void removeWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    if ((this.webviewScrollListenerList != null) && (this.webviewScrollListenerList.contains(paramOnWebviewScrollListener))) {
      this.webviewScrollListenerList.remove(paramOnWebviewScrollListener);
    }
  }
  
  public void resetTitle()
  {
    evaluteJs("document.title=\"\"");
  }
  
  public void setEnableNativeBuffer(boolean paramBoolean)
  {
    this.mEnableNativeBuffer = paramBoolean;
  }
  
  public void setEnableShowBackHome(boolean paramBoolean)
  {
    QLog.d(TAG, 2, "setEnableShowBackHome : " + paramBoolean);
    this.mEnableShowBackHome = paramBoolean;
  }
  
  public void setOnWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    if (this.webviewScrollListenerList == null) {
      this.webviewScrollListenerList = new ArrayList();
    }
    this.webviewScrollListenerList.add(paramOnWebviewScrollListener);
  }
  
  public void setTitle()
  {
    if (this.apkgInfo != null)
    {
      String str = "\"" + this.apkgInfo.appId + ":" + this.mRouteUrl + ":VISIBLE\"";
      evaluteJs("document.title=" + str);
    }
  }
  
  public void shotWebview(PageWebview.WebviewShotCallback paramWebviewShotCallback)
  {
    ThreadManager.getSubThreadHandler().post(new PageWebview.3(this, paramWebviewShotCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */