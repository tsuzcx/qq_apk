package com.tencent.qflutter;

import android.app.Application;

public class MainApplication
  extends Application
{
  public void onCreate()
  {
    super.onCreate();
    QFlutterEngine.initializeFlutterBoost(this, null, new MainApplication.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qflutter.MainApplication
 * JD-Core Version:    0.7.0.1
 */