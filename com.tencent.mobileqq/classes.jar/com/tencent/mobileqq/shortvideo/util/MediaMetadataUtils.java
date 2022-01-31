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
    label250:
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        str1 = localMediaMetadataRetriever.extractMetadata(18);
        str2 = localMediaMetadataRetriever.extractMetadata(19);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        str3 = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString))) {
          break label250;
        }
        paramString = "0";
        if ((str1 == null) || (str2 == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MediaMetadataUtils", 2, "[@] extractMetadata:width=" + str1 + " height=" + str2);
          }
          return -2;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMetadataUtils", 2, "[@] setDataSource", paramString);
        }
        return -1;
      }
      for (;;)
      {
        try
        {
          paramMetaData.a[0] = Integer.parseInt(str1);
          paramMetaData.a[1] = Integer.parseInt(str2);
          paramMetaData.a[3] = Integer.parseInt(str3);
          i = 0;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MediaMetadataUtils", 2, "[@] parseInt", localNumberFormatException);
          int i = -3;
          continue;
        }
        try
        {
          paramMetaData.a[2] = Integer.parseInt(paramString);
          paramMetaData.a[4] = 0;
          return i;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MediaMetadataUtils", 2, "[@] parseInt", paramString);
          }
          paramMetaData.a[2] = 0;
          return i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils
 * JD-Core Version:    0.7.0.1
 */