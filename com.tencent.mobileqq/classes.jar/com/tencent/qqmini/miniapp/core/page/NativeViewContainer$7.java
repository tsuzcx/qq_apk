package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class NativeViewContainer$7
  implements Runnable
{
  NativeViewContainer$7(NativeViewContainer paramNativeViewContainer, JSONObject paramJSONObject1, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    this.this$0.updateTextArea(this.val$jsonObject, this.val$req);
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.7
 * JD-Core Version:    0.7.0.1
 */