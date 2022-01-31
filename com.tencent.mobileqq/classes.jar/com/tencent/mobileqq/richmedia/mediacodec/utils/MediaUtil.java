package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;

public class MediaUtil
{
  private static String a = "MediaUtil";
  
  @TargetApi(10)
  public static long a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(9);
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  @TargetApi(10)
  public static Bitmap a(String paramString, int paramInt)
  {
    if (!FileUtils.e(paramString))
    {
      SLog.e(a, "File note exist when getFrameAtTime(). videoPath = " + paramString + " millisecond = " + paramInt);
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = paramInt * 1000;
    try
    {
      paramString = localMediaMetadataRetriever.getFrameAtTime(l, 0);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      SLog.c(a, "getFrameAtTime", paramString);
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, 0);
    if (paramString1 != null) {
      BitmapUtils.a(paramString1, Bitmap.CompressFormat.JPEG, 80, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil
 * JD-Core Version:    0.7.0.1
 */