package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class MediaMetadataUtils
{
  public static int a(String paramString, MediaMetadataUtils.MetaData paramMetaData)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      String str2 = localMediaMetadataRetriever.extractMetadata(18);
      String str3 = localMediaMetadataRetriever.extractMetadata(19);
      String str1 = localMediaMetadataRetriever.extractMetadata(24);
      String str4 = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      if ((str1 != null) && (!"".equals(str1)))
      {
        paramString = str1;
        if (!"null".equals(str1)) {}
      }
      else
      {
        paramString = "0";
      }
      if ((str2 != null) && (str3 != null))
      {
        int i;
        try
        {
          paramMetaData.a[0] = Integer.parseInt(str2);
          paramMetaData.a[1] = Integer.parseInt(str3);
          paramMetaData.a[3] = Integer.parseInt(str4);
          i = 0;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("MediaMetadataUtils", 1, "parseInt", localNumberFormatException);
          i = -103;
        }
        try
        {
          paramMetaData.a[2] = Integer.parseInt(paramString);
          paramMetaData.a[4] = 0;
          return i;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("MediaMetadataUtils", 1, "parseInt", paramString);
          paramMetaData.a[2] = 0;
          return i;
        }
      }
      paramString = new StringBuilder();
      paramString.append("extractMetadata:width=");
      paramString.append(str2);
      paramString.append(" height=");
      paramString.append(str3);
      QLog.e("MediaMetadataUtils", 1, paramString.toString());
      return -102;
    }
    catch (RuntimeException paramString)
    {
      QLog.e("MediaMetadataUtils", 1, "setDataSource", paramString);
    }
    return -101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils
 * JD-Core Version:    0.7.0.1
 */