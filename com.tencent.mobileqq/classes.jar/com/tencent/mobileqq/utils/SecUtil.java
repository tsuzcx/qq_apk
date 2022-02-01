package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SecUtil
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static boolean check0DayRepack(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = new JarFile(new File(paramContext.getApplicationContext().getApplicationInfo().sourceDir));
      Enumeration localEnumeration = paramContext.entries();
      HashSet localHashSet = new HashSet();
      while (localEnumeration.hasMoreElements())
      {
        String str = ((JarEntry)localEnumeration.nextElement()).getName();
        if (localHashSet.contains(str) == true)
        {
          paramContext.close();
          return true;
        }
        localHashSet.add(str);
      }
      paramContext.close();
      return false;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static String getFileMd5(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = toHexString(localMessageDigest.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return "";
  }
  
  public static String getFileMd5(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      try
      {
        String str1 = getFileMd5(paramString);
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramString = null;
    }
    String str2 = "";
    if (paramString != null) {
      try
      {
        paramString.close();
        return str2;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return str2;
  }
  
  public static String getPackageVersion(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramContext.getApplicationContext().getApplicationInfo().sourceDir, 1);
    if (paramContext == null) {
      return "";
    }
    return paramContext.versionName;
  }
  
  public static byte[] getSign(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail ");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append(" ");
    localObject = ((StringBuilder)localObject).toString();
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append(" get sign fail ");
        return paramContext.toString().getBytes();
      }
      if (paramContext.signatures == null)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append(" get signatures fail ");
        return paramContext.toString().getBytes();
      }
      if (paramContext.signatures[0] == null)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append(" get signatures[0] fail ");
        return paramContext.toString().getBytes();
      }
      if (paramContext.signatures[0].toByteArray().length == 0)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append(" byteSig len 0 ");
        return paramContext.toString().getBytes();
      }
      return paramContext.signatures[0].toByteArray();
    }
    catch (Exception paramContext)
    {
      label211:
      break label211;
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject);
    paramContext.append(" getInstallPackages exception ");
    return paramContext.toString().getBytes();
  }
  
  public static String getSignatureHash(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new String(paramArrayOfByte);
      if (((String)localObject).indexOf("fail") != -1) {
        return localObject;
      }
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = toHexString(((MessageDigest)localObject).digest());
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return "get signature hash failed!";
      }
    }
    return "getPublicKey signature null ";
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecUtil
 * JD-Core Version:    0.7.0.1
 */