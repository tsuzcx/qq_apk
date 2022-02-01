package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

class MiniAppWorker$6
  implements ValueCallback
{
  MiniAppWorker$6(MiniAppWorker paramMiniAppWorker) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QMLog.i("minisdk-worker", "[postMessageToWorker] over");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.6
 * JD-Core Version:    0.7.0.1
 */