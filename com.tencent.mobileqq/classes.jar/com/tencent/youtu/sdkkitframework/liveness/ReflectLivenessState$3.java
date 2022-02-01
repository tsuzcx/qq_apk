package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener;

class ReflectLivenessState$3
  implements YTAGReflectLiveCheckInterface.IYTReflectListener
{
  ReflectLivenessState$3(ReflectLivenessState paramReflectLivenessState) {}
  
  public void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    try
    {
      YtFSM.getInstance().getContext().reflectListener.onReflectEvent(paramColorMatrixColorFilter);
      return;
    }
    catch (Exception paramColorMatrixColorFilter)
    {
      YtLogger.e(ReflectLivenessState.access$100(), paramColorMatrixColorFilter.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.3
 * JD-Core Version:    0.7.0.1
 */