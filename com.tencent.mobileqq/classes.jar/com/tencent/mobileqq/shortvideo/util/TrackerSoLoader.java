package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class TrackerSoLoader
{
  private static boolean a = false;
  
  public static boolean a()
  {
    boolean bool = false;
    if (a) {
      return true;
    }
    String str = PtvFilterSoLoad.d();
    if (str == null) {
      return false;
    }
    if (!FileUtils.a(str + "libObjectTracker.so")) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, " isTrackingSoExist =" + bool);
      }
      a = bool;
      return a;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.TrackerSoLoader
 * JD-Core Version:    0.7.0.1
 */