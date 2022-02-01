package com.tencent.mobileqq.music.api.impl;

import android.content.Context;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.api.IQQPlayer;

public class QQPlayerImpl
  extends IQQPlayer
{
  private static final String TAG = "QQPlayerImpl";
  
  public void addCallback(QQPlayerCallback paramQQPlayerCallback)
  {
    QQPlayerService.b(paramQQPlayerCallback);
  }
  
  public String generateToken(int paramInt, String paramString)
  {
    return QQPlayerService.a(paramInt, paramString);
  }
  
  public int getCurrentPlayPosition()
  {
    return QQPlayerService.f();
  }
  
  public SongInfo getCurrentSong()
  {
    return QQPlayerService.b();
  }
  
  public int getDuration()
  {
    return QQPlayerService.d();
  }
  
  public SongInfo getNextPlaySong()
  {
    return QQPlayerService.d();
  }
  
  public SongInfo getNextSong()
  {
    return QQPlayerService.c();
  }
  
  public SongInfo[] getPlayList()
  {
    return QQPlayerService.a();
  }
  
  public int getPlayListCount()
  {
    return QQPlayerService.c();
  }
  
  public int getPlayMode()
  {
    return QQPlayerService.b();
  }
  
  public int getPlayState()
  {
    return QQPlayerService.a();
  }
  
  public String getToken()
  {
    return QQPlayerService.a();
  }
  
  public boolean isMusicFileValid(String paramString)
  {
    return QQPlayerService.b(paramString);
  }
  
  public boolean isPlaying()
  {
    return QQPlayerService.a();
  }
  
  public boolean isPlayingMySong(String paramString)
  {
    return QQPlayerService.a(paramString);
  }
  
  public void pausePlayMusic(Context paramContext)
  {
    QQPlayerService.a(paramContext);
  }
  
  public SongInfo pickNextSong()
  {
    return QQPlayerService.a();
  }
  
  public boolean playNext(Context paramContext)
  {
    return QQPlayerService.b(paramContext);
  }
  
  public boolean playPrev(Context paramContext)
  {
    return QQPlayerService.a(paramContext);
  }
  
  public void removeCallback(QQPlayerCallback paramQQPlayerCallback)
  {
    QQPlayerService.c(paramQQPlayerCallback);
  }
  
  public void resumePlayMusic(Context paramContext)
  {
    QQPlayerService.b(paramContext);
  }
  
  public void resumePlayMusic(Context paramContext, boolean paramBoolean)
  {
    QQPlayerService.a(paramContext, paramBoolean);
  }
  
  public void setPlayMode(int paramInt)
  {
    QQPlayerService.a(paramInt);
  }
  
  public void setSongList(SongInfo[] paramArrayOfSongInfo)
  {
    QQPlayerService.a(paramArrayOfSongInfo);
  }
  
  public void setSongList(SongInfo[] paramArrayOfSongInfo, int paramInt1, int paramInt2)
  {
    QQPlayerService.a(paramArrayOfSongInfo, paramInt1, paramInt2);
  }
  
  public void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo)
  {
    QQPlayerService.a(paramContext, paramString, paramArrayOfSongInfo);
  }
  
  public void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    QQPlayerService.a(paramContext, paramString, paramArrayOfSongInfo, paramInt);
  }
  
  public void startPlayMusic(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt, boolean paramBoolean)
  {
    QQPlayerService.a(paramContext, paramString, paramArrayOfSongInfo, paramInt, paramBoolean);
  }
  
  public void startPlaySingleSong(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    QQPlayerService.a(paramContext, paramString, paramSongInfo);
  }
  
  public void stopPlayMusic(Context paramContext)
  {
    QQPlayerService.c(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.api.impl.QQPlayerImpl
 * JD-Core Version:    0.7.0.1
 */