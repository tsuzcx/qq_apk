package com.tencent.mobileqq.together.api.impl;

import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.together.api.IQQPlayerServiceApi;

public class QQPlayerServiceApiImpl
  implements IQQPlayerServiceApi
{
  public String getQQPlayerServiceToken()
  {
    return QQPlayerService.o();
  }
  
  public boolean isListeningTogether()
  {
    return (QQMusicPlayService.c()) && (QQMusicPlayService.f() != null);
  }
  
  public boolean isPlayStateCompletion(int paramInt)
  {
    return paramInt == 8;
  }
  
  public boolean isPlayStateError(int paramInt)
  {
    return (paramInt == 5) || (paramInt == 7);
  }
  
  public boolean isPlayStatePause(int paramInt)
  {
    return paramInt == 3;
  }
  
  public boolean isPlayStatePlaying(int paramInt)
  {
    return paramInt == 2;
  }
  
  public boolean isPlayStateStop(int paramInt)
  {
    return paramInt == 4;
  }
  
  public boolean isQQPlayServicePlaying()
  {
    return (QQPlayerService.b()) && (QQPlayerService.g() != null);
  }
  
  public boolean isStateCompletion(int paramInt)
  {
    return paramInt == 8;
  }
  
  public boolean isStateError(int paramInt)
  {
    return paramInt == 5;
  }
  
  public boolean isStatePause(int paramInt)
  {
    return paramInt == 3;
  }
  
  public boolean isStatePlaying(int paramInt)
  {
    return paramInt == 2;
  }
  
  public boolean isStateStop(int paramInt)
  {
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.api.impl.QQPlayerServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */