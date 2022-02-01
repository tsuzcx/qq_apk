package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.ProgressWebView;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceRemoteRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.Callback;
import com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorker;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebviewPool
{
  private static final int DEFAULT_POOL_SIZE = 1;
  private static final String TAG = WebviewPool.class.getSimpleName();
  protected boolean enableEmbeddedLive;
  protected boolean enableEmbeddedVideo;
  private JsVirtualMachine jsVirtualMachine;
  private AppBrandRuntime mAppBrandRuntime;
  private MutableContextWrapper mCt;
  private boolean mEnableNativeBuffer;
  public PageWebview mFirstPageWebview;
  public JsRuntime mFirstServiceWebview;
  public ProgressWebView mNormalWebview;
  private ConcurrentHashMap<String, ProgressWebView> mNormalWebviewMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PageWebview> mPageWebviewMap = new ConcurrentHashMap();
  private int mPoolSize = 1;
  private ConcurrentHashMap<String, JsRuntime> mServiceWebviewMap = new ConcurrentHashMap();
  private MiniAppWorker mWorker;
  
  public WebviewPool(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
  }
  
  private void destoryWebview(WebView paramWebView)
  {
    paramWebView.stopLoading();
    paramWebView.loadUrl("about:blank");
    paramWebView.clearHistory();
    paramWebView.clearView();
    ((MutableContextWrapper)paramWebView.getContext()).setBaseContext(BaseApplicationImpl.context);
  }
  
  private int getTmpDirTbsVersion(Context paramContext)
  {
    try
    {
      int i = QbSdk.getTmpDirTbsVersion(paramContext);
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.d("miniapp-start", 1, "", paramContext);
    }
    return 0;
  }
  
  public void cleanFirstWebView(Context paramContext)
  {
    try
    {
      if (this.mFirstPageWebview != null) {
        this.mFirstPageWebview = null;
      }
      if (this.mFirstServiceWebview != null) {
        this.mFirstServiceWebview = null;
      }
      if (this.mNormalWebview != null) {
        this.mNormalWebview = null;
      }
      return;
    }
    finally {}
  }
  
  public MiniAppWorker createWorker()
  {
    QLog.i("miniapp-worker", 1, "[createWorker]");
    if (this.mCt == null)
    {
      QLog.e("miniapp-worker", 1, "[createWorker] empty mct");
      throw new Exception("Context not found");
    }
    if ((this.mWorker != null) && (!this.mWorker.isTerminated())) {
      throw new Exception("Worker already created and running!");
    }
    int i = QbSdk.getTbsVersion(this.mCt);
    int j = getTmpDirTbsVersion(this.mCt);
    if (((i > 0) || (j > 0)) && (!isTbsFallback(this.mCt)))
    {
      this.mWorker = new MiniAppWorker(this.mCt, this.mAppBrandRuntime);
      return this.mWorker;
    }
    QLog.e(TAG, 1, "tbs not ready, can not create worker.");
    return null;
  }
  
  public void destroyCachePageWebView()
  {
    try
    {
      Iterator localIterator = this.mPageWebviewMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PageWebview localPageWebview = (PageWebview)((Map.Entry)localIterator.next()).getValue();
        if (localPageWebview != null) {
          localPageWebview.destroy();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "recyclePageWebview error:", localException);
    }
  }
  
  public PageWebview getPageWebview(String paramString)
  {
    PageWebview localPageWebview = (PageWebview)this.mPageWebviewMap.remove(paramString);
    if (localPageWebview == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "create new PageWebview when getPageWebview");
      }
      paramString = new PageWebview(this.mCt);
      paramString.setEnableNativeBuffer(this.mEnableNativeBuffer);
      paramString.loadHtml();
    }
    do
    {
      return paramString;
      paramString = localPageWebview;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "get cache PageWebview when getPageWebview");
    return localPageWebview;
  }
  
  public JsRuntime getServiceWebview(String paramString)
  {
    JsRuntime localJsRuntime = (JsRuntime)this.mServiceWebviewMap.get(paramString);
    paramString = localJsRuntime;
    if (localJsRuntime == null)
    {
      int i = QbSdk.getTbsVersion(this.mCt);
      int j = getTmpDirTbsVersion(this.mCt);
      QLog.d("miniapp-start", 2, "create new ServiceWebview when getServiceWebview, tbsVersion: " + i + ", tmpDirTbsVersion: " + j);
      if (((i > 0) || (j > 0)) && (!isTbsFallback(this.mCt.getBaseContext())))
      {
        paramString = new ServiceWebview(this.mCt);
        paramString.setAppBrandEventInterface(this.mAppBrandRuntime);
      }
    }
    else
    {
      return paramString;
    }
    paramString = new ServiceOriginalWebview(this.mCt);
    paramString.setJsConsoleMessageListener(this.mAppBrandRuntime.mJsErrorGuard);
    this.mFirstServiceWebview = paramString;
    paramString.setAppBrandEventInterface(this.mAppBrandRuntime);
    return paramString;
  }
  
  public MiniAppWorker getWorker()
  {
    return this.mWorker;
  }
  
  /* Error */
  public void initFirstPageWebView(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6: ifnonnull +39 -> 45
    //   9: ldc 110
    //   11: iconst_1
    //   12: ldc_w 284
    //   15: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 137	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   22: ifnull +44 -> 66
    //   25: aload_0
    //   26: getfield 137	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   29: invokevirtual 287	android/content/MutableContextWrapper:getApplicationContext	()Landroid/content/Context;
    //   32: astore_1
    //   33: aload_0
    //   34: new 198	com/tencent/mobileqq/mini/appbrand/page/PageWebview
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 222	com/tencent/mobileqq/mini/appbrand/page/PageWebview:<init>	(Landroid/content/Context;)V
    //   42: putfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   45: aload_0
    //   46: getfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   49: aload_0
    //   50: getfield 224	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   53: invokevirtual 228	com/tencent/mobileqq/mini/appbrand/page/PageWebview:setEnableNativeBuffer	(Z)V
    //   56: aload_0
    //   57: getfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   60: invokevirtual 231	com/tencent/mobileqq/mini/appbrand/page/PageWebview:loadHtml	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_1
    //   67: invokevirtual 290	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   70: astore_1
    //   71: goto -38 -> 33
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	WebviewPool
    //   0	79	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	33	74	finally
    //   33	45	74	finally
    //   45	63	74	finally
    //   66	71	74	finally
  }
  
  public void initFistWebview(Context paramContext)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-start", 2, "---initFistWebview----");
      }
      if (this.mCt == null) {
        this.mCt = new MutableContextWrapper(paramContext);
      }
      if (this.mFirstPageWebview == null) {
        this.mFirstPageWebview = new PageWebview(this.mCt);
      }
      this.enableEmbeddedVideo = this.mFirstPageWebview.isEnableEmbeddedVideo();
      this.enableEmbeddedLive = this.mFirstPageWebview.isEnableEmbeddedLive();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void initServiceWebView(Context paramContext, String paramString, com.tencent.smtt.sdk.ValueCallback paramValueCallback)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   9: ifnonnull +150 -> 159
    //   12: aload_1
    //   13: invokestatic 161	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   16: istore 4
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 162	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:getTmpDirTbsVersion	(Landroid/content/Context;)I
    //   23: istore 5
    //   25: aload_0
    //   26: getfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   29: ifnull +160 -> 189
    //   32: aload_0
    //   33: getfield 121	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   36: invokevirtual 310	com/tencent/mobileqq/mini/appbrand/page/PageWebview:getX5WebViewExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewExtension;
    //   39: ifnull +150 -> 189
    //   42: ldc 110
    //   44: iconst_1
    //   45: new 242	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 312
    //   55: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload 4
    //   60: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 254
    //   65: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 5
    //   70: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 314
    //   76: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 6
    //   81: invokevirtual 317	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iload 4
    //   92: ifgt +8 -> 100
    //   95: iload 5
    //   97: ifle +98 -> 195
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 166	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:isTbsFallback	(Landroid/content/Context;)Z
    //   105: ifne +90 -> 195
    //   108: iload 6
    //   110: ifeq +85 -> 195
    //   113: new 262	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview
    //   116: dup
    //   117: aload_0
    //   118: getfield 137	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   121: invokespecial 263	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview:<init>	(Landroid/content/Context;)V
    //   124: astore 7
    //   126: aload_0
    //   127: aload 7
    //   129: putfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 224	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   137: aload 7
    //   139: aload_0
    //   140: getfield 224	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   143: invokevirtual 318	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview:setEnableNativeBuffer	(Z)V
    //   146: aload_0
    //   147: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   150: aload_0
    //   151: getfield 63	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mAppBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/AppBrandRuntime;
    //   154: invokeinterface 267 2 0
    //   159: aload_0
    //   160: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   163: ifnull +23 -> 186
    //   166: aload_0
    //   167: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   170: aload_3
    //   171: invokeinterface 322 2 0
    //   176: aload_0
    //   177: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   180: aload_2
    //   181: invokeinterface 325 2 0
    //   186: aload_0
    //   187: monitorexit
    //   188: return
    //   189: iconst_0
    //   190: istore 6
    //   192: goto -150 -> 42
    //   195: new 327	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$2
    //   198: dup
    //   199: aload_0
    //   200: aload_1
    //   201: aload_2
    //   202: invokespecial 330	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/utils/WebviewPool;Landroid/content/Context;Ljava/lang/String;)V
    //   205: invokestatic 336	com/tencent/mobileqq/mini/appbrand/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   208: goto -49 -> 159
    //   211: astore 7
    //   213: ldc 110
    //   215: iconst_1
    //   216: ldc_w 338
    //   219: aload 7
    //   221: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: new 340	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$3
    //   227: dup
    //   228: aload_0
    //   229: aload_1
    //   230: aload_2
    //   231: invokespecial 341	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/utils/WebviewPool;Landroid/content/Context;Ljava/lang/String;)V
    //   234: invokestatic 336	com/tencent/mobileqq/mini/appbrand/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   237: goto -78 -> 159
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	WebviewPool
    //   0	245	1	paramContext	Context
    //   0	245	2	paramString	String
    //   0	245	3	paramValueCallback	com.tencent.smtt.sdk.ValueCallback
    //   16	75	4	i	int
    //   23	73	5	j	int
    //   1	190	6	bool	boolean
    //   124	14	7	localServiceWebview	ServiceWebview
    //   211	9	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   100	108	211	java/lang/Exception
    //   113	159	211	java/lang/Exception
    //   195	208	211	java/lang/Exception
    //   5	42	240	finally
    //   42	90	240	finally
    //   100	108	240	finally
    //   113	159	240	finally
    //   159	186	240	finally
    //   195	208	240	finally
    //   213	237	240	finally
  }
  
  /* Error */
  public void initServiceWebViewByFakeApkgInfo(ApkgInfo paramApkgInfo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   6: ifnull +54 -> 60
    //   9: new 242	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 345
    //   19: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: astore 4
    //   24: aload_2
    //   25: ifnull +38 -> 63
    //   28: aload_2
    //   29: invokevirtual 351	java/lang/String:length	()I
    //   32: istore_3
    //   33: ldc 110
    //   35: iconst_1
    //   36: aload 4
    //   38: iload_3
    //   39: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 123	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   52: aload_1
    //   53: aload_2
    //   54: aconst_null
    //   55: invokeinterface 355 4 0
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: iconst_m1
    //   64: istore_3
    //   65: goto -32 -> 33
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	WebviewPool
    //   0	73	1	paramApkgInfo	ApkgInfo
    //   0	73	2	paramString	String
    //   32	33	3	i	int
    //   22	15	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	24	68	finally
    //   28	33	68	finally
    //   33	60	68	finally
  }
  
  public void initServiceWebViewEx(Context paramContext, MiniAppConfig paramMiniAppConfig, ServiceWebview.Callback paramCallback)
  {
    for (;;)
    {
      try
      {
        QLog.i("miniapp-start", 1, "initServiceWebViewEx");
        if (this.mFirstServiceWebview != null) {
          break label406;
        }
        int j = QbSdk.getTbsVersion(paramContext);
        int k = getTmpDirTbsVersion(paramContext);
        int i;
        if ((this.mFirstPageWebview != null) && (this.mFirstPageWebview.getX5WebViewExtension() != null))
        {
          i = 1;
          QLog.d("miniapp-start", 1, "create new ServiceWebview when initServiceWebViewEx, tbsVersion : " + j + ", tmpDirTbsVersion: " + k + "  isFallback:" + isTbsFallback(paramContext));
          if ((QzoneConfig.getInstance().getConfig("qqminiapp", "enableSchemeDebug", 1) != 1) || ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.debugInfo != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.debugInfo.wsUrl)) && (!TextUtils.isEmpty(paramMiniAppConfig.config.debugInfo.roomId))))
          {
            this.mFirstServiceWebview = new ServiceRemoteRuntime(paramContext, "service-thread", paramCallback, paramMiniAppConfig.config.appId, paramMiniAppConfig.config.debugInfo.roomId, paramMiniAppConfig.config.debugInfo.wsUrl);
            this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (((j <= 0) && (k <= 0)) || (isTbsFallback(paramContext)) || (i == 0)) {
          break label390;
        }
        paramContext = new ServiceWebview(paramContext, "service-thread", paramCallback);
        paramContext.setJsErrorListener(this.mAppBrandRuntime.mJsErrorListener);
        paramContext.setEnableEmbeddedVideo(this.enableEmbeddedVideo);
        paramContext.setEnableEmbeddedLive(this.enableEmbeddedLive);
        this.mFirstServiceWebview = paramContext;
        this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
        this.mEnableNativeBuffer = true;
        paramMiniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
        if (this.enableEmbeddedVideo)
        {
          paramContext = "x5_embedded_video";
          MiniReportManager.reportEventType(paramMiniAppConfig, 700, paramContext, "0");
          paramMiniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
          if (!this.enableEmbeddedLive) {
            break label419;
          }
          paramContext = "x5_embedded_live_player";
          MiniReportManager.reportEventType(paramMiniAppConfig, 710, paramContext, "0");
          continue;
        }
        paramContext = "x5_normal_video";
      }
      finally {}
      continue;
      label390:
      AppBrandTask.runTaskOnUiThread(new WebviewPool.1(this, paramContext, paramCallback));
      continue;
      label406:
      if (paramCallback != null)
      {
        paramCallback.onJscoreInited();
        continue;
        label419:
        paramContext = "x5_normal_live_player";
      }
    }
  }
  
  public void initWebviewEnv(Context paramContext, ApkgInfo paramApkgInfo)
  {
    if (this.mCt == null) {
      this.mCt = new MutableContextWrapper(paramContext);
    }
    Object localObject;
    if (this.mFirstServiceWebview == null)
    {
      int i = QbSdk.getTbsVersion(paramContext);
      int j = getTmpDirTbsVersion(paramContext);
      QLog.d("miniapp-start", 2, "create n  ew ServiceWebview when initWebviewEnv, tbsVersion: " + i + ", tmpDirTbsVersion: " + j);
      if (((i > 0) || (j > 0)) && (!isTbsFallback(paramContext)))
      {
        localObject = new ServiceWebview(paramContext.getApplicationContext());
        this.mFirstServiceWebview = ((JsRuntime)localObject);
        this.mEnableNativeBuffer = true;
        ((ServiceWebview)localObject).setEnableNativeBuffer(this.mEnableNativeBuffer);
        this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
        this.mServiceWebviewMap.put(paramApkgInfo.appId, this.mFirstServiceWebview);
        if (this.mFirstPageWebview != null) {
          break label320;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "create new PageWebview when initWebviewEnv");
        }
        if (this.mCt == null) {
          break label312;
        }
        paramContext = this.mCt.getApplicationContext();
        label191:
        this.mFirstPageWebview = new PageWebview(paramContext);
        this.mFirstPageWebview.setEnableNativeBuffer(this.mEnableNativeBuffer);
      }
    }
    for (;;)
    {
      this.mFirstPageWebview.setApkgInfo(paramApkgInfo);
      this.mFirstPageWebview.initApkgJs();
      this.mPageWebviewMap.put(paramApkgInfo.appId, this.mFirstPageWebview);
      return;
      localObject = new ServiceOriginalWebview(paramContext.getApplicationContext());
      ((ServiceOriginalWebview)localObject).setJsConsoleMessageListener(this.mAppBrandRuntime.mJsErrorGuard);
      this.mFirstServiceWebview = ((JsRuntime)localObject);
      this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "get cache ServiceWebview when initWebviewEnv");
      break;
      label312:
      paramContext = paramContext.getApplicationContext();
      break label191;
      label320:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "get cache PageWebview when initWebviewEnv");
      }
    }
  }
  
  public boolean isTbsFallback(Context paramContext)
  {
    if (this.jsVirtualMachine == null) {
      this.jsVirtualMachine = new JsVirtualMachine(paramContext);
    }
    return this.jsVirtualMachine.isFallback();
  }
  
  public void onDestory()
  {
    try
    {
      if (this.mPageWebviewMap != null)
      {
        this.mPageWebviewMap.clear();
        this.mPageWebviewMap = null;
      }
      if (this.mServiceWebviewMap != null)
      {
        this.mServiceWebviewMap.clear();
        this.mServiceWebviewMap = null;
      }
      return;
    }
    finally {}
  }
  
  public void putPageWebview(Context paramContext, ApkgInfo paramApkgInfo)
  {
    if (this.mPageWebviewMap.containsKey(paramApkgInfo.appId)) {
      return;
    }
    paramContext = new PageWebview(new MutableContextWrapper(paramContext), this.enableEmbeddedVideo);
    paramContext.setEnableNativeBuffer(this.mEnableNativeBuffer);
    paramContext.apkgInfo = paramApkgInfo;
    paramContext.loadHtml();
    this.mPageWebviewMap.put(paramApkgInfo.appId, paramContext);
  }
  
  public void recycleFirstWebView(Context paramContext)
  {
    try
    {
      if (this.mFirstPageWebview != null)
      {
        recyclePageWebview(this.mFirstPageWebview, paramContext);
        this.mFirstPageWebview = null;
      }
      if (this.mFirstServiceWebview != null)
      {
        recycleServiceWebview(this.mFirstServiceWebview, paramContext);
        this.mFirstServiceWebview = null;
      }
      if (this.mNormalWebview != null)
      {
        recycleWebview(this.mNormalWebview, paramContext);
        this.mNormalWebview = null;
      }
      return;
    }
    finally {}
  }
  
  public void recyclePageWebview(PageWebview paramPageWebview, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 2, "----recyclePageWebview----");
    }
    MiniAppStateManager.getInstance().notifyChange("hideKeyboard");
    if (paramPageWebview == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!"about:blank".equals(paramPageWebview.getUrl()))
        {
          paramPageWebview.clearUp();
          destoryWebview(paramPageWebview);
        }
        if ((this.mPageWebviewMap == null) || (!this.mPageWebviewMap.contains(paramPageWebview))) {
          continue;
        }
        this.mPageWebviewMap.remove(paramPageWebview);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "destroy error:" + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public void recycleServiceWebview(JsRuntime paramJsRuntime, Context paramContext)
  {
    if (!paramJsRuntime.isDestroyed()) {}
    try
    {
      paramJsRuntime.clearUp();
      if ((paramJsRuntime instanceof BaseAppBrandWebview)) {
        ((BaseAppBrandWebview)paramJsRuntime).destroy();
      }
      if ((this.mServiceWebviewMap != null) && (this.mServiceWebviewMap.contains(paramJsRuntime))) {
        this.mServiceWebviewMap.remove(paramJsRuntime);
      }
      if ((this.mWorker != null) && (this.mWorker.isJSContextValid()) && (!this.mWorker.isTerminated())) {
        this.mWorker.clearUp();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 1, "destroy error:" + paramContext.getMessage());
        }
      }
    }
  }
  
  public void recycleWebview(ProgressWebView paramProgressWebView, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 2, "----recyclePageWebview----");
    }
    MiniAppStateManager.getInstance().notifyChange("hideKeyboard");
    if (paramProgressWebView == null) {}
    for (;;)
    {
      return;
      if (!"about:blank".equals(paramProgressWebView.getUrl())) {}
      try
      {
        destoryWebview(paramProgressWebView);
        if ((this.mNormalWebviewMap == null) || (!this.mNormalWebviewMap.contains(paramProgressWebView))) {
          continue;
        }
        this.mNormalWebviewMap.remove(paramProgressWebView);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "destroy error:" + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public void setContext(Activity paramActivity)
  {
    if (this.mCt == null)
    {
      this.mCt = new MutableContextWrapper(paramActivity);
      QLog.i("miniapp-start", 2, "new MutableContextWrapper : " + paramActivity);
      return;
    }
    this.mCt.setBaseContext(paramActivity);
    QLog.i("miniapp-start", 2, "setBaseContext : " + paramActivity);
  }
  
  public void setPoolSize(int paramInt)
  {
    this.mPoolSize = paramInt;
  }
  
  public void stopWorker()
  {
    if (this.mWorker == null) {
      return;
    }
    this.mWorker.clearUp();
    this.mWorker = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.WebviewPool
 * JD-Core Version:    0.7.0.1
 */