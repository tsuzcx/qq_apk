package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import oicq.wlogin_sdk.tools.util;

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
  private static int appid = 0;
  private static int checkedSOVersion = 0;
  public static boolean isLoaded = false;
  private static final Object mLockObj = new Object();
  public static int soLoadResultCode = 0;
  public static String tag = "MSF.C.CodecWarpper";
  
  static
  {
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo(tag, "codecwrapperV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    String str1 = tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadso codecwrapperV2 ");
    localStringBuilder.append(isLoaded);
    localStringBuilder.append(" resultCode=");
    localStringBuilder.append(soLoadResultCode);
    localStringBuilder.append(" cost=");
    localStringBuilder.append(SystemClock.elapsedRealtime() - l);
    QLog.e(str1, 1, localStringBuilder.toString());
    if (!isLoaded)
    {
      try
      {
        isLoaded = StringUtils.loadLibrary(tag, "codecwrapperV2", BaseApplication.getContext());
        MsfCore.sCore.bLoadUseTxlib = isLoaded;
      }
      catch (Throwable localThrowable)
      {
        isLoaded = false;
        localThrowable.printStackTrace();
      }
      String str2 = tag;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadso again codecwrapperV2 ");
      localStringBuilder.append(isLoaded);
      localStringBuilder.append(" by txlib. cost=");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l);
      QLog.e(str2, 1, localStringBuilder.toString());
    }
    checkSOVersion();
  }
  
  public static void checkSOVersion()
  {
    try
    {
      appid = getAppid();
    }
    catch (Throwable localThrowable1)
    {
      QLog.w(tag, 1, "getAppid error. ", localThrowable1);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      QLog.w(tag, 1, "getAppid UnsatisfiedLinkError. ", localUnsatisfiedLinkError1);
    }
    String str = tag;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkSO so_appid=");
    ((StringBuilder)localObject).append(appid);
    QLog.i(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      checkedSOVersion = getSOVersion();
      str = tag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkSO version=");
      ((StringBuilder)localObject).append(checkedSOVersion);
      QLog.d(str, 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.d(tag, 1, "set so version failed ", localThrowable2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
    try
    {
      i = getVersionCode();
      if (i == 8) {
        break label154;
      }
      if (i != 9) {
        break label241;
      }
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        int i;
        StringBuilder localStringBuilder;
        continue;
        if (i != 10) {
          if (i != 11) {}
        }
      }
    }
    checkedSOVersion = 595;
    break label160;
    label154:
    checkedSOVersion = 591;
    label160:
    localObject = tag;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set so version to ");
    localStringBuilder.append(checkedSOVersion);
    localStringBuilder.append(" with error ");
    QLog.d((String)localObject, 1, localStringBuilder.toString(), localUnsatisfiedLinkError2);
    j.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError2.getMessage());
    return;
    checkedSOVersion = 591;
    QLog.d(tag, 1, "set so version to 591 with deep error ", localUnsatisfiedLinkError2);
  }
  
  private static native void closeReceData();
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean);
  
  public static native int getAppid();
  
  public static native byte[] getFileStoreKey();
  
  public static native int getMaxPackageSize();
  
  public static native long getPacketLossLength(int paramInt);
  
  public static native int getSOVersion();
  
  public static int getSharedObjectVersion()
  {
    return checkedSOVersion;
  }
  
  public static native int getVersionCode();
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean)
  {
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramByte3, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(tag, 2, "nativeEncodeRequest 1 exception", paramString1);
      }
    }
    return null;
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(tag, 2, "nativeEncodeRequest 3 exception", paramString1);
      }
    }
    return null;
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean)
  {
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(tag, 2, "nativeEncodeRequest 2 exception", paramString1);
      }
    }
    return null;
  }
  
  public static void nativeOnConnClose() {}
  
  public static void nativeRemoveAccountKey(String paramString)
  {
    removeAccountKey(paramString);
  }
  
  public static void nativeSetAccountKey(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("nativeSetAccountKey ");
    localStringBuilder.append(",uin=");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramString1));
    printBytes(",A1=", paramArrayOfByte1, localStringBuilder);
    printBytes(",A2=", paramArrayOfByte2, localStringBuilder);
    printBytes(",A3=", paramArrayOfByte3, localStringBuilder);
    printBytes(",D1=", paramArrayOfByte4, localStringBuilder);
    printBytes(",D2=", paramArrayOfByte5, localStringBuilder);
    printBytes(",S2=", paramArrayOfByte6, localStringBuilder);
    printBytes(",key=", paramArrayOfByte7, localStringBuilder);
    printBytes(",cookie=", paramArrayOfByte8, localStringBuilder);
    QLog.d(tag, 1, localStringBuilder.toString());
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
  
  private native void onReceData(byte[] paramArrayOfByte, int paramInt);
  
  private native FromServiceMsg parseData(byte[] paramArrayOfByte);
  
  public static void printBytes(String paramString, byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramString);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramStringBuilder.append(paramArrayOfByte.length);
      paramStringBuilder.append("|");
      paramStringBuilder.append(util.buf_to_string(paramArrayOfByte, 1));
      return;
    }
    paramStringBuilder.append("null");
  }
  
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
      synchronized (mLockObj)
      {
        closeReceData();
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      j.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError.getMessage());
      return;
    }
  }
  
  public void nativeOnReceData(byte[] paramArrayOfByte, int paramInt)
  {
    synchronized (mLockObj)
    {
      onReceData(paramArrayOfByte, paramInt);
      return;
    }
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
  
  public abstract int onSSOPingResponse(byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.CodecWarpper
 * JD-Core Version:    0.7.0.1
 */