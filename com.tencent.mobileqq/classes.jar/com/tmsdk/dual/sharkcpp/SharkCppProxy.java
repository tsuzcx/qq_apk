package com.tmsdk.dual.sharkcpp;

import android.os.Handler;
import com.tmsdk.dual.a;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackCommon;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackPhoneNumber;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackPullCloudCmd;
import dualsim.common.model.SoftKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharkCppProxy
{
  public static native String getGuid();
  
  private static native void getPhoneNumber(String paramString, SharkCallbackPhoneNumber paramSharkCallbackPhoneNumber);
  
  public static void getPhoneNumberAsy(String paramString, final SharkCallbackPhoneNumber paramSharkCallbackPhoneNumber)
  {
    new Handler(a.a()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SharkCppProxy.getPhoneNumber(this.X, paramSharkCallbackPhoneNumber);
          return;
        }
        catch (Throwable localThrowable)
        {
          while (paramSharkCallbackPhoneNumber == null) {}
          paramSharkCallbackPhoneNumber.onFinish(-1, -1, null);
        }
      }
    });
  }
  
  private static native void pullCloudCmd(int paramInt, SharkCallbackPullCloudCmd paramSharkCallbackPullCloudCmd);
  
  public static void pullCloudCmdAsyn(int paramInt, final SharkCallbackPullCloudCmd paramSharkCallbackPullCloudCmd)
  {
    new Handler(a.a()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SharkCppProxy.pullCloudCmd(this.S, paramSharkCallbackPullCloudCmd);
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  private static native void reportSoftList(List<SoftKey> paramList, int paramInt, SharkCallbackCommon paramSharkCallbackCommon);
  
  public static void reportSoftListAsyn(List<SoftKey> paramList, final int paramInt, final SharkCallbackCommon paramSharkCallbackCommon)
  {
    new Handler(a.a()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SharkCppProxy.reportSoftList(this.U, paramInt, paramSharkCallbackCommon);
          return;
        }
        catch (Throwable localThrowable)
        {
          while (paramSharkCallbackCommon == null) {}
          paramSharkCallbackCommon.onFinish(-1);
        }
      }
    });
  }
  
  public static native void sharkInit();
  
  public static native byte[] tccDecrypt(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] tccEncrypt(byte[] paramArrayOfByte, int paramInt);
  
  private static native void unifiedReport(int paramInt, List<Map<Integer, String>> paramList, SharkCallbackCommon paramSharkCallbackCommon);
  
  public static void unifiedReportAsyn(final int paramInt, Map paramMap, final SharkCallbackCommon paramSharkCallbackCommon)
  {
    new Handler(a.a()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.O);
          SharkCppProxy.unifiedReport(paramInt, localArrayList, paramSharkCallbackCommon);
          return;
        }
        catch (Throwable localThrowable)
        {
          while (paramSharkCallbackCommon == null) {}
          paramSharkCallbackCommon.onFinish(-1);
        }
      }
    });
  }
  
  public static void unifiedReportListAsyn(int paramInt, final List<Map<Integer, String>> paramList, final SharkCallbackCommon paramSharkCallbackCommon)
  {
    new Handler(a.a()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SharkCppProxy.unifiedReport(this.P, paramList, paramSharkCallbackCommon);
          return;
        }
        catch (Throwable localThrowable)
        {
          while (paramSharkCallbackCommon == null) {}
          paramSharkCallbackCommon.onFinish(-1);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tmsdk.dual.sharkcpp.SharkCppProxy
 * JD-Core Version:    0.7.0.1
 */