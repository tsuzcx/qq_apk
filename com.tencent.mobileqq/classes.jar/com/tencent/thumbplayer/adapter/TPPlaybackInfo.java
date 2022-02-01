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
  private int channels;
  private String containerFormat;
  private int currentPlayClipNo;
  private long currentPositionMs;
  private String definition;
  private long durationMs;
  private long height;
  private long playableDurationMs;
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
    String[] arrayOfString = paramString.split("\n");
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < arrayOfString.length)
    {
      if ((!arrayOfString[i].startsWith("#")) && (arrayOfString[i].contains("=")))
      {
        paramString = arrayOfString[i].split("=");
        if ((paramString != null) && (paramString.length >= 2))
        {
          localHashMap.put(paramString[0], paramString[1]);
        }
        else
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseInfo, ");
          if ((paramString != null) && (paramString.length >= 1)) {
            paramString = paramString[0];
          } else {
            paramString = "param null, ";
          }
          localStringBuilder.append(paramString);
          localStringBuilder.append("is empty");
          TPLogUtil.i(str, localStringBuilder.toString());
        }
      }
      i += 1;
    }
    paramString = new TPPlaybackInfo();
    if (localHashMap.containsKey("ContainerFormat")) {
      paramString.setContainerFormat((String)localHashMap.get("ContainerFormat"));
    }
    if (localHashMap.containsKey("VideoCodec")) {
      paramString.setVideoCodec((String)localHashMap.get("VideoCodec"));
    }
    if (localHashMap.containsKey("AudioCodec")) {
      paramString.setAudioCodec((String)localHashMap.get("AudioCodec"));
    }
    if (localHashMap.containsKey("Width")) {
      paramString.setWidth(Long.valueOf((String)localHashMap.get("Width")).longValue());
    }
    if (localHashMap.containsKey("Height")) {
      paramString.setHeight(Long.valueOf((String)localHashMap.get("Height")).longValue());
    }
    if (localHashMap.containsKey("VideoBitRate")) {
      paramString.setVideoBitRate(Long.valueOf((String)localHashMap.get("VideoBitRate")).longValue());
    }
    if (localHashMap.containsKey("AudioBitRate")) {
      paramString.setAudioBitRate(Long.valueOf((String)localHashMap.get("AudioBitRate")).longValue());
    }
    if (localHashMap.containsKey("SampleRate")) {
      paramString.setSampleRate(Long.valueOf((String)localHashMap.get("SampleRate")).longValue());
    }
    if (localHashMap.containsKey("Channels")) {
      paramString.setChannels(Integer.valueOf((String)localHashMap.get("Channels")).intValue());
    }
    if (localHashMap.containsKey("Definition")) {
      paramString.setDefinition((String)localHashMap.get("Definition"));
    }
    return paramString;
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
    this.playableDurationMs = 0L;
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
  
  public String getDefinition()
  {
    return this.definition;
  }
  
  public long getDurationMs()
  {
    return this.durationMs;
  }
  
  public long getHeight()
  {
    return this.height;
  }
  
  public long getPlayableDurationMs()
  {
    return this.playableDurationMs;
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
  
  public void setDefinition(String paramString)
  {
    this.definition = paramString;
  }
  
  public void setDurationMs(long paramLong)
  {
    this.durationMs = paramLong;
  }
  
  public void setHeight(long paramLong)
  {
    this.height = paramLong;
  }
  
  public void setPlayableDurationMs(long paramLong)
  {
    this.playableDurationMs = paramLong;
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