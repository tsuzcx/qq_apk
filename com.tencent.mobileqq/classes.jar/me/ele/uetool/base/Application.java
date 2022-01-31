package me.ele.uetool.base;

import android.content.Context;
import java.lang.reflect.Method;

public class Application
{
  private static Context CONTEXT;
  
  public static Context getApplicationContext()
  {
    if (CONTEXT != null) {
      return CONTEXT;
    }
    try
    {
      CONTEXT = (Context)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
      Context localContext = CONTEXT;
      return localContext;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.base.Application
 * JD-Core Version:    0.7.0.1
 */