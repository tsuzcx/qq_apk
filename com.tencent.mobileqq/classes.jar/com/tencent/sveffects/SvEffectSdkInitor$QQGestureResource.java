package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;

public class SvEffectSdkInitor$QQGestureResource
  implements GestureResource
{
  public static String a = "5";
  public static String b = "200";
  public static String c = "20";
  public static boolean d = false;
  
  public String getGestureGapFrame()
  {
    return a;
  }
  
  public String getGestureGapTime()
  {
    return b;
  }
  
  public boolean getGestureShouldUpload()
  {
    return d;
  }
  
  public String getGestureThreadColdTime()
  {
    return c;
  }
  
  public String getModelPath()
  {
    return GestureUtil.a();
  }
  
  public String getSoPathDir()
  {
    return GestureUtil.b();
  }
  
  public boolean isGestureEnable()
  {
    return GestureMgr.e().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource
 * JD-Core Version:    0.7.0.1
 */