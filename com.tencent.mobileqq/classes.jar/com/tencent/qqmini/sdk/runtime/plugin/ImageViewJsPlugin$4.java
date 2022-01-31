package com.tencent.qqmini.sdk.runtime.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class ImageViewJsPlugin$4
  implements View.OnClickListener
{
  ImageViewJsPlugin$4(ImageViewJsPlugin paramImageViewJsPlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("data", this.val$data);
      ImageViewJsPlugin.access$200(this.this$0, "onImageViewClick", paramView.toString(), ImageViewJsPlugin.access$100(this.this$0));
      return;
    }
    catch (Throwable paramView)
    {
      QMLog.e("ImageViewJsPlugin", "evaluateSubcribeJS error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.ImageViewJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */