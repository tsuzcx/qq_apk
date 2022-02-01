package com.tencent.mobileqq.statistics.crash;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListMonitor
{
  private static final String TAG = "COWriteArrayListMonitor";
  
  @SuppressLint({"NewApi"})
  public static void checkWithObj(Object paramObject)
  {
    try
    {
      if ((paramObject instanceof CopyOnWriteArrayList))
      {
        Log.e("COWriteArrayListMonitor", "Collections.sort's first parameter couldn't be CopyOnWriteArrayList", new RuntimeException());
        throwException(new RuntimeException());
      }
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private static void throwException(Throwable paramThrowable)
  {
    new CopyOnWriteArrayListMonitor.1(paramThrowable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.crash.CopyOnWriteArrayListMonitor
 * JD-Core Version:    0.7.0.1
 */