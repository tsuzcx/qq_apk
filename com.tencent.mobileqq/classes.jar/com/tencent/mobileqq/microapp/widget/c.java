package com.tencent.mobileqq.microapp.widget;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import org.json.JSONException;
import org.json.JSONObject;

final class c
  implements TextWatcher
{
  c(MiniAppTextArea paramMiniAppTextArea, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, WebviewContainer paramWebviewContainer, JSONObject paramJSONObject3) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", this.c);
      localJSONObject.put("cursor", paramEditable.toString().length());
      localJSONObject.put("value", paramEditable.toString());
      localJSONObject.put("data", this.e.optString("data"));
      paramEditable = this.d.appBrandRuntime.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onKeyboardValueChange\", ");
      localStringBuilder.append(localJSONObject);
      localStringBuilder.append(",");
      localStringBuilder.append(this.d.getPageWebview().pageWebviewId);
      localStringBuilder.append(")");
      paramEditable.evaluteJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramEditable)
    {
      paramEditable.printStackTrace();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0)
    {
      this.f.setTextSize(2, this.a.optInt("fontSize"));
      this.f.setTextColor(Color.parseColor(this.a.optString("color")));
    }
    else
    {
      this.f.setTextSize(2, this.b.optInt("fontSize"));
      this.f.setTextColor(Color.parseColor(this.b.optString("color")));
    }
    try
    {
      paramCharSequence = new JSONObject();
      paramCharSequence.put("height", this.f.getMeasuredHeight());
      paramCharSequence.put("lineCount", this.f.getLineCount());
      paramCharSequence.put("inputId", this.c);
      PageWebview localPageWebview = this.d.getPageWebview();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onTextAreaHeightChange\", ");
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append(",");
      localStringBuilder.append(this.d.getPageWebview().pageWebviewId);
      localStringBuilder.append(")");
      localPageWebview.evaluteJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.c
 * JD-Core Version:    0.7.0.1
 */