package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class NativeViewContainer$6
  implements Runnable
{
  NativeViewContainer$6(NativeViewContainer paramNativeViewContainer, int paramInt, JSONObject paramJSONObject1, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    try
    {
      this.this$0.insertTextArea(this.val$inputId, this.val$jsonObject, this.val$req);
      this.val$req.ok(this.val$result);
      this.this$0.callbackLineChange(this.val$inputId);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$req.event);
      localStringBuilder.append(" error.");
      QMLog.e("NativeViewContainer", localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.6
 * JD-Core Version:    0.7.0.1
 */