package com.tencent.rtmp;

import android.os.Bundle;

public abstract interface ITXLivePlayListener
{
  public abstract void onNetStatus(Bundle paramBundle);
  
  public abstract void onPlayEvent(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.ITXLivePlayListener
 * JD-Core Version:    0.7.0.1
 */