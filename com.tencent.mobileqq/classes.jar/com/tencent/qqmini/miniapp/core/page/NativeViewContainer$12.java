package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;

class NativeViewContainer$12
  implements Runnable
{
  NativeViewContainer$12(NativeViewContainer paramNativeViewContainer, int paramInt, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    this.this$0.removeCanvas(this.val$canvasId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.12
 * JD-Core Version:    0.7.0.1
 */