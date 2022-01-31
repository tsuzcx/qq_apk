package com.tencent.thumbplayer.adapter;

import android.text.TextUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPPlaybackInfo
{
  private static String TAG = "TPPlaybackInfo";
  private long audioBitRate;
  private String audioCodec;
  private int audioProfile;
  private int bufferPercent;
  private int channels;
  private String containerFormat;
  private int currentPlayClipNo;
  private long currentPositionMs;
  private long durationMs;
  private long height;
  private long sampleRate;
  private long videoBitRate;
  private String videoCodec;
  private int videoCodedId;
  private int videoLevel;
  private int videoProfile;
  private long width;
  
  public static TPPlaybackInfo parseInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new TPPlaybackInfo();
    }
    Object localObject = paramString.split("\n");
    paramString = new HashMap();
    int i = 0;
    if (i < localObject.length)
    {
      if (localObject[i].startsWith("#")) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject[i].contains("="))
        {
          String[] arrayOfString = localObject[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length >= 2)) {
            paramString.put(arrayOfString[0], arrayOfString[1]);
          } else {
            TPLogUtil.i(TAG, "parseInfo, " + arrayOfString[0] + "is empty");
          }
        }
      }
    }
    localObject = new TPPlaybackInfo();
    if (paramString.containsKey("ContainerFormat")) {
      ((TPPlaybackInfo)localObject).setContainerFormat((String)paramString.get("ContainerFormat"));
    }
    if (paramString.containsKey("VideoCodec")) {
      ((TPPlaybackInfo)localObject).setVideoCodec((String)paramString.get("VideoCodec"));
    }
    if (paramString.containsKey("AudioCodec")) {
      ((TPPlaybackInfo)localObject).setAudioCodec((String)paramString.get("AudioCodec"));
    }
    if (paramString.containsKey("Width")) {
      ((TPPlaybackInfo)localObject).setWidth(Long.valueOf((String)paramString.get("Width")).longValue());
    }
    if (paramString.containsKey("Height")) {
      ((TPPlaybackInfo)localObject).setHeight(Long.valueOf((String)paramString.get("Height")).longValue());
    }
    if (paramString.containsKey("VideoBitRate")) {
      ((TPPlaybackInfo)localObject).setVideoBitRate(Long.valueOf((String)paramString.get("VideoBitRate")).longValue());
    }
    if (paramString.containsKey("AudioBitRate")) {
      ((TPPlaybackInfo)localObject).setAudioBitRate(Long.valueOf((String)paramString.get("AudioBitRate")).longValue());
    }
    if (paramString.containsKey("SampleRate")) {
      ((TPPlaybackInfo)localObject).setSampleRate(Long.valueOf((String)paramString.get("SampleRate")).longValue());
    }
    if (paramString.containsKey("Channels")) {
      ((TPPlaybackInfo)localObject).setChannels(Integer.valueOf((String)paramString.get("Channels")).intValue());
    }
    return localObject;
  }
  
  public void clear()
  {
    this.containerFormat = null;
    this.videoCodec = null;
    this.videoProfile = 0;
    this.videoCodedId = 0;
    this.width = 0L;
    this.height = 0L;
    this.videoBitRate = 0L;
    this.audioCodec = null;
    this.audioProfile = 0;
    this.audioBitRate = 0L;
    this.channels = 0;
    this.sampleRate = 0L;
    this.videoLevel = 0;
    this.currentPositionMs = 0L;
    this.durationMs = 0L;
    this.bufferPercent = 0;
    this.currentPlayClipNo = 0;
  }
  
  public long getAudioBitRate()
  {
    return this.audioBitRate;
  }
  
  public String getAudioCodec()
  {
    return this.audioCodec;
  }
  
  public int getAudioProfile()
  {
    return this.audioProfile;
  }
  
  public int getBufferPercent()
  {
    return this.bufferPercent;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public String getContainerFormat()
  {
    return this.containerFormat;
  }
  
  public int getCurrentPlayClipNo()
  {
    return this.currentPlayClipNo;
  }
  
  public long getCurrentPositionMs()
  {
    return this.currentPositionMs;
  }
  
  public long getDurationMs()
  {
    return this.durationMs;
  }
  
  public long getHeight()
  {
    return this.height;
  }
  
  public long getSampleRate()
  {
    return this.sampleRate;
  }
  
  public long getVideoBitRate()
  {
    return this.videoBitRate;
  }
  
  public String getVideoCodec()
  {
    return this.videoCodec;
  }
  
  public int getVideoCodedId()
  {
    return this.videoCodedId;
  }
  
  public int getVideoLevel()
  {
    return this.videoLevel;
  }
  
  public int getVideoProfile()
  {
    return this.videoProfile;
  }
  
  public long getWidth()
  {
    return this.width;
  }
  
  public void setAudioBitRate(long paramLong)
  {
    this.audioBitRate = paramLong;
  }
  
  public void setAudioCodec(String paramString)
  {
    this.audioCodec = paramString;
  }
  
  public void setAudioProfile(int paramInt)
  {
    this.audioProfile = paramInt;
  }
  
  public void setBufferPercent(int paramInt)
  {
    this.bufferPercent = paramInt;
  }
  
  public void setChannels(int paramInt)
  {
    this.channels = paramInt;
  }
  
  public void setContainerFormat(String paramString)
  {
    this.containerFormat = paramString;
  }
  
  public void setCurrentPlayClipNo(int paramInt)
  {
    this.currentPlayClipNo = paramInt;
  }
  
  public void setCurrentPositionMs(long paramLong)
  {
    this.currentPositionMs = paramLong;
  }
  
  public void setDurationMs(long paramLong)
  {
    this.durationMs = paramLong;
  }
  
  public void setHeight(long paramLong)
  {
    this.height = paramLong;
  }
  
  public void setSampleRate(long paramLong)
  {
    this.sampleRate = paramLong;
  }
  
  public void setVideoBitRate(long paramLong)
  {
    this.videoBitRate = paramLong;
  }
  
  public void setVideoCodec(String paramString)
  {
    this.videoCodec = paramString;
  }
  
  public void setVideoCodedId(int paramInt)
  {
    this.videoCodedId = paramInt;
  }
  
  public void setVideoLevel(int paramInt)
  {
    this.videoLevel = paramInt;
  }
  
  public void setVideoProfile(int paramInt)
  {
    this.videoProfile = paramInt;
  }
  
  public void setWidth(long paramLong)
  {
    this.width = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlaybackInfo
 * JD-Core Version:    0.7.0.1
 */