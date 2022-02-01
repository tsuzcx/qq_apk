package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class NativeViewContainer$11
  implements Runnable
{
  NativeViewContainer$11(NativeViewContainer paramNativeViewContainer, int paramInt, JSONObject paramJSONObject1, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    this.this$0.updateCanvas(this.val$canvasId, this.val$postionObj, this.val$hide);
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.11
 * JD-Core Version:    0.7.0.1
 */