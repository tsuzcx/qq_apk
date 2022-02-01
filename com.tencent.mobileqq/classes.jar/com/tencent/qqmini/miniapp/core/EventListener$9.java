package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class EventListener$9
  implements Runnable
{
  EventListener$9(EventListener paramEventListener, IAppBrandPageContainer paramIAppBrandPageContainer, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$pageContainer.navigateBack(this.val$delta, this.val$req.callbackId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.9
 * JD-Core Version:    0.7.0.1
 */