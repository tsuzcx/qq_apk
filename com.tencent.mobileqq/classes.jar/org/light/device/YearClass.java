package org.light.device;

import android.content.Context;
import java.util.ArrayList;
import org.light.utils.LightLogUtil;

public class YearClass
{
  public static final int CLASS_UNKNOWN = -1;
  private static final String TAG = "Phone_year";
  private static long mCPUMaxFreq = 0L;
  private static int mCoreNum;
  private static long mTotalMem = 0L;
  private static volatile Integer mYearCategory;
  private static int sBaseYear;
  private static float sCpuRate = 0.5F;
  
  static
  {
    sBaseYear = 2012;
    mCoreNum = 0;
  }
  
  private static int categorizeByYear(Context paramContext)
  {
    int i = -1;
    int j = getClockSpeedYear();
    int k = getRamYear(paramContext);
    if ((j == -1) && (-1 == k))
    {
      LightLogUtil.i("Phone_year", "手机配置所属年份为：" + i + ",cpuYear:" + j + ",ramYear:" + k);
      return i;
    }
    float f;
    if (j >= sBaseYear)
    {
      f = j * sCpuRate;
      label82:
      if (f > 0.0F) {
        break label106;
      }
      f = k;
    }
    for (;;)
    {
      i = (int)(f + 0.5F);
      break;
      f = 0.0F;
      break label82;
      label106:
      if (k >= sBaseYear) {
        f += k * (1.0F - sCpuRate);
      } else {
        f = j;
      }
    }
  }
  
  private static void conditionallyAdd(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramInt != -1) {
      paramArrayList.add(Integer.valueOf(paramInt));
    }
  }
  
  public static int get(Context paramContext)
  {
    if (mYearCategory == null) {
      if (paramContext == null) {
        return -1;
      }
    }
    try
    {
      if (mYearCategory == null) {
        mYearCategory = Integer.valueOf(categorizeByYear(paramContext));
      }
      return mYearCategory.intValue();
    }
    finally {}
  }
  
  private static int getClockSpeedYear()
  {
    mCPUMaxFreq = LightDeviceUtils.getMaxCpuFreq();
    LightLogUtil.i("Phone_year", "cpuMaxHZ:" + mCPUMaxFreq);
    if (mCPUMaxFreq <= 0L) {
      return -1;
    }
    return CPUYearList.getCPUOclock(mCPUMaxFreq);
  }
  
  private static int getNumCoresYear()
  {
    mCoreNum = LightDeviceUtils.getNumCores();
    LightLogUtil.i("Phone_year", "corenum:" + mCoreNum);
    return CPUYearList.getCoreNumYear(mCoreNum);
  }
  
  public static String getPhonHWInfo()
  {
    return "CPU core num:" + mCoreNum + ",CPU max freq:" + mCPUMaxFreq + ",total memory:" + mTotalMem;
  }
  
  private static int getRamYear(Context paramContext)
  {
    long l = LightDeviceUtils.getTotalRamMemory(paramContext);
    mTotalMem = l;
    LightLogUtil.i("Phone_year", "ramSize:" + mTotalMem);
    if (mTotalMem <= 0L) {
      return -1;
    }
    return RamYearList.getRamYear(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.device.YearClass
 * JD-Core Version:    0.7.0.1
 */