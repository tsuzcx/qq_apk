package com.tencent.ttpic;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class CommonUtils
{
  private static final String TAG = "CommonUtils";
  
  @RequiresApi(api=23)
  private static int getMaxSupportedInstanceCount(String paramString)
  {
    MediaCodecInfo localMediaCodecInfo = selectDecoder(paramString);
    if (localMediaCodecInfo == null) {
      return 0;
    }
    try
    {
      int i = localMediaCodecInfo.getCapabilitiesForType(paramString).getMaxSupportedInstances();
      return i;
    }
    catch (Throwable paramString)
    {
      LogUtils.e("CommonUtils", paramString.getMessage());
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int getPAGSupportedDecoderInstanceCount()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return 0;
    }
    return Math.min(getMaxSupportedInstanceCount("video/avc"), getMaxSupportedInstanceCount("video/hevc"));
  }
  
  @RequiresApi(api=17)
  private static MediaCodecInfo selectDecoder(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.CommonUtils
 * JD-Core Version:    0.7.0.1
 */