package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.smtt.sdk.WebView;

class MiniAppWorker$7
  implements Runnable
{
  MiniAppWorker$7(MiniAppWorker paramMiniAppWorker) {}
  
  public void run()
  {
    MiniAppWorker.access$200(this.this$0).removeJavascriptInterface("WeixinJSCore");
    MiniAppWorker.access$200(this.this$0).removeJavascriptInterface("WeixinWorker");
    MiniAppWorker.access$200(this.this$0).destroy();
    MiniAppWorker.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.7
 * JD-Core Version:    0.7.0.1
 */