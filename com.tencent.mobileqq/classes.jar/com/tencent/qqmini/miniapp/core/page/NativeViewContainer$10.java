package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class NativeViewContainer$10
  implements Runnable
{
  NativeViewContainer$10(NativeViewContainer paramNativeViewContainer, JSONObject paramJSONObject1, int paramInt1, int paramInt2, JSONObject paramJSONObject2, String paramString, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject3) {}
  
  public void run()
  {
    Boolean localBoolean;
    if (this.val$jsonObject.opt("disableScroll") != null) {
      localBoolean = Boolean.valueOf(this.val$jsonObject.optBoolean("disableScroll"));
    } else {
      localBoolean = null;
    }
    this.this$0.insertCanvas(this.val$canvasId, this.val$parentId, this.val$postionObj, this.val$data, this.val$jsonObject.optBoolean("hide"), this.val$jsonObject.optBoolean("useHardwareAccelerate"), localBoolean, this.val$jsonObject.optBoolean("gesture"), this.val$req.jsService);
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.10
 * JD-Core Version:    0.7.0.1
 */