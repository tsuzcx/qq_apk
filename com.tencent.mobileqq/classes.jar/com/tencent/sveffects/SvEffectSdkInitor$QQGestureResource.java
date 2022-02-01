package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;

public class SvEffectSdkInitor$QQGestureResource
  implements GestureResource
{
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "5";
    b = "200";
    c = "20";
    jdField_a_of_type_Boolean = false;
  }
  
  public String getGestureGapFrame()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String getGestureGapTime()
  {
    return b;
  }
  
  public boolean getGestureShouldUpload()
  {
    return jdField_a_of_type_Boolean;
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
    return GestureMgr.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource
 * JD-Core Version:    0.7.0.1
 */