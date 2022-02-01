package com.tencent.mobileqq.microapp.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class WebviewContainer$1
  implements View.OnClickListener
{
  WebviewContainer$1(WebviewContainer paramWebviewContainer, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    try
    {
      String str = this.val$jsonObject.optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", str);
      WebviewContainer.access$000(this.this$0).evaluteJs("WeixinJSBridge.subscribeHandler(\"onTextViewClick\", " + localJSONObject + "," + WebviewContainer.access$000(this.this$0).pageWebviewId + ")");
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
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.1
 * JD-Core Version:    0.7.0.1
 */