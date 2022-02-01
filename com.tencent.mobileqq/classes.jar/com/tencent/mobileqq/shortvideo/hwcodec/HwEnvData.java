package com.tencent.mobileqq.shortvideo.hwcodec;

import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

public class HwEnvData
{
  public static int a;
  public static boolean a;
  public static boolean b = false;
  
  static
  {
    jdField_a_of_type_Int = 1500;
    jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + jdField_a_of_type_Boolean);
    }
    boolean bool = CameraCompatibleList.a(CameraCompatibleList.r);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:black=" + bool);
      }
    }
    while (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportPre_SendEncode=" + b + "dpcSupportHwCodec=" + jdField_a_of_type_Boolean);
    }
    if (Build.VERSION.SDK_INT < 18) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          bool = CameraCompatibleList.e(CameraCompatibleList.o);
          if (!bool) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool);
        return false;
        bool = CameraCompatibleList.a(CameraCompatibleList.r);
        if (!bool) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool + " hardware Black");
      return false;
    } while ((!b) || (!jdField_a_of_type_Boolean));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData
 * JD-Core Version:    0.7.0.1
 */