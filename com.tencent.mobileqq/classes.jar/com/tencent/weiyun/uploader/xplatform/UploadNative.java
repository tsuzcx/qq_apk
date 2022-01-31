package com.tencent.weiyun.uploader.xplatform;

import android.text.TextUtils;
import com.tencent.weiyun.uploader.module.XpLog;
import com.tencent.weiyun.utils.Singleton;

public final class UploadNative
{
  private static final String TAG = "UploadNative";
  private static Singleton<UploadNative, Void> sInstance = new UploadNative.1();
  private static boolean sIsLoaded = false;
  private boolean mIsInit = false;
  
  static
  {
    loadLibrary(null);
  }
  
  public static UploadNative getInstance()
  {
    return (UploadNative)sInstance.get(null);
  }
  
  private static boolean loadLibrary(String paramString)
  {
    bool2 = true;
    bool3 = true;
    bool1 = true;
    if (sIsLoaded) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          System.loadLibrary("wlc_upload_uni_v1.0.1");
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        bool1 = false;
        XpLog.e("UploadNative", "System.loadLibrary failed..", localUnsatisfiedLinkError1);
        continue;
      }
      catch (Exception localException1)
      {
        bool1 = false;
        XpLog.e("UploadNative", "System.loadLibrary failed..", localException1);
        continue;
      }
      try
      {
        XpLog.v("UploadNative", "System.loadLibrary wlc_upload_uni_v1.0.1 finish.");
        XpLog.i("UploadNative", "loadLibrary libwlc_upload_uni_v1.0.1.so result " + bool1 + ", path=" + paramString);
        sIsLoaded = bool1;
        return bool1;
      }
      catch (Exception localException2)
      {
        bool1 = bool3;
        continue;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        bool1 = bool2;
        continue;
      }
      System.load(paramString);
    }
  }
  
  private native Object[] nativeCalSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag);
  
  private native String nativeCreateXpUploadTask(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String[] paramArrayOfString, long[] paramArrayOfLong);
  
  private native void nativeInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, UploadSDKContext paramUploadSDKContext, int paramInt);
  
  private native void nativeReportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2);
  
  private native void nativeSetHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private native void nativeSetIpConfig(String paramString1, String paramString2);
  
  private native void nativeSetNetType(int paramInt);
  
  private native void nativeSpeedDown();
  
  private native void nativeStartTask(String paramString);
  
  private native void nativeStopTask(String paramString);
  
  private native void nativeTrialSpeedUp(int paramInt);
  
  private native void nativeVipSpeedUp();
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      XpLog.w("UploadNative", "calSliceSha1: the param filePath should be valid.");
    }
    do
    {
      return null;
      if (!this.mIsInit) {
        break;
      }
      paramString = nativeCalSliceSha1(paramString, paramCanceledFlag);
    } while (paramString == null);
    paramCanceledFlag = new String[paramString.length];
    int k = paramString.length;
    int i = 0;
    while (j < k)
    {
      paramCanceledFlag[i] = ((String)paramString[j]);
      j += 1;
      i += 1;
    }
    XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    return null;
    return paramCanceledFlag;
  }
  
  public String createUploadTask(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    if (this.mIsInit) {
      return nativeCreateXpUploadTask(paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramArrayOfString, paramArrayOfLong);
    }
    XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    return null;
  }
  
  public void init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, UploadSDKContext paramUploadSDKContext)
  {
    if (!this.mIsInit) {
      try
      {
        if (!this.mIsInit)
        {
          nativeInit(paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramUploadSDKContext, UploadSDKContext.getLogLevel());
          this.mIsInit = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean isLoaded()
  {
    return sIsLoaded;
  }
  
  public boolean loadLibFromPath(String paramString)
  {
    if (sIsLoaded) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return loadLibrary(paramString);
  }
  
  public boolean reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2)
  {
    if (this.mIsInit) {
      if (paramString1 == null)
      {
        paramString1 = "";
        if (paramString2 != null) {
          break label64;
        }
        paramString2 = "";
        label23:
        if (paramString3 != null) {
          break label67;
        }
        paramString3 = "";
        label32:
        nativeReportError(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramBoolean1, paramLong2, paramLong3, paramLong4, paramBoolean2, paramInt2);
      }
    }
    for (;;)
    {
      return this.mIsInit;
      break;
      label64:
      break label23;
      label67:
      break label32;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.mIsInit) {
      nativeSetHttpProxy(paramString1, paramInt, paramString2, paramString3);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean setIpConfig(String paramString1, String paramString2)
  {
    if (this.mIsInit) {
      nativeSetIpConfig(paramString1, paramString2);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean setNetType(int paramInt)
  {
    if (this.mIsInit) {
      nativeSetNetType(paramInt);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean speedDown()
  {
    if (this.mIsInit) {
      nativeSpeedDown();
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean startTask(String paramString)
  {
    if (this.mIsInit) {
      nativeStartTask(paramString);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean stopTask(String paramString)
  {
    if (this.mIsInit) {
      nativeStopTask(paramString);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean trialSpeedUp(int paramInt)
  {
    if (this.mIsInit) {
      nativeTrialSpeedUp(paramInt);
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
  
  public boolean vipSpeedUp()
  {
    if (this.mIsInit) {
      nativeVipSpeedUp();
    }
    for (;;)
    {
      return this.mIsInit;
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadNative
 * JD-Core Version:    0.7.0.1
 */