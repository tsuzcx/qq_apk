package oicq.wlogin_sdk.pow;

import android.util.Log;
import oicq.wlogin_sdk.tools.util;

public class b
  implements Runnable
{
  int a;
  byte[] b;
  
  public b(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  public static void a()
  {
    try
    {
      new Thread(new b(1, null), "Wtlogin_asynCalcPow").start();
      util.LOGI("asyncGetPerformance started", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("asyncGetPerformance error ");
      localStringBuilder.append(Log.getStackTraceString(localThrowable));
      util.LOGI(localStringBuilder.toString(), "");
    }
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      new Thread(new b(0, paramArrayOfByte), "Wtlogin_asynCalcPow").start();
      util.LOGI("aysncCalcPow started", "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("aysncCalcPow error ");
      localStringBuilder.append(Log.getStackTraceString(paramArrayOfByte));
      util.LOGI(localStringBuilder.toString(), "");
    }
  }
  
  public static void b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ClientPow().a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        oicq.wlogin_sdk.request.t.an = paramArrayOfByte;
        return;
      }
      util.LOGI("outBuf is null", "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncCalcPow error ");
      localStringBuilder.append(Log.getStackTraceString(paramArrayOfByte));
      util.LOGI(localStringBuilder.toString(), "");
    }
  }
  
  public void run()
  {
    int i = this.a;
    byte[] arrayOfByte;
    if (i == 0)
    {
      arrayOfByte = this.b;
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        arrayOfByte = new ClientPow().a(this.b);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          oicq.wlogin_sdk.request.t.an = arrayOfByte;
          return;
        }
        util.LOGI("outBuf is null", "");
        return;
      }
      util.LOGI("inBuf is null ", "");
      return;
    }
    if (i == 1) {
      try
      {
        arrayOfByte = new ClientPow().nativeGetTestData();
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          oicq.wlogin_sdk.request.t.ao = arrayOfByte;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("get performance");
          localStringBuilder2.append(arrayOfByte.length);
          util.LOGI(localStringBuilder2.toString(), "");
          return;
        }
        util.LOGI("outBuf is null", "");
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getPerformance ");
        localStringBuilder2.append(Log.getStackTraceString(localThrowable));
        util.LOGI(localStringBuilder2.toString(), "");
        return;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("error type:");
    localStringBuilder1.append(this.a);
    util.LOGI(localStringBuilder1.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.pow.b
 * JD-Core Version:    0.7.0.1
 */