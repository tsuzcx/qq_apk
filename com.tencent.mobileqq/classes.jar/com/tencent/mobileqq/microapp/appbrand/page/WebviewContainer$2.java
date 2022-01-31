package com.tencent.mobileqq.microapp.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class WebviewContainer$2
  implements View.OnClickListener
{
  WebviewContainer$2(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("data", this.val$data);
      WebviewContainer.access$000(this.this$0).evaluteJs("WeixinJSBridge.subscribeHandler(\"onImageViewClick\", " + paramView + "," + WebviewContainer.access$000(this.this$0).pageWebviewId + ")");
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */