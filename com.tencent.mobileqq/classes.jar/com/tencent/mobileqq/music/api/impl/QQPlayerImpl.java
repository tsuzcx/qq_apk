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
    return QQPlayerService.k();
  }
  
  public SongInfo getCurrentSong()
  {
    return QQPlayerService.g();
  }
  
  public int getDuration()
  {
    return QQPlayerService.i();
  }
  
  public SongInfo getNextPlaySong()
  {
    return QQPlayerService.q();
  }
  
  public SongInfo getNextSong()
  {
    return QQPlayerService.h();
  }
  
  public SongInfo[] getPlayList()
  {
    return QQPlayerService.e();
  }
  
  public int getPlayListCount()
  {
    return QQPlayerService.f();
  }
  
  public int getPlayMode()
  {
    return QQPlayerService.d();
  }
  
  public int getPlayState()
  {
    return QQPlayerService.c();
  }
  
  public String getToken()
  {
    return QQPlayerService.o();
  }
  
  public boolean isMusicFileValid(String paramString)
  {
    return QQPlayerService.b(paramString);
  }
  
  public boolean isPlaying()
  {
    return QQPlayerService.b();
  }
  
  public boolean isPlayingMySong(String paramString)
  {
    return QQPlayerService.a(paramString);
  }
  
  public void pausePlayMusic(Context paramContext)
  {
    QQPlayerService.c(paramContext);
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
    QQPlayerService.d(paramContext);
  }
  
  public void resumePlayMusic(Context paramContext, boolean paramBoolean)
  {
    QQPlayerService.a(paramContext, paramBoolean);
  }
  
  public void setPlayMode(int paramInt)
  {
    QQPlayerService.b(paramInt);
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
    QQPlayerService.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.api.impl.QQPlayerImpl
 * JD-Core Version:    0.7.0.1
 */