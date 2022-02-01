package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class NativeViewContainer$2
  implements Runnable
{
  NativeViewContainer$2(NativeViewContainer paramNativeViewContainer, int paramInt, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    Object localObject = this.this$0.getTextArea(this.val$inputId);
    if (localObject != null)
    {
      this.this$0.setCurInputId(this.val$inputId);
      ((MiniAppTextArea)localObject).setFocusable(true);
      ((MiniAppTextArea)localObject).setFocusableInTouchMode(true);
      ((MiniAppTextArea)localObject).requestFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)NativeViewContainer.access$100(this.this$0).getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput((View)localObject, 0);
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", this.val$inputId);
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.2
 * JD-Core Version:    0.7.0.1
 */