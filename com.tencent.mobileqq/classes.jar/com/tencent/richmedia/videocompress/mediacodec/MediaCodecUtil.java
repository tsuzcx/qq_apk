package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MediaCodecUtil
{
  private static String TAG = "CodecUtil";
  
  public static MediaCodecWrapper createVideoDecoder(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    Object localObject = getDecoderInfoList(paramMediaFormat.getString("mime"), false);
    if (!((List)localObject).isEmpty())
    {
      localObject = (MediaCodecInfo)((List)localObject).get(0);
      MediaCodecWrapper localMediaCodecWrapper = new MediaCodecWrapper(null);
      localMediaCodecWrapper.init(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface);
      localMediaCodecWrapper.start();
      return localMediaCodecWrapper;
    }
    return null;
  }
  
  public static MediaCodecWrapper createVideoEncoder(MediaFormat paramMediaFormat, AtomicReference<Surface> paramAtomicReference)
  {
    MediaCodecWrapper localMediaCodecWrapper = new MediaCodecWrapper(null);
    localMediaCodecWrapper.init(paramMediaFormat, MediaCodecWrapper.ENC_CODEC);
    paramAtomicReference.set(localMediaCodecWrapper.getInnerMediaCodec().createInputSurface());
    localMediaCodecWrapper.start();
    return localMediaCodecWrapper;
  }
  
  public static int getAndSelectAudioTrackIndex(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        String str = paramMediaExtractor.getTrackFormat(i).getString("mime");
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d(TAG, 2, new Object[] { "format for track ", Integer.valueOf(i), " is ", str });
        }
        if ((str != null) && (str.startsWith("audio/")))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor)
    {
      ConvertLog.e(TAG, 1, "getAndSelectAudioTrackIndex error", paramMediaExtractor);
    }
  }
  
  public static int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        String str = paramMediaExtractor.getTrackFormat(i).getString("mime");
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d(TAG, 2, new Object[] { "format for track ", Integer.valueOf(i), " is ", str });
        }
        if ((str != null) && (str.startsWith("video/")))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor)
    {
      ConvertLog.e(TAG, 1, "getAndSelectVideoTrackIndex error", paramMediaExtractor);
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      ConvertLog.e(TAG, 1, "getCodecCapabilities error, mime:" + paramString, paramMediaCodecInfo);
    }
    return null;
  }
  
  public static List<MediaCodecInfo> getDecoderInfoList(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    for (;;)
    {
      if (i < k) {
        try
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((!localMediaCodecInfo.isEncoder()) && ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int m = arrayOfString.length;
            int j = 0;
            while (j < m)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
              return localArrayList;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          ConvertLog.e(TAG, 1, "getDecoderInfoList error, mime:" + paramString, localThrowable);
        }
      }
      i += 1;
    }
  }
  
  public static List<MediaCodecInfo> getEncoderInfoList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable localThrowable)
      {
        ConvertLog.e(TAG, 1, "getEncoderInfoList error, mime:" + paramString, localThrowable);
      }
      i += 1;
    }
  }
  
  public static MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
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
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil
 * JD-Core Version:    0.7.0.1
 */