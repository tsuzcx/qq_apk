package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class NativeViewContainer$8
  implements Runnable
{
  NativeViewContainer$8(NativeViewContainer paramNativeViewContainer, int paramInt, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.removeTextArea(this.val$inputId);
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.8
 * JD-Core Version:    0.7.0.1
 */