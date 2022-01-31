package com.tencent.mobileqq.microapp.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
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
      paramView = this.val$jsonObject.optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramView);
      WebviewContainer.access$000(this.this$0).evaluteJs("WeixinJSBridge.subscribeHandler(\"onTextViewClick\", " + localJSONObject + "," + WebviewContainer.access$000(this.this$0).pageWebviewId + ")");
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.1
 * JD-Core Version:    0.7.0.1
 */