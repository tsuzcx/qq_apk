package com.tencent.ttpic.util;

public class NativeProperty
{
  private static final int ARM_FEATURE_ARMv7 = 1;
  private static final int ARM_FEATURE_NEON = 4;
  private static final int FAMILY_ARM = 1;
  private static final int FAMILY_ARM64 = 4;
  private static int cpuFamily = 1;
  private static int cpuFeature;
  
  public static int cpuFeature()
  {
    return cpuFeature;
  }
  
  public static boolean hasNeonFeature()
  {
    cpuFeature = nGetCpuInfo();
    return (1 == cpuFamily) && ((cpuFeature & 0x4) != 0);
  }
  
  public static boolean isArmV7Feature()
  {
    return ((1 == cpuFamily) && ((cpuFeature & 0x1) != 0)) || (4 == cpuFamily);
  }
  
  private static native int nGetCpuInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.NativeProperty
 * JD-Core Version:    0.7.0.1
 */