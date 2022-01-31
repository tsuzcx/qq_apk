package com.tencent.mobileqq.mini.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppTextArea1$2
  implements TextWatcher
{
  MiniAppTextArea1$2(MiniAppTextArea1 paramMiniAppTextArea1, int paramInt, WebviewContainer paramWebviewContainer) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject;
    if ((paramCharSequence != null) && (paramCharSequence.length() == 0))
    {
      if (MiniAppTextArea1.access$700(this.this$0) != null)
      {
        this.this$0.setTextSize(2, MiniAppTextArea1.access$700(this.this$0).optInt("fontSize"));
        this.this$0.setTextColor(ColorUtils.parseColor(MiniAppTextArea1.access$700(this.this$0).optString("color")));
      }
      MiniAppTextArea1.access$900(this.this$0);
      MiniAppTextArea1.access$1000(this.this$0);
      MiniAppTextArea1.access$1100(this.this$0);
      if ((paramCharSequence != null) && (!paramCharSequence.toString().equals(MiniAppTextArea1.access$1200(this.this$0))))
      {
        localJSONObject = new JSONObject();
        MiniAppTextArea1.access$1202(this.this$0, paramCharSequence.toString());
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("inputId", this.val$inputId);
        if (paramInt3 == 0)
        {
          localJSONObject.put("cursor", paramInt1);
          localJSONObject.put("value", MiniAppTextArea1.access$1200(this.this$0));
          if ((paramInt2 == 0) || (paramInt3 != 0)) {
            break label338;
          }
          localJSONObject.put("keyCode", 8);
          localJSONObject.put("data", MiniAppTextArea1.access$1300(this.this$0));
          this.val$wc.appBrandRuntime.serviceRuntime.evaluateSubcribeJS("onKeyboardValueChange", localJSONObject.toString(), this.val$wc.getPageWebview().pageWebviewId);
          return;
          if (MiniAppTextArea1.access$800(this.this$0) == null) {
            break;
          }
          this.this$0.setTextSize(2, MiniAppTextArea1.access$800(this.this$0).optInt("fontSize"));
          this.this$0.setTextColor(ColorUtils.parseColor(MiniAppTextArea1.access$800(this.this$0).optString("color")));
          break;
        }
        if (paramInt2 != 0)
        {
          paramInt2 -= 1;
          localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
          continue;
        }
        paramInt2 = 0;
      }
      catch (Exception paramCharSequence)
      {
        QLog.e("MiniAppTextArea1", 2, "onTextChanged error", paramCharSequence);
        return;
      }
      continue;
      label338:
      localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.2
 * JD-Core Version:    0.7.0.1
 */