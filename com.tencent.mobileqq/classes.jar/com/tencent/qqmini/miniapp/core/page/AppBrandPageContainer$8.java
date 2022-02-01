package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

class AppBrandPageContainer$8
  implements Runnable
{
  AppBrandPageContainer$8(AppBrandPageContainer paramAppBrandPageContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    try
    {
      String str = new JSONObject(this.val$req.jsonParams).optString("backgroundColor", "#FFFFFF");
      this.this$0.setBackgroundColor(ColorUtils.parseColor(str));
      this.val$req.ok();
      return;
    }
    catch (Exception localException)
    {
      this.val$req.fail();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$req.event);
      localStringBuilder.append(" error.");
      QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.8
 * JD-Core Version:    0.7.0.1
 */