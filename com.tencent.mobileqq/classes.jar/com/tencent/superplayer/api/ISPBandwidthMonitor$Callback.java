package com.tencent.superplayer.api;

import java.util.Map;

public abstract interface ISPBandwidthMonitor$Callback
{
  public abstract void onBandwidthUpdate(Map<String, ISPBandwidthMonitor.Stat> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPBandwidthMonitor.Callback
 * JD-Core Version:    0.7.0.1
 */