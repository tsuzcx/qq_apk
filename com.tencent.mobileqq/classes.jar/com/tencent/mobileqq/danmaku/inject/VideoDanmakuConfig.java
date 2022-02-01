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
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (b());
  }
  
  private static boolean b()
  {
    EnableHardwareAccelerateChecker localEnableHardwareAccelerateChecker = jdField_a_of_type_ComTencentMobileqqDanmakuInjectEnableHardwareAccelerateChecker;
    if (localEnableHardwareAccelerateChecker != null) {
      return localEnableHardwareAccelerateChecker.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */