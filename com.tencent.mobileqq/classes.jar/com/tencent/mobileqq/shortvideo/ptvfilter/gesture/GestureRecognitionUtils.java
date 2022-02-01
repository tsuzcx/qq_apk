package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.qphone.base.util.QLog;

public class GestureRecognitionUtils
{
  public static String[] a = { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X" };
  
  public static boolean a()
  {
    boolean bool = GestureMgr.e().b();
    if (!bool) {
      GestureMgr.e().c();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GestureRecognitionUtils check gestureResource ready ");
    localStringBuilder.append(bool);
    QLog.d("GestureRecognitionUtils", 2, localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils
 * JD-Core Version:    0.7.0.1
 */