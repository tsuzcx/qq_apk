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
    if (sIsLoaded) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        System.loadLibrary("wlc_upload_uni_v1.0.1");
      } else {
        System.load(paramString);
      }
      try
      {
        XpLog.v("UploadNative", "System.loadLibrary wlc_upload_uni_v1.0.1 finish.");
        bool1 = true;
      }
      catch (Exception localException1)
      {
        bool1 = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        bool1 = true;
      }
      XpLog.e("UploadNative", "System.loadLibrary failed..", localUnsatisfiedLinkError2);
    }
    catch (Exception localException2)
    {
      XpLog.e("UploadNative", "System.loadLibrary failed..", localException2);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      bool1 = bool2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadLibrary libwlc_upload_uni_v1.0.1.so result ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", path=");
    localStringBuilder.append(paramString);
    XpLog.i("UploadNative", localStringBuilder.toString());
    sIsLoaded = bool1;
    return bool1;
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
    if (TextUtils.isEmpty(paramString))
    {
      XpLog.w("UploadNative", "calSliceSha1: the param filePath should be valid.");
      return null;
    }
    if (this.mIsInit)
    {
      paramString = nativeCalSliceSha1(paramString, paramCanceledFlag);
      if (paramString != null)
      {
        paramCanceledFlag = new String[paramString.length];
        int k = paramString.length;
        int j = 0;
        int i = 0;
        while (j < k)
        {
          paramCanceledFlag[i] = ((String)paramString[j]);
          j += 1;
          i += 1;
        }
        return paramCanceledFlag;
      }
    }
    else
    {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return null;
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
    if (this.mIsInit)
    {
      if (paramString1 == null) {
        paramString1 = "";
      }
      if (paramString2 == null) {
        paramString2 = "";
      }
      if (paramString3 == null) {
        paramString3 = "";
      }
      nativeReportError(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramBoolean1, paramLong2, paramLong3, paramLong4, paramBoolean2, paramInt2);
    }
    else
    {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.mIsInit) {
      nativeSetHttpProxy(paramString1, paramInt, paramString2, paramString3);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean setIpConfig(String paramString1, String paramString2)
  {
    if (this.mIsInit) {
      nativeSetIpConfig(paramString1, paramString2);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean setNetType(int paramInt)
  {
    if (this.mIsInit) {
      nativeSetNetType(paramInt);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean speedDown()
  {
    if (this.mIsInit) {
      nativeSpeedDown();
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean startTask(String paramString)
  {
    if (this.mIsInit) {
      nativeStartTask(paramString);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean stopTask(String paramString)
  {
    if (this.mIsInit) {
      nativeStopTask(paramString);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean trialSpeedUp(int paramInt)
  {
    if (this.mIsInit) {
      nativeTrialSpeedUp(paramInt);
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public boolean vipSpeedUp()
  {
    if (this.mIsInit) {
      nativeVipSpeedUp();
    } else {
      XpLog.e("UploadNative", "UploadSdk hasn't be init.");
    }
    return this.mIsInit;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadNative
 * JD-Core Version:    0.7.0.1
 */