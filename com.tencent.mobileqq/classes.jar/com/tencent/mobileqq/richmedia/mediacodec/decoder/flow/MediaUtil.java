package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public class MediaUtil
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static int a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(18);
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      SLog.e("MediaUtil", paramString.toString());
      return 0;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public static long a(String paramString)
  {
    long l = -1L;
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  @Nullable
  public static List a(String paramString)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        paramString = new ArrayList();
        i = 0;
        if (i >= localMediaExtractor.getTrackCount()) {
          break label313;
        }
        MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(i);
        if (localMediaFormat.getString("mime").startsWith("video/"))
        {
          localMediaExtractor.selectTrack(i);
          l1 = localMediaFormat.getLong("durationUs");
          if (l1 != -1L) {
            break label129;
          }
          localMediaExtractor.release();
          return null;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        localMediaExtractor.release();
        return null;
      }
      i += 1;
      continue;
      label129:
      long l2;
      do
      {
        Object localObject;
        paramString.add(Long.valueOf(localObject));
        localMediaExtractor.seekTo(1000000L + localObject, 1);
        if (localMediaExtractor.getSampleTime() == -1L) {
          break;
        }
        l2 = localMediaExtractor.getSampleTime();
      } while ((paramString.size() <= 1) || (((Long)paramString.get(paramString.size() - 1)).longValue() != l2));
      paramString.add(Long.valueOf(l1));
      localMediaExtractor.release();
      int i = paramString.size();
      if (i > 2)
      {
        l1 = ((Long)paramString.get(i - 2)).longValue();
        l2 = ((Long)paramString.get(i - 3)).longValue();
        long l3 = ((Long)paramString.get(i - 1)).longValue() - ((Long)paramString.get(i - 2)).longValue();
        if ((l3 < 400000L) && (l1 - l2 + l3 < 2000000L)) {
          paramString.remove(i - 2);
        }
      }
      return paramString;
      label313:
      long l1 = -1L;
    }
  }
  
  public static int b(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(19);
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      SLog.e("MediaUtil", paramString.toString());
      return 0;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.MediaUtil
 * JD-Core Version:    0.7.0.1
 */