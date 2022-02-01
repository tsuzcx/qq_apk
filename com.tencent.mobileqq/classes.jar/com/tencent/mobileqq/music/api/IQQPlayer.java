package com.tencent.mobileqq.music.api;

import android.content.Context;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract class IQQPlayer
  implements QRouteApi
{
  public abstract void addCallback(QQPlayerCallback paramQQPlayerCallback);
  
  public abstract String generateToken(int paramInt, String paramString);
  
  public abstract int getCurrentPlayPosition();
  
  public abstract SongInfo getCurrentSong();
  
  public abstract int getDuration();
  
  public abstract SongInfo getNextPlaySong();
  
  public abstract SongInfo getNextSong();
  
  public abstract SongInfo[] getPlayList();
  
  public abstract int getPlayListCount();
  
  public abstract int getPlayMode();
  
  public abstract int getPlayState();
  
  public abstract String getToken();
  
  public abstract boolean isMusicFileValid(String paramString);
  
  public abstract boolean isPlaying();
  
  public abstract boolean isPlayingMySong(String paramString);
  
  public abstract void pausePlayMusic(Context paramContext);
  
  public abstract SongInfo pickNextSong();
  
  public abstract boolean playNext(Context paramContext);
  
  public abstract boolean playPrev(Context paramContext);
  
  public abstract void removeCallback(QQPlayerCallback paramQQPlayerCallback);
  
  public abstract void resumePlayMusic(Context paramContext);
  
  public abstract void resumePlayMusic(Context paramContext, boolean paramBoolean);
  
  public abstract void setPlayMode(int paramInt);
  
  public abstract void setSongList(SongInfo[] paramArrayOfSongInfo);
  
  public abstract void setSongList(SongInfo[] paramArrayOfSongInfo, int paramInt1, int paramInt2);
  
  public abstract void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo);
  
  public abstract void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt);
  
  public abstract void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt, boolean paramBoolean);
  
  public abstract void startPlaySingleSong(Context paramContext, String paramString, SongInfo paramSongInfo);
  
  public abstract void stopPlayMusic(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.api.IQQPlayer
 * JD-Core Version:    0.7.0.1
 */