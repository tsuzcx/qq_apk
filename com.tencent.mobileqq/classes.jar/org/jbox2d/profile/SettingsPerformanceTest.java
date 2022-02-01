package org.jbox2d.profile;

public abstract class SettingsPerformanceTest
  extends BasicPerformanceTest
{
  private static int NUM_TESTS = 8;
  
  public SettingsPerformanceTest(int paramInt)
  {
    super(NUM_TESTS, paramInt);
  }
  
  public String getTestName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return "All optimizations on";
    case 6: 
      return "Sincos lookup table";
    case 5: 
      return "Fast round";
    case 4: 
      return "Fast floor";
    case 3: 
      return "Fast ceil";
    case 2: 
      return "Fast atan2";
    case 1: 
      return "Fast abs";
    }
    return "No optimizations";
  }
  
  public abstract void runBenchmarkWorld();
  
  public void runTest(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    org.jbox2d.common.Settings.FAST_ABS = bool1;
    if (paramInt == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    org.jbox2d.common.Settings.FAST_ATAN2 = bool1;
    if (paramInt == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    org.jbox2d.common.Settings.FAST_CEIL = bool1;
    if (paramInt == 4) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    org.jbox2d.common.Settings.FAST_FLOOR = bool1;
    if (paramInt == 5) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    org.jbox2d.common.Settings.FAST_ROUND = bool1;
    boolean bool1 = bool2;
    if (paramInt == 6) {
      bool1 = true;
    }
    org.jbox2d.common.Settings.SINCOS_LUT_ENABLED = bool1;
    if (paramInt == 7)
    {
      org.jbox2d.common.Settings.FAST_ABS = true;
      org.jbox2d.common.Settings.FAST_ATAN2 = true;
      org.jbox2d.common.Settings.FAST_CEIL = true;
      org.jbox2d.common.Settings.FAST_FLOOR = true;
      org.jbox2d.common.Settings.FAST_ROUND = true;
      org.jbox2d.common.Settings.SINCOS_LUT_ENABLED = true;
    }
    runBenchmarkWorld();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.profile.SettingsPerformanceTest
 * JD-Core Version:    0.7.0.1
 */