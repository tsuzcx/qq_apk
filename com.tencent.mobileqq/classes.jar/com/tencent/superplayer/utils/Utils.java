package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils
{
  private static AtomicInteger PLAYER_ID_BASE = new AtomicInteger(1000);
  public static final String TAG = Utils.class.getSimpleName();
  
  public static String calculateFileIDForVideoInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId())) {
      return paramSuperPlayerVideoInfo.getFileId();
    }
    if ((!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getVid())) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null)) {
      return paramSuperPlayerVideoInfo.getVid() + paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn();
    }
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
      return calculateMD5ForInput(paramSuperPlayerVideoInfo.getPlayUrl());
    }
    return null;
  }
  
  public static String calculateMD5ForInput(String paramString)
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
    case 1006: 
      return 207;
    case 502: 
      return 208;
    }
    return 125;
  }
  
  public static String createPlayerTag()
  {
    return String.valueOf(PLAYER_ID_BASE.getAndAdd(1));
  }
  
  public static int getDownloadProxyServiceType(int paramInt)
  {
    if (SuperPlayerSDKMgr.getPlatform() <= 0) {
      return 0;
    }
    String str2 = String.valueOf(SuperPlayerSDKMgr.getPlatform());
    String str1 = str2;
    if (paramInt >= 0) {
      str1 = str2 + String.valueOf(paramInt);
    }
    return Integer.valueOf(str1).intValue();
  }
  
  public static boolean initDataTransportDataFolder(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
      return false;
    }
    String str = SuperPlayerSDKMgr.getDataCacheFolder() + File.separator + paramInt;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        LogUtil.d(TAG, "业务缓存目录创建成功，path = " + str);
      }
      for (;;)
      {
        TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, str, str, null);
        return true;
        LogUtil.d(TAG, "业务缓存目录已存在，path = " + str);
      }
      return false;
    }
    catch (Exception localException)
    {
      LogUtil.d(TAG, "业务缓存目录创建失败，path = " + str + ", error = " + localException.getMessage());
    }
  }
  
  public static int parseStr2Int(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.Utils
 * JD-Core Version:    0.7.0.1
 */