package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import azpo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SecurityUtile
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static boolean jdField_a_of_type_Boolean;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static volatile char[] jdField_a_of_type_ArrayOfChar = { 0, 1, 0, 1 };
  private static volatile int b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 1, 0, 1 };
    jdField_a_of_type_Int = 4;
    try
    {
      long l = SystemClock.elapsedRealtime();
      int i = com.tencent.qphone.base.util.StringUtils.msfLoadSo("SecurityUtile", "DBEncryptV2");
      jdField_a_of_type_Boolean = com.tencent.qphone.base.util.StringUtils.getLoadResult(i);
      QLog.e("SecurityUtile", 1, new Object[] { "loadso ", Boolean.valueOf(jdField_a_of_type_Boolean), ", resultCode:", Integer.valueOf(i), " cost:", Long.valueOf(SystemClock.elapsedRealtime() - l) });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SecurityUtile", 1, "SecurityUtile load so fail, ", localThrowable);
    }
  }
  
  private static String a(Context paramContext)
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
  
  public static String a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {}
    String str;
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        str = paramString;
        if (QLog.isColorLevel())
        {
          str = paramString;
          if (!jdField_a_of_type_Boolean)
          {
            a();
            return paramString;
          }
        }
      }
      else
      {
        if ((b == 0) || (jdField_a_of_type_ArrayOfChar.length == 4)) {
          a(BaseApplicationImpl.getContext());
        }
        paramString = com.tencent.commonsdk.util.StringUtils.newStringWithData(encrypt(paramString.toCharArray(), jdField_a_of_type_ArrayOfChar, b));
        return paramString;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramBoolean) {
        azpo.a(paramString, "encode str error");
      }
      QLog.e("SecurityUtile", 1, "encode str error", paramString);
      str = null;
    }
    return str;
  }
  
  private static void a()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 5000L)
    {
      QLog.e("SecurityUtile", 2, new Object[] { "SecurityUtile encode, loadSo:", Boolean.valueOf(jdField_a_of_type_Boolean) });
      jdField_a_of_type_Long = l;
    }
  }
  
  public static void a(Context paramContext)
  {
    localObject1 = null;
    for (;;)
    {
      label172:
      label197:
      label226:
      try
      {
        boolean bool = a(paramContext);
        if (!bool) {}
      }
      finally {}
      for (;;)
      {
        try
        {
          localObject2 = a(paramContext);
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
        catch (Exception localException1)
        {
          break label226;
        }
        try
        {
          if (((String)localObject2).length() < jdField_a_of_type_ArrayOfChar.length)
          {
            Thread.sleep(200L);
            localObject1 = a(paramContext);
          }
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() >= jdField_a_of_type_ArrayOfChar.length) {}
          }
          else
          {
            localObject1 = paramContext.getSharedPreferences("mobileQQ", 0).getString("security_key", null);
            if (localObject1 != null)
            {
              int i = ((String)localObject1).length();
              int j = jdField_a_of_type_ArrayOfChar.length;
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
          break label226;
          break label172;
          break label197;
        }
      }
      try
      {
        localObject2 = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() >= jdField_a_of_type_ArrayOfChar.length) {
            break label328;
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
        if (((String)localObject2).length() >= jdField_a_of_type_ArrayOfChar.length) {}
      }
      else
      {
        localObject1 = "361910168";
      }
      try
      {
        a(paramContext, (String)localObject1);
        localObject2 = localObject1;
      }
      catch (IOException paramContext)
      {
        QLog.e("SecurityUtile", 1, "write key Exception " + paramContext.getMessage());
        localObject2 = localObject1;
        continue;
      }
      jdField_a_of_type_ArrayOfChar = ((String)localObject2).toCharArray();
      b = jdField_a_of_type_ArrayOfChar.length;
      return;
      QLog.e("SecurityUtile", 1, "read key Exception " + ((Exception)localObject2).getMessage());
      continue;
      QLog.e("SecurityUtile", 1, "isKeyFileExists = false");
      localObject1 = null;
    }
  }
  
  private static void a(Context paramContext, String paramString)
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
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
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
        paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)(paramArrayOfByte[(paramInt3 + paramInt1)] ^ jdField_a_of_type_ArrayOfByte[((int)((paramInt3 + paramLong) % jdField_a_of_type_Int))]));
        paramInt3 += 1;
      }
      break;
      paramInt2 = paramInt3;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("kc") != null) && (paramContext.getFileStreamPath("kc").exists());
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    byte[] arrayOfByte;
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        arrayOfByte = paramArrayOfByte;
        if (QLog.isColorLevel())
        {
          arrayOfByte = paramArrayOfByte;
          if (!jdField_a_of_type_Boolean)
          {
            a();
            return paramArrayOfByte;
          }
        }
      }
      else
      {
        if ((b == 0) || (jdField_a_of_type_ArrayOfChar.length == 4)) {
          a(BaseApplicationImpl.getContext());
        }
        paramArrayOfByte = encryptByte(paramArrayOfByte, jdField_a_of_type_ArrayOfChar, b);
        return paramArrayOfByte;
      }
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      azpo.a(paramArrayOfByte, "encode byte error");
      QLog.e("SecurityUtile", 1, "encode byte error", paramArrayOfByte);
      arrayOfByte = null;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfByte[(i % jdField_a_of_type_Int)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
  
  public static char[] a()
  {
    if ((b == 0) || (jdField_a_of_type_ArrayOfChar.length == 4)) {
      a(BaseApplicationImpl.getContext());
    }
    return Arrays.copyOf(jdField_a_of_type_ArrayOfChar, jdField_a_of_type_ArrayOfChar.length);
  }
  
  public static String b(String paramString)
  {
    return a(paramString);
  }
  
  public static String b(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean);
  }
  
  public static native char[] encrypt(char[] paramArrayOfChar1, char[] paramArrayOfChar2, int paramInt);
  
  public static native byte[] encryptByte(byte[] paramArrayOfByte, char[] paramArrayOfChar, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */