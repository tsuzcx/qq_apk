package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

public abstract interface IAudioPlayer
{
  public abstract int getCurrentPosition__();
  
  public abstract int getDuration__();
  
  public abstract String getPlayerId__();
  
  @IAudioPlayer.PlayerType
  public abstract int getPlayerType__();
  
  public abstract boolean isAudioPlayer__();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
 * JD-Core Version:    0.7.0.1
 */