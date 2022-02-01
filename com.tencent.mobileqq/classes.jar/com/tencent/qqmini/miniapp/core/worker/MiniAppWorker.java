package com.tencent.qqmini.miniapp.core.worker;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
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
    this.mWebView = new DtX5WebView(this.mMiniAppContext.getContext());
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
    //   2: ldc 193
    //   4: invokestatic 196	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   11: ifnull +33 -> 44
    //   14: aload_0
    //   15: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   18: ldc 151
    //   20: invokevirtual 199	com/tencent/smtt/sdk/JsContext:removeJavascriptInterface	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   27: ldc 162
    //   29: invokevirtual 199	com/tencent/smtt/sdk/JsContext:removeJavascriptInterface	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   36: invokevirtual 202	com/tencent/smtt/sdk/JsContext:destroy	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 97	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mJsContext	Lcom/tencent/smtt/sdk/JsContext;
    //   44: aload_0
    //   45: getfield 91	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mWebView	Lcom/tencent/smtt/sdk/WebView;
    //   48: ifnull +14 -> 62
    //   51: new 204	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker$7
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 205	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker$7:<init>	(Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;)V
    //   59: invokestatic 117	com/tencent/qqmini/sdk/launcher/core/utils/AppBrandTask:runTaskOnUiThread	(Ljava/lang/Runnable;)V
    //   62: aload_0
    //   63: getfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   66: ifnull +15 -> 81
    //   69: aload_0
    //   70: getfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   73: invokevirtual 206	com/tencent/smtt/sdk/JsVirtualMachine:destroy	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 133	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mVM	Lcom/tencent/smtt/sdk/JsVirtualMachine;
    //   81: aload_0
    //   82: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   85: ifnull +44 -> 129
    //   88: aload_0
    //   89: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   92: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   95: ifnull +34 -> 129
    //   98: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   101: bipush 18
    //   103: if_icmplt +16 -> 119
    //   106: aload_0
    //   107: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   110: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   113: invokevirtual 217	android/os/Looper:quitSafely	()V
    //   116: goto +13 -> 129
    //   119: aload_0
    //   120: getfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   123: invokevirtual 62	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   126: invokevirtual 220	android/os/Looper:quit	()V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 53	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mHandlerThread	Landroid/os/HandlerThread;
    //   134: aload_0
    //   135: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   138: astore_1
    //   139: aload_1
    //   140: monitorenter
    //   141: aload_0
    //   142: iconst_1
    //   143: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   151: aload_1
    //   152: monitorexit
    //   153: return
    //   154: astore_2
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: athrow
    //   159: astore_2
    //   160: goto +37 -> 197
    //   163: astore_1
    //   164: ldc 69
    //   166: ldc 222
    //   168: aload_1
    //   169: invokestatic 225	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_0
    //   173: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   176: astore_1
    //   177: aload_1
    //   178: monitorenter
    //   179: aload_0
    //   180: iconst_1
    //   181: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   189: aload_1
    //   190: monitorexit
    //   191: return
    //   192: astore_2
    //   193: aload_1
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    //   197: aload_0
    //   198: getfield 34	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mLock	Ljava/lang/Object;
    //   201: astore_1
    //   202: aload_1
    //   203: monitorenter
    //   204: aload_0
    //   205: iconst_1
    //   206: putfield 30	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsTerminated	Z
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 32	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:mIsCtxValid	Z
    //   214: aload_1
    //   215: monitorexit
    //   216: aload_2
    //   217: athrow
    //   218: astore_2
    //   219: aload_1
    //   220: monitorexit
    //   221: aload_2
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	MiniAppWorker
    //   138	18	1	localObject1	Object
    //   163	6	1	localException	java.lang.Exception
    //   176	44	1	localObject2	Object
    //   154	4	2	localObject3	Object
    //   159	1	2	localObject4	Object
    //   192	25	2	localObject5	Object
    //   218	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   141	153	154	finally
    //   155	157	154	finally
    //   7	44	159	finally
    //   44	62	159	finally
    //   62	81	159	finally
    //   81	116	159	finally
    //   119	129	159	finally
    //   129	134	159	finally
    //   164	172	159	finally
    //   7	44	163	java/lang/Exception
    //   44	62	163	java/lang/Exception
    //   62	81	163	java/lang/Exception
    //   81	116	163	java/lang/Exception
    //   119	129	163	java/lang/Exception
    //   129	134	163	java/lang/Exception
    //   179	191	192	finally
    //   193	195	192	finally
    //   204	216	218	finally
    //   219	221	218	finally
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
    if (this.mMiniAppWorkerManager.isJsCoreMode())
    {
      localObject = this.mThreadHandler;
      if (localObject != null) {
        ((Handler)localObject).post(new MiniAppWorker.1(this));
      }
    }
    else
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppWorker.2(this));
    }
    Object localObject = this.mMiniAppWorkerManager;
    if (localObject != null) {
      ((MiniAppWorkerManager)localObject).onWorkerJSContextInitFinished();
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
    Object localObject = this.mMiniAppContext;
    if ((localObject != null) && (((IMiniAppContext)localObject).getMiniAppInfo() != null) && (this.mMiniAppContext.getMiniAppInfo().apkgInfo != null))
    {
      String str = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);", new Object[] { this.mMiniAppContext.getMiniAppInfo().apkgInfo.mConfigStr });
      SharedPreferences localSharedPreferences = StorageUtil.getPreference();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMiniAppContext.getMiniAppInfo().appId);
      localStringBuilder.append("_debug");
      localObject = str;
      if (localSharedPreferences.getBoolean(localStringBuilder.toString(), false))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("__qqConfig.debug=true;");
        localObject = ((StringBuilder)localObject).toString();
      }
      evaluteJs((String)localObject, new MiniAppWorker.4(this));
      return true;
    }
    QMLog.e("minisdk-worker", "[loadExecutedAppConfig] failed : empty apkginfo");
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[postMessageToWorker] jsScript:");
    localStringBuilder.append(paramString);
    QMLog.i("minisdk-worker", localStringBuilder.toString());
    evaluteJs(paramString, new MiniAppWorker.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker
 * JD-Core Version:    0.7.0.1
 */