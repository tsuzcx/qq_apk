package com.tencent.mobileqq.identification;

import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import java.util.Map;

public abstract interface RequestListener
{
  public abstract void handleEvent(Map<String, Object> paramMap);
  
  public abstract void onRequestFinish(int paramInt, Bundle paramBundle);
  
  public abstract void onUploadVideo();
  
  public abstract void updateLightReflect(ColorMatrixColorFilter paramColorMatrixColorFilter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.RequestListener
 * JD-Core Version:    0.7.0.1
 */