package com.tencent.mobileqq.shortvideo.dancemachine;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.sveffects.SdkContext;

public class DisplayUtils
{
  private static float a = 0.0F;
  
  private static float a(float paramFloat)
  {
    if (a == 0.0F) {
      a = SdkContext.a().a().getResources().getDisplayMetrics().density;
    }
    return a * paramFloat + 0.5F;
  }
  
  public static int a(float paramFloat)
  {
    return (int)b(paramFloat);
  }
  
  private static float b(float paramFloat)
  {
    return a(paramFloat / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */