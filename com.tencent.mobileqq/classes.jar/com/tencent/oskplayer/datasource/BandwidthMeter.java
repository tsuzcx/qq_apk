package com.tencent.oskplayer.datasource;

public abstract interface BandwidthMeter
  extends TransferListener
{
  public static final long NO_ESTIMATE = -1L;
  
  public abstract long getBitrateEstimate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.BandwidthMeter
 * JD-Core Version:    0.7.0.1
 */