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
    QMLog.i("minisdk-worker", "WORKER|create --> " + paramString);
    if (this.mMiniAppContext != null) {
      return WorkerAction.obtain(this.mMiniAppContext).createWorker(paramString);
    }
    return 0;
  }
  
  @JavascriptInterface
  public void postMsgToAppService(String paramString)
  {
    QMLog.i("minisdk-worker", "WORKER|postMsgToMain --> data = " + paramString);
    if (this.mMiniAppContext != null) {
      WorkerAction.obtain(this.mMiniAppContext).postMsgToService(paramString);
    }
  }
  
  @JavascriptInterface
  public void postMsgToWorker(Object paramObject, String paramString)
  {
    QMLog.i("minisdk-worker", "WORKER|postMsgToWorker --> obj = " + paramObject + "data = " + paramString);
    if (this.mMiniAppContext != null) {
      WorkerAction.obtain(this.mMiniAppContext).postMsgToWorker(paramString);
    }
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    QMLog.i("minisdk-worker", "WORKER|stopWorker code = " + paramInt);
    if (this.mMiniAppContext != null) {
      WorkerAction.obtain(this.mMiniAppContext).stopWorker();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface
 * JD-Core Version:    0.7.0.1
 */