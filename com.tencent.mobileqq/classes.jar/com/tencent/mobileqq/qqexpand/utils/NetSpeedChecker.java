package com.tencent.mobileqq.qqexpand.utils;

import android.net.TrafficStats;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/NetSpeedChecker;", "", "()V", "computeDownloadLeftTime", "", "interval", "bytes", "", "startSize", "", "computeNetworkData", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class NetSpeedChecker
{
  public static final NetSpeedChecker.Companion a = new NetSpeedChecker.Companion(null);
  
  private final double a(long paramLong)
  {
    double d = (TrafficStats.getTotalRxBytes() - paramLong) / 1024;
    Double.isNaN(d);
    return d * 1.0D;
  }
  
  public final double a(double paramDouble, int paramInt, long paramLong)
  {
    double d = a(paramLong);
    paramDouble = d / paramDouble;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadData ");
    localStringBuilder.append(d);
    localStringBuilder.append(" speed ");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" kb/s bytes ");
    localStringBuilder.append(paramInt);
    QLog.d("NetSpeedChecker", 4, localStringBuilder.toString());
    d = paramInt / 1024;
    Double.isNaN(d);
    return d / paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.NetSpeedChecker
 * JD-Core Version:    0.7.0.1
 */