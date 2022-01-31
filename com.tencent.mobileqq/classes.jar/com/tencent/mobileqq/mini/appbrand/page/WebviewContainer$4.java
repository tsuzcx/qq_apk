package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class WebviewContainer$4
  implements View.OnClickListener
{
  WebviewContainer$4(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("data", this.val$data);
      this.this$0.pageWebview.evaluateSubcribeJS("onImageViewClick", paramView.toString(), this.this$0.pageWebview.pageWebviewId);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("WebViewContainer", 1, "evaluateSubcribeJS error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */