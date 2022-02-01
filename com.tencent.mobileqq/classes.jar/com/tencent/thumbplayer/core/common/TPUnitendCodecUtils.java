package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;

public class TPUnitendCodecUtils
{
  private static int DolbyVisionProfileDvavPen = 1;
  private static int DolbyVisionProfileDvavPer = 0;
  private static int DolbyVisionProfileDvavSe = 9;
  private static int DolbyVisionProfileDvheDen = 3;
  private static int DolbyVisionProfileDvheDer = 2;
  private static int DolbyVisionProfileDvheDtb = 7;
  private static int DolbyVisionProfileDvheDth = 6;
  private static int DolbyVisionProfileDvheDtr = 4;
  private static int DolbyVisionProfileDvheSt = 8;
  private static int DolbyVisionProfileDvheStn = 5;
  private static HashMap<String, String> mSecureDecoderNameMaps;
  
  public static int convertOmxProfileToDolbyVision(int paramInt)
  {
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32)
              {
                if (paramInt != 64)
                {
                  if (paramInt != 128)
                  {
                    if (paramInt != 256)
                    {
                      if (paramInt != 512) {
                        i = 0;
                      } else {
                        i = DolbyVisionProfileDvavSe;
                      }
                    }
                    else {
                      i = DolbyVisionProfileDvheSt;
                    }
                  }
                  else {
                    i = DolbyVisionProfileDvheDtb;
                  }
                }
                else {
                  i = DolbyVisionProfileDvheDth;
                }
              }
              else {
                i = DolbyVisionProfileDvheStn;
              }
            }
            else {
              i = DolbyVisionProfileDvheDtr;
            }
          }
          else {
            i = DolbyVisionProfileDvheDen;
          }
        }
        else {
          i = DolbyVisionProfileDvheDer;
        }
      }
      else {
        i = DolbyVisionProfileDvavPen;
      }
    }
    else {
      i = DolbyVisionProfileDvavPer;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertOmxProfileToDolbyVision omxProfile:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" dolbyVisionProfile:");
    localStringBuilder.append(i);
    TPNativeLog.printLog(2, "TPUnitendCodecUtils", localStringBuilder.toString());
    return i;
  }
  
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.equals("video/dolby-vision", paramString);
        if (!bool) {
          return null;
        }
        paramInt2 = Build.VERSION.SDK_INT;
        if (paramInt2 < 21) {
          return null;
        }
        MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
        if (arrayOfMediaCodecInfo == null) {
          return null;
        }
        int j = arrayOfMediaCodecInfo.length;
        localObject1 = null;
        paramInt2 = 0;
        localObject2 = localObject1;
        if (paramInt2 < j)
        {
          localMediaCodecInfo = arrayOfMediaCodecInfo[paramInt2];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDolbyVisionDecoderName name:");
          ((StringBuilder)localObject2).append(localMediaCodecInfo.getName());
          TPNativeLog.printLog(2, "TPUnitendCodecUtils", ((StringBuilder)localObject2).toString());
          bool = localMediaCodecInfo.isEncoder();
          if (!bool) {}
        }
      }
      finally
      {
        Object localObject2;
        MediaCodecInfo localMediaCodecInfo;
        MediaCodecInfo.CodecCapabilities localCodecCapabilities;
        MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel;
        int k;
        continue;
        throw paramString;
        continue;
      }
      try
      {
        localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(paramString);
      }
      catch (Exception localException)
      {
        continue;
        Object localObject3 = localObject1;
        continue;
        i += 1;
        continue;
      }
      localCodecCapabilities = null;
      if (localCodecCapabilities != null)
      {
        arrayOfCodecProfileLevel = localCodecCapabilities.profileLevels;
        i = 0;
        localObject2 = localObject1;
        if (i < arrayOfCodecProfileLevel.length)
        {
          k = convertOmxProfileToDolbyVision(arrayOfCodecProfileLevel[i].profile);
          if (k != paramInt1) {
            break label418;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDolbyVisionDecoderName i:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" profile:");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(" dvProfile:");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append(" bSecure:");
          ((StringBuilder)localObject2).append(paramBoolean);
          ((StringBuilder)localObject2).append(" name:");
          ((StringBuilder)localObject2).append(localMediaCodecInfo.getName());
          TPNativeLog.printLog(2, "TPUnitendCodecUtils", ((StringBuilder)localObject2).toString());
          if (paramBoolean)
          {
            if (!localCodecCapabilities.isFeatureSupported("secure-playback")) {
              break label418;
            }
            localObject1 = localMediaCodecInfo.getName();
            break label411;
          }
          localObject1 = localMediaCodecInfo.getName();
          break label411;
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          paramString = new StringBuilder();
          paramString.append("getDolbyVisionDecoderName name:");
          paramString.append((String)localObject2);
          TPNativeLog.printLog(2, "TPUnitendCodecUtils", paramString.toString());
          continue;
        }
      }
      paramInt2 += 1;
    }
    return localObject2;
  }
  
  public static String getSecureDecoderName(String paramString)
  {
    try
    {
      bool = TextUtils.equals("video/avc", paramString);
      localObject2 = null;
      if ((!bool) && (!TextUtils.equals("video/hevc", paramString)))
      {
        bool = TextUtils.equals("video/dolby-vision", paramString);
        if (!bool) {
          return null;
        }
      }
      if (mSecureDecoderNameMaps == null) {
        mSecureDecoderNameMaps = new HashMap();
      }
      if (mSecureDecoderNameMaps.containsKey(paramString))
      {
        paramString = (String)mSecureDecoderNameMaps.get(paramString);
        return paramString;
      }
      arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      if (arrayOfMediaCodecInfo == null) {
        return null;
      }
      j = arrayOfMediaCodecInfo.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        boolean bool;
        Object localObject2;
        MediaCodecInfo[] arrayOfMediaCodecInfo;
        int j;
        int i;
        Object localObject1;
        MediaCodecInfo localMediaCodecInfo;
        for (;;)
        {
          label152:
          throw paramString;
        }
        i += 1;
      }
    }
    localObject1 = localObject2;
    if (i < j)
    {
      localMediaCodecInfo = arrayOfMediaCodecInfo[i];
      bool = localMediaCodecInfo.isEncoder();
      if (bool) {}
    }
    else
    {
      try
      {
        localObject1 = localMediaCodecInfo.getCapabilitiesForType(paramString);
      }
      catch (Exception localException)
      {
        break label152;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((MediaCodecInfo.CodecCapabilities)localObject1).isFeatureSupported("secure-playback")))
      {
        localObject1 = localMediaCodecInfo.getName();
        mSecureDecoderNameMaps.put(paramString, localObject1);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPUnitendCodecUtils
 * JD-Core Version:    0.7.0.1
 */