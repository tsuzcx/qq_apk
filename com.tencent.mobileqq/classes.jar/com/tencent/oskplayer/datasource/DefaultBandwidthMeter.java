package com.tencent.oskplayer.datasource;

import android.os.Handler;
import com.tencent.oskplayer.util.Assertions;

public class DefaultBandwidthMeter
  implements BandwidthMeter
{
  public static final int DEFAULT_MAX_WEIGHT = 2000;
  private static long bitrateEstimate;
  private static int elapsedMs;
  private static long sBitrate;
  private long bytesAccumulator;
  private final Clock clock;
  private final Handler eventHandler;
  private final BandwidthMeter.EventListener eventListener;
  private final SlidingPercentile slidingPercentile;
  private long startTimeMs;
  private int streamCount;
  
  public DefaultBandwidthMeter()
  {
    this(null, null);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener)
  {
    this(paramHandler, paramEventListener, new SystemClock());
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt)
  {
    this(paramHandler, paramEventListener, new SystemClock(), paramInt);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, Clock paramClock)
  {
    this(paramHandler, paramEventListener, paramClock, 2000);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, Clock paramClock, int paramInt)
  {
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.clock = paramClock;
    this.slidingPercentile = new SlidingPercentile(paramInt);
    bitrateEstimate = -1L;
  }
  
  public static long getBitrate()
  {
    try
    {
      long l = sBitrate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getElapsedMs()
  {
    try
    {
      int i = elapsedMs;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void notifyBandwidthSample(int paramInt, long paramLong1, long paramLong2)
  {
    Handler localHandler = this.eventHandler;
    if ((localHandler != null) && (this.eventListener != null)) {
      localHandler.post(new DefaultBandwidthMeter.1(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long getBitrateEstimate()
  {
    try
    {
      long l = bitrateEstimate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBytesTransferred(int paramInt)
  {
    try
    {
      this.bytesAccumulator += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onTransferEnd()
  {
    for (;;)
    {
      float f;
      try
      {
        if (this.streamCount > 0)
        {
          bool = true;
          Assertions.checkState(bool);
          long l2 = this.clock.elapsedRealtime();
          elapsedMs = (int)(l2 - this.startTimeMs);
          if (elapsedMs > 0)
          {
            f = (float)(this.bytesAccumulator * 8000L / elapsedMs);
            this.slidingPercentile.addSample((int)Math.sqrt(this.bytesAccumulator), f);
            f = this.slidingPercentile.getPercentile(0.5F);
            if (!Float.isNaN(f)) {
              break label169;
            }
            l1 = -1L;
            bitrateEstimate = l1;
            sBitrate = bitrateEstimate;
            notifyBandwidthSample(elapsedMs, this.bytesAccumulator, bitrateEstimate);
          }
          this.streamCount -= 1;
          if (this.streamCount > 0) {
            this.startTimeMs = l2;
          }
          this.bytesAccumulator = 0L;
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label169:
      long l1 = f;
    }
  }
  
  public void onTransferStart()
  {
    try
    {
      if (this.streamCount == 0) {
        this.startTimeMs = this.clock.elapsedRealtime();
      }
      this.streamCount += 1;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultBandwidthMeter
 * JD-Core Version:    0.7.0.1
 */