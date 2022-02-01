package com.tencent.qqmini.miniapp.util.logmonitor;

import android.os.AsyncTask;

public class LogLoader
{
  public static final String TAG = "LogLoader";
  
  public static void load(Process paramProcess, LogLoader.LoadHandler paramLoadHandler)
  {
    new LogLoader.1(paramProcess, paramLoadHandler).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogLoader
 * JD-Core Version:    0.7.0.1
 */