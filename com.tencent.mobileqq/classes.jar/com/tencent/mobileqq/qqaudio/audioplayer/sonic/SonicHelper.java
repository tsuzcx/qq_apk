package com.tencent.mobileqq.qqaudio.audioplayer.sonic;

import com.tencent.mobileqq.qqaudio.QQAudioReporter;
import com.tencent.qphone.base.util.QLog;

public class SonicHelper
{
  public static float a;
  private static boolean a;
  public static float b;
  public static float c;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
    b = 1.5F;
    c = 1.8F;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      System.loadLibrary("sonic");
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sonic", 2, "load error:" + localThrowable.toString());
      }
      jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      QQAudioReporter.a(jdField_a_of_type_Boolean);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(float paramFloat)
  {
    return (paramFloat > 1.0F) && (Math.abs(paramFloat - 1.0F) > 0.0F);
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-006F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper
 * JD-Core Version:    0.7.0.1
 */