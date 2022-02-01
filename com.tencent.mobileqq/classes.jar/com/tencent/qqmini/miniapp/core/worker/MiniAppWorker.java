package com.tencent.qqmini.miniapp.core.worker;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public class MiniAppWorker
{
  private HandlerThread mHandlerThread;
  private volatile boolean mIsCtxValid = false;
  private volatile boolean mIsTerminated = false;
  private JsContext mJsContext;
  private Object mLock = new Object();
  private IMiniAppContext mMiniAppContext;
  private MiniAppWorkerManager mMiniAppWorkerManager;
  private Handler mThreadHandler;
  private JsVirtualMachine mVM;
  private WebView mWebView;
  
  public MiniAppWorker(IMiniAppContext paramIMiniAppContext, MiniAppWorkerManager paramMiniAppWorkerManager)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mMiniAppWorkerManager = paramMiniAppWorkerManager;
    if (this.mMiniAppWorkerManager.isJsCoreMode())
    {
      this.mHandlerThread = new HandlerThread("mini_worker_thread");
      this.mHandlerThread.start();
      this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
      QMLog.i("minisdk-worker", "[MiniAppWorker] create and alive in thread --> mini_worker_thread.");
    }
  }
  
  private void evaluteJs(String paramString, ValueCallback paramValueCallback)
  {
    if (this.mMiniAppWorkerManager.isJsCoreMode())
    {
      this.mThreadHandler.post(new MiniAppWorker.8(this, paramString, paramValueCallback));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new MiniAppWorker.9(this, paramString, paramValueCallback));
  }
  
  private void initJsCore()
  {
    QMLog.i("minisdk-worker", "[initJsCore]");
    this.mVM = new JsVirtualMachine(this.mMiniAppContext.getContext(), this.mThreadHandler.getLooper());
    this.mJsContext = new JsContext(this.mVM);
    this.mJsContext.setExceptionHandler(new MiniAppWorker.3(this));
    this.mJsContext.addJavascriptInterface(new MiniAppWorker.ServiceInterface(this), "WeixinJSCore");
    this.mJsContext.addJavascriptInterface(new MiniWorkerInterface(this.mMiniAppContext), "WeixinWorker");
  }
  
  private void initWebview()
  {
    QMLog.i("minisdk-worker", "[initWebview]");
    this.mWebView = new WebView(this.mMiniAppContext.getContext());
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setSupportZoom(false);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.mWebView.addJavascriptInterface(new MiniAppWorker.ServiceInterface(this), "WeixinJSCore");
    this.mWebView.addJavascriptInterface(new MiniWorkerInterface(this.mMiniAppContext), "WeixinWorker");
  }
  
  /* Error */
  public void clearUp()
  {
    // Byte code:
    //   0: ldc 69
    //   2: ldc 191
    //   4: invokestatic 194	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   11: ifnull +33 -> 44
    //   14: aload_0
    //   15: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   18: ldc 151
    //   20: invokevirtual 197	com/tencent/smtt/sdk/JsContext:removeJavascriptInterface	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   27: ldc 162
    //   29: invokevirtual 197	com/tencent/smtt/sdk/JsContext:removeJavascriptInterface	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   36: invokevirtual 200	com/tencent/smtt/sdk/JsContext:destroy	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   44: aload_0
    //   45: getfield 91	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mWebView	Lcom/tencent/smtt/sdk/WebView;
    //   48: ifnull +14 -> 62
    //   51: new 202	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker$7
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 203	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker$7:<init>	(Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;)V
    //   59: invokestatic 117	com/tencent/qqmini/sdk/launcher/core/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   62: aload_0
    //   63: getfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   66: ifnull +15 -> 81
    //   69: aload_0
    //   70: getfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   73: invokevirtual 204	com/tencent/smtt/sdk/JsVirtualMachine:destroy	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   81: aload_0
    //   82: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   85: ifnull +31 -> 116
    //   88: aload_0
    //   89: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   92: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   95: ifnull +21 -> 116
    //   98: getstatic 210	android/os/Build$VERSION:SDK_INT	I
    //   101: bipush 18
    //   103: if_icmplt +38 -> 141
    //   106: aload_0
    //   107: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   110: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   113: invokevirtual 215	android/os/Looper:quitSafely	()V
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   121: aload_0
    //   122: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   125: astore_1
    //   126: aload_1
    //   127: monitorenter
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   138: aload_1
    //   139: monitorexit
    //   140: return
    //   141: aload_0
    //   142: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   145: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   148: invokevirtual 218	android/os/Looper:quit	()V
    //   151: goto -35 -> 116
    //   154: astore_1
    //   155: ldc 69
    //   157: ldc 220
    //   159: aload_1
    //   160: invokestatic 223	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_0
    //   164: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   167: astore_1
    //   168: aload_1
    //   169: monitorenter
    //   170: aload_0
    //   171: iconst_1
    //   172: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   180: aload_1
    //   181: monitorexit
    //   182: return
    //   183: astore_2
    //   184: aload_1
    //   185: monitorexit
    //   186: aload_2
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    //   193: astore_2
    //   194: aload_0
    //   195: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   198: astore_1
    //   199: aload_1
    //   200: monitorenter
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   211: aload_1
    //   212: monitorexit
    //   213: aload_2
    //   214: athrow
    //   215: astore_2
    //   216: aload_1
    //   217: monitorexit
    //   218: aload_2
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	MiniAppWorker
    //   125	14	1	localObject1	Object
    //   154	6	1	localException	java.lang.Exception
    //   167	50	1	localObject2	Object
    //   183	4	2	localObject3	Object
    //   188	4	2	localObject4	Object
    //   193	21	2	localObject5	Object
    //   215	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	44	154	java/lang/Exception
    //   44	62	154	java/lang/Exception
    //   62	81	154	java/lang/Exception
    //   81	116	154	java/lang/Exception
    //   116	121	154	java/lang/Exception
    //   141	151	154	java/lang/Exception
    //   170	182	183	finally
    //   184	186	183	finally
    //   128	140	188	finally
    //   189	191	188	finally
    //   7	44	193	finally
    //   44	62	193	finally
    //   62	81	193	finally
    //   81	116	193	finally
    //   116	121	193	finally
    //   141	151	193	finally
    //   155	163	193	finally
    //   201	213	215	finally
    //   216	218	215	finally
  }
  
  public void ctxValid()
  {
    synchronized (this.mLock)
    {
      this.mIsCtxValid = true;
      return;
    }
  }
  
  public void initJSContext()
  {
    QMLog.e("minisdk-worker", "[initJSContext]");
    if (this.mMiniAppWorkerManager.isJsCoreMode()) {
      if (this.mThreadHandler != null) {
        this.mThreadHandler.post(new MiniAppWorker.1(this));
      }
    }
    for (;;)
    {
      if (this.mMiniAppWorkerManager != null) {
        this.mMiniAppWorkerManager.onWorkerJSContextInitFinished();
      }
      return;
      AppBrandTask.runTaskOnUiThread(new MiniAppWorker.2(this));
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
  
  public boolean loadExecutedAppConfig()
  {
    QMLog.i("minisdk-worker", "[loadExecutedAppConfig]");
    if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getMiniAppInfo() == null) || (this.mMiniAppContext.getMiniAppInfo().apkgInfo == null))
    {
      QMLog.e("minisdk-worker", "[loadExecutedAppConfig] failed : empty apkginfo");
      return false;
    }
    String str2 = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);", new Object[] { this.mMiniAppContext.getMiniAppInfo().apkgInfo.mConfigStr });
    String str1 = str2;
    if (StorageUtil.getPreference().getBoolean(this.mMiniAppContext.getMiniAppInfo().appId + "_debug", false)) {
      str1 = str2 + "__qqConfig.debug=true;";
    }
    evaluteJs(str1, new MiniAppWorker.4(this));
    return true;
  }
  
  public boolean loadWorkerJs(String paramString)
  {
    QMLog.i("minisdk-worker", "[load workerJs]");
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("minisdk-worker", "[loadWAWorker] failed : empty workerJs");
      return false;
    }
    evaluteJs(paramString, new MiniAppWorker.5(this));
    return true;
  }
  
  public void postMessageListToWorker(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null)
    {
      QMLog.e("minisdk-worker", "[postMessageListToWorker] messagePendingList is null");
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
    QMLog.i("minisdk-worker", "[postMessageToWorker] jsScript:" + paramString);
    evaluteJs(paramString, new MiniAppWorker.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker
 * JD-Core Version:    0.7.0.1
 */