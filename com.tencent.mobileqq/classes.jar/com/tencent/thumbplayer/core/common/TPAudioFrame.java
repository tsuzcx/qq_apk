package com.tencent.thumbplayer.core.common;

public class TPAudioFrame
{
  public static final long TP_CH_FRONT_CENTER = 4L;
  public static final long TP_CH_FRONT_LEFT = 1L;
  public static final long TP_CH_FRONT_RIGHT = 2L;
  public static final long TP_CH_LAYOUT_MONO = 4L;
  public static final long TP_CH_LAYOUT_NONE = 0L;
  public static final long TP_CH_LAYOUT_STEREO = 3L;
  public static final int TP_SAMPLE_FMT_NONE = -1;
  public static final int TP_SAMPLE_FMT_S16 = 1;
  public static final int TP_SAMPLE_FMT_S32 = 2;
  public static final int TP_SAMPLE_FMT_U8 = 0;
  public long channelLayout;
  public byte[] data;
  public int exFlags;
  public long ptsUs;
  public int sampleRate;
  public int size;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioFrame
 * JD-Core Version:    0.7.0.1
 */