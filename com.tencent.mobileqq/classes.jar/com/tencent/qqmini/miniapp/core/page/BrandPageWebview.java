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
  
  /* Error */
  private WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 36
    //   6: invokevirtual 240	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +264 -> 273
    //   12: aload_2
    //   13: ldc 242
    //   15: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifeq +255 -> 273
    //   21: aload_0
    //   22: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   25: ldc 247
    //   27: invokeinterface 253 2 0
    //   32: checkcast 247	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider
    //   35: invokevirtual 257	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider:getBasePageFrameStr	()Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +580 -> 623
    //   46: aload_0
    //   47: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   50: ifnull +11 -> 61
    //   53: aload_0
    //   54: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   57: arraylength
    //   58: ifne +14 -> 72
    //   61: aload_0
    //   62: aload_1
    //   63: ldc_w 267
    //   66: invokevirtual 271	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   69: putfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   72: new 273	java/io/ByteArrayInputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   85: arraylength
    //   86: invokespecial 276	java/io/ByteArrayInputStream:<init>	([BII)V
    //   89: astore 5
    //   91: aload 5
    //   93: astore_2
    //   94: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   97: dup
    //   98: ldc_w 280
    //   101: ldc_w 267
    //   104: aload 5
    //   106: invokespecial 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   109: astore_1
    //   110: aload 5
    //   112: astore_2
    //   113: new 285	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 288
    //   123: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore 6
    //   128: aload 5
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   135: ifnull +47 -> 182
    //   138: aload 5
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 265	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   145: arraylength
    //   146: istore_3
    //   147: aload 5
    //   149: astore_2
    //   150: ldc 39
    //   152: aload 6
    //   154: iload_3
    //   155: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 304	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_1
    //   165: astore_2
    //   166: aload 5
    //   168: ifnull +10 -> 178
    //   171: aload 5
    //   173: invokevirtual 307	java/io/ByteArrayInputStream:close	()V
    //   176: aload_1
    //   177: astore_2
    //   178: aload_2
    //   179: astore_1
    //   180: aload_1
    //   181: areturn
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -37 -> 147
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 310	java/io/IOException:printStackTrace	()V
    //   192: aload_1
    //   193: astore_2
    //   194: goto -16 -> 178
    //   197: astore 6
    //   199: aconst_null
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_1
    //   204: aload 5
    //   206: astore_2
    //   207: aload 6
    //   209: invokevirtual 311	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   212: aload 5
    //   214: astore_2
    //   215: ldc 39
    //   217: ldc_w 313
    //   220: aload 6
    //   222: invokestatic 317	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: astore_2
    //   227: aload 5
    //   229: ifnull -51 -> 178
    //   232: aload 5
    //   234: invokevirtual 307	java/io/ByteArrayInputStream:close	()V
    //   237: aload_1
    //   238: astore_2
    //   239: goto -61 -> 178
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 310	java/io/IOException:printStackTrace	()V
    //   247: aload_1
    //   248: astore_2
    //   249: goto -71 -> 178
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_2
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 307	java/io/ByteArrayInputStream:close	()V
    //   263: aload_1
    //   264: athrow
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 310	java/io/IOException:printStackTrace	()V
    //   270: goto -7 -> 263
    //   273: aload_2
    //   274: ldc 36
    //   276: invokevirtual 240	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   279: ifeq +165 -> 444
    //   282: aload 5
    //   284: astore_1
    //   285: aload_0
    //   286: getfield 319	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   289: ifnull -109 -> 180
    //   292: aload_2
    //   293: invokestatic 324	com/tencent/qqmini/sdk/core/utils/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   296: ifne +10 -> 306
    //   299: aload_2
    //   300: invokestatic 327	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   303: ifeq +62 -> 365
    //   306: aload_2
    //   307: ldc 36
    //   309: invokevirtual 331	java/lang/String:length	()I
    //   312: invokevirtual 335	java/lang/String:substring	(I)Ljava/lang/String;
    //   315: astore 5
    //   317: aload_2
    //   318: invokestatic 327	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   321: istore 4
    //   323: iload 4
    //   325: ifeq +33 -> 358
    //   328: ldc_w 337
    //   331: astore_1
    //   332: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   335: dup
    //   336: aload_1
    //   337: ldc_w 267
    //   340: aload_0
    //   341: getfield 319	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   344: aload 5
    //   346: invokevirtual 343	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   349: iload 4
    //   351: invokestatic 347	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   354: invokespecial 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   357: areturn
    //   358: ldc_w 349
    //   361: astore_1
    //   362: goto -30 -> 332
    //   365: aload_2
    //   366: ldc_w 351
    //   369: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   372: ifne +16 -> 388
    //   375: aload 5
    //   377: astore_1
    //   378: aload_2
    //   379: ldc_w 353
    //   382: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   385: ifeq -205 -> 180
    //   388: aload_2
    //   389: ldc 36
    //   391: invokevirtual 331	java/lang/String:length	()I
    //   394: invokevirtual 335	java/lang/String:substring	(I)Ljava/lang/String;
    //   397: astore 5
    //   399: aload_2
    //   400: ldc_w 351
    //   403: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   406: ifeq +31 -> 437
    //   409: ldc_w 355
    //   412: astore_1
    //   413: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   416: dup
    //   417: aload_1
    //   418: ldc_w 267
    //   421: aload_0
    //   422: getfield 319	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   425: aload 5
    //   427: invokevirtual 343	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokestatic 359	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   433: invokespecial 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   436: areturn
    //   437: ldc_w 361
    //   440: astore_1
    //   441: goto -28 -> 413
    //   444: aload 5
    //   446: astore_1
    //   447: aload_2
    //   448: ldc_w 363
    //   451: invokevirtual 240	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   454: ifeq -274 -> 180
    //   457: aload_2
    //   458: invokestatic 324	com/tencent/qqmini/sdk/core/utils/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   461: ifne +10 -> 471
    //   464: aload_2
    //   465: invokestatic 327	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   468: ifeq +61 -> 529
    //   471: aload_2
    //   472: invokestatic 327	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   475: istore 4
    //   477: iload 4
    //   479: ifeq +43 -> 522
    //   482: ldc_w 337
    //   485: astore_1
    //   486: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   489: dup
    //   490: aload_1
    //   491: ldc_w 267
    //   494: aload_0
    //   495: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   498: ldc_w 365
    //   501: invokeinterface 253 2 0
    //   506: checkcast 365	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   509: aload_2
    //   510: invokevirtual 368	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   513: iload 4
    //   515: invokestatic 347	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   518: invokespecial 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   521: areturn
    //   522: ldc_w 349
    //   525: astore_1
    //   526: goto -40 -> 486
    //   529: aload_2
    //   530: ldc_w 351
    //   533: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   536: ifne +16 -> 552
    //   539: aload 5
    //   541: astore_1
    //   542: aload_2
    //   543: ldc_w 353
    //   546: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   549: ifeq -369 -> 180
    //   552: aload_2
    //   553: ldc_w 351
    //   556: invokevirtual 245	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   559: ifeq +41 -> 600
    //   562: ldc_w 355
    //   565: astore_1
    //   566: new 278	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   569: dup
    //   570: aload_1
    //   571: ldc_w 267
    //   574: aload_0
    //   575: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   578: ldc_w 365
    //   581: invokeinterface 253 2 0
    //   586: checkcast 365	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   589: aload_2
    //   590: invokevirtual 368	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   593: invokestatic 359	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   596: invokespecial 283	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   599: areturn
    //   600: ldc_w 361
    //   603: astore_1
    //   604: goto -38 -> 566
    //   607: astore_1
    //   608: goto -353 -> 255
    //   611: astore 6
    //   613: aconst_null
    //   614: astore_1
    //   615: goto -411 -> 204
    //   618: astore 6
    //   620: goto -416 -> 204
    //   623: aconst_null
    //   624: astore_2
    //   625: goto -447 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	BrandPageWebview
    //   0	628	1	paramWebView	WebView
    //   0	628	2	paramString	String
    //   146	38	3	i	int
    //   321	193	4	bool	boolean
    //   1	539	5	localObject	Object
    //   126	27	6	localStringBuilder	StringBuilder
    //   197	24	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   611	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   618	1	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   171	176	187	java/io/IOException
    //   46	61	197	java/io/UnsupportedEncodingException
    //   61	72	197	java/io/UnsupportedEncodingException
    //   72	91	197	java/io/UnsupportedEncodingException
    //   232	237	242	java/io/IOException
    //   46	61	252	finally
    //   61	72	252	finally
    //   72	91	252	finally
    //   259	263	265	java/io/IOException
    //   94	110	607	finally
    //   113	128	607	finally
    //   131	138	607	finally
    //   141	147	607	finally
    //   150	164	607	finally
    //   207	212	607	finally
    //   215	225	607	finally
    //   94	110	611	java/io/UnsupportedEncodingException
    //   113	128	618	java/io/UnsupportedEncodingException
    //   131	138	618	java/io/UnsupportedEncodingException
    //   141	147	618	java/io/UnsupportedEncodingException
    //   150	164	618	java/io/UnsupportedEncodingException
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
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.mRealWebView != null) {
        this.mRealWebView.evaluateJavascript(paramString1, AppBrandUtil.convertValueCallback(paramValueCallback));
      }
      return;
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
      paramApkgInfo = WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com");
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
    if ((paramString1.equals("custom_event_PAGE_EVENT")) && (paramString2.contains("DOMReady")) && (this.mAppBrandPageContainer != null))
    {
      QMLog.i("BrandPageWebview", "custom_event_PAGE_EVENT __DOMReady.  Show the page.");
      this.mContext.performAction(AppStateEvent.obtain(11));
      if (this.mAppBrandPageContainer.getAppBrandPagePool() != null) {
        AppBrandTask.runTaskOnUiThreadDelay(new BrandPageWebview.4(this), 100L);
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
    if ((paramState == this.stateLoadSucc) && (this.mEventListener != null)) {
      this.mEventListener.onWebViewReady(this.mOpenType, this.mShowingUrl, this.mRealWebView.getPageWebViewId());
    }
    StateMachine.State localState = getCurrState();
    if (localState == this.stateWaJsLoading) {
      MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 18, "0");
    }
    for (;;)
    {
      super.setCurrState(paramState);
      return;
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