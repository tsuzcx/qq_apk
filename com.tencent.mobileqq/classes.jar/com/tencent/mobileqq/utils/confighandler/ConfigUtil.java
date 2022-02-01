package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.utils.QQAudioHelper;

public class ConfigUtil
{
  public static boolean isActivity(long paramLong1, long paramLong2)
  {
    long l = QQAudioHelper.a();
    return (paramLong1 < l) && (paramLong2 > l);
  }
  
  public static boolean isExpired(long paramLong)
  {
    return paramLong < QQAudioHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */