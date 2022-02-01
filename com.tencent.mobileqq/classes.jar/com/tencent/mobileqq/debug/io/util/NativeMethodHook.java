package com.tencent.mobileqq.debug.io.util;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.debug.tools.ObjectForCallback;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

public class NativeMethodHook
{
  public static boolean a = false;
  
  static
  {
    try
    {
      System.loadLibrary("apmnative");
      a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      do
      {
        a = false;
        com.tencent.qqperf.debug.IOMonitor.a = false;
        com.tencent.qqperf.debug.IOMonitor.b = false;
      } while (!QLog.isColorLevel());
      QLog.e("IOMonitor", 2, "loadNative io error");
    }
  }
  
  public static native void hookHitMiss();
  
  public static native void setDbName(String paramString);
  
  public static native void writehm();
  
  public void a(int paramInt, String paramString)
  {
    if (!a) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          doHook(paramInt, paramString, Build.VERSION.SDK_INT, new ObjectForCallback(), DropFrameMonitor.a());
          return;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("IOMonitor", 2, paramString.toString());
            return;
          }
        }
        catch (UnsatisfiedLinkError paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("IOMonitor", 2, paramString.toString());
  }
  
  public native void doHook(int paramInt1, String paramString, int paramInt2, Object paramObject1, Object paramObject2);
  
  public native void saveAllData();
  
  public native void setTimeUpLoad(int paramInt1, int paramInt2);
  
  public native void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.io.util.NativeMethodHook
 * JD-Core Version:    0.7.0.1
 */