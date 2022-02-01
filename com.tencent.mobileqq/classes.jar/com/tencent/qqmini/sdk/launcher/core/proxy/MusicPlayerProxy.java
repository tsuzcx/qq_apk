package com.tencent.qqmini.sdk.launcher.core.proxy;

import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;

public abstract interface MusicPlayerProxy
{
  public static final int PLAY_MODE_LIST = 102;
  public static final int PLAY_MODE_LIST_REPEAT = 103;
  public static final int PLAY_MODE_LIST_SHUFFLE_REPEAT = 105;
  public static final int PLAY_MODE_ONESHOT = 100;
  public static final int PLAY_MODE_ONESHOT_REPEAT = 101;
  public static final int PLAY_STATE_BUFFERING = 1;
  public static final int PLAY_STATE_COMPLETETION = 8;
  public static final int PLAY_STATE_ERROR_INTERNAL = 5;
  public static final int PLAY_STATE_ERROR_SERVER = 7;
  public static final int PLAY_STATE_IDLE = 0;
  public static final int PLAY_STATE_NETWORK_INTERRUPT = 6;
  public static final int PLAY_STATE_PAUSE = 3;
  public static final int PLAY_STATE_PLAYING = 2;
  public static final int PLAY_STATE_STOP = 4;
  public static final int PLAY_STATE_URL_NEED_TO_BE_UPDATED = 10;
  
  public abstract SongInfo getCurrentSong();
  
  public abstract int getCurrentSongPosition();
  
  public abstract int getDuration();
  
  public abstract void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2);
  
  public abstract boolean isInit();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setPlayMode(int paramInt);
  
  public abstract void startPlay(SongInfo[] paramArrayOfSongInfo, int paramInt);
  
  public abstract void stop();
  
  public abstract void unInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
 * JD-Core Version:    0.7.0.1
 */