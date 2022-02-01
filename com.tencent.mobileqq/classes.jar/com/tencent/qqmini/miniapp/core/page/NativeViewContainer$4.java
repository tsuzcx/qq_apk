package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;

class NativeViewContainer$4
  implements Runnable
{
  NativeViewContainer$4(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if ((NativeViewContainer.access$000(this.this$0) != null) && (NativeViewContainer.access$000(this.this$0).updateInput(this.val$req.jsonParams)))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.4
 * JD-Core Version:    0.7.0.1
 */