package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class NativeViewContainer$14
  implements Runnable
{
  NativeViewContainer$14(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject.optInt("htmlId");
      localJSONObject = localJSONObject.optJSONObject("position");
      if (localJSONObject != null)
      {
        int j = localJSONObject.optInt("left");
        int k = localJSONObject.optInt("top");
        int m = localJSONObject.optInt("width");
        int n = localJSONObject.optInt("height");
        if (NativeViewContainer.access$400(this.this$0, i, j, k, m, n))
        {
          this.val$req.ok();
          return;
        }
        this.val$req.fail("create webview failed.");
        return;
      }
      this.val$req.fail();
      QMLog.e("NativeViewContainer", "posObj is null");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$req.event);
      localStringBuilder.append(" error.");
      QMLog.e("NativeViewContainer", localStringBuilder.toString(), localException);
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.14
 * JD-Core Version:    0.7.0.1
 */