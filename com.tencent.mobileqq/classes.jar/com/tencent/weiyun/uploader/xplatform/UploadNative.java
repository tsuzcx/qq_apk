package com.tencent.weiyun.uploader.xplatform;

import android.text.TextUtils;
import com.tencent.weiyun.uploader.module.XpLog;
import com.tencent.weiyun.utils.Singleton;

public final class UploadNative
{
  private static final String TAG = "UploadNative";
  private static Singleton<UploadNative, Void> sInstance = new Singleton()
  {
    protected UploadNative create(Void paramAnonymousVoid)
    {
      return new UploadNative();
    }
  };
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
    boolean bool4 = false;
    boolean bool3 = false;
    bool1 = bool3;
    bool2 = bool4;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        bool1 = bool3;
        bool2 = bool4;
        System.loadLibrary("wlc_upload_uni_v1.0.1");
        bool1 = true;
        bool2 = true;
        bool3 = true;
        XpLog.v("UploadNative", "System.loadLibrary wlc_upload_uni_v1.0.1 finish.");
        bool1 = bool3;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        XpLog.e("UploadNative", "System.loadLibrary failed..", localUnsatisfiedLinkError);
        continue;
      }
      catch (Exception localException)
      {
        XpLog.e("UploadNative", "System.loadLibrary failed..", localException);
        bool1 = bool2;
        continue;
      }
      XpLog.i("UploadNative", "loadLibrary libwlc_upload_uni_v1.0.1.so result " + bool1 + ", path=" + paramString);
      sIsLoaded = bool1;
      return bool1;
      bool1 = bool3;
      bool2 = bool4;
      System.load(paramString);
    }
  }
  
  private native Object[] nativeCalSliceSha1(String paramString, CanceledFlag paramCanceledFlag);
  
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
  
  public String[] calSliceSha1(String paramString, CanceledFlag paramCanceledFlag)
  {
    if (TextUtils.isEmpty(paramString))
    {
      XpLog.w("UploadNative", "calSliceSha1: the param filePath should be valid.");
      paramString = null;
    }
    Object[] arrayOfObject;
    do
    {
      return paramString;
      Object localObject = null;
      if (!this.mIsInit) {
        break;
      }
      arrayOfObject = nativeCalSliceSha1(paramString, paramCanceledFlag);
      paramString = localObject;
    } while (arrayOfObject == null);
    paramCanceledFlag = new String[arrayOfObject.length];
    int k = arrayOfObject.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      paramString = paramCanceledFlag;
      if (j >= k) {
        break;
      }
      paramCanceledFlag[i] = ((String)arrayOfObject[j]);
      j += 1;
      i += 1;
    }
    XpLog.e("UploadNative", "UploadSdk hasn't be init.");
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
  
  public static final class CanceledFlag
  {
    private volatile boolean isCanceled;
    
    private CanceledFlag() {}
    
    public CanceledFlag(boolean paramBoolean)
    {
      this.isCanceled = paramBoolean;
    }
    
    public boolean isCanceled()
    {
      return this.isCanceled;
    }
    
    public void setCanceled(boolean paramBoolean)
    {
      this.isCanceled = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadNative
 * JD-Core Version:    0.7.0.1
 */