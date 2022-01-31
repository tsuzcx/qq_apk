package com.tencent.thumbplayer.api;

public class TPAudioFrameBuffer
{
  public static final long TP_AUDIO_CH_LAYOUT_MONO = 4L;
  public static final long TP_AUDIO_CH_LAYOUT_NONE = 0L;
  public static final long TP_AUDIO_CH_LAYOUT_STEREO = 3L;
  public static final int TP_AUDIO_SAMPLE_FMT_NONE = -1;
  public static final int TP_AUDIO_SAMPLE_FMT_S16 = 1;
  public static final int TP_AUDIO_SAMPLE_FMT_S32 = 2;
  public static final int TP_AUDIO_SAMPLE_FMT_U8 = 0;
  private static final long TP_CH_FRONT_CENTER = 4L;
  private static final long TP_CH_FRONT_LEFT = 1L;
  private static final long TP_CH_FRONT_RIGHT = 2L;
  public long channelLayout;
  public byte[] data;
  public int flags;
  public int format;
  public long ptsMs;
  public int sampleRate;
  public int size;
  
  public long getChannelLayout()
  {
    return this.channelLayout;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public int getExFlags()
  {
    return this.flags;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public long getPtsMs()
  {
    return this.ptsMs;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int getSize()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPAudioFrameBuffer
 * JD-Core Version:    0.7.0.1
 */