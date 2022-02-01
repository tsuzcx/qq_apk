package com.tencent.mobileqq.microapp.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.val$data);
      WebviewContainer.access$000(this.this$0).evaluteJs("WeixinJSBridge.subscribeHandler(\"onImageViewClick\", " + localJSONObject + "," + WebviewContainer.access$000(this.this$0).pageWebviewId + ")");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */