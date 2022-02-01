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
      Object localObject = this.val$jsonObject.optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", localObject);
      localObject = WebviewContainer.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onTextViewClick\", ");
      localStringBuilder.append(localJSONObject);
      localStringBuilder.append(",");
      localStringBuilder.append(WebviewContainer.access$000(this.this$0).pageWebviewId);
      localStringBuilder.append(")");
      ((PageWebview)localObject).evaluteJs(localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.1
 * JD-Core Version:    0.7.0.1
 */