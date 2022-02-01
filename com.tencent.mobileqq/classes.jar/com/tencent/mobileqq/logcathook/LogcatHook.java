package com.tencent.mobileqq.logcathook;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class LogcatHook
{
  public static boolean a;
  
  public static void a()
  {
    ThreadManager.getSubThreadHandler().post(new LogcatHook.1());
  }
  
  private static native void hookLogcat(boolean paramBoolean);
  
  public static native void updateLogFilePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHook
 * JD-Core Version:    0.7.0.1
 */