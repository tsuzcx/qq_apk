package com.tencent.qqmini.sdk.runtime.core.page;

import besl;
import bfas;
import bfbb;
import org.json.JSONObject;

public class AppBrandPageContainer$1$2
  implements Runnable
{
  public AppBrandPageContainer$1$2(bfbb parambfbb) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", 0);
      localJSONObject.put("inputId", this.a.a.d());
      if (this.a.a.a != null) {
        this.a.a.a.a("onKeyboardHeightChange", localJSONObject.toString(), this.a.a.c());
      }
      this.a.a.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.1.2
 * JD-Core Version:    0.7.0.1
 */