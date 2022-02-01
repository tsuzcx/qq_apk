package com.tencent.sveffects;

import bczy;
import bdaf;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;

public class SvEffectSdkInitor$QQGestureResource
  implements GestureResource
{
  public static String mGestureGapFrame = "5";
  public static String mGestureGapTime = "200";
  public static boolean mGestureShouldUpload;
  public static String mGestureThreadColdTime = "20";
  
  public String getGestureGapFrame()
  {
    return mGestureGapFrame;
  }
  
  public String getGestureGapTime()
  {
    return mGestureGapTime;
  }
  
  public boolean getGestureShouldUpload()
  {
    return mGestureShouldUpload;
  }
  
  public String getGestureThreadColdTime()
  {
    return mGestureThreadColdTime;
  }
  
  public String getModelPath()
  {
    return bdaf.a();
  }
  
  public String getSoPathDir()
  {
    return bdaf.b();
  }
  
  public boolean isGestureEnable()
  {
    return bczy.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource
 * JD-Core Version:    0.7.0.1
 */