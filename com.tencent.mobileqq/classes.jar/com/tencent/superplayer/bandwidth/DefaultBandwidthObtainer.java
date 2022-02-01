package com.tencent.superplayer.bandwidth;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.superplayer.utils.LogUtil;
import java.lang.reflect.Method;

public class DefaultBandwidthObtainer
  implements IBandwidthObtainer
{
  private static final String TAG = "DefaultBandwidthObtainer";
  private Method getLoopbackRxBytes;
  private Method getRxBytes;
  private long lastLoopBackBytes;
  private long lastTimeStamp = 0L;
  private long lastTotalRxBytes;
  
  @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
  private long getLoopbackRxBytesIn14()
  {
    try
    {
      if (this.getRxBytes == null)
      {
        this.getRxBytes = TrafficStats.class.getDeclaredMethod("getRxBytes", new Class[] { String.class });
        this.getRxBytes.setAccessible(true);
      }
      long l = ((Long)this.getRxBytes.invoke(null, new Object[] { "lo" })).longValue();
      return l;
    }
    catch (Exception localException)
    {
      LogUtil.e("DefaultBandwidthObtainer", "getLoopbackRxBytesIn14: ", localException);
    }
    return 0L;
  }
  
  @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
  private long getLoopbackRxBytesIn28()
  {
    try
    {
      if (this.getLoopbackRxBytes == null)
      {
        this.getLoopbackRxBytes = TrafficStats.class.getDeclaredMethod("getLoopbackRxBytes", new Class[0]);
        this.getLoopbackRxBytes.setAccessible(true);
      }
      long l = ((Long)this.getLoopbackRxBytes.invoke(null, new Object[0])).longValue();
      return l;
    }
    catch (Exception localException)
    {
      LogUtil.e("DefaultBandwidthObtainer", "getLoopbackRxBytesIn28: ", localException);
    }
    return 0L;
  }
  
  public long getCurrentBandwidth()
  {
    int i = Build.VERSION.SDK_INT;
    long l3 = SystemClock.elapsedRealtime();
    long l4 = TrafficStats.getTotalRxBytes();
    long l1;
    if (i >= 28) {
      l1 = getLoopbackRxBytesIn28();
    } else if (i >= 14) {
      l1 = getLoopbackRxBytesIn14();
    } else {
      l1 = 0L;
    }
    long l5 = this.lastTotalRxBytes;
    if (l5 > 0L)
    {
      l2 = this.lastLoopBackBytes;
      if (l2 > 0L)
      {
        l5 = l4 - l5;
        long l6 = l1 - l2;
        i = (int)Math.max((l3 - this.lastTimeStamp) / 1000L, 1L);
        l2 = Math.max(0L, (l5 - l6) / 1024L) / i;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("calculateBandwidth: totalBytes=");
        localStringBuilder.append(l5);
        localStringBuilder.append(", loopbackBytes=");
        localStringBuilder.append(l6);
        localStringBuilder.append(", bandwidth=");
        localStringBuilder.append(l2);
        localStringBuilder.append("kb/s");
        LogUtil.d("DefaultBandwidthObtainer", localStringBuilder.toString());
        break label199;
      }
    }
    long l2 = 0L;
    label199:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentBandwidth: bandwidth=");
    localStringBuilder.append(l2);
    localStringBuilder.append("kb/s");
    LogUtil.d("DefaultBandwidthObtainer", localStringBuilder.toString());
    this.lastTotalRxBytes = l4;
    this.lastLoopBackBytes = l1;
    this.lastTimeStamp = l3;
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.DefaultBandwidthObtainer
 * JD-Core Version:    0.7.0.1
 */