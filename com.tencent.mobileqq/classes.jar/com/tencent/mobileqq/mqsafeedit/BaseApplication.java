package com.tencent.mobileqq.mqsafeedit;

import android.app.Application;
import android.content.Context;

public abstract class BaseApplication
  extends Application
{
  public static int appnewmsgicon = 0;
  static Context context;
  public static int defaultNotifSoundResourceId = 0;
  public static int qqlaunchicon = 0;
  
  public static Context getContext()
  {
    return context;
  }
  
  public static int getDefaultNotifSoundResourceId()
  {
    return defaultNotifSoundResourceId;
  }
  
  public static int getQQLaunchIcon()
  {
    return qqlaunchicon;
  }
  
  public static int getQQNewMsgIcon()
  {
    return appnewmsgicon;
  }
  
  public void callSystemSuperCreate()
  {
    super.onCreate();
    context = this;
  }
  
  public void onCreate()
  {
    if (context == null) {
      callSystemSuperCreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.BaseApplication
 * JD-Core Version:    0.7.0.1
 */