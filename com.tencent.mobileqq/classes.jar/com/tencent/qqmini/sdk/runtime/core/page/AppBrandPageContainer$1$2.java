package com.tencent.qqmini.sdk.runtime.core.page;

import bhez;
import bhfl;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class AppBrandPageContainer$1$2
  implements Runnable
{
  public AppBrandPageContainer$1$2(bhfl parambhfl) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", 0);
      localJSONObject.put("inputId", this.a.a.f());
      if (this.a.a.a != null) {
        this.a.a.a.a("onKeyboardHeightChange", localJSONObject.toString(), this.a.a.e());
      }
      this.a.a.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.2
 * JD-Core Version:    0.7.0.1
 */