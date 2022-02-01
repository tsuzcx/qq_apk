package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;

class NativeViewContainer$1
  implements Runnable
{
  NativeViewContainer$1(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (NativeViewContainer.access$000(this.this$0) != null) {
      NativeViewContainer.access$000(this.this$0).showKeyboard(this.val$req);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.1
 * JD-Core Version:    0.7.0.1
 */