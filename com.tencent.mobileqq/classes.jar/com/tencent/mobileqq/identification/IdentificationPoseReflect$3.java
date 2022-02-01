package com.tencent.mobileqq.identification;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;

class IdentificationPoseReflect$3
  implements YtSDKKitFramework.IYTReflectListener
{
  IdentificationPoseReflect$3(IdentificationPoseReflect paramIdentificationPoseReflect) {}
  
  public float onGetAppBrightness()
  {
    return 0.0F;
  }
  
  public void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat)
  {
    IdentificationPoseReflect.a(this.a, new IdentificationPoseReflect.3.1(this, paramColorMatrixColorFilter));
  }
  
  public void onReflectStart(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect.3
 * JD-Core Version:    0.7.0.1
 */