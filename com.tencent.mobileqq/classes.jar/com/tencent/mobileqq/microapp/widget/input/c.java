package com.tencent.mobileqq.microapp.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import org.json.JSONException;
import org.json.JSONObject;

final class c
  implements TextWatcher
{
  c(a parama, String paramString, f paramf, PageWebview paramPageWebview) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", a.a(this.d));
      localJSONObject.put("cursor", paramEditable.toString().length());
      localJSONObject.put("value", paramEditable.toString());
      localJSONObject.put("data", new JSONObject(this.a).optString("data"));
      paramEditable = this.b.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onKeyboardValueChange\", ");
      localStringBuilder.append(localJSONObject);
      localStringBuilder.append(",");
      localStringBuilder.append(this.c.pageWebviewId);
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
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.c
 * JD-Core Version:    0.7.0.1
 */