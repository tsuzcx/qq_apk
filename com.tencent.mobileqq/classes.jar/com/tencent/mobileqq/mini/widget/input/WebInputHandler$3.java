package com.tencent.mobileqq.mini.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

class WebInputHandler$3
  implements TextWatcher
{
  WebInputHandler$3(WebInputHandler paramWebInputHandler, String paramString, BaseJsPluginEngine paramBaseJsPluginEngine, PageWebview paramPageWebview) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((WebInputHandler.access$200(this.this$0).containsKey(Integer.valueOf(WebInputHandler.access$100(this.this$0)))) && (paramCharSequence.toString().equals(WebInputHandler.access$200(this.this$0).get(Integer.valueOf(WebInputHandler.access$100(this.this$0)))))) {
      return;
    }
    WebInputHandler.access$200(this.this$0).remove(Integer.valueOf(WebInputHandler.access$100(this.this$0)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", WebInputHandler.access$100(this.this$0));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.val$webParams).optString("data"));
        this.val$jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onKeyboardValueChange", localJSONObject.toString(), this.val$pageWebview.pageWebviewId);
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      QLog.e("WebInputHandler", 2, "onTextChanged error", paramCharSequence);
      return;
    }
    if (paramInt2 != 0) {
      paramInt2 -= 1;
    }
    for (;;)
    {
      localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
      break;
      label241:
      localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
      break label154;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.3
 * JD-Core Version:    0.7.0.1
 */