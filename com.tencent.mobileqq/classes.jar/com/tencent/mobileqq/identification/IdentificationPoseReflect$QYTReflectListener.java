package com.tencent.mobileqq.identification;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;

class IdentificationPoseReflect$QYTReflectListener
  implements YtSDKKitFramework.IYTReflectListener
{
  private IdentificationPoseReflect$QYTReflectListener(IdentificationPoseReflect paramIdentificationPoseReflect) {}
  
  public float onGetAppBrightness()
  {
    return 0.0F;
  }
  
  public void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat)
  {
    this.a.a(new IdentificationPoseReflect.QYTReflectListener.1(this, paramColorMatrixColorFilter));
  }
  
  public void onReflectStart(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect.QYTReflectListener
 * JD-Core Version:    0.7.0.1
 */