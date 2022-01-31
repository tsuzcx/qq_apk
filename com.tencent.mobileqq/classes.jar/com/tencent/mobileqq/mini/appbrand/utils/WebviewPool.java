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
import com.tencent.mobileqq.mini.sdk.LaunchParam;
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
    int j = QbSdk.getTmpDirTbsVersion(this.mCt);
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
      int j = QbSdk.getTmpDirTbsVersion(this.mCt);
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
    //   3: getfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6: ifnonnull +39 -> 45
    //   9: ldc 232
    //   11: iconst_1
    //   12: ldc_w 276
    //   15: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 120	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   22: ifnull +44 -> 66
    //   25: aload_0
    //   26: getfield 120	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   29: invokevirtual 279	android/content/MutableContextWrapper:getApplicationContext	()Landroid/content/Context;
    //   32: astore_1
    //   33: aload_0
    //   34: new 186	com/tencent/mobileqq/mini/appbrand/page/PageWebview
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 212	com/tencent/mobileqq/mini/appbrand/page/PageWebview:<init>	(Landroid/content/Context;)V
    //   42: putfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   45: aload_0
    //   46: getfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   49: aload_0
    //   50: getfield 214	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   53: invokevirtual 218	com/tencent/mobileqq/mini/appbrand/page/PageWebview:setEnableNativeBuffer	(Z)V
    //   56: aload_0
    //   57: getfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   60: invokevirtual 221	com/tencent/mobileqq/mini/appbrand/page/PageWebview:loadHtml	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_1
    //   67: invokevirtual 282	android/content/Context:getApplicationContext	()Landroid/content/Context;
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
    //   6: getfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   9: ifnonnull +149 -> 158
    //   12: aload_1
    //   13: invokestatic 147	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   16: istore 4
    //   18: aload_1
    //   19: invokestatic 150	com/tencent/smtt/sdk/QbSdk:getTmpDirTbsVersion	(Landroid/content/Context;)I
    //   22: istore 5
    //   24: aload_0
    //   25: getfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   28: ifnull +160 -> 188
    //   31: aload_0
    //   32: getfield 102	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstPageWebview	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   35: invokevirtual 297	com/tencent/mobileqq/mini/appbrand/page/PageWebview:getX5WebViewExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewExtension;
    //   38: ifnull +150 -> 188
    //   41: ldc 232
    //   43: iconst_1
    //   44: new 234	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 299
    //   54: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 4
    //   59: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 246
    //   64: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 5
    //   69: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc_w 301
    //   75: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 6
    //   80: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: iload 4
    //   91: ifgt +8 -> 99
    //   94: iload 5
    //   96: ifle +98 -> 194
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 154	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:isTbsFallback	(Landroid/content/Context;)Z
    //   104: ifne +90 -> 194
    //   107: iload 6
    //   109: ifeq +85 -> 194
    //   112: new 254	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview
    //   115: dup
    //   116: aload_0
    //   117: getfield 120	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mCt	Landroid/content/MutableContextWrapper;
    //   120: invokespecial 255	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview:<init>	(Landroid/content/Context;)V
    //   123: astore 7
    //   125: aload_0
    //   126: aload 7
    //   128: putfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 214	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   136: aload 7
    //   138: aload_0
    //   139: getfield 214	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mEnableNativeBuffer	Z
    //   142: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview:setEnableNativeBuffer	(Z)V
    //   145: aload_0
    //   146: getfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   149: aload_0
    //   150: getfield 62	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mAppBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/AppBrandRuntime;
    //   153: invokeinterface 259 2 0
    //   158: aload_0
    //   159: getfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   162: ifnull +23 -> 185
    //   165: aload_0
    //   166: getfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   169: aload_3
    //   170: invokeinterface 309 2 0
    //   175: aload_0
    //   176: getfield 104	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool:mFirstServiceWebview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   179: aload_2
    //   180: invokeinterface 312 2 0
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: iconst_0
    //   189: istore 6
    //   191: goto -150 -> 41
    //   194: new 314	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$2
    //   197: dup
    //   198: aload_0
    //   199: aload_1
    //   200: aload_2
    //   201: invokespecial 317	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/utils/WebviewPool;Landroid/content/Context;Ljava/lang/String;)V
    //   204: invokestatic 323	com/tencent/mobileqq/mini/appbrand/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   207: goto -49 -> 158
    //   210: astore 7
    //   212: ldc 232
    //   214: iconst_1
    //   215: ldc_w 325
    //   218: aload 7
    //   220: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: new 327	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$3
    //   226: dup
    //   227: aload_0
    //   228: aload_1
    //   229: aload_2
    //   230: invokespecial 328	com/tencent/mobileqq/mini/appbrand/utils/WebviewPool$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/utils/WebviewPool;Landroid/content/Context;Ljava/lang/String;)V
    //   233: invokestatic 323	com/tencent/mobileqq/mini/appbrand/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   236: goto -78 -> 158
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	WebviewPool
    //   0	244	1	paramContext	Context
    //   0	244	2	paramString	String
    //   0	244	3	paramValueCallback	com.tencent.smtt.sdk.ValueCallback
    //   16	74	4	i	int
    //   22	73	5	j	int
    //   1	189	6	bool	boolean
    //   123	14	7	localServiceWebview	ServiceWebview
    //   210	9	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   99	107	210	java/lang/Exception
    //   112	158	210	java/lang/Exception
    //   194	207	210	java/lang/Exception
    //   5	41	239	finally
    //   41	89	239	finally
    //   99	107	239	finally
    //   112	158	239	finally
    //   158	185	239	finally
    //   194	207	239	finally
    //   212	236	239	finally
  }
  
  public void initServiceWebViewEx(Context paramContext, MiniAppConfig paramMiniAppConfig, ServiceWebview.Callback paramCallback)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        QLog.i("miniapp-start", 1, "initServiceWebViewEx");
        if (this.mFirstServiceWebview != null) {
          break label411;
        }
        int k = QbSdk.getTbsVersion(paramContext);
        int m = QbSdk.getTmpDirTbsVersion(paramContext);
        int i;
        if ((this.mFirstPageWebview != null) && (this.mFirstPageWebview.getX5WebViewExtension() != null))
        {
          i = 1;
          QLog.d("miniapp-start", 1, "create new ServiceWebview when initServiceWebViewEx, tbsVersion : " + k + ", tmpDirTbsVersion: " + m + "  isFallback:" + isTbsFallback(paramContext));
          if (QzoneConfig.getInstance().getConfig("qqminiapp", "enableSchemeDebug", 1) == 1)
          {
            if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (paramMiniAppConfig.config.debugInfo == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.debugInfo.wsUrl)) || (TextUtils.isEmpty(paramMiniAppConfig.config.debugInfo.roomId)) || ((paramMiniAppConfig.launchParam.scene != 1011) && ((j == 0) || (paramMiniAppConfig.launchParam.scene != 2016)))) {
              continue;
            }
            this.mFirstServiceWebview = new ServiceRemoteRuntime(paramContext, "service-thread", paramCallback, paramMiniAppConfig.config.appId, paramMiniAppConfig.config.debugInfo.roomId, paramMiniAppConfig.config.debugInfo.wsUrl);
            this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
        continue;
        if (((k <= 0) && (m <= 0)) || (isTbsFallback(paramContext)) || (i == 0)) {
          break label395;
        }
        paramContext = new ServiceWebview(paramContext, "service-thread", paramCallback);
        paramContext.setJsErrorListener(this.mAppBrandRuntime.mJsErrorListener);
        paramContext.setEnableEmbeddedVideo(this.enableEmbeddedVideo);
        this.mFirstServiceWebview = paramContext;
        this.mFirstServiceWebview.setAppBrandEventInterface(this.mAppBrandRuntime);
        this.mEnableNativeBuffer = true;
        paramMiniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
        if (this.enableEmbeddedVideo)
        {
          paramContext = "x5_embedded_video";
          MiniReportManager.reportEventType(paramMiniAppConfig, 700, paramContext, "0");
          continue;
        }
        paramContext = "x5_normal_video";
      }
      finally {}
      continue;
      label395:
      AppBrandTask.runTaskOnUiThread(new WebviewPool.1(this, paramContext, paramCallback));
      continue;
      label411:
      if (paramCallback != null) {
        paramCallback.onJscoreInited();
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
      int j = QbSdk.getTmpDirTbsVersion(paramContext);
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
          break label319;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "create new PageWebview when initWebviewEnv");
        }
        if (this.mCt == null) {
          break label311;
        }
        paramContext = this.mCt.getApplicationContext();
        label190:
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
      label311:
      paramContext = paramContext.getApplicationContext();
      break label190;
      label319:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.WebviewPool
 * JD-Core Version:    0.7.0.1
 */