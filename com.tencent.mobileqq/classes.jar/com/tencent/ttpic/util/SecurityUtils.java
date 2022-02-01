package com.tencent.ttpic.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.BuildConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

public class SecurityUtils
{
  private static final String TAG = SecurityUtils.class.getSimpleName();
  private static String sSignMD5;
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String getSignMD5(Context paramContext)
  {
    if (TextUtils.isEmpty(sSignMD5))
    {
      if (!BuildConfig.DEBUG) {
        break label25;
      }
      sSignMD5 = Coffee.getDefaultSign();
    }
    for (;;)
    {
      return sSignMD5;
      try
      {
        label25:
        sSignMD5 = stringMD5(getSignature(paramContext));
      }
      catch (Exception paramContext)
      {
        sSignMD5 = Coffee.getDefaultSign();
      }
    }
  }
  
  private static String getSignature(Context paramContext)
  {
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(64).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equals(paramContext.getPackageName()))
      {
        LogUtils.v(TAG, "getSignature(), signature = %s", new Object[] { localPackageInfo.signatures[0].toCharsString() });
        return localPackageInfo.signatures[0].toCharsString();
      }
    }
    return "";
  }
  
  public static String stringMD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      paramString = byteArrayToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  public static String stringSHA1(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.update(paramString.getBytes());
      paramString = byteArrayToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.SecurityUtils
 * JD-Core Version:    0.7.0.1
 */