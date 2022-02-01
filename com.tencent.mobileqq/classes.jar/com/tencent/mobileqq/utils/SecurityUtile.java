package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SecurityUtile
{
  private static final String KEY_FILE = "kc";
  private static final long MIN_INTERVAL_TO_REPORT_SO_FAIL = 5000L;
  private static final String TAG = "SecurityUtile";
  private static byte[] codeEmosmKey;
  private static int codeEmosmKeyLen;
  private static volatile char[] codeKey = { 0, 1, 0, 1 };
  private static volatile int codeKeyLen;
  private static boolean loadSo;
  private static long mLastTimestampReportSoFail;
  
  static
  {
    codeEmosmKey = new byte[] { 0, 1, 0, 1 };
    codeEmosmKeyLen = 4;
    codeKeyLen = 0;
    mLastTimestampReportSoFail = 0L;
    try
    {
      long l = SystemClock.elapsedRealtime();
      int i = com.tencent.qphone.base.util.StringUtils.msfLoadSo("SecurityUtile", "DBEncryptV2");
      loadSo = com.tencent.qphone.base.util.StringUtils.getLoadResult(i);
      QLog.e("SecurityUtile", 1, new Object[] { "loadso ", Boolean.valueOf(loadSo), ", resultCode:", Integer.valueOf(i), " cost:", Long.valueOf(SystemClock.elapsedRealtime() - l) });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SecurityUtile", 1, "SecurityUtile load so fail, ", localThrowable);
    }
  }
  
  public static String decode(String paramString)
  {
    return encode(paramString);
  }
  
  public static String decode(String paramString, boolean paramBoolean)
  {
    return encode(paramString, paramBoolean);
  }
  
  public static String encode(String paramString)
  {
    return encode(paramString, true);
  }
  
  public static String encode(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {}
    try
    {
      if (loadSo)
      {
        if ((codeKeyLen == 0) || (codeKey.length == 4)) {
          setKey(BaseApplication.getContext());
        }
        return com.tencent.commonsdk.util.StringUtils.newStringWithData(encrypt(paramString.toCharArray(), codeKey, codeKeyLen));
      }
      if ((QLog.isColorLevel()) && (!loadSo)) {
        printEncodeButNotEncrypt();
      }
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramBoolean) {
        CaughtExceptionReportProxy.e(paramString, "encode str error");
      }
      QLog.e("SecurityUtile", 1, "encode str error", paramString);
    }
    return null;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (loadSo)
      {
        if ((codeKeyLen == 0) || (codeKey.length == 4)) {
          setKey(BaseApplication.getContext());
        }
        return encryptByte(paramArrayOfByte, codeKey, codeKeyLen);
      }
      if ((QLog.isColorLevel()) && (!loadSo)) {
        printEncodeButNotEncrypt();
      }
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      CaughtExceptionReportProxy.e(paramArrayOfByte, "encode byte error");
      QLog.e("SecurityUtile", 1, "encode byte error", paramArrayOfByte);
    }
    return null;
  }
  
  public static native char[] encrypt(char[] paramArrayOfChar1, char[] paramArrayOfChar2, int paramInt);
  
  public static native byte[] encryptByte(byte[] paramArrayOfByte, char[] paramArrayOfChar, int paramInt);
  
  public static char[] getKey()
  {
    if ((codeKeyLen == 0) || (codeKey.length == 4)) {
      setKey(BaseApplication.getContext());
    }
    return Arrays.copyOf(codeKey, codeKey.length);
  }
  
  private static boolean isKeyFileExists(Context paramContext)
  {
    return (paramContext.getFileStreamPath("kc") != null) && (paramContext.getFileStreamPath("kc").exists());
  }
  
  private static void printEncodeButNotEncrypt()
  {
    long l = System.currentTimeMillis();
    if (l - mLastTimestampReportSoFail > 5000L)
    {
      QLog.e("SecurityUtile", 2, new Object[] { "SecurityUtile encode, loadSo:", Boolean.valueOf(loadSo) });
      mLastTimestampReportSoFail = l;
    }
  }
  
  /* Error */
  private static String readKeyCodeFile(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ldc 8
    //   7: invokevirtual 190	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 196	java/io/FileInputStream:available	()I
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_0
    //   23: astore_1
    //   24: aload_0
    //   25: astore_2
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 200	java/io/FileInputStream:read	([B)I
    //   31: pop
    //   32: aload_0
    //   33: ifnull +7 -> 40
    //   36: aload_0
    //   37: invokevirtual 203	java/io/FileInputStream:close	()V
    //   40: new 120	java/lang/String
    //   43: dup
    //   44: aload_3
    //   45: ldc 205
    //   47: invokespecial 208	java/lang/String:<init>	([BLjava/lang/String;)V
    //   50: areturn
    //   51: astore_0
    //   52: goto +8 -> 60
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: athrow
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 203	java/io/FileInputStream:close	()V
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   3	62	1	localContext1	Context
    //   1	56	2	localContext2	Context
    //   21	24	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   4	11	51	finally
    //   15	22	51	finally
    //   26	32	51	finally
    //   58	60	51	finally
    //   4	11	55	java/io/IOException
    //   15	22	55	java/io/IOException
    //   26	32	55	java/io/IOException
  }
  
  public static void setKey(Context paramContext)
  {
    Object localObject1;
    Object localObject5;
    label274:
    try
    {
      boolean bool = isKeyFileExists(paramContext);
      if (bool)
      {
        try
        {
          Object localObject3 = readKeyCodeFile(paramContext);
          if (localObject3 != null) {
            localObject1 = localObject3;
          }
          try
          {
            if (((String)localObject3).length() >= codeKey.length) {
              break label125;
            }
            Thread.sleep(200L);
            localObject1 = readKeyCodeFile(paramContext);
          }
          catch (Exception localException3)
          {
            localObject1 = localObject3;
            localObject3 = localException3;
          }
          localObject5 = new StringBuilder();
        }
        catch (Exception localException2)
        {
          localObject1 = null;
        }
        ((StringBuilder)localObject5).append("read key Exception ");
        ((StringBuilder)localObject5).append(localException2.getMessage());
        QLog.e("SecurityUtile", 1, ((StringBuilder)localObject5).toString());
      }
      else
      {
        QLog.e("SecurityUtile", 1, "isKeyFileExists = false");
        localObject1 = null;
      }
      label125:
      if (localObject1 != null)
      {
        localObject4 = localObject1;
        if (((String)localObject1).length() >= codeKey.length) {}
      }
      else
      {
        localObject1 = paramContext.getSharedPreferences("mobileQQ", 0).getString("security_key", null);
        if (localObject1 != null)
        {
          int i = ((String)localObject1).length();
          int j = codeKey.length;
          localObject4 = localObject1;
          if (i >= j) {}
        }
        else
        {
          localObject4 = localObject1;
        }
      }
    }
    finally {}
    try
    {
      localObject5 = PhoneInfoMonitor.getDeviceId((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone"));
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        if (((String)localObject5).length() >= codeKey.length) {}
      }
      else
      {
        localObject4 = localObject5;
        WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi"));
        localObject1 = localObject5;
        if (localWifiInfo != null)
        {
          localObject4 = localObject5;
          localObject1 = localWifiInfo.getMacAddress();
        }
      }
    }
    catch (Exception localException1)
    {
      Object localObject2 = localObject4;
      break label274;
    }
    if (localObject1 != null)
    {
      localObject4 = localObject1;
      if (((String)localObject1).length() >= codeKey.length) {}
    }
    else
    {
      localObject4 = "361910168";
    }
    try
    {
      writeKeyCodeFile(paramContext, (String)localObject4);
    }
    catch (IOException paramContext)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("write key Exception ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      QLog.e("SecurityUtile", 1, ((StringBuilder)localObject1).toString());
    }
    codeKey = ((String)localObject4).toCharArray();
    codeKeyLen = codeKey.length;
  }
  
  /* Error */
  private static void writeKeyCodeFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: ldc 8
    //   7: iconst_0
    //   8: invokevirtual 306	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   11: astore_0
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: astore_3
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 205
    //   20: invokevirtual 310	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   23: invokevirtual 316	java/io/FileOutputStream:write	([B)V
    //   26: aload_0
    //   27: ifnull +7 -> 34
    //   30: aload_0
    //   31: invokevirtual 317	java/io/FileOutputStream:close	()V
    //   34: return
    //   35: astore_0
    //   36: goto +8 -> 44
    //   39: astore_0
    //   40: aload_3
    //   41: astore_2
    //   42: aload_0
    //   43: athrow
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 317	java/io/FileOutputStream:close	()V
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   0	54	1	paramString	String
    //   3	46	2	localContext1	Context
    //   1	40	3	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   4	12	35	finally
    //   16	26	35	finally
    //   42	44	35	finally
    //   4	12	39	java/io/IOException
    //   16	26	39	java/io/IOException
  }
  
  public static void xorInLimit(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramArrayOfByte != null)
    {
      long l = paramInt3;
      if (paramLong >= l) {
        return;
      }
      paramInt3 = (int)(l - paramLong);
      if (paramInt3 <= paramInt2) {
        paramInt2 = paramInt3;
      }
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        int i = paramInt3 + paramInt1;
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ codeEmosmKey[((int)((paramInt3 + paramLong) % codeEmosmKeyLen))]));
        paramInt3 += 1;
      }
    }
  }
  
  public static byte[] xorInLimit(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ codeEmosmKey[(i % codeEmosmKeyLen)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */