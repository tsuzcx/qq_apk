package com.tencent.smtt.sdk;

public abstract interface TbsMediaPlayer$TbsMediaPlayerListener
{
  public static final int MEDIA_EXTRA_AUDIOTRACK_INDEX = 104;
  public static final int MEDIA_EXTRA_AUDIOTRACK_TITLES = 103;
  public static final int MEDIA_EXTRA_SUBTITLE_COUNT = 101;
  public static final int MEDIA_EXTRA_SUBTITLE_INDEX = 102;
  public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 790;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
  public static final int MEDIA_INFO_HAVE_VIDEO_DATA = 752;
  public static final int MEDIA_INFO_METADATA_UPDATE = 802;
  public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  public static final int MEDIA_INFO_NO_VIDEO_DATA = 751;
  public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
  public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
  public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  public static final int ROTATE_ACTION_HASROTATE = 3;
  public static final int ROTATE_ACTION_NOTHING = 1;
  public static final int ROTATE_ACTION_SETDEGREE = 2;
  public static final int ROTATE_ACTION_UNKNOWN = 0;
  
  public abstract void onBufferingUpdate(float paramFloat);
  
  public abstract void onPlayerCompleted();
  
  public abstract void onPlayerError(String paramString, int paramInt1, int paramInt2, Throwable paramThrowable);
  
  public abstract void onPlayerExtra(int paramInt, Object paramObject);
  
  public abstract void onPlayerInfo(int paramInt1, int paramInt2);
  
  public abstract void onPlayerPaused();
  
  public abstract void onPlayerPlaying();
  
  public abstract void onPlayerPrepared(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onPlayerProgress(long paramLong);
  
  public abstract void onPlayerSeeked(long paramLong);
  
  public abstract void onPlayerSubtitle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener
 * JD-Core Version:    0.7.0.1
 */