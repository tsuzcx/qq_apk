package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;

public class VideoUtil
{
  public static long getDurationOfVideo(String paramString)
  {
    if (!FileUtil.checkFileExist(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0L;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      long l = Long.valueOf(localMediaMetadataRetriever.extractMetadata(9)).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static float getHeightWidthRatioOfVideo(String paramString)
  {
    if (!FileUtil.checkFileExist(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0.0F;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(18);
      String str = localMediaMetadataRetriever.extractMetadata(19);
      localMediaMetadataRetriever.release();
      int i = Integer.valueOf(paramString).intValue();
      int j = Integer.valueOf(str).intValue();
      return j * 1.0F / i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */