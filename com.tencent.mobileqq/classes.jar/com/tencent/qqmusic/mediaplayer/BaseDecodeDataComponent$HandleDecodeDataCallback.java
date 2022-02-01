package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;

abstract interface BaseDecodeDataComponent$HandleDecodeDataCallback
{
  public abstract long getCurPositionByDecoder();
  
  public abstract long getMinPcmBufferSize();
  
  public abstract void onAudioTrackChanged(AudioTrack paramAudioTrack);
  
  public abstract void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2);
  
  public abstract int pullDecodeData(int paramInt, byte[] paramArrayOfByte);
  
  public abstract int seekTo(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
 * JD-Core Version:    0.7.0.1
 */