package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SPlayerUtils
{
  public static final String TAG = SPlayerUtils.class.getSimpleName();
  
  public static String calculateFileID(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if ("".equals(paramString)) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString.getBytes());
      paramString = new BigInteger(1, ((MessageDigest)localObject1).digest()).toString(16);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        while (paramString.length() < 32)
        {
          localObject1 = "0" + paramString;
          paramString = (String)localObject1;
        }
        localObject1 = paramString.toUpperCase();
        return localObject1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        break label97;
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = localObject2;
    }
    label97:
    localNoSuchAlgorithmException1.printStackTrace();
    return paramString;
  }
  
  public static int convertPlayerMsg(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    default: 
      return 0;
    case 101: 
      return 100;
    case 102: 
      return 106;
    case 103: 
      return 102;
    case 104: 
      return 103;
    case 105: 
      return 104;
    case 106: 
      return 105;
    case 107: 
      return 106;
    case 150: 
      return 107;
    case 151: 
      return 108;
    case 152: 
      return 109;
    case 154: 
      return 110;
    case 200: 
      return 112;
    case 201: 
      return 113;
    case 203: 
      return 114;
    case 204: 
      return 115;
    case 205: 
      return 116;
    case 206: 
      return 117;
    case 207: 
      return 118;
    case 208: 
      return 119;
    case 501: 
      return 123;
    case 500: 
      return 122;
    case 1000: 
      return 124;
    case 1001: 
      return 201;
    case 1003: 
      return 204;
    case 1004: 
      return 206;
    case 1005: 
      return 205;
    }
    return 207;
  }
  
  public static int getDownloadProxyServiceType(int paramInt)
  {
    if (SuperPlayerMgr.getPlatform() <= 0) {
      return 0;
    }
    String str2 = String.valueOf(SuperPlayerMgr.getPlatform());
    String str1 = str2;
    if (paramInt >= 0) {
      str1 = str2 + String.valueOf(paramInt);
    }
    return Integer.valueOf(str1).intValue();
  }
  
  public static boolean initDataTransportDataFolder(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerMgr.getDataCacheFolder())) {
      return false;
    }
    String str = SuperPlayerMgr.getDataCacheFolder() + File.separator + paramInt;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        SPlayerLogUtil.d(TAG, "业务缓存目录创建成功，path = " + str);
      }
      for (;;)
      {
        TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, str, str, null);
        return true;
        SPlayerLogUtil.d(TAG, "业务缓存目录已存在，path = " + str);
      }
      return false;
    }
    catch (Exception localException)
    {
      SPlayerLogUtil.d(TAG, "业务缓存目录创建失败，path = " + str + ", error = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.SPlayerUtils
 * JD-Core Version:    0.7.0.1
 */