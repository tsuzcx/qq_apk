package com.tencent.open.agent.util;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.utils.HexUtil;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class OpenSdkDESUtils
{
  public static String a(Bundle paramBundle)
  {
    String str7 = paramBundle.getString("status_os");
    String str6 = paramBundle.getString("status_machine");
    String str5 = paramBundle.getString("status_version");
    String str4 = paramBundle.getString("sdkv");
    String str3 = paramBundle.getString("client_id");
    String str2 = paramBundle.getString("need_pay");
    String str1 = paramBundle.getString("pf");
    SSOLog.a("OpenSdkDESUtils", new Object[] { "os=", str7, ", machine=", str6, ", version=", str5, ", sdkv=", str4, ", appId=", str3, ", needPay=", str2, ", pf=", str1 });
    StringBuilder localStringBuilder = new StringBuilder();
    paramBundle = str7;
    if (str7 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str6;
    if (str6 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str5;
    if (str5 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str4;
    if (str4 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str3;
    if (str3 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str2;
    if (str2 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    paramBundle = str1;
    if (str1 == null) {
      paramBundle = "";
    }
    localStringBuilder.append(paramBundle);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      SSOLog.b("OpenSdkDESUtils", new Object[] { "getDecryptPkgName decryptStr==null !!!!!!" });
      return "";
    }
    try
    {
      paramString2 = a(paramString2);
      if (paramString2 == null)
      {
        SSOLog.b("OpenSdkDESUtils", new Object[] { "getDecryptPkgName shaBytes==null !!!!!!" });
        return "";
      }
      byte[] arrayOfByte = new byte[8];
      System.arraycopy(paramString2, 5, arrayOfByte, 0, 8);
      Object localObject = new byte[16];
      System.arraycopy(paramString2, 8, localObject, 0, 16);
      localObject = HexUtil.bytes2HexStr((byte[])localObject);
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = "";
      }
      paramString1 = a(paramString1, paramString2, arrayOfByte);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("OpenSdkDESUtils", "getDecryptPkgName", paramString1);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = Base64.decode(paramString1, 0);
      paramArrayOfByte = new IvParameterSpec(paramArrayOfByte);
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
      localCipher.init(2, paramString2, paramArrayOfByte);
      paramString1 = new String(localCipher.doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("OpenSdkDESUtils", "decryptAES", paramString1);
    }
    return null;
  }
  
  public static String a(String[] paramArrayOfString, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      i += 1;
    }
    return a(paramString, localStringBuilder.toString());
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (Exception paramString)
    {
      SSOLog.c("OpenSdkDESUtils", "encryptSha", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.OpenSdkDESUtils
 * JD-Core Version:    0.7.0.1
 */