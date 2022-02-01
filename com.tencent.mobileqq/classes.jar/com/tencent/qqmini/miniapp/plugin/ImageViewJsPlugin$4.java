package com.tencent.qqmini.miniapp.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class ImageViewJsPlugin$4
  implements View.OnClickListener
{
  ImageViewJsPlugin$4(ImageViewJsPlugin paramImageViewJsPlugin, String paramString, RequestEvent paramRequestEvent) {}
  
  public void onClick(View paramView)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.val$data);
      this.val$req.jsService.evaluateSubscribeJS("onImageViewClick", localJSONObject.toString(), ImageViewJsPlugin.access$200(this.this$0));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("ImageViewJsPlugin", "evaluateSubcribeJS error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */