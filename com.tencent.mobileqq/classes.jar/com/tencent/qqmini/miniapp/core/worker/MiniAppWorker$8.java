package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.ValueCallback;

class MiniAppWorker$8
  implements Runnable
{
  MiniAppWorker$8(MiniAppWorker paramMiniAppWorker, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (MiniAppWorker.access$300(this.this$0) != null)
    {
      MiniAppWorker.access$300(this.this$0).evaluateJavascript(this.val$js, this.val$valueCallback);
      return;
    }
    QMLog.e("minisdk-worker", " mJsContext === null  ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.8
 * JD-Core Version:    0.7.0.1
 */