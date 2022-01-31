package com.tencent.qqmini.sdk.runtime.core.page;

import bhez;
import bhfl;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class AppBrandPageContainer$1$1
  implements Runnable
{
  public AppBrandPageContainer$1$1(bhfl parambhfl, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", this.jdField_a_of_type_Int);
      localJSONObject.put("inputId", this.jdField_a_of_type_Bhfl.a.f());
      if (this.jdField_a_of_type_Bhfl.a.a != null) {
        this.jdField_a_of_type_Bhfl.a.a.a("onKeyboardHeightChange", localJSONObject.toString(), this.jdField_a_of_type_Bhfl.a.e());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */