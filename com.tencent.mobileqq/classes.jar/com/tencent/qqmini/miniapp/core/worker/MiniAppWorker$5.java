package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

class MiniAppWorker$5
  implements ValueCallback
{
  MiniAppWorker$5(MiniAppWorker paramMiniAppWorker) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QMLog.i("minisdk-worker", "[workerJS] over");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.5
 * JD-Core Version:    0.7.0.1
 */