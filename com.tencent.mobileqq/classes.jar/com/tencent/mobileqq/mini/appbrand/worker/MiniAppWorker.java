package com.tencent.mobileqq.mini.appbrand.worker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import java.util.ArrayList;
import java.util.Iterator;

public class MiniAppWorker
  extends ServiceWebview
{
  public static final String WORKER_T = "miniapp-worker";
  private volatile boolean mIsCtxValid;
  private volatile boolean mIsTerminated;
  private Object mLock = new Object();
  
  public MiniAppWorker(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext, "worker-thread");
    this.mAppBrandRuntime = paramAppBrandRuntime;
    QLog.i("miniapp-worker", 2, "[MiniAppWorker] create and alive in thread --> " + this.threadName);
  }
  
  /* Error */
  public void clearUp()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 65	com/tencent/mobileqq/mini/appbrand/page/ServiceWebview:clearUp	()V
    //   4: aload_0
    //   5: getfield 69	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 69	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   15: invokevirtual 74	com/tencent/smtt/sdk/JsContext:destroy	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 69	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   23: aload_0
    //   24: getfield 78	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 78	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   34: invokevirtual 81	com/tencent/smtt/sdk/JsVirtualMachine:destroy	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 78	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   42: aload_0
    //   43: getfield 85	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   46: ifnull +31 -> 77
    //   49: aload_0
    //   50: getfield 85	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   53: invokevirtual 91	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   56: ifnull +21 -> 77
    //   59: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 18
    //   64: if_icmplt +38 -> 102
    //   67: aload_0
    //   68: getfield 85	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   71: invokevirtual 91	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   74: invokevirtual 102	android/os/Looper:quitSafely	()V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 85	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   82: aload_0
    //   83: getfield 27	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_1
    //   88: monitorenter
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 104	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsTerminated	Z
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 106	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsCtxValid	Z
    //   99: aload_1
    //   100: monitorexit
    //   101: return
    //   102: aload_0
    //   103: getfield 85	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   106: invokevirtual 91	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   109: invokevirtual 109	android/os/Looper:quit	()V
    //   112: goto -35 -> 77
    //   115: astore_1
    //   116: ldc 8
    //   118: iconst_1
    //   119: ldc 111
    //   121: aload_1
    //   122: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getfield 27	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: monitorenter
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 104	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsTerminated	Z
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 106	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsCtxValid	Z
    //   142: aload_1
    //   143: monitorexit
    //   144: return
    //   145: astore_2
    //   146: aload_1
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore_2
    //   151: aload_1
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    //   155: astore_2
    //   156: aload_0
    //   157: getfield 27	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   160: astore_1
    //   161: aload_1
    //   162: monitorenter
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 104	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsTerminated	Z
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 106	com/tencent/mobileqq/mini/appbrand/worker/MiniAppWorker:mIsCtxValid	Z
    //   173: aload_1
    //   174: monitorexit
    //   175: aload_2
    //   176: athrow
    //   177: astore_2
    //   178: aload_1
    //   179: monitorexit
    //   180: aload_2
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	MiniAppWorker
    //   86	14	1	localObject1	Object
    //   115	7	1	localException	java.lang.Exception
    //   129	50	1	localObject2	Object
    //   145	4	2	localObject3	Object
    //   150	4	2	localObject4	Object
    //   155	21	2	localObject5	Object
    //   177	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   4	23	115	java/lang/Exception
    //   23	42	115	java/lang/Exception
    //   42	77	115	java/lang/Exception
    //   77	82	115	java/lang/Exception
    //   102	112	115	java/lang/Exception
    //   132	144	145	finally
    //   146	148	145	finally
    //   89	101	150	finally
    //   151	153	150	finally
    //   4	23	155	finally
    //   23	42	155	finally
    //   42	77	155	finally
    //   77	82	155	finally
    //   102	112	155	finally
    //   116	125	155	finally
    //   163	175	177	finally
    //   178	180	177	finally
  }
  
  public void ctxValid()
  {
    synchronized (this.mLock)
    {
      this.mIsCtxValid = true;
      return;
    }
  }
  
  public void init(Context paramContext)
  {
    QLog.e("miniapp-worker", 2, "[init]");
    this.mVM = new JsVirtualMachine(paramContext, this.mThreadHandler.getLooper());
    this.mJsContext = new JsContext(this.mVM);
    this.mJsContext.setExceptionHandler(new MiniAppWorker.1(this));
    onAddingJsInterface();
    onInitOver();
  }
  
  public void initFramework(Context paramContext)
  {
    QLog.e("miniapp-worker", 2, "[initFramework] initFramework is not allowed in worker!");
  }
  
  public void initJSContext()
  {
    QLog.e("miniapp-worker", 2, "[initJSContext]");
    if (this.mThreadHandler != null) {
      this.mThreadHandler.post(new MiniAppWorker.2(this));
    }
  }
  
  public boolean isJSContextValid()
  {
    return this.mIsCtxValid;
  }
  
  public boolean isTerminated()
  {
    return this.mIsTerminated;
  }
  
  public boolean loadExecuteWorkerJs(String paramString)
  {
    QLog.i("miniapp-worker", 2, "[loadExecuteWorkerJs]");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("miniapp-worker", 1, "[loadExecuteWorkerJs] failed : empty exeworker");
      return false;
    }
    evaluteJs(paramString, new MiniAppWorker.5(this));
    return true;
  }
  
  public boolean loadExecutedAppConfig(ApkgInfo paramApkgInfo)
  {
    QLog.i("miniapp-worker", 2, "[loadExecutedAppConfig]");
    if (paramApkgInfo == null)
    {
      QLog.e("miniapp-worker", 1, "[loadExecutedAppConfig] failed : empty apkginfo");
      return false;
    }
    String str2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=JSON.parse('%1$s');Object.assign(__qqConfig, __tempConfig);", new Object[] { paramApkgInfo.mConfigStr });
    String str1 = str2;
    if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
      str1 = str2 + "__qqConfig.debug=true;";
    }
    evaluteJs(str1, new MiniAppWorker.3(this));
    return true;
  }
  
  public boolean loadWAWorker(String paramString)
  {
    QLog.i("miniapp-worker", 2, "[loadWAWorker]");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("miniapp-worker", 1, "[loadWAWorker] failed : empty waworker");
      return false;
    }
    evaluteJs(paramString, new MiniAppWorker.4(this));
    return true;
  }
  
  public void onInitOver()
  {
    if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.miniAppWorkerManager != null)) {
      this.mAppBrandRuntime.miniAppWorkerManager.workerJSContextInitFinished();
    }
  }
  
  public void postMessageListToWorker(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null)
    {
      QLog.e("miniapp-worker", 1, "[postMessageListToWorker] messagePendingList is null");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      postMessageToWorker((String)localIterator.next());
    }
    paramArrayList.clear();
  }
  
  public void postMessageToWorker(String paramString)
  {
    paramString = String.format("WeixinWorker.appServiceMsgHandler(%s)", new Object[] { paramString });
    QLog.i("miniapp-worker", 2, "[postMessageToWorker] jsScript:" + paramString);
    evaluteJs(paramString, new MiniAppWorker.6(this));
  }
  
  public boolean shouldInitFramework()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorker
 * JD-Core Version:    0.7.0.1
 */