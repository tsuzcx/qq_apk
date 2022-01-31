package com.tencent.qqmini.sdk.runtime.core.page;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import bgid;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import org.json.JSONException;
import org.json.JSONObject;

class NativeViewContainer$1
  implements Runnable
{
  NativeViewContainer$1(NativeViewContainer paramNativeViewContainer, int paramInt, bgid parambgid) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      this.this$0.setCurInputId(this.jdField_a_of_type_Int);
      ((MiniAppTextArea)localObject).setFocusable(true);
      ((MiniAppTextArea)localObject).setFocusableInTouchMode(true);
      ((MiniAppTextArea)localObject).requestFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)NativeViewContainer.a(this.this$0).getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput((View)localObject, 0);
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bgid.a((JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer.1
 * JD-Core Version:    0.7.0.1
 */