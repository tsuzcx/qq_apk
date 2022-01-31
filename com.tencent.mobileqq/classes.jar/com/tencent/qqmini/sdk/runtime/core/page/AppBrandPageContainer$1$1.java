package com.tencent.qqmini.sdk.runtime.core.page;

import bdnw;
import bduk;
import bdut;
import org.json.JSONObject;

public class AppBrandPageContainer$1$1
  implements Runnable
{
  public AppBrandPageContainer$1$1(bdut parambdut, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", this.jdField_a_of_type_Int);
      localJSONObject.put("inputId", this.jdField_a_of_type_Bdut.a.d());
      if (this.jdField_a_of_type_Bdut.a.a != null) {
        this.jdField_a_of_type_Bdut.a.a.a("onKeyboardHeightChange", localJSONObject.toString(), this.jdField_a_of_type_Bdut.a.c());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */