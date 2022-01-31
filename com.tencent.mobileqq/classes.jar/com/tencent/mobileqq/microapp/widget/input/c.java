package com.tencent.mobileqq.microapp.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.microapp.appbrand.a.a.y;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import org.json.JSONException;
import org.json.JSONObject;

final class c
  implements TextWatcher
{
  c(a parama, String paramString, y paramy, PageWebview paramPageWebview) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", a.a(this.d));
      localJSONObject.put("cursor", paramEditable.toString().length());
      localJSONObject.put("value", paramEditable.toString());
      localJSONObject.put("data", new JSONObject(this.a).optString("data"));
      this.b.a.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onKeyboardValueChange\", " + localJSONObject + "," + this.c.pageWebviewId + ")");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.c
 * JD-Core Version:    0.7.0.1
 */