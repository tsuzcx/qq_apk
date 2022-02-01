package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class EventListener$3
  implements Runnable
{
  EventListener$3(EventListener paramEventListener, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.this$0.reload(this.val$url);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.3
 * JD-Core Version:    0.7.0.1
 */