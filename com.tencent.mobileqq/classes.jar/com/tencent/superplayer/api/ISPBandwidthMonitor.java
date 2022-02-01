package com.tencent.superplayer.api;

import android.content.Context;

public abstract interface ISPBandwidthMonitor
{
  public static final long DEFAULE_INTERVAL = 60000L;
  public static final long ONE_MINUTE = 60000L;
  public static final long ONE_SECOND = 1000L;
  
  public abstract void start(Context paramContext, ISPBandwidthMonitor.Callback paramCallback, long paramLong);
  
  public abstract void stop(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPBandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */