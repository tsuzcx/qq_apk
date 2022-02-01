package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class DetectionPolicy
{
  private static final String TAG = "DetectionPolicy";
  @DetectionMode
  private static int sCurrentMode = 0;
  private static DefaultPolicy sDefaultPolicy = new DefaultPolicy();
  private static IDetectionPolicy sDetectionImpl = sDefaultPolicy;
  
  public static void addBlacklist(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBlacklist: activity = ");
      localStringBuilder.append(paramActivity);
      Log.i("DetectionPolicy", localStringBuilder.toString());
      if (sCurrentMode != 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addBlacklist: currentMode = ");
        localStringBuilder.append(sCurrentMode);
        localStringBuilder.append(" is not BLACKLIST");
        Log.e("DetectionPolicy", localStringBuilder.toString());
      }
    }
    DetectionPolicy.BlacklistPolicyHolder.access$000().addBlacklist(paramActivity);
  }
  
  public static void addWhitelist(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWhitelist: activity = ");
      localStringBuilder.append(paramActivity);
      Log.i("DetectionPolicy", localStringBuilder.toString());
      if (sCurrentMode != 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addBlacklist: currentMode = ");
        localStringBuilder.append(sCurrentMode);
        localStringBuilder.append(" is not WHITELIST");
        Log.e("DetectionPolicy", localStringBuilder.toString());
      }
    }
    DetectionPolicy.WhitelistPolicyHolder.access$100().addWhitelist(paramActivity);
  }
  
  public static boolean isAbleToDetect(Activity paramActivity)
  {
    return sDetectionImpl.isAbleToDetect(paramActivity);
  }
  
  public static void setDetectionMode(@DetectionMode int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        sCurrentMode = 0;
        sDetectionImpl = sDefaultPolicy;
        return;
      }
      sCurrentMode = 2;
      sDetectionImpl = DetectionPolicy.WhitelistPolicyHolder.access$100();
      return;
    }
    sCurrentMode = 1;
    sDetectionImpl = DetectionPolicy.BlacklistPolicyHolder.access$000();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectionPolicy
 * JD-Core Version:    0.7.0.1
 */