package com.tencent.qqmini.sdk.runtime.core.page;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import bgmk;
import bhgx;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import java.util.Map;
import org.json.JSONObject;

class NativeViewContainer$3
  implements Runnable
{
  NativeViewContainer$3(NativeViewContainer paramNativeViewContainer, bgmk parambgmk) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.a.b).optInt("inputId");
      if ((NativeViewContainer.a(this.this$0) != null) && (NativeViewContainer.a(this.this$0).a() != null) && (!NativeViewContainer.a(this.this$0).a().containsKey(Integer.valueOf(i))))
      {
        MiniAppTextArea localMiniAppTextArea = this.this$0.a(i);
        if (localMiniAppTextArea != null)
        {
          Object localObject = (InputMethodManager)NativeViewContainer.a(this.this$0).getSystemService("input_method");
          if (localObject != null) {
            ((InputMethodManager)localObject).hideSoftInputFromWindow(localMiniAppTextArea.getWindowToken(), 0);
          }
          this.this$0.a();
          this.a.a();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("inputId", i);
          ((JSONObject)localObject).put("value", localMiniAppTextArea.getText().toString());
          ((JSONObject)localObject).put("cursor", localMiniAppTextArea.getText().toString().length());
          this.a.a("onKeyboardComplete", ((JSONObject)localObject).toString(), 0);
        }
      }
      else if (NativeViewContainer.a(this.this$0) != null)
      {
        NativeViewContainer.a(this.this$0).c(this.a);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NativeViewContainer", "EVENT_HIDE_KEYBOARD error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer.3
 * JD-Core Version:    0.7.0.1
 */