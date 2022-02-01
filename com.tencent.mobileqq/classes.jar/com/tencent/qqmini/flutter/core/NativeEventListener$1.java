package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NativeEventListener$1
  implements Runnable
{
  NativeEventListener$1(NativeEventListener paramNativeEventListener, IAppBrandPageContainer paramIAppBrandPageContainer, String paramString1, String paramString2, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$pageContainer.dispatchEventToWebView(this.val$eventName, this.val$jsonParams, null);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeEventListener.1
 * JD-Core Version:    0.7.0.1
 */