package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.view.Surface;
import android.view.SurfaceHolder;

public abstract interface IMediaPlayer
{
  public static final int MEDIA_ERROR_IO = -1004;
  public static final int MEDIA_ERROR_MALFORMED = -1007;
  public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
  public static final int MEDIA_ERROR_SERVER_DIED = 100;
  public static final int MEDIA_ERROR_TIMED_OUT = -110;
  public static final int MEDIA_ERROR_UNKNOWN = 1;
  public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
  public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
  public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
  public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
  public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
  public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
  public static final int MEDIA_INFO_METADATA_UPDATE = 802;
  public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  public static final int MEDIA_INFO_OPEN_INPUT = 10005;
  public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
  public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
  public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
  public static final int MEDIA_INFO_UNKNOWN = 1;
  public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
  public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  
  public abstract long getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLooping();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener);
  
  public abstract void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setRate(float paramFloat);
  
  public abstract void setScreenOnWhilePlaying(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
 * JD-Core Version:    0.7.0.1
 */