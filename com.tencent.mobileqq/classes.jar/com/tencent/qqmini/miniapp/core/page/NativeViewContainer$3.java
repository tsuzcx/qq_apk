package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;
import org.json.JSONObject;

class NativeViewContainer$3
  implements Runnable
{
  NativeViewContainer$3(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$req.jsonParams).optInt("inputId");
      if (((this.val$req.jsService instanceof PageWebview)) && (NativeViewContainer.access$000(this.this$0) != null) && (NativeViewContainer.access$000(this.this$0).getShowingInput() != null) && (!NativeViewContainer.access$000(this.this$0).getShowingInput().containsKey(Integer.valueOf(i))))
      {
        MiniAppTextArea localMiniAppTextArea = this.this$0.getTextArea(i);
        if (localMiniAppTextArea != null)
        {
          Object localObject = (InputMethodManager)NativeViewContainer.access$100(this.this$0).getContext().getSystemService("input_method");
          if (localObject != null) {
            ((InputMethodManager)localObject).hideSoftInputFromWindow(localMiniAppTextArea.getWindowToken(), 0);
          }
          this.this$0.hideKeyBoardConfirmView();
          this.val$req.ok();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("inputId", i);
          ((JSONObject)localObject).put("value", localMiniAppTextArea.getText().toString());
          ((JSONObject)localObject).put("cursor", localMiniAppTextArea.getText().toString().length());
          this.val$req.sendSubscribeJs("onKeyboardComplete", ((JSONObject)localObject).toString(), 0);
        }
      }
      else if (NativeViewContainer.access$000(this.this$0) != null)
      {
        NativeViewContainer.access$000(this.this$0).hideKeyboard(this.val$req);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NativeViewContainer", "EVENT_HIDE_KEYBOARD error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.3
 * JD-Core Version:    0.7.0.1
 */