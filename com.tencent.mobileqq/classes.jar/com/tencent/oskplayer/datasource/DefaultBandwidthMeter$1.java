package com.tencent.oskplayer.datasource;

class DefaultBandwidthMeter$1
  implements Runnable
{
  DefaultBandwidthMeter$1(DefaultBandwidthMeter paramDefaultBandwidthMeter, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    DefaultBandwidthMeter.access$000(this.this$0).onBandwidthSample(this.val$elapsedMs, this.val$bytes, this.val$bitrate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultBandwidthMeter.1
 * JD-Core Version:    0.7.0.1
 */