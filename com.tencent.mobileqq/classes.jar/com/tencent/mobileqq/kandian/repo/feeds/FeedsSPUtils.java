package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FeedsSPUtils
{
  public static void a(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoWidthHeightRatio() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsShortVideoWidthHeightRatio() value=");
    localStringBuilder.append(paramFloat);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("readinjoy_short_video_width_height_ratio", paramFloat);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoMaxDrationLimit() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsShortVideoMaxDrationLimit() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_short_video_max_duration_limit", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_support", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_support", true);
  }
  
  public static float b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsShortVideoWidthHeightRatio() failed");
      return 0.0F;
    }
    float f = paramAppRuntime.getFloat("readinjoy_short_video_width_height_ratio", -1.0F);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoFeedsShortVideoWidthHeightRatio() result=");
    paramAppRuntime.append(f);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils
 * JD-Core Version:    0.7.0.1
 */