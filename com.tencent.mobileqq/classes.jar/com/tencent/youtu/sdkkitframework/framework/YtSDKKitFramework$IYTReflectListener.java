package com.tencent.youtu.sdkkitframework.framework;

import android.graphics.ColorMatrixColorFilter;

public abstract interface YtSDKKitFramework$IYTReflectListener
{
  public abstract float onGetAppBrightness();
  
  public abstract void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat);
  
  public abstract void onReflectStart(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
 * JD-Core Version:    0.7.0.1
 */