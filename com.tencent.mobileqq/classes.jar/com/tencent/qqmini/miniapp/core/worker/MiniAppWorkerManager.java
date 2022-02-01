package com.tencent.qqmini.miniapp.core.worker;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.action.WorkerAction;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import java.util.ArrayList;

public class MiniAppWorkerManager
{
  public static final int MODE_JSCORE = 1;
  public static final int MODE_WEBVIEW = 0;
  public static final String OBJ_WEIXINWORKER = "WeixinWorker";
  public static final String TAG = "minisdk-worker";
  private static volatile MiniAppWorker mWorker;
  private IMiniAppContext mMiniAppContext;
  private String mWAWorkerJsStr;
  private String mWorkerRunnableStr;
  private ArrayList<String> messagePendingList = new ArrayList();
  private int workerVmMode;
  
  public MiniAppWorkerManager(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    paramIMiniAppContext = ((BaseRuntimeImpl.BaselibProvider)paramIMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
    if (paramIMiniAppContext != null) {
      this.mWAWorkerJsStr = paramIMiniAppContext.waWorkerStr;
    }
  }
  
  /* Error */
  private void handlePendingMsgList()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   5: ifnull +12 -> 17
    //   8: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   11: invokevirtual 67	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:isJSContextValid	()Z
    //   14: ifne +13 -> 27
    //   17: ldc 16
    //   19: ldc 69
    //   21: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   30: aload_0
    //   31: getfield 36	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:messagePendingList	Ljava/util/ArrayList;
    //   34: invokevirtual 79	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:postMessageListToWorker	(Ljava/util/ArrayList;)V
    //   37: goto -13 -> 24
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	MiniAppWorkerManager
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	40	finally
    //   17	24	40	finally
    //   24	26	40	finally
    //   27	37	40	finally
    //   41	43	40	finally
  }
  
  public MiniAppWorker createRelWorker()
  {
    QMLog.i("minisdk-worker", "[createWorker]");
    try
    {
      if ((mWorker != null) && (!mWorker.isTerminated())) {
        throw new Exception("Worker already created and running!");
      }
    }
    finally {}
    mWorker = new MiniAppWorker(this.mMiniAppContext, this);
    MiniAppWorker localMiniAppWorker = mWorker;
    return localMiniAppWorker;
  }
  
  public int createWorker(String paramString)
  {
    QMLog.i("minisdk-worker", "[handleCreateWorker]");
    setWorkerVmMode(WorkerAction.obtain(this.mMiniAppContext).getWorkerMode());
    if (TextUtils.isEmpty(this.mWAWorkerJsStr))
    {
      localObject = ((BaseRuntimeImpl.BaselibProvider)this.mMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
      if (localObject != null) {
        this.mWAWorkerJsStr = ((BaselibLoader.BaselibContent)localObject).waWorkerStr;
      }
    }
    if (TextUtils.isEmpty(this.mWAWorkerJsStr))
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] error : waWorker.js is missing");
      return 0;
    }
    if ((this.mMiniAppContext.getMiniAppInfo() == null) || (this.mMiniAppContext.getMiniAppInfo().apkgInfo == null))
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] error : apkgInfo is missing");
      return 0;
    }
    if (TextUtils.isEmpty(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getWorkerPath(null, paramString)))
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] error : 001 executed js file " + paramString + " is missing");
      return -1;
    }
    Object localObject = ((ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo).getWorkerJsContent(null, paramString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] error : 002 executed js file " + paramString + " is missing");
      return -1;
    }
    this.mWorkerRunnableStr = ((String)localObject);
    try
    {
      createRelWorker().initJSContext();
      return 1;
    }
    catch (Exception paramString)
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] failed : ", paramString);
    }
    return 0;
  }
  
  public int getWorkerVmMode()
  {
    return this.workerVmMode;
  }
  
  /* Error */
  public void handlePostMsgToWorker(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   5: ifnull +12 -> 17
    //   8: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   11: invokevirtual 67	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:isJSContextValid	()Z
    //   14: ifne +57 -> 71
    //   17: aload_0
    //   18: getfield 36	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:messagePendingList	Ljava/util/ArrayList;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 33	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 34	java/util/ArrayList:<init>	()V
    //   32: putfield 36	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:messagePendingList	Ljava/util/ArrayList;
    //   35: ldc 16
    //   37: new 145	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   44: ldc 183
    //   46: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 86	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 36	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:messagePendingList	Ljava/util/ArrayList;
    //   63: aload_1
    //   64: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: getstatic 61	com/tencent/qqmini/miniapp/core/worker/MiniAppWorkerManager:mWorker	Lcom/tencent/qqmini/miniapp/core/worker/MiniAppWorker;
    //   74: aload_1
    //   75: invokevirtual 190	com/tencent/qqmini/miniapp/core/worker/MiniAppWorker:postMessageToWorker	(Ljava/lang/String;)V
    //   78: goto -10 -> 68
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	MiniAppWorkerManager
    //   0	86	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	17	81	finally
    //   17	35	81	finally
    //   35	68	81	finally
    //   68	70	81	finally
    //   71	78	81	finally
    //   82	84	81	finally
  }
  
  public boolean isJsCoreMode()
  {
    return this.workerVmMode == 1;
  }
  
  public void onWorkerJSContextInitFinished()
  {
    QMLog.i("minisdk-worker", "[onWorkerJSContextInitFinished]");
    try
    {
      if (mWorker == null)
      {
        QMLog.e("minisdk-worker", "[onWorkerJSContextInitFinished] failed : worker null!");
        return;
      }
      if (!mWorker.loadExecutedAppConfig()) {
        return;
      }
    }
    finally {}
    if (!mWorker.loadWorkerJs(this.mWAWorkerJsStr)) {
      return;
    }
    if (!mWorker.loadWorkerJs(this.mWorkerRunnableStr)) {
      return;
    }
    mWorker.ctxValid();
    handlePendingMsgList();
  }
  
  public void setWorkerVmMode(int paramInt)
  {
    this.workerVmMode = paramInt;
  }
  
  public void stopWorker()
  {
    try
    {
      if (mWorker == null) {
        return;
      }
      mWorker.clearUp();
      mWorker = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager
 * JD-Core Version:    0.7.0.1
 */