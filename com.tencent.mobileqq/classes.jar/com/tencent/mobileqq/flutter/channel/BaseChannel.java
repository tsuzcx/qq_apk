package com.tencent.mobileqq.flutter.channel;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class BaseChannel
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  
  public abstract String a();
  
  public AppRuntime d()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public String e()
  {
    AppRuntime localAppRuntime = d();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.BaseChannel", 2, String.format("channel: %s is destroy", new Object[] { a() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.BaseChannel
 * JD-Core Version:    0.7.0.1
 */