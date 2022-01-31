package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class CodecWarpper
{
  public static final int CODE_FAIL = -1;
  public static final int CODE_FAIL_DECRYPT_DATA_LEN_ERROR = -5;
  public static final int CODE_FAIL_DECRYPT_EMPTY = -4;
  public static final int CODE_FAIL_DECRYPT_ONCE = -2;
  public static final int CODE_FAIL_DECRYPT_TWICE = -3;
  public static final int CODE_FAIL_PBUNPACK = -8;
  public static final int CODE_FAIL_ZLIB_DATA_LEN_SHORT = -6;
  public static final int CODE_FAIL_ZLIB_UNCOMPRESS_ERROR = -7;
  public static final int CODE_SUCC_DECRYPT_ONCE = 1;
  public static final int CODE_SUCC_DECRYPT_TWICE = 2;
  private static int appid;
  private static int checkedSOVersion;
  public static boolean isLoaded;
  public static int soLoadResultCode;
  public static String tag = "MSF.C.CodecWarpper";
  
  static
  {
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo(tag, "codecwrapperV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    QLog.e(tag, 1, "loadso codecwrapperV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - l));
    if (!isLoaded) {}
    try
    {
      isLoaded = StringUtils.loadLibrary(tag, "codecwrapperV2", BaseApplication.getContext());
      MsfCore.sCore.bLoadUseTxlib = isLoaded;
      QLog.e(tag, 1, "loadso again codecwrapperV2 " + isLoaded + " by txlib. cost=" + (SystemClock.elapsedRealtime() - l));
      checkSOVersion();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        isLoaded = false;
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static void checkSOVersion()
  {
    try
    {
      appid = getAppid();
      QLog.i(tag, 1, "checkSO so_appid=" + appid);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          checkedSOVersion = getSOVersion();
          QLog.d(tag, 1, "checkSO version=" + checkedSOVersion);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          int i;
          try
          {
            i = getVersionCode();
            if ((i == 8) || (i == 9))
            {
              checkedSOVersion = 591;
              QLog.d(tag, 1, "set so version to " + checkedSOVersion + " with error ", localUnsatisfiedLinkError2);
              j.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError2.getMessage());
              return;
            }
          }
          catch (Throwable localThrowable3)
          {
            checkedSOVersion = 591;
            QLog.d(tag, 1, "set so version to 591 with deep error ", localUnsatisfiedLinkError2);
            return;
          }
          if ((i != 10) && (i != 11)) {
            continue;
          }
          checkedSOVersion = 595;
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.d(tag, 1, "set so version failed ", localThrowable2);
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        QLog.w(tag, 1, "getAppid UnsatisfiedLinkError. ", localUnsatisfiedLinkError1);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.w(tag, 1, "getAppid error. ", localThrowable1);
      }
    }
  }
  
  private static native void closeReceData();
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, boolean paramBoolean);
  
  public static native int getAppid();
  
  public static native byte[] getFileStoreKey();
  
  public static native int getMaxPackageSize();
  
  public static native int getSOVersion();
  
  public static int getSharedObjectVersion()
  {
    return checkedSOVersion;
  }
  
  public static native int getVersionCode();
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    return encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramBoolean);
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, boolean paramBoolean)
  {
    return encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramArrayOfByte3, paramBoolean);
  }
  
  public static void nativeOnConnClose() {}
  
  public static void nativeRemoveAccountKey(String paramString)
  {
    removeAccountKey(paramString);
  }
  
  public static void nativeSetAccountKey(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, String paramString2)
  {
    setAccountKey(paramString1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramString2);
  }
  
  public static void nativeSetKsid(byte[] paramArrayOfByte)
  {
    setKsid(paramArrayOfByte);
  }
  
  public static void nativeSetUseSimpleHead(String paramString, boolean paramBoolean)
  {
    setUseSimpleHead(paramString, paramBoolean);
  }
  
  private static synchronized native void onConnClose();
  
  private native void onReceData(byte[] paramArrayOfByte);
  
  private native FromServiceMsg parseData(byte[] paramArrayOfByte);
  
  private static synchronized native void removeAccountKey(String paramString);
  
  private static synchronized native void setAccountKey(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, String paramString2);
  
  private static synchronized native void setKsid(byte[] paramArrayOfByte);
  
  public static native void setMaxPackageSize(int paramInt);
  
  private static synchronized native void setUseSimpleHead(String paramString, boolean paramBoolean);
  
  public native void init(Context paramContext, boolean paramBoolean);
  
  public void nativeClearReceData()
  {
    if (QLog.isColorLevel()) {
      QLog.i(tag, 2, "nativeClearReceData");
    }
    try
    {
      closeReceData();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      j.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError.getMessage());
    }
  }
  
  public void nativeOnReceData(byte[] paramArrayOfByte)
  {
    onReceData(paramArrayOfByte);
  }
  
  public FromServiceMsg nativeParseData(byte[] paramArrayOfByte)
  {
    return parseData(paramArrayOfByte);
  }
  
  public abstract void onInvalidData(int paramInt1, int paramInt2);
  
  public void onInvalidDataNative(int paramInt)
  {
    onInvalidData(-5, paramInt);
  }
  
  public abstract void onInvalidSign();
  
  public abstract void onResponse(int paramInt1, Object paramObject, int paramInt2);
  
  public abstract void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onSSOPingResponse(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.CodecWarpper
 * JD-Core Version:    0.7.0.1
 */