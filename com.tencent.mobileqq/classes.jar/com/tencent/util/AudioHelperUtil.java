package com.tencent.util;

import com.tencent.qphone.base.util.QLog;

public class AudioHelperUtil
{
  static long a = 0L;
  
  public static long a()
  {
    try
    {
      long l = a;
      a += 1L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.AudioHelperUtil
 * JD-Core Version:    0.7.0.1
 */