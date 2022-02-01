package com.tencent.mobileqq.kandian.base.bandwidth;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoPreloadStrategyConoller
{
  private static VideoPreloadStrategyConoller a;
  
  private int a(String paramString)
  {
    return Math.round(((Float)RIJSPUtils.a(a(paramString), Float.valueOf(0.0F))).floatValue());
  }
  
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
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_watch_length");
    return localStringBuilder.toString();
  }
  
  private boolean a(String paramString)
  {
    return BandWidthConfig.a.a(paramString);
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = a(paramString);
    int j = BandWidthConfig.a.e();
    int k = BandWidthConfig.a.f();
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
  
  public void a(String paramString, int paramInt)
  {
    float f = ((Float)RIJSPUtils.a(a(paramString), Float.valueOf(0.0F))).floatValue();
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
  
  public boolean a(int paramInt)
  {
    long l1 = BandwidthPredictor.from().getCurrentPrediction();
    float f = BandWidthConfig.a.a();
    int i = BandWidthConfig.a.d();
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
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.b() > 0L)) {
      i = paramVideoPlayerWrapper.a;
    } else {
      i = 0;
    }
    return a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller
 * JD-Core Version:    0.7.0.1
 */