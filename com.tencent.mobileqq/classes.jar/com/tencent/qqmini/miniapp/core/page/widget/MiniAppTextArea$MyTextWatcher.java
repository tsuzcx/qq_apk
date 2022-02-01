package com.tencent.qqmini.miniapp.core.page.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

class MiniAppTextArea$MyTextWatcher
  implements TextWatcher
{
  private final NativeViewRequestEvent req;
  private final JSONObject style;
  
  public MiniAppTextArea$MyTextWatcher(MiniAppTextArea paramMiniAppTextArea, JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    this.style = paramJSONObject;
    this.req = paramNativeViewRequestEvent;
  }
  
  private void updateStyle(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() == 0))
    {
      if (MiniAppTextArea.access$2600(this.this$0) != null)
      {
        paramCharSequence = this.this$0;
        paramCharSequence.setTextSize(2, MiniAppTextArea.access$2600(paramCharSequence).optInt("fontSize"));
        paramCharSequence = this.this$0;
        paramCharSequence.setTextColor(ColorUtils.parseColor(MiniAppTextArea.access$2600(paramCharSequence).optString("color")));
      }
    }
    else
    {
      paramCharSequence = this.style;
      if (paramCharSequence != null)
      {
        this.this$0.setTextSize(2, paramCharSequence.optInt("fontSize"));
        this.this$0.setTextColor(ColorUtils.parseColor(this.style.optString("color")));
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    MiniAppTextArea.access$2100(this.this$0, paramInt1, paramInt2, paramInt3);
    updateStyle(paramCharSequence);
    MiniAppTextArea.access$2000(this.this$0);
    MiniAppTextArea.access$2200(this.this$0);
    MiniAppTextArea.access$2300(this.this$0);
    JSONObject localJSONObject;
    if ((paramCharSequence != null) && (!paramCharSequence.toString().equals(MiniAppTextArea.access$2400(this.this$0))))
    {
      localJSONObject = new JSONObject();
      MiniAppTextArea.access$2402(this.this$0, paramCharSequence.toString());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("inputId", MiniAppTextArea.access$900(this.this$0));
        if (paramInt3 != 0) {
          break label236;
        }
        localJSONObject.put("cursor", paramInt1);
        continue;
        localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
        localJSONObject.put("value", MiniAppTextArea.access$2400(this.this$0));
        if ((paramInt2 != 0) && (paramInt3 == 0)) {
          localJSONObject.put("keyCode", 8);
        } else {
          localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
        }
        localJSONObject.put("data", MiniAppTextArea.access$2500(this.this$0));
        this.req.sendSubscribeJs("onKeyboardValueChange", localJSONObject.toString(), MiniAppTextArea.access$100(this.this$0).getWebviewId());
        return;
      }
      catch (Exception paramCharSequence)
      {
        QMLog.e("MiniAppTextArea", "onTextChanged error", paramCharSequence);
      }
      return;
      label236:
      if (paramInt2 != 0) {
        paramInt2 -= 1;
      } else {
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.MyTextWatcher
 * JD-Core Version:    0.7.0.1
 */