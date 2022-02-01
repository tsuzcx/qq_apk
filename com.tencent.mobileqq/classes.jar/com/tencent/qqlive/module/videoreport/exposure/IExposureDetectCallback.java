package com.tencent.qqlive.module.videoreport.exposure;

import android.view.View;
import androidx.annotation.NonNull;

public abstract interface IExposureDetectCallback<T extends DetectionData>
{
  public abstract T createDetectionData();
  
  public abstract boolean onEnter(View paramView, T paramT);
  
  public abstract void onExposed(View paramView, T paramT, @NonNull AreaInfo paramAreaInfo);
  
  public abstract void onLeave(View paramView, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
 * JD-Core Version:    0.7.0.1
 */