package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

class MiniAppWorker$9
  implements Runnable
{
  MiniAppWorker$9(MiniAppWorker paramMiniAppWorker, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (MiniAppWorker.access$200(this.this$0) != null) {
      MiniAppWorker.access$200(this.this$0).evaluateJavascript(this.val$js, this.val$valueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.9
 * JD-Core Version:    0.7.0.1
 */