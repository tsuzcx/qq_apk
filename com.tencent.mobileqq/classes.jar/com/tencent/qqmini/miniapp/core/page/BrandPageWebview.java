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
    //   6: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +264 -> 273
    //   12: aload_2
    //   13: ldc 248
    //   15: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifeq +255 -> 273
    //   21: aload_0
    //   22: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   25: ldc 253
    //   27: invokeinterface 259 2 0
    //   32: checkcast 253	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider
    //   35: invokevirtual 263	com/tencent/qqmini/sdk/core/BaseRuntimeImpl$BaselibProvider:getBasePageFrameStr	()Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +552 -> 595
    //   46: aload_0
    //   47: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   50: ifnull +11 -> 61
    //   53: aload_0
    //   54: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   57: arraylength
    //   58: ifne +14 -> 72
    //   61: aload_0
    //   62: aload_1
    //   63: ldc_w 273
    //   66: invokevirtual 277	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   69: putfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   72: new 279	java/io/ByteArrayInputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   85: arraylength
    //   86: invokespecial 282	java/io/ByteArrayInputStream:<init>	([BII)V
    //   89: astore 5
    //   91: aload 5
    //   93: astore_2
    //   94: new 284	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   97: dup
    //   98: ldc_w 286
    //   101: ldc_w 273
    //   104: aload 5
    //   106: invokespecial 289	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   109: astore_1
    //   110: aload 5
    //   112: astore_2
    //   113: new 291	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 294
    //   123: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore 6
    //   128: aload 5
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   135: ifnull +47 -> 182
    //   138: aload 5
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 271	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:defaultPageHtmlBytes	[B
    //   145: arraylength
    //   146: istore_3
    //   147: aload 5
    //   149: astore_2
    //   150: ldc 39
    //   152: aload 6
    //   154: iload_3
    //   155: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 310	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_1
    //   165: astore_2
    //   166: aload 5
    //   168: ifnull +10 -> 178
    //   171: aload 5
    //   173: invokevirtual 313	java/io/ByteArrayInputStream:close	()V
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
    //   189: invokevirtual 316	java/io/IOException:printStackTrace	()V
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
    //   209: invokevirtual 317	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   212: aload 5
    //   214: astore_2
    //   215: ldc 39
    //   217: ldc_w 319
    //   220: aload 6
    //   222: invokestatic 323	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: astore_2
    //   227: aload 5
    //   229: ifnull -51 -> 178
    //   232: aload 5
    //   234: invokevirtual 313	java/io/ByteArrayInputStream:close	()V
    //   237: aload_1
    //   238: astore_2
    //   239: goto -61 -> 178
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   247: aload_1
    //   248: astore_2
    //   249: goto -71 -> 178
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_2
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 313	java/io/ByteArrayInputStream:close	()V
    //   263: aload_1
    //   264: athrow
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   270: goto -7 -> 263
    //   273: aload_2
    //   274: ldc 36
    //   276: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   279: ifeq +150 -> 429
    //   282: aload_2
    //   283: ldc 36
    //   285: invokevirtual 327	java/lang/String:length	()I
    //   288: invokevirtual 331	java/lang/String:substring	(I)Ljava/lang/String;
    //   291: astore_1
    //   292: aload_0
    //   293: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   296: ldc_w 333
    //   299: invokeinterface 259 2 0
    //   304: checkcast 333	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   307: aload_1
    //   308: invokevirtual 337	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 6
    //   313: aload_2
    //   314: invokestatic 342	com/tencent/qqmini/sdk/core/utils/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   317: ifne +10 -> 327
    //   320: aload_2
    //   321: invokestatic 345	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   324: ifeq +44 -> 368
    //   327: aload_2
    //   328: invokestatic 345	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   331: istore 4
    //   333: iload 4
    //   335: ifeq +26 -> 361
    //   338: ldc_w 347
    //   341: astore_1
    //   342: new 284	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   345: dup
    //   346: aload_1
    //   347: ldc_w 273
    //   350: aload 6
    //   352: iload 4
    //   354: invokestatic 351	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   357: invokespecial 289	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   360: areturn
    //   361: ldc_w 353
    //   364: astore_1
    //   365: goto -23 -> 342
    //   368: aload_2
    //   369: ldc_w 355
    //   372: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   375: ifne +16 -> 391
    //   378: aload 5
    //   380: astore_1
    //   381: aload_2
    //   382: ldc_w 357
    //   385: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   388: ifeq -208 -> 180
    //   391: aload_2
    //   392: ldc_w 355
    //   395: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   398: ifeq +24 -> 422
    //   401: ldc_w 359
    //   404: astore_1
    //   405: new 284	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   408: dup
    //   409: aload_1
    //   410: ldc_w 273
    //   413: aload 6
    //   415: invokestatic 363	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   418: invokespecial 289	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   421: areturn
    //   422: ldc_w 365
    //   425: astore_1
    //   426: goto -21 -> 405
    //   429: aload 5
    //   431: astore_1
    //   432: aload_2
    //   433: ldc_w 367
    //   436: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   439: ifeq -259 -> 180
    //   442: aload_0
    //   443: getfield 177	com/tencent/qqmini/miniapp/core/page/BrandPageWebview:mContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   446: ldc_w 333
    //   449: invokeinterface 259 2 0
    //   454: checkcast 333	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   457: aload_2
    //   458: invokevirtual 337	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 6
    //   463: aload_2
    //   464: invokestatic 342	com/tencent/qqmini/sdk/core/utils/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   467: ifne +10 -> 477
    //   470: aload_2
    //   471: invokestatic 345	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   474: ifeq +44 -> 518
    //   477: aload_2
    //   478: invokestatic 345	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   481: istore 4
    //   483: iload 4
    //   485: ifeq +26 -> 511
    //   488: ldc_w 347
    //   491: astore_1
    //   492: new 284	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   495: dup
    //   496: aload_1
    //   497: ldc_w 273
    //   500: aload 6
    //   502: iload 4
    //   504: invokestatic 351	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   507: invokespecial 289	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   510: areturn
    //   511: ldc_w 353
    //   514: astore_1
    //   515: goto -23 -> 492
    //   518: aload_2
    //   519: ldc_w 355
    //   522: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   525: ifne +16 -> 541
    //   528: aload 5
    //   530: astore_1
    //   531: aload_2
    //   532: ldc_w 357
    //   535: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   538: ifeq -358 -> 180
    //   541: aload_2
    //   542: ldc_w 355
    //   545: invokevirtual 251	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   548: ifeq +24 -> 572
    //   551: ldc_w 359
    //   554: astore_1
    //   555: new 284	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   558: dup
    //   559: aload_1
    //   560: ldc_w 273
    //   563: aload 6
    //   565: invokestatic 363	com/tencent/qqmini/sdk/core/utils/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   568: invokespecial 289	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   571: areturn
    //   572: ldc_w 365
    //   575: astore_1
    //   576: goto -21 -> 555
    //   579: astore_1
    //   580: goto -325 -> 255
    //   583: astore 6
    //   585: aconst_null
    //   586: astore_1
    //   587: goto -383 -> 204
    //   590: astore 6
    //   592: goto -388 -> 204
    //   595: aconst_null
    //   596: astore_2
    //   597: goto -419 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	BrandPageWebview
    //   0	600	1	paramWebView	WebView
    //   0	600	2	paramString	String
    //   146	38	3	i	int
    //   331	172	4	bool	boolean
    //   1	528	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   126	27	6	localStringBuilder	StringBuilder
    //   197	24	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   311	253	6	str	String
    //   583	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   590	1	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
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
    //   94	110	579	finally
    //   113	128	579	finally
    //   131	138	579	finally
    //   141	147	579	finally
    //   150	164	579	finally
    //   207	212	579	finally
    //   215	225	579	finally
    //   94	110	583	java/io/UnsupportedEncodingException
    //   113	128	590	java/io/UnsupportedEncodingException
    //   131	138	590	java/io/UnsupportedEncodingException
    //   141	147	590	java/io/UnsupportedEncodingException
    //   150	164	590	java/io/UnsupportedEncodingException
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