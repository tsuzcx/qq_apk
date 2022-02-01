package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderList
{
  private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
  private static String MEDIA_DECODER_VERSION = "2.16.0.1086.full";
  private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
  private static final String TAG = "TPMediaDecoderList";
  private static TPMediaDecoderInfo[] sDecoderInfos;
  
  private static void cacheDecoderInfos(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    try
    {
      paramLocalCache.put("DecoderInfos_Key", paramArrayOfTPMediaDecoderInfo);
      return;
    }
    catch (Throwable paramLocalCache)
    {
      label8:
      break label8;
    }
    TPNativeLog.printLog(4, "TPMediaDecoderList", "cache decode infos failed");
  }
  
  private static void cacheVersion(LocalCache paramLocalCache, String paramString)
  {
    try
    {
      paramLocalCache.put("Version_Key", paramString);
      return;
    }
    catch (Throwable paramLocalCache)
    {
      label8:
      break label8;
    }
    TPNativeLog.printLog(4, "TPMediaDecoderList", "cache version failed");
  }
  
  private static TPMediaDecoderInfo[] getCachedDecoderInfos(LocalCache paramLocalCache)
  {
    try
    {
      paramLocalCache = (TPMediaDecoderInfo[])paramLocalCache.getAsObject("DecoderInfos_Key");
      return paramLocalCache;
    }
    catch (Throwable paramLocalCache)
    {
      label15:
      break label15;
    }
    TPNativeLog.printLog(4, "TPMediaDecoderList", "get decoder info failed");
    return null;
  }
  
  private static String getCachedVersion(LocalCache paramLocalCache)
  {
    try
    {
      paramLocalCache = paramLocalCache.getAsString("Version_Key");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("version:");
      localStringBuilder.append(paramLocalCache);
      TPNativeLog.printLog(2, "TPMediaDecoderList", localStringBuilder.toString());
      return paramLocalCache;
    }
    catch (Throwable paramLocalCache)
    {
      label40:
      break label40;
    }
    TPNativeLog.printLog(4, "TPMediaDecoderList", "get version failed");
    return null;
  }
  
  private static final MediaCodecInfo[] getCodecInfos()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      int j = MediaCodecList.getCodecCount();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(MediaCodecList.getCodecInfoAt(i));
        i += 1;
      }
      return (MediaCodecInfo[])localArrayList.toArray(new MediaCodecInfo[localArrayList.size()]);
    }
    return new MediaCodecList(1).getCodecInfos();
  }
  
  private static final TPMediaDecoderInfo[] getLocalCacheMediaCodecList(LocalCache paramLocalCache)
  {
    TPNativeLog.printLog(2, "getLocalCacheMediaCodecList");
    Object localObject = getCachedVersion(paramLocalCache);
    if ((localObject != null) && (((String)localObject).equals(MEDIA_DECODER_VERSION)))
    {
      paramLocalCache = getCachedDecoderInfos(paramLocalCache);
      if (paramLocalCache != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCachedDecoderInfos length ");
        ((StringBuilder)localObject).append(paramLocalCache.length);
        TPNativeLog.printLog(2, ((StringBuilder)localObject).toString());
        return paramLocalCache;
      }
    }
    return null;
  }
  
  private static final TPMediaDecoderInfo[] getSystemMediaCodecList()
  {
    TPNativeLog.printLog(2, "getSystemMediaCodecList");
    MediaCodecInfo[] arrayOfMediaCodecInfo = getCodecInfos();
    if (arrayOfMediaCodecInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfMediaCodecInfo.length;
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = arrayOfMediaCodecInfo[i];
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          String str = arrayOfString[j];
          TPMediaDecoderInfo localTPMediaDecoderInfo = new TPMediaDecoderInfo(str, localMediaCodecInfo.getName(), localMediaCodecInfo.getCapabilitiesForType(str));
          if (!localTPMediaDecoderInfo.isVideoSofwareDecoder())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("MediaCodecList codecName ");
            localStringBuilder.append(localMediaCodecInfo.getName());
            localStringBuilder.append("supportedType ");
            localStringBuilder.append(str);
            TPNativeLog.printLog(2, localStringBuilder.toString());
            localArrayList.add(localTPMediaDecoderInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return (TPMediaDecoderInfo[])localArrayList.toArray(new TPMediaDecoderInfo[localArrayList.size()]);
  }
  
  public static final TPMediaDecoderInfo[] getTPMediaDecoderInfos(LocalCache paramLocalCache)
  {
    try
    {
      if (sDecoderInfos == null) {
        sDecoderInfos = initCodecList(paramLocalCache);
      }
      if (sDecoderInfos == null) {
        paramLocalCache = new TPMediaDecoderInfo[0];
      } else {
        paramLocalCache = (TPMediaDecoderInfo[])Arrays.copyOf(sDecoderInfos, sDecoderInfos.length);
      }
      return paramLocalCache;
    }
    finally {}
  }
  
  private static final TPMediaDecoderInfo[] initCodecList(LocalCache paramLocalCache)
  {
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo2 = getLocalCacheMediaCodecList(paramLocalCache);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo1 = arrayOfTPMediaDecoderInfo2;
    if (arrayOfTPMediaDecoderInfo2 == null)
    {
      arrayOfTPMediaDecoderInfo1 = getSystemMediaCodecList();
      storeLocalCacheMediaCodecList(paramLocalCache, arrayOfTPMediaDecoderInfo1);
    }
    return arrayOfTPMediaDecoderInfo1;
  }
  
  private static final void storeLocalCacheMediaCodecList(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    TPNativeLog.printLog(2, "storeLocalCacheMediaCodecList");
    cacheDecoderInfos(paramLocalCache, paramArrayOfTPMediaDecoderInfo);
    cacheVersion(paramLocalCache, MEDIA_DECODER_VERSION);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderList
 * JD-Core Version:    0.7.0.1
 */