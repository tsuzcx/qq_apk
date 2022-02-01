package com.tencent.mobileqq.music;

public abstract interface QQPlayerCallback
{
  public abstract String getToken();
  
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerCallback
 * JD-Core Version:    0.7.0.1
 */