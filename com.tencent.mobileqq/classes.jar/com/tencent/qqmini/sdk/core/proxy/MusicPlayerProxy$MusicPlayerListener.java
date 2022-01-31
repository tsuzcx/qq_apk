package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.core.model.SongInfo;

public abstract interface MusicPlayerProxy$MusicPlayerListener
{
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy.MusicPlayerListener
 * JD-Core Version:    0.7.0.1
 */