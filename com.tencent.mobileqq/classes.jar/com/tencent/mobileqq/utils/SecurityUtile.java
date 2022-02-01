package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.CaughtExceptionReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    String str;
    try
    {
      if (!loadSo)
      {
        str = paramString;
        if (QLog.isColorLevel())
        {
          str = paramString;
          if (!loadSo)
          {
            printEncodeButNotEncrypt();
            return paramString;
          }
        }
      }
      else
      {
        if ((codeKeyLen == 0) || (codeKey.length == 4)) {
          setKey(BaseApplication.getContext());
        }
        paramString = com.tencent.commonsdk.util.StringUtils.newStringWithData(encrypt(paramString.toCharArray(), codeKey, codeKeyLen));
        return paramString;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramBoolean) {
        IMCoreProxyRoute.CaughtExceptionReport.e(paramString, "encode str error");
      }
      QLog.e("SecurityUtile", 1, "encode str error", paramString);
      str = null;
    }
    return str;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    byte[] arrayOfByte;
    try
    {
      if (!loadSo)
      {
        arrayOfByte = paramArrayOfByte;
        if (QLog.isColorLevel())
        {
          arrayOfByte = paramArrayOfByte;
          if (!loadSo)
          {
            printEncodeButNotEncrypt();
            return paramArrayOfByte;
          }
        }
      }
      else
      {
        if ((codeKeyLen == 0) || (codeKey.length == 4)) {
          setKey(BaseApplication.getContext());
        }
        paramArrayOfByte = encryptByte(paramArrayOfByte, codeKey, codeKeyLen);
        return paramArrayOfByte;
      }
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      IMCoreProxyRoute.CaughtExceptionReport.e(paramArrayOfByte, "encode byte error");
      QLog.e("SecurityUtile", 1, "encode byte error", paramArrayOfByte);
      arrayOfByte = null;
    }
    return arrayOfByte;
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
  
  private static String readKeyCodeFile(Context paramContext)
  {
    Object localObject = null;
    Context localContext = null;
    try
    {
      paramContext = paramContext.openFileInput("kc");
      localContext = paramContext;
      localObject = paramContext;
      byte[] arrayOfByte = new byte[paramContext.available()];
      localContext = paramContext;
      localObject = paramContext;
      paramContext.read(arrayOfByte);
      if (paramContext != null) {
        paramContext.close();
      }
      return new String(arrayOfByte, "UTF-8");
    }
    catch (IOException paramContext)
    {
      localObject = localContext;
      throw paramContext;
    }
    finally
    {
      if (localObject != null) {
        ((FileInputStream)localObject).close();
      }
    }
  }
  
  public static void setKey(Context paramContext)
  {
    localObject1 = null;
    for (;;)
    {
      label173:
      label199:
      label228:
      try
      {
        boolean bool = isKeyFileExists(paramContext);
        if (!bool) {}
      }
      finally {}
      for (;;)
      {
        try
        {
          localObject2 = readKeyCodeFile(paramContext);
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
        catch (Exception localException1)
        {
          break label228;
        }
        try
        {
          if (((String)localObject2).length() < codeKey.length)
          {
            Thread.sleep(200L);
            localObject1 = readKeyCodeFile(paramContext);
          }
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() >= codeKey.length) {}
          }
          else
          {
            localObject1 = paramContext.getSharedPreferences("mobileQQ", 0).getString("security_key", null);
            if (localObject1 != null)
            {
              int i = ((String)localObject1).length();
              int j = codeKey.length;
              if (i >= j) {
                continue;
              }
            }
          }
        }
        catch (Exception localException3)
        {
          localObject1 = localObject2;
          localObject2 = localException3;
          break label228;
          break label173;
          break label199;
        }
      }
      try
      {
        localObject2 = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() >= codeKey.length) {
            break label332;
          }
        }
        localObject1 = localObject2;
        localObject2 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      }
      catch (Exception localException2)
      {
        Object localObject3 = localObject1;
        continue;
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() >= codeKey.length) {}
      }
      else
      {
        localObject1 = "361910168";
      }
      try
      {
        writeKeyCodeFile(paramContext, (String)localObject1);
        localObject2 = localObject1;
      }
      catch (IOException paramContext)
      {
        QLog.e("SecurityUtile", 1, "write key Exception " + paramContext.getMessage());
        localObject2 = localObject1;
        continue;
      }
      codeKey = ((String)localObject2).toCharArray();
      codeKeyLen = codeKey.length;
      return;
      QLog.e("SecurityUtile", 1, "read key Exception " + ((Exception)localObject2).getMessage());
      continue;
      QLog.e("SecurityUtile", 1, "isKeyFileExists = false");
      localObject1 = null;
    }
  }
  
  private static void writeKeyCodeFile(Context paramContext, String paramString)
  {
    Object localObject = null;
    Context localContext = null;
    try
    {
      paramContext = paramContext.openFileOutput("kc", 0);
      localContext = paramContext;
      localObject = paramContext;
      paramContext.write(paramString.getBytes("UTF-8"));
      if (paramContext != null) {
        paramContext.close();
      }
      return;
    }
    catch (IOException paramContext)
    {
      localObject = localContext;
      throw paramContext;
    }
    finally
    {
      if (localObject != null) {
        ((FileOutputStream)localObject).close();
      }
    }
  }
  
  public static void xorInLimit(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramLong >= paramInt3)) {
      return;
    }
    paramInt3 = (int)(paramInt3 - paramLong);
    if (paramInt3 > paramInt2) {}
    for (;;)
    {
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)(paramArrayOfByte[(paramInt3 + paramInt1)] ^ codeEmosmKey[((int)((paramInt3 + paramLong) % codeEmosmKeyLen))]));
        paramInt3 += 1;
      }
      break;
      paramInt2 = paramInt3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */