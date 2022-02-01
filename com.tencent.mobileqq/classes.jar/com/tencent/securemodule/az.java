package com.tencent.securemodule;

import android.content.Context;
import android.net.Uri;
import android.text.format.Formatter;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.jni.SecureEngine;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class az
{
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static long a(AppInfo paramAppInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramAppInfo.getPkgName());
    localStringBuffer.append("&");
    localStringBuffer.append(paramAppInfo.getCertMd5());
    localStringBuffer.append("&");
    localStringBuffer.append(paramAppInfo.getFileSize());
    paramAppInfo = b(localStringBuffer.toString().getBytes());
    long l1 = 0L;
    long l2 = l1;
    if (paramAppInfo != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= 8) {
          break;
        }
        l1 = (l1 << 8) + (paramAppInfo[(i + 8)] & 0xFF);
        i += 1;
      }
    }
    return l2;
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong == -1L) {
      return "0";
    }
    return Formatter.formatFileSize(paramContext, paramLong);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static final String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = SecureEngine.getEngineVersion(paramContext);
    int i;
    if (paramContext != null)
    {
      i = paramContext.indexOf("version=");
      if (i == -1) {}
    }
    try
    {
      i = Integer.parseInt(paramContext.substring(i + 8, i + 13).replace(".", "")) / 10;
      if (i == 21) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      label55:
      break label55;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject1 = paramContext.getFilesDir();
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((File)localObject1).getAbsolutePath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/lib");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".so");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (new File((String)localObject2).exists()) {}
    try
    {
      System.load((String)localObject2);
      j = 1;
    }
    catch (Throwable localThrowable2)
    {
      label95:
      break label95;
    }
    j = 0;
    i = j;
    if (j == 0) {}
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).replaceFirst("/files", "/lib"));
      ((StringBuilder)localObject2).append("/lib");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".so");
      System.load(((StringBuilder)localObject2).toString());
      i = 1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        i = j;
      }
    }
    j = i;
    if (i == 0) {}
    try
    {
      System.loadLibrary(paramString);
      j = 1;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        boolean bool1;
        j = i;
      }
    }
    bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (a(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = a(paramString[k]);
      arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static final String c(String paramString)
  {
    String str = Uri.decode(paramString);
    if (str != null)
    {
      int i = str.indexOf('?');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      if (!paramString.endsWith("/"))
      {
        i = paramString.lastIndexOf('/') + 1;
        if (i > 0)
        {
          paramString = paramString.substring(i);
          break label62;
        }
      }
    }
    paramString = null;
    label62:
    str = paramString;
    if (paramString == null) {
      str = "downloadfile";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.az
 * JD-Core Version:    0.7.0.1
 */