package com.tencent.rfw.barrage.inject;

import com.tencent.rfw.barrage.util.RFWBarrageLogger;

public class RFWVideoBarrageConfig
{
  private static IRFWEnableHardwareAccelerateChecker a;
  private static boolean b;
  
  public static void a(RFWVideoBarrageConfig.ILogger paramILogger)
  {
    if (paramILogger != null) {
      RFWBarrageLogger.a(paramILogger);
    }
  }
  
  public static boolean a()
  {
    return (b) && (b());
  }
  
  private static boolean b()
  {
    IRFWEnableHardwareAccelerateChecker localIRFWEnableHardwareAccelerateChecker = a;
    if (localIRFWEnableHardwareAccelerateChecker != null) {
      return localIRFWEnableHardwareAccelerateChecker.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig
 * JD-Core Version:    0.7.0.1
 */