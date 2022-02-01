package com.tencent.mobileqq.kandian.base.bandwidth;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoPreloadStrategyConoller
{
  private static VideoPreloadStrategyConoller a;
  
  public static VideoPreloadStrategyConoller a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoPreloadStrategyConoller();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean a(String paramString)
  {
    return BandWidthConfig.a.b(paramString);
  }
  
  private int b(String paramString)
  {
    return Math.round(((Float)RIJSPUtils.b(c(paramString), Float.valueOf(0.0F))).floatValue());
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_watch_length");
    return localStringBuilder.toString();
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = b(paramString);
    int j = BandWidthConfig.a.g();
    int k = BandWidthConfig.a.h();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getForwardPredownloadCount: enable:true, prediction=");
      paramString.append(i);
      paramString.append(", curPosition=");
      paramString.append(paramInt);
      paramString.append(", maxPreloadCount = ");
      paramString.append(k);
      paramString.append(", defaultPreloadCount=");
      paramString.append(j);
      QLog.d("VideoPreloadStrategyConoller", 2, paramString.toString());
    }
    if ((i > paramInt) && (a("watch_length_predict_enable"))) {
      return Math.min(i - paramInt, k);
    }
    return j;
  }
  
  public boolean a(int paramInt)
  {
    long l1 = BandwidthPredictor.from().getCurrentPrediction();
    float f = BandWidthConfig.a.e();
    int i = BandWidthConfig.a.f();
    long l2 = ((float)l1 - paramInt / 8 * f);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPreloadEnable: bandwidth=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", birate=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", weight=");
      localStringBuilder.append(f);
      localStringBuilder.append(", idleBandwidth=");
      localStringBuilder.append(l2);
      localStringBuilder.append(", idleThreshold=");
      localStringBuilder.append(i);
      localStringBuilder.append(", enable=");
      localStringBuilder.append(a("idle_preload_limit_enable"));
      QLog.d("VideoPreloadStrategyConoller", 2, localStringBuilder.toString());
    }
    if ((l1 > 50L) && (paramInt > 0) && (a("idle_preload_limit_enable"))) {
      return l2 > i;
    }
    return NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    int i;
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.I() > 0L)) {
      i = paramVideoPlayerWrapper.d;
    } else {
      i = 0;
    }
    return a(i);
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(String paramString, int paramInt)
  {
    float f = ((Float)RIJSPUtils.b(c(paramString), Float.valueOf(0.0F))).floatValue();
    if (f > 0.0F) {
      f = paramInt * 0.5F + f * 0.5F;
    } else {
      f = paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_watch_length");
    RIJSPUtils.a(localStringBuilder.toString(), Float.valueOf(f));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("reoprt: currentPredition=");
      paramString.append(f);
      QLog.d("VideoPreloadStrategyConoller", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller
 * JD-Core Version:    0.7.0.1
 */