package com.tencent.mobileqq.danmaku.inject;

import com.tencent.mobileqq.danmaku.util.Logger;

public class VideoDanmakuConfig
{
  private static EnableHardwareAccelerateChecker jdField_a_of_type_ComTencentMobileqqDanmakuInjectEnableHardwareAccelerateChecker;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a(VideoDanmakuConfig.ILogger paramILogger)
  {
    if (paramILogger != null) {
      Logger.a(paramILogger);
    }
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (b());
  }
  
  private static boolean b()
  {
    if (jdField_a_of_type_ComTencentMobileqqDanmakuInjectEnableHardwareAccelerateChecker != null) {
      return jdField_a_of_type_ComTencentMobileqqDanmakuInjectEnableHardwareAccelerateChecker.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */