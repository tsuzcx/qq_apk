package com.tencent.mobileqq.webview.api.impl;

class WebProcessManagerServiceImpl$2
  implements Runnable
{
  WebProcessManagerServiceImpl$2(WebProcessManagerServiceImpl paramWebProcessManagerServiceImpl) {}
  
  public void run()
  {
    if (this.this$0.isNeedPreloadWebProcess()) {
      this.this$0.startWebProcess(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */