package com.tencent.qqmini.sdk.runtime.core.page;

import besl;
import bfas;
import bfbb;
import org.json.JSONObject;

public class AppBrandPageContainer$1$1
  implements Runnable
{
  public AppBrandPageContainer$1$1(bfbb parambfbb, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", this.jdField_a_of_type_Int);
      localJSONObject.put("inputId", this.jdField_a_of_type_Bfbb.a.d());
      if (this.jdField_a_of_type_Bfbb.a.a != null) {
        this.jdField_a_of_type_Bfbb.a.a.a("onKeyboardHeightChange", localJSONObject.toString(), this.jdField_a_of_type_Bfbb.a.c());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */