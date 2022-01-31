package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class WebviewContainer$3
  implements View.OnClickListener
{
  WebviewContainer$3(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("data", this.val$data);
      WebviewContainer.access$300(this.this$0).evaluateSubcribeJS("onImageViewClick", paramView.toString(), WebviewContainer.access$300(this.this$0).pageWebviewId);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("WebViewContainer", 1, "evaluateSubcribeJS error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.3
 * JD-Core Version:    0.7.0.1
 */