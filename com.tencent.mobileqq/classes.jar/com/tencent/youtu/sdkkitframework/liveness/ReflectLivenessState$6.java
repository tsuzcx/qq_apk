package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener;
import java.util.HashMap;

class ReflectLivenessState$6
  implements YTAGReflectLiveCheckInterface.IYTReflectListener
{
  ReflectLivenessState$6(ReflectLivenessState paramReflectLivenessState) {}
  
  public float onGetAppBrightness()
  {
    try
    {
      float f = YtFSM.getInstance().getContext().reflectListener.onGetAppBrightness();
      return f;
    }
    catch (Exception localException)
    {
      YtLogger.e(ReflectLivenessState.access$400(), localException.getLocalizedMessage());
    }
    return -1.0F;
  }
  
  public void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat)
  {
    try
    {
      if (!ReflectLivenessState.access$200(this.this$0).containsKey("refcontrol_begin"))
      {
        long l = System.currentTimeMillis();
        ReflectLivenessState.access$300(this.this$0).put("refcontrol_begin", String.valueOf(l * 1000L));
      }
      YtFSM.getInstance().getContext().reflectListener.onReflectEvent(paramColorMatrixColorFilter, paramFloat);
      return;
    }
    catch (Exception paramColorMatrixColorFilter)
    {
      YtLogger.e(ReflectLivenessState.access$400(), paramColorMatrixColorFilter.getLocalizedMessage());
    }
  }
  
  public void onReflectStart(long paramLong)
  {
    try
    {
      YtFSM.getInstance().getContext().reflectListener.onReflectStart(paramLong);
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(ReflectLivenessState.access$400(), localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.6
 * JD-Core Version:    0.7.0.1
 */