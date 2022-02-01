package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class EventListener$10
  implements Runnable
{
  EventListener$10(EventListener paramEventListener, IAppBrandPageContainer paramIAppBrandPageContainer, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$pageContainer.navigateTo(this.val$url, this.val$req.callbackId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.10
 * JD-Core Version:    0.7.0.1
 */