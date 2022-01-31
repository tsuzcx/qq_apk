package com.tencent.qgplayer.rtmpsdk;

import android.os.Bundle;

public abstract interface IQGPlayListener
{
  public abstract void onPlayEvent(int paramInt, Bundle paramBundle);
  
  public abstract void onPlayerStatus(int paramInt, Bundle paramBundle);
  
  public abstract void onStatusChanged(QGAVProfile paramQGAVProfile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.IQGPlayListener
 * JD-Core Version:    0.7.0.1
 */