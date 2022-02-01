package com.tencent.qqmini.miniapp.core.page.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;
import org.json.JSONObject;

class WebInputHandler$MyTextWatcher
  implements TextWatcher
{
  private final NativeViewRequestEvent req;
  
  public WebInputHandler$MyTextWatcher(WebInputHandler paramWebInputHandler, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    this.req = paramNativeViewRequestEvent;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((WebInputHandler.access$500(this.this$0).containsKey(Integer.valueOf(WebInputHandler.access$300(this.this$0)))) && (paramCharSequence.toString().equals(WebInputHandler.access$500(this.this$0).get(Integer.valueOf(WebInputHandler.access$300(this.this$0)))))) {
      return;
    }
    WebInputHandler.access$500(this.this$0).remove(Integer.valueOf(WebInputHandler.access$300(this.this$0)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", WebInputHandler.access$300(this.this$0));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.req.jsonParams).optString("data"));
        this.req.sendSubscribeJs("onKeyboardValueChange", localJSONObject.toString(), WebInputHandler.access$200(this.this$0).getWebviewId());
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      QMLog.e("WebInputHandler", "onTextChanged error", paramCharSequence);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.MyTextWatcher
 * JD-Core Version:    0.7.0.1
 */