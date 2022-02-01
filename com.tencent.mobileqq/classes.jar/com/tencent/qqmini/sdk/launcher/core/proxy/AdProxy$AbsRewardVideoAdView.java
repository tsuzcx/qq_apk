package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public abstract class AdProxy$AbsRewardVideoAdView
{
  public static final String REALTIME_TAG = "RealTimeRewardedVideoAdPlugin";
  public long loadInterval = 9223372036854775807L;
  public long loadTime = 0L;
  
  public AdProxy$AbsRewardVideoAdView(AdProxy paramAdProxy) {}
  
  public abstract void loadAD(Context paramContext);
  
  public boolean needToLoadNewAd()
  {
    long l = System.currentTimeMillis() / 1000L;
    boolean bool;
    if (l - this.loadTime >= this.loadInterval) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needToLoadNewAd currTime:");
    localStringBuilder.append(l);
    localStringBuilder.append(" loadTime:");
    localStringBuilder.append(this.loadTime);
    localStringBuilder.append(" loadInterval:");
    localStringBuilder.append(this.loadInterval);
    localStringBuilder.append(" result:");
    localStringBuilder.append(bool);
    QMLog.d("RealTimeRewardedVideoAdPlugin", localStringBuilder.toString());
    return bool;
  }
  
  public abstract void showAD(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView
 * JD-Core Version:    0.7.0.1
 */