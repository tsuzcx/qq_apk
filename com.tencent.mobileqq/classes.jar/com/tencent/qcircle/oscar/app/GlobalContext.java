package com.tencent.qcircle.oscar.app;

import android.app.Application;
import android.content.Context;

public class GlobalContext
{
  private static Application sApp;
  private static Context sContext;
  
  public static Application getApp()
  {
    return sApp;
  }
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static void setApp(Application paramApplication)
  {
    sApp = paramApplication;
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.oscar.app.GlobalContext
 * JD-Core Version:    0.7.0.1
 */