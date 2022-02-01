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
    boolean bool = false;
    if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private WebResourceResponse doInterceptPrefFile(String paramString, WebResourceResponse paramWebResourceResponse)
  {
    String str = paramString.substring(26);
    str = ((MiniAppFileManager)this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
    if ((!ImageUtil.isJpgFile(paramString)) && (!ImageUtil.isPngFile(paramString)))
    {
      if ((paramString.endsWith(".gif")) || (paramString.endsWith(".svg")))
      {
        if (paramString.endsWith(".gif")) {
          paramString = "image/gif";
        } else {
          paramString = "image/svg+xml";
        }
        return new WebResourceResponse(paramString, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(str));
      }
    }
    else
    {
      boolean bool = ImageUtil.isPngFile(paramString);
      if (bool) {
        paramString = "image/png";
      } else {
        paramString = "image/jpg";
      }
      paramWebResourceResponse = new WebResourceResponse(paramString, "UTF-8", ImageUtil.getLocalImageStream(str, bool));
    }
    return paramWebResourceResponse;
  }
  
  /* Error */
  private WebResourceResponse doInterceptPrefHtml(WebResourceResponse paramWebResourceResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 182	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   4: ldc_w 308
    //   7: invokeinterface 257 2 0
    //   12: checkcast 308	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider
    //   15: invokevirtual 312	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider:getBasePageFrameStr	()Ljava/lang/String;
    //   18: astore 6
    //   20: aload 6
    //   22: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +277 -> 302
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 5
    //   34: aload 5
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   42: astore 8
    //   44: aload 8
    //   46: ifnull +15 -> 61
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   57: arraylength
    //   58: ifne +19 -> 77
    //   61: aload 5
    //   63: astore 4
    //   65: aload_0
    //   66: aload 6
    //   68: ldc_w 285
    //   71: invokevirtual 324	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   74: putfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   77: aload 5
    //   79: astore 4
    //   81: aload_0
    //   82: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   85: astore 6
    //   87: aload 5
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   95: arraylength
    //   96: istore_3
    //   97: iconst_0
    //   98: istore_2
    //   99: aload 5
    //   101: astore 4
    //   103: new 326	java/io/ByteArrayInputStream
    //   106: dup
    //   107: aload 6
    //   109: iconst_0
    //   110: iload_3
    //   111: invokespecial 329	java/io/ByteArrayInputStream:<init>	([BII)V
    //   114: astore 5
    //   116: new 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   119: dup
    //   120: ldc_w 331
    //   123: ldc_w 285
    //   126: aload 5
    //   128: invokespecial 292	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   131: astore 4
    //   133: new 333	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   140: astore_1
    //   141: aload_1
    //   142: ldc_w 336
    //   145: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_0
    //   150: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: getfield 320	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   160: arraylength
    //   161: istore_2
    //   162: aload_1
    //   163: iload_2
    //   164: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 41
    //   170: aload_1
    //   171: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 352	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 5
    //   179: invokevirtual 355	java/io/ByteArrayInputStream:close	()V
    //   182: goto +8 -> 190
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   190: aload 4
    //   192: areturn
    //   193: astore 6
    //   195: aload 5
    //   197: astore_1
    //   198: aload 4
    //   200: astore 5
    //   202: goto +38 -> 240
    //   205: astore_1
    //   206: goto +74 -> 280
    //   209: astore 6
    //   211: aload 5
    //   213: astore 4
    //   215: aload_1
    //   216: astore 5
    //   218: aload 4
    //   220: astore_1
    //   221: goto +19 -> 240
    //   224: astore_1
    //   225: aload 4
    //   227: astore 5
    //   229: goto +51 -> 280
    //   232: astore 6
    //   234: aload_1
    //   235: astore 5
    //   237: aload 7
    //   239: astore_1
    //   240: aload_1
    //   241: astore 4
    //   243: aload 6
    //   245: invokevirtual 359	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   248: aload_1
    //   249: astore 4
    //   251: ldc 41
    //   253: ldc_w 361
    //   256: aload 6
    //   258: invokestatic 365	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload_1
    //   262: ifnull +15 -> 277
    //   265: aload_1
    //   266: invokevirtual 355	java/io/ByteArrayInputStream:close	()V
    //   269: goto +8 -> 277
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   277: aload 5
    //   279: areturn
    //   280: aload 5
    //   282: ifnull +18 -> 300
    //   285: aload 5
    //   287: invokevirtual 355	java/io/ByteArrayInputStream:close	()V
    //   290: goto +10 -> 300
    //   293: astore 4
    //   295: aload 4
    //   297: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   300: aload_1
    //   301: athrow
    //   302: aload_1
    //   303: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	BrandPageWebview
    //   0	304	1	paramWebResourceResponse	WebResourceResponse
    //   98	66	2	i	int
    //   96	15	3	j	int
    //   36	214	4	localObject1	Object
    //   293	3	4	localIOException	java.io.IOException
    //   32	254	5	localObject2	Object
    //   18	90	6	localObject3	Object
    //   193	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   209	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   232	25	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   29	209	7	localObject4	Object
    //   42	3	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   177	182	185	java/io/IOException
    //   133	149	193	java/io/UnsupportedEncodingException
    //   149	162	193	java/io/UnsupportedEncodingException
    //   162	177	193	java/io/UnsupportedEncodingException
    //   116	133	205	finally
    //   133	149	205	finally
    //   149	162	205	finally
    //   162	177	205	finally
    //   116	133	209	java/io/UnsupportedEncodingException
    //   38	44	224	finally
    //   53	61	224	finally
    //   65	77	224	finally
    //   81	87	224	finally
    //   91	97	224	finally
    //   103	116	224	finally
    //   243	248	224	finally
    //   251	261	224	finally
    //   38	44	232	java/io/UnsupportedEncodingException
    //   53	61	232	java/io/UnsupportedEncodingException
    //   65	77	232	java/io/UnsupportedEncodingException
    //   81	87	232	java/io/UnsupportedEncodingException
    //   91	97	232	java/io/UnsupportedEncodingException
    //   103	116	232	java/io/UnsupportedEncodingException
    //   265	269	272	java/io/IOException
    //   285	290	293	java/io/IOException
  }
  
  private WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
  {
    boolean bool = paramString.startsWith("https://appservice.qq.com/");
    Object localObject = null;
    if ((bool) && (paramString.endsWith(".html"))) {
      return doInterceptPrefHtml(null);
    }
    if (paramString.startsWith("https://appservice.qq.com/")) {
      return doInterceptPrefFile(paramString, null);
    }
    paramWebView = localObject;
    if (paramString.startsWith("wxfile://"))
    {
      String str = ((MiniAppFileManager)this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      if ((!ImageUtil.isJpgFile(paramString)) && (!ImageUtil.isPngFile(paramString)))
      {
        if (!paramString.endsWith(".gif"))
        {
          paramWebView = localObject;
          if (!paramString.endsWith(".svg")) {}
        }
        else
        {
          if (paramString.endsWith(".gif")) {
            paramWebView = "image/gif";
          } else {
            paramWebView = "image/svg+xml";
          }
          return new WebResourceResponse(paramWebView, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(str));
        }
      }
      else
      {
        bool = ImageUtil.isPngFile(paramString);
        if (bool) {
          paramWebView = "image/png";
        } else {
          paramWebView = "image/jpg";
        }
        paramWebView = new WebResourceResponse(paramWebView, "UTF-8", ImageUtil.getLocalImageStream(str, bool));
      }
    }
    return paramWebView;
  }
  
  private void initPageWebview()
  {
    this.mRealWebView = new PageWebview(this.mContext, this.mAppBrandPageContainer, this);
    this.mRealWebView.addJavascriptInterface(this, "WeixinJSCore");
    setWebviewClient();
    setWebChromeClient();
  }
  
  private void setWebChromeClient()
  {
    this.mRealWebView.setWebChromeClient(new BrandPageWebview.2(this));
  }
  
  private void setWebviewClient()
  {
    this.mRealWebView.setWebViewClient(new BrandPageWebview.3(this));
  }
  
  private void webviewReport()
  {
    StateMachine.State localState = getCurrState();
    if (localState == this.stateWaJsLoading)
    {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 18, "0");
      return;
    }
    if (this.stateRemoteDebugJsLoadSucc == localState)
    {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 19, "0");
      return;
    }
    if (this.stateInitial == localState)
    {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 102, "0");
      return;
    }
    if (this.stateInited == localState)
    {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 103, "0");
      return;
    }
    if (this.stateGlobalConfigJsLoading == localState)
    {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 106, "0");
      return;
    }
    if (this.stateLoadSucc == localState) {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 107, "0");
    }
  }
  
  public void cleanUp()
  {
    Object localObject = this.customViewCallback;
    if (localObject != null) {
      ((IX5WebChromeClient.CustomViewCallback)localObject).onCustomViewHidden();
    }
    localObject = this.customContainer;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    try
    {
      this.customContainer.removeAllViews();
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    this.customContainer = null;
    this.mFullscreenView = null;
    this.customViewCallback = null;
    localObject = this.mRealWebView;
    if (localObject != null)
    {
      ((PageWebview)localObject).removeJavascriptInterface("WeixinJSCore");
      this.mRealWebView.destroy();
    }
  }
  
  public int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.isFullScreen) && (this.mFullscreenView != null))
    {
      FrameLayout localFrameLayout = this.customContainer;
      if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        QMLog.d("miniapp-embedded", "KEYCODE_BACK");
        this.isFullScreen = false;
        evaluateSubscribeJS("onXWebVideoExitFullscreen", null, getWebViewId());
        return true;
      }
    }
    return false;
  }
  
  public WebResourceResponse doIPV6OnlyRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    paramWebView = paramWebResourceRequest.getUrl().toString();
    Object localObject1 = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramWebView);
      localObject1 = ((StringBuilder)localObject2).toString();
      paramWebView = new StringBuilder();
      paramWebView.append("ipv6 url = ");
      paramWebView.append((String)localObject1);
      QMLog.e("BrandPageWebview", paramWebView.toString());
      localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
      ((HttpURLConnection)localObject2).setRequestMethod(paramWebResourceRequest.getMethod());
      if (paramWebResourceRequest.getRequestHeaders() != null)
      {
        paramWebView = paramWebResourceRequest.getRequestHeaders().entrySet().iterator();
        while (paramWebView.hasNext())
        {
          paramWebResourceRequest = (Map.Entry)paramWebView.next();
          ((HttpURLConnection)localObject2).setRequestProperty((String)paramWebResourceRequest.getKey(), (String)paramWebResourceRequest.getValue());
        }
      }
      ((HttpURLConnection)localObject2).setConnectTimeout(6000);
      ((HttpURLConnection)localObject2).setReadTimeout(6000);
      paramWebResourceRequest = "";
      paramWebView = paramWebResourceRequest;
      if (((HttpURLConnection)localObject2).getHeaderFields() != null)
      {
        paramWebView = paramWebResourceRequest;
        if (((HttpURLConnection)localObject2).getHeaderFields().containsKey("Content-Type")) {
          paramWebView = (String)((List)((HttpURLConnection)localObject2).getHeaderFields().get("Content-Type")).get(0);
        }
      }
      paramWebResourceRequest = IPV6OnlyUtils.getMimeType(paramWebView);
      paramWebView = IPV6OnlyUtils.getEncoding(paramWebView);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipv6 code:");
      localStringBuilder.append(((HttpURLConnection)localObject2).getResponseCode());
      localStringBuilder.append("  url:");
      localStringBuilder.append((String)localObject1);
      QMLog.e("BrandPageWebview", localStringBuilder.toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ipv6 mimeType = ");
      ((StringBuilder)localObject1).append(paramWebResourceRequest);
      ((StringBuilder)localObject1).append("encoding:");
      ((StringBuilder)localObject1).append(paramWebView);
      QMLog.e("BrandPageWebview", ((StringBuilder)localObject1).toString());
      paramWebView = new WebResourceResponse(paramWebResourceRequest, paramWebView, ((HttpURLConnection)localObject2).getInputStream());
      return paramWebView;
    }
    catch (Exception paramWebView)
    {
      QMLog.e("BrandPageWebview", "shouldInterceptRequest: failed ", paramWebView);
    }
    return null;
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
    if (QMLog.isColorLevel())
    {
      int j = paramString1.length();
      int i = 150;
      if (j <= 150) {
        i = paramString1.length();
      }
      paramString2 = paramString1.substring(0, i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateJs: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("   (");
      localStringBuilder.append(this);
      localStringBuilder.append(") --> id:");
      localStringBuilder.append(getWebViewId());
      QMLog.d("BrandPageWebview", localStringBuilder.toString());
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString2 = this.mRealWebView;
      if (paramString2 != null) {
        paramString2.evaluateJavascript(paramString1, AppBrandUtil.convertValueCallback(paramValueCallback));
      }
    }
    else
    {
      this.mMainHandler.post(new BrandPageWebview.7(this, paramString1, paramValueCallback));
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(0);
    localStringBuilder.append(")");
    evaluateJs(localStringBuilder.toString(), null);
  }
  
  public void evaluateSubscribeJSInService(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",");
    localStringBuilder.append(0);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\")");
    evaluateJs(localStringBuilder.toString(), null);
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("appId", paramApkgInfo.appId);
      ((JSONObject)localObject3).put("icon", paramApkgInfo.iconUrl);
      ((JSONObject)localObject3).put("nickname", paramApkgInfo.apkgName);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (paramApkgInfo.mMiniAppInfo != null)
    {
      localObject1 = paramApkgInfo.mMiniAppInfo.getVerTypeStr();
      localObject2 = paramApkgInfo.mMiniAppInfo.version;
    }
    else
    {
      localObject2 = "";
      localObject1 = "release";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("'; __qqConfig.deviceinfo='");
    localStringBuilder.append(QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()));
    localStringBuilder.append("'; __qqConfig.miniapp_version='");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("';");
    Object localObject1 = String.format(localStringBuilder.toString(), new Object[] { paramApkgInfo.mConfigStr, ((JSONObject)localObject3).toString() });
    Object localObject2 = StorageUtil.getPreference();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramApkgInfo.appId);
    ((StringBuilder)localObject3).append("_debug");
    paramApkgInfo = (ApkgInfo)localObject1;
    if (((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject3).toString(), false))
    {
      paramApkgInfo = new StringBuilder();
      paramApkgInfo.append((String)localObject1);
      paramApkgInfo.append("__qqConfig.debug=true;");
      paramApkgInfo = paramApkgInfo.toString();
    }
    localObject1 = WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramApkgInfo);
    ((StringBuilder)localObject2).append("__qqConfig.openDataHosts='");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("';");
    paramApkgInfo = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramApkgInfo);
    ((StringBuilder)localObject1).append("if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};");
    return ((StringBuilder)localObject1).toString();
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject1).put("env", localObject2);
      ((JSONObject)localObject1).put("preload", paramBoolean);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.QUA='");
      ((StringBuilder)localObject2).append(QUAUtil.getPlatformQUA());
      ((StringBuilder)localObject2).append("';__qqConfig.platform = 'android';");
      localObject1 = String.format(((StringBuilder)localObject2).toString(), new Object[] { localObject1 });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("__qqConfig.XWebVideoMinVersion=045100;");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (getRealView() != null)
      {
        localObject1 = localObject2;
        if (getRealView().getEmbeddedState() != null)
        {
          paramBoolean = getRealView().getEmbeddedState().isEnableEmbeddedVideo();
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("__qqConfig.useXWebVideo=");
            ((StringBuilder)localObject1).append(paramBoolean);
            ((StringBuilder)localObject1).append(";");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          paramBoolean = getRealView().getEmbeddedState().isEnableEmbeddedLive();
          localObject2 = localObject1;
          if (paramBoolean)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("__qqConfig.useXWebLive=");
            ((StringBuilder)localObject2).append(paramBoolean);
            ((StringBuilder)localObject2).append(";");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          paramBoolean = getRealView().getEmbeddedState().isEnableEmbeddedElement();
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("__qqConfig.useXWebElement=");
            ((StringBuilder)localObject1).append(paramBoolean);
            ((StringBuilder)localObject1).append(";");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getJsDefaultConfig pageWebview String: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.d("minisdk-start", ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getJsDefaultConfig failed: ");
      ((StringBuilder)localObject2).append(localException);
      QMLog.e("BrandPageWebview", ((StringBuilder)localObject2).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleBackPressed : ");
    boolean bool;
    if (this.mFullscreenView != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QMLog.d("miniapp-embedded", localStringBuilder.toString());
    return this.mFullscreenView != null;
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
    PageEventListener localPageEventListener = this.mEventListener;
    if (localPageEventListener != null) {
      return localPageEventListener.onWebViewNativeRequest(paramString1, paramString2, this, paramInt);
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
    paramString3 = this.mEventListener;
    if (paramString3 != null) {
      paramString3.onWebViewEvent(paramString1, paramString2, this.mRealWebView.getPageWebViewId());
    }
    if ((paramString1.equals("custom_event_GenerateFuncReady")) && (this.mAppBrandPageContainer != null))
    {
      paramString3 = new StringBuilder();
      paramString3.append("custom_event_GenerateFuncReady.(");
      paramString3.append(this);
      paramString3.append(") id:");
      paramString3.append(getWebViewId());
      QMLog.i("BrandPageWebview", paramString3.toString());
      appendEvent(Integer.valueOf(14));
    }
    if ((paramString1.equals("custom_event_PAGE_EVENT")) && (paramString2.contains("DOMReady")) && (this.mAppBrandPageContainer != null))
    {
      paramString1 = new StringBuilder();
      paramString1.append("custom_event_PAGE_EVENT __DOMReady.  Show the page.(");
      paramString1.append(this);
      paramString1.append(") id:");
      paramString1.append(getWebViewId());
      QMLog.i("BrandPageWebview", paramString1.toString());
      this.mContext.performAction(AppStateEvent.obtain(11));
      if (this.mAppBrandPageContainer.getAppBrandPagePool() != null) {
        AppBrandTask.runTaskOnUiThreadDelay(new BrandPageWebview.4(this), 1000L);
      }
      if ((this.mAppBrandPageContainer.getShowingPage() != null) && (this.mAppBrandPageContainer.getShowingPage().getVisibility() != 0) && (!this.mAppBrandPageContainer.getShowingPage().isHomePage()))
      {
        AppBrandTask.runTaskOnUiThread(new BrandPageWebview.5(this));
        return;
      }
      AppBrandTask.runTaskOnUiThreadDelay(new BrandPageWebview.6(this), 10L);
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return;
    }
    this.mApkgInfo = paramApkgInfo;
    Object localObject = getJSGlobalConfig(paramApkgInfo);
    this.stateGlobalConfigJsLoading.setJsContent((String)localObject);
    appendEvent(Integer.valueOf(8));
    localObject = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApkgInfo.appId);
    localStringBuilder.append("_debug");
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    localObject = "";
    if (bool)
    {
      if (!TextUtils.isEmpty(this.waConsoleJsStr)) {
        localObject = this.waConsoleJsStr;
      }
      this.statDebugJsLoading.setJsContent((String)localObject);
    }
    else
    {
      this.statDebugJsLoading.setJsContent("");
    }
    appendEvent(Integer.valueOf(9));
    paramApkgInfo = paramApkgInfo.getRootWxssJsContent();
    this.stateWxssJsLoading.setJsContent(paramApkgInfo);
    appendEvent(Integer.valueOf(10));
  }
  
  public void setCurrState(StateMachine.State paramState)
  {
    if (paramState == this.stateGenerateFuncReady)
    {
      StringBuilder localStringBuilder;
      if (this.mEventListener != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWebViewReady  (");
        localStringBuilder.append(this);
        localStringBuilder.append(")");
        QMLog.d("BrandPageWebview", localStringBuilder.toString());
        this.mEventListener.onWebViewReady(this.mOpenType, this.mShowingUrl, this.mRealWebView.getPageWebViewId());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWebViewReady no listener  (");
        localStringBuilder.append(this);
        localStringBuilder.append(")");
        QMLog.d("BrandPageWebview", localStringBuilder.toString());
      }
    }
    webviewReport();
    super.setCurrState(paramState);
  }
  
  public void setWebViewEventListener(PageEventListener paramPageEventListener)
  {
    this.mEventListener = paramPageEventListener;
    PageWebview localPageWebview = this.mRealWebView;
    if (localPageWebview != null) {
      localPageWebview.setPageEventListener(paramPageEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview
 * JD-Core Version:    0.7.0.1
 */