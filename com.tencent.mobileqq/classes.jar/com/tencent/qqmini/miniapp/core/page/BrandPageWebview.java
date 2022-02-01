package com.tencent.qqmini.miniapp.core.page;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.StateTransfer;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo.PageHtmlContent;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class BrandPageWebview
  extends JsStatMachine
  implements IJsService
{
  public static final int EVENT_INIT_SUCC = 3;
  public static final int EVENT_JS_APP_CONFIG_READY = 8;
  public static final int EVENT_JS_CONFIG_READY = 5;
  public static final int EVENT_JS_DEBUG_READY = 9;
  public static final int EVENT_JS_PAGE_FRAME_HTML_READY = 11;
  public static final int EVENT_JS_PAGE_FRAME_READY = 12;
  public static final int EVENT_JS_PAGE_GENERATE_FUNC_READY = 14;
  public static final int EVENT_JS_PAGE_READY = 13;
  public static final int EVENT_JS_REMOTE_DEBUG_READY = 7;
  public static final int EVENT_JS_WA_READY = 6;
  public static final int EVENT_JS_WXSS_READY = 10;
  public static final int EVENT_LOAD_PAGE = 4;
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  private static final String PREF_HTML_URL = "https://appservice.qq.com/";
  private static final String TAG = "BrandPageWebview";
  public FrameLayout customContainer;
  public IX5WebChromeClient.CustomViewCallback customViewCallback;
  private byte[] defaultPageHtmlBytes;
  public boolean isFullScreen = false;
  private ApkgInfo mApkgInfo;
  private AppBrandPageContainer mAppBrandPageContainer;
  private IMiniAppContext mContext;
  private boolean mEnableNativeBuffer = false;
  private PageEventListener mEventListener;
  public View mFullscreenView = null;
  private StateMachine.OnStateChangeListener mOnStateChangeListener = new BrandPageWebview.1(this);
  private String mOpenType = "appLaunch";
  private PageWebview mRealWebView;
  private String mShowingUrl;
  private JsStatMachine.JsState statDebugJsLoading = new JsStatMachine.JsState(this, 13).nextState(this.stateDebugJsLoadSucc);
  private StateMachine.State stateDebugJsLoadSucc = new StateMachine.State(this, Integer.valueOf(14));
  private StateMachine.State stateDefaultConfigJsLoadSucc = new StateMachine.State(this, Integer.valueOf(6));
  private JsStatMachine.JsState stateDefaultConfigJsLoading = new JsStatMachine.JsState(this, 5).nextState(this.stateDefaultConfigJsLoadSucc);
  private StateMachine.State stateGenerateFuncReady = new StateMachine.State(this, Integer.valueOf(23));
  private StateMachine.State stateGlobalConfigJsLoadSucc = new StateMachine.State(this, Integer.valueOf(12));
  private JsStatMachine.JsState stateGlobalConfigJsLoading = new JsStatMachine.JsState(this, 11).nextState(this.stateGlobalConfigJsLoadSucc);
  private StateMachine.State stateInited = new StateMachine.State(this, Integer.valueOf(2));
  private StateMachine.State stateInitial = new StateMachine.State(this, Integer.valueOf(1));
  private StateMachine.State stateLoadSucc = new StateMachine.State(this, Integer.valueOf(22));
  private StateMachine.State statePageFrameHtmlJsLoadSucc = new StateMachine.State(this, Integer.valueOf(18));
  private JsStatMachine.JsState statePageFrameHtmlJsLoading = new JsStatMachine.JsState(this, 17).nextState(this.statePageFrameHtmlJsLoadSucc);
  private StateMachine.State statePageFrameJsLoadSucc = new StateMachine.State(this, Integer.valueOf(20));
  private JsStatMachine.JsState statePageFrameJsLoading = new JsStatMachine.JsState(this, 19).nextState(this.statePageFrameJsLoadSucc);
  private JsStatMachine.JsState statePageJsLoading = new JsStatMachine.JsState(this, 21).nextState(this.stateLoadSucc);
  private StateMachine.State statePageLoadSucc = new StateMachine.State(this, Integer.valueOf(4));
  private StateMachine.State statePageLoading = new StateMachine.State(this, Integer.valueOf(3));
  private StateMachine.State stateRemoteDebugJsLoadSucc = new StateMachine.State(this, Integer.valueOf(10));
  private JsStatMachine.JsState stateRemoteDebugJsLoading = new JsStatMachine.JsState(this, 9).nextState(this.stateRemoteDebugJsLoadSucc);
  private StateMachine.State stateWaJsLoadSucc = new StateMachine.State(this, Integer.valueOf(8));
  private JsStatMachine.JsState stateWaJsLoading = new JsStatMachine.JsState(this, 7).nextState(this.stateWaJsLoadSucc);
  private StateMachine.State stateWxssJsLoadSucc = new StateMachine.State(this, Integer.valueOf(16));
  private JsStatMachine.JsState stateWxssJsLoading = new JsStatMachine.JsState(this, 15).nextState(this.stateWxssJsLoadSucc);
  private String waConsoleJsStr;
  
  public BrandPageWebview(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    this.mContext = paramIMiniAppContext;
    this.mAppBrandPageContainer = paramAppBrandPageContainer;
    addStateChangeListener(this.mOnStateChangeListener);
    setCurrState(this.stateInitial);
    initStateConfig();
    initPageWebview();
    setCurrState(this.stateInited);
    loadDefaultHtml();
  }
  
  private boolean checkEnableIPV6Only()
  {
    return WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
  }
  
  private WebResourceResponse doInterceptPrefFile(String paramString, WebResourceResponse paramWebResourceResponse)
  {
    String str = paramString.substring("https://appservice.qq.com/".length());
    str = ((MiniAppFileManager)this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
    if ((ImageUtil.isJpgFile(paramString)) || (ImageUtil.isPngFile(paramString)))
    {
      bool = ImageUtil.isPngFile(paramString);
      if (bool)
      {
        paramString = "image/png";
        paramWebResourceResponse = new WebResourceResponse(paramString, "UTF-8", ImageUtil.getLocalImageStream(str, bool));
      }
    }
    while ((!paramString.endsWith(".gif")) && (!paramString.endsWith(".svg"))) {
      for (;;)
      {
        boolean bool;
        return paramWebResourceResponse;
        paramString = "image/jpg";
      }
    }
    if (paramString.endsWith(".gif")) {}
    for (paramString = "image/gif";; paramString = "image/svg+xml") {
      return new WebResourceResponse(paramString, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(str));
    }
  }
  
  /* Error */
  private WebResourceResponse doInterceptPrefHtml(WebResourceResponse paramWebResourceResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 182	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   9: ldc_w 312
    //   12: invokeinterface 261 2 0
    //   17: checkcast 312	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider
    //   20: invokevirtual 316	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider:getBasePageFrameStr	()Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: astore 4
    //   28: aload 6
    //   30: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +124 -> 157
    //   36: aload_3
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   43: ifnull +14 -> 57
    //   46: aload_3
    //   47: astore 4
    //   49: aload_0
    //   50: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   53: arraylength
    //   54: ifne +18 -> 72
    //   57: aload_3
    //   58: astore 4
    //   60: aload_0
    //   61: aload 6
    //   63: ldc_w 280
    //   66: invokevirtual 328	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   69: putfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   72: aload_3
    //   73: astore 4
    //   75: new 330	java/io/ByteArrayInputStream
    //   78: dup
    //   79: aload_0
    //   80: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   83: iconst_0
    //   84: aload_0
    //   85: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   88: arraylength
    //   89: invokespecial 333	java/io/ByteArrayInputStream:<init>	([BII)V
    //   92: astore_3
    //   93: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   96: dup
    //   97: ldc_w 335
    //   100: ldc_w 280
    //   103: aload_3
    //   104: invokespecial 287	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   107: astore 4
    //   109: new 337	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 340
    //   119: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   127: ifnull +33 -> 160
    //   130: aload_0
    //   131: getfield 324	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   134: arraylength
    //   135: istore_2
    //   136: ldc 41
    //   138: aload_1
    //   139: iload_2
    //   140: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 356	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_3
    //   150: ifnull +114 -> 264
    //   153: aload_3
    //   154: invokevirtual 359	java/io/ByteArrayInputStream:close	()V
    //   157: aload 4
    //   159: areturn
    //   160: iconst_0
    //   161: istore_2
    //   162: goto -26 -> 136
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 362	java/io/IOException:printStackTrace	()V
    //   170: aload 4
    //   172: areturn
    //   173: astore 4
    //   175: aload 5
    //   177: astore_3
    //   178: aload 4
    //   180: astore 5
    //   182: aload_3
    //   183: astore 4
    //   185: aload 5
    //   187: invokevirtual 363	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   190: aload_3
    //   191: astore 4
    //   193: ldc 41
    //   195: ldc_w 365
    //   198: aload 5
    //   200: invokestatic 369	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: astore 4
    //   206: aload_3
    //   207: ifnull -50 -> 157
    //   210: aload_3
    //   211: invokevirtual 359	java/io/ByteArrayInputStream:close	()V
    //   214: aload_1
    //   215: areturn
    //   216: astore_3
    //   217: aload_3
    //   218: invokevirtual 362	java/io/IOException:printStackTrace	()V
    //   221: aload_1
    //   222: areturn
    //   223: astore_1
    //   224: aload 4
    //   226: ifnull +8 -> 234
    //   229: aload 4
    //   231: invokevirtual 359	java/io/ByteArrayInputStream:close	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 362	java/io/IOException:printStackTrace	()V
    //   241: goto -7 -> 234
    //   244: astore_1
    //   245: aload_3
    //   246: astore 4
    //   248: goto -24 -> 224
    //   251: astore 5
    //   253: goto -71 -> 182
    //   256: astore 5
    //   258: aload 4
    //   260: astore_1
    //   261: goto -79 -> 182
    //   264: aload 4
    //   266: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	BrandPageWebview
    //   0	267	1	paramWebResourceResponse	WebResourceResponse
    //   135	27	2	i	int
    //   1	210	3	localObject1	Object
    //   216	2	3	localIOException1	java.io.IOException
    //   236	10	3	localIOException2	java.io.IOException
    //   26	145	4	localObject2	Object
    //   173	6	4	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   183	82	4	localObject3	Object
    //   3	196	5	localObject4	Object
    //   251	1	5	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   256	1	5	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   23	39	6	str	String
    // Exception table:
    //   from	to	target	type
    //   153	157	165	java/io/IOException
    //   39	46	173	java/io/UnsupportedEncodingException
    //   49	57	173	java/io/UnsupportedEncodingException
    //   60	72	173	java/io/UnsupportedEncodingException
    //   75	93	173	java/io/UnsupportedEncodingException
    //   210	214	216	java/io/IOException
    //   39	46	223	finally
    //   49	57	223	finally
    //   60	72	223	finally
    //   75	93	223	finally
    //   185	190	223	finally
    //   193	203	223	finally
    //   229	234	236	java/io/IOException
    //   93	109	244	finally
    //   109	136	244	finally
    //   136	149	244	finally
    //   93	109	251	java/io/UnsupportedEncodingException
    //   109	136	256	java/io/UnsupportedEncodingException
    //   136	149	256	java/io/UnsupportedEncodingException
  }
  
  private WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("https://appservice.qq.com/")) && (paramString.endsWith(".html"))) {
      return doInterceptPrefHtml(null);
    }
    if (paramString.startsWith("https://appservice.qq.com/")) {
      return doInterceptPrefFile(paramString, null);
    }
    if (paramString.startsWith("wxfile://"))
    {
      String str = ((MiniAppFileManager)this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      if ((ImageUtil.isJpgFile(paramString)) || (ImageUtil.isPngFile(paramString)))
      {
        boolean bool = ImageUtil.isPngFile(paramString);
        if (bool) {}
        for (paramWebView = "image/png";; paramWebView = "image/jpg") {
          return new WebResourceResponse(paramWebView, "UTF-8", ImageUtil.getLocalImageStream(str, bool));
        }
      }
      if ((paramString.endsWith(".gif")) || (paramString.endsWith(".svg")))
      {
        if (paramString.endsWith(".gif")) {}
        for (paramWebView = "image/gif";; paramWebView = "image/svg+xml") {
          return new WebResourceResponse(paramWebView, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(str));
        }
      }
    }
    return null;
  }
  
  private void initPageWebview()
  {
    this.mRealWebView = new PageWebview(this.mContext, this.mAppBrandPageContainer, this);
    this.mRealWebView.addJavascriptInterface(this, "WeixinJSCore");
    this.mRealWebView.setWebViewClient(new BrandPageWebview.2(this));
    this.mRealWebView.setWebChromeClient(new BrandPageWebview.3(this));
  }
  
  public void cleanUp()
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
      if (this.mRealWebView != null)
      {
        this.mRealWebView.removeJavascriptInterface("WeixinJSCore");
        this.mRealWebView.destroy();
      }
      return;
    }
    catch (Exception localException)
    {
      break label39;
    }
  }
  
  public int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.isFullScreen)
    {
      bool1 = bool2;
      if (this.mFullscreenView != null)
      {
        bool1 = bool2;
        if (this.customContainer != null)
        {
          bool1 = bool2;
          if (this.customContainer.getVisibility() == 0)
          {
            bool1 = bool2;
            if (paramKeyEvent.getKeyCode() == 4)
            {
              QMLog.d("miniapp-embedded", "KEYCODE_BACK");
              this.isFullScreen = false;
              evaluateSubscribeJS("onXWebVideoExitFullscreen", null, getWebViewId());
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public WebResourceResponse doIPV6OnlyRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    paramWebView = paramWebResourceRequest.getUrl().toString();
    String str = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    HttpURLConnection localHttpURLConnection;
    try
    {
      str = str + paramWebView;
      QMLog.e("BrandPageWebview", "ipv6 url = " + str);
      localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
      localHttpURLConnection.setRequestMethod(paramWebResourceRequest.getMethod());
      if (paramWebResourceRequest.getRequestHeaders() != null)
      {
        paramWebView = paramWebResourceRequest.getRequestHeaders().entrySet().iterator();
        while (paramWebView.hasNext())
        {
          paramWebResourceRequest = (Map.Entry)paramWebView.next();
          localHttpURLConnection.setRequestProperty((String)paramWebResourceRequest.getKey(), (String)paramWebResourceRequest.getValue());
        }
      }
      localHttpURLConnection.setConnectTimeout(6000);
    }
    catch (Exception paramWebView)
    {
      QMLog.e("BrandPageWebview", "shouldInterceptRequest: failed ", paramWebView);
      return null;
    }
    localHttpURLConnection.setReadTimeout(6000);
    paramWebResourceRequest = "";
    paramWebView = paramWebResourceRequest;
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      paramWebView = paramWebResourceRequest;
      if (localHttpURLConnection.getHeaderFields().containsKey("Content-Type")) {
        paramWebView = (String)((List)localHttpURLConnection.getHeaderFields().get("Content-Type")).get(0);
      }
    }
    paramWebResourceRequest = IPV6OnlyUtils.getMimeType(paramWebView);
    paramWebView = IPV6OnlyUtils.getEncoding(paramWebView);
    QMLog.e("BrandPageWebview", "ipv6 code:" + localHttpURLConnection.getResponseCode() + "  url:" + str);
    QMLog.e("BrandPageWebview", "ipv6 mimeType = " + paramWebResourceRequest + "encoding:" + paramWebView);
    paramWebView = new WebResourceResponse(paramWebResourceRequest, paramWebView, localHttpURLConnection.getInputStream());
    return paramWebView;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    evaluateJs(paramString, paramValueCallback, null);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    int i = 150;
    if (QMLog.isColorLevel()) {
      if (paramString1.length() <= 150) {
        break label109;
      }
    }
    for (;;)
    {
      paramString2 = paramString1.substring(0, i);
      QMLog.d("BrandPageWebview", "evaluateJs: " + paramString2 + "   (" + this + ") --> id:" + getWebViewId());
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break;
      }
      if (this.mRealWebView != null) {
        this.mRealWebView.evaluateJavascript(paramString1, AppBrandUtil.convertValueCallback(paramValueCallback));
      }
      return;
      label109:
      i = paramString1.length();
    }
    this.mMainHandler.post(new BrandPageWebview.6(this, paramString1, paramValueCallback));
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    evaluateJs("WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")", null);
  }
  
  public void evaluateSubscribeJSInService(String paramString1, String paramString2, int paramInt)
  {
    evaluateJs("WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + 0 + ",\"" + paramInt + "\")", null);
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", paramApkgInfo.appId);
      localJSONObject.put("icon", paramApkgInfo.iconUrl);
      localJSONObject.put("nickname", paramApkgInfo.apkgName);
      String str2 = "release";
      String str1 = "";
      if (paramApkgInfo.mMiniAppInfo != null)
      {
        str2 = paramApkgInfo.mMiniAppInfo.getVerTypeStr();
        str1 = paramApkgInfo.mMiniAppInfo.version;
      }
      str2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "'; __qqConfig.miniapp_version='" + str1 + "';", new Object[] { paramApkgInfo.mConfigStr, localJSONObject.toString() });
      str1 = str2;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        str1 = str2 + "__qqConfig.debug=true;";
      }
      paramApkgInfo = WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
      paramApkgInfo = str1 + "__qqConfig.openDataHosts='" + paramApkgInfo + "';";
      return paramApkgInfo + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject1).put("env", localObject2);
      ((JSONObject)localObject1).put("preload", paramBoolean);
      localObject1 = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.QUA='" + QUAUtil.getPlatformQUA() + "';__qqConfig.platform = 'android';", new Object[] { localObject1 });
      String str = (String)localObject1 + "__qqConfig.XWebVideoMinVersion=045100;";
      localObject2 = str;
      if (getRealView() != null)
      {
        localObject2 = str;
        if (getRealView().getEmbeddedState() != null)
        {
          paramBoolean = getRealView().getEmbeddedState().isEnableEmbeddedVideo();
          localObject1 = str;
          if (paramBoolean) {
            localObject1 = str + "__qqConfig.useXWebVideo=" + paramBoolean + ";";
          }
          paramBoolean = getRealView().getEmbeddedState().isEnableEmbeddedLive();
          localObject2 = localObject1;
          if (paramBoolean) {
            localObject2 = (String)localObject1 + "__qqConfig.useXWebLive=" + paramBoolean + ";";
          }
        }
      }
      QMLog.d("minisdk-start", "getJsDefaultConfig pageWebview String: " + (String)localObject2);
      return localObject2;
    }
    catch (Exception localException)
    {
      QMLog.e("BrandPageWebview", "getJsDefaultConfig failed: " + localException);
    }
    return "";
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return new byte[0];
  }
  
  public PageEventListener getPageEventListener()
  {
    return this.mEventListener;
  }
  
  public PageWebview getRealView()
  {
    return this.mRealWebView;
  }
  
  public String getShowingUrl()
  {
    return this.mShowingUrl;
  }
  
  public int getWebViewId()
  {
    return this.mRealWebView.getPageWebViewId();
  }
  
  public boolean handleBackPressed()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleBackPressed : ");
    if (this.mFullscreenView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.d("miniapp-embedded", bool);
      if (this.mFullscreenView == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    String str = getJsDefaultConfig(true);
    this.stateDefaultConfigJsLoading.setJsContent(str);
    appendEvent(Integer.valueOf(5));
    str = paramBaselibContent.waWebviewJsStr;
    this.stateWaJsLoading.setJsContent(str);
    appendEvent(Integer.valueOf(6));
    str = paramBaselibContent.waRemoteDebugStr;
    this.stateRemoteDebugJsLoading.setJsContent(str);
    appendEvent(Integer.valueOf(7));
    this.waConsoleJsStr = paramBaselibContent.waConsoleJsStr;
  }
  
  protected void initStateConfig()
  {
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInitial).next(this.stateInited).registEvent(Integer.valueOf(3)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.statePageLoadSucc).next(this.stateDefaultConfigJsLoading).registEvent(Integer.valueOf(5)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateDefaultConfigJsLoadSucc).next(this.stateWaJsLoading).registEvent(Integer.valueOf(6)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateWaJsLoadSucc).next(this.stateRemoteDebugJsLoading).registEvent(Integer.valueOf(7)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateRemoteDebugJsLoadSucc).next(this.stateGlobalConfigJsLoading).registEvent(Integer.valueOf(8)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateGlobalConfigJsLoadSucc).next(this.statDebugJsLoading).registEvent(Integer.valueOf(9)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateDebugJsLoadSucc).next(this.stateWxssJsLoading).registEvent(Integer.valueOf(10)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateWxssJsLoadSucc).next(this.statePageFrameHtmlJsLoading).registEvent(Integer.valueOf(11)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.statePageFrameHtmlJsLoadSucc).next(this.statePageFrameJsLoading).registEvent(Integer.valueOf(12)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.statePageFrameJsLoadSucc).next(this.statePageJsLoading).registEvent(Integer.valueOf(13)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateLoadSucc).next(this.stateGenerateFuncReady).registEvent(Integer.valueOf(14)));
    setCurrState(this.stateInitial);
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1)) {
      return "";
    }
    if (this.mEventListener != null) {
      return this.mEventListener.onWebViewNativeRequest(paramString1, paramString2, this, paramInt);
    }
    return "";
  }
  
  public boolean isReady()
  {
    return this.stateGenerateFuncReady == getCurrState();
  }
  
  public void loadDefaultHtml()
  {
    if (this.mRealWebView != null)
    {
      setCurrState(this.statePageLoading);
      this.mRealWebView.loadUrl("https://appservice.qq.com/page-frame.html");
    }
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    this.mShowingUrl = paramString1;
    this.mOpenType = paramString2;
    paramString2 = ((BaseRuntimeImpl.BaselibProvider)this.mContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBasePageFrameStr();
    paramString2 = this.mApkgInfo.getPageHtmlContent(paramString2).jsStr;
    this.statePageFrameHtmlJsLoading.setJsContent(paramString2);
    appendEvent(Integer.valueOf(11));
    paramString2 = this.mApkgInfo.getPageFrameJSStr(paramString1);
    this.statePageFrameJsLoading.setJsContent(paramString2);
    appendEvent(Integer.valueOf(12));
    paramString1 = this.mApkgInfo.getPageJsStr(paramString1);
    this.statePageJsLoading.setJsContent(paramString1);
    appendEvent(Integer.valueOf(13));
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    if (this.mEventListener != null) {
      this.mEventListener.onWebViewEvent(paramString1, paramString2, this.mRealWebView.getPageWebViewId());
    }
    if ((paramString1.equals("custom_event_GenerateFuncReady")) && (this.mAppBrandPageContainer != null))
    {
      QMLog.i("BrandPageWebview", "custom_event_GenerateFuncReady.(" + this + ") id:" + getWebViewId());
      appendEvent(Integer.valueOf(14));
    }
    if ((paramString1.equals("custom_event_PAGE_EVENT")) && (paramString2.contains("DOMReady")) && (this.mAppBrandPageContainer != null))
    {
      QMLog.i("BrandPageWebview", "custom_event_PAGE_EVENT __DOMReady.  Show the page.(" + this + ") id:" + getWebViewId());
      this.mContext.performAction(AppStateEvent.obtain(11));
      if (this.mAppBrandPageContainer.getAppBrandPagePool() != null) {
        AppBrandTask.runTaskOnUiThreadDelay(new BrandPageWebview.4(this), 1000L);
      }
      if ((this.mAppBrandPageContainer.getShowingPage() != null) && (this.mAppBrandPageContainer.getShowingPage().getVisibility() != 0) && (!this.mAppBrandPageContainer.getShowingPage().isHomePage())) {
        AppBrandTask.runTaskOnUiThread(new BrandPageWebview.5(this));
      }
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return;
    }
    this.mApkgInfo = paramApkgInfo;
    String str = getJSGlobalConfig(paramApkgInfo);
    this.stateGlobalConfigJsLoading.setJsContent(str);
    appendEvent(Integer.valueOf(8));
    if (StorageUtil.getPreference().getBoolean(this.mApkgInfo.appId + "_debug", false)) {
      if (!TextUtils.isEmpty(this.waConsoleJsStr))
      {
        str = this.waConsoleJsStr;
        this.statDebugJsLoading.setJsContent(str);
      }
    }
    for (;;)
    {
      appendEvent(Integer.valueOf(9));
      paramApkgInfo = paramApkgInfo.getRootWxssJsContent();
      this.stateWxssJsLoading.setJsContent(paramApkgInfo);
      appendEvent(Integer.valueOf(10));
      return;
      str = "";
      break;
      this.statDebugJsLoading.setJsContent("");
    }
  }
  
  public void setCurrState(StateMachine.State paramState)
  {
    StateMachine.State localState;
    if (paramState == this.stateGenerateFuncReady)
    {
      if (this.mEventListener != null)
      {
        QMLog.d("BrandPageWebview", "onWebViewReady  (" + this + ")");
        this.mEventListener.onWebViewReady(this.mOpenType, this.mShowingUrl, this.mRealWebView.getPageWebViewId());
      }
    }
    else
    {
      localState = getCurrState();
      if (localState != this.stateWaJsLoading) {
        break label140;
      }
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 18, "0");
    }
    for (;;)
    {
      super.setCurrState(paramState);
      return;
      QMLog.d("BrandPageWebview", "onWebViewReady no listener  (" + this + ")");
      break;
      label140:
      if (this.stateRemoteDebugJsLoadSucc == localState) {
        MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 19, "0");
      }
    }
  }
  
  public void setWebViewEventListener(PageEventListener paramPageEventListener)
  {
    this.mEventListener = paramPageEventListener;
    if (this.mRealWebView != null) {
      this.mRealWebView.setPageEventListener(paramPageEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview
 * JD-Core Version:    0.7.0.1
 */