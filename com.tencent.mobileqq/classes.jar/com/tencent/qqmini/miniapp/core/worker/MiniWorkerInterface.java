package com.tencent.qqmini.miniapp.core.worker;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.miniapp.action.WorkerAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniWorkerInterface
{
  private IMiniAppContext mMiniAppContext;
  
  public MiniWorkerInterface(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
  }
  
  @JavascriptInterface
  public int create(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WORKER|create --> ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-worker", ((StringBuilder)localObject).toString());
    localObject = this.mMiniAppContext;
    if (localObject != null) {
      return WorkerAction.obtain((IMiniAppContext)localObject).createWorker(paramString);
    }
    return 0;
  }
  
  @JavascriptInterface
  public void postMsgToAppService(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WORKER|postMsgToMain --> data = ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-worker", ((StringBuilder)localObject).toString());
    localObject = this.mMiniAppContext;
    if (localObject != null) {
      WorkerAction.obtain((IMiniAppContext)localObject).postMsgToService(paramString);
    }
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WORKER|postMsgToWorker --> obj = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("data = ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-worker", ((StringBuilder)localObject).toString());
    localObject = this.mMiniAppContext;
    if (localObject != null) {
      WorkerAction.obtain((IMiniAppContext)localObject).postMsgToWorker(paramString);
    }
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WORKER|stopWorker code = ");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.i("minisdk-worker", ((StringBuilder)localObject).toString());
    localObject = this.mMiniAppContext;
    if (localObject != null) {
      WorkerAction.obtain((IMiniAppContext)localObject).stopWorker();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface
 * JD-Core Version:    0.7.0.1
 */