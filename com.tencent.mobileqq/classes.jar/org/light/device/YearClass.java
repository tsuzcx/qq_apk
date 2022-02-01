package org.light.device;

import android.content.Context;
import java.util.ArrayList;
import org.light.utils.LightLogUtil;

public class YearClass
{
  public static final int CLASS_UNKNOWN = -1;
  private static final String TAG = "Phone_year";
  private static long mCPUMaxFreq = 0L;
  private static int mCoreNum = 0;
  private static long mTotalMem = 0L;
  private static volatile Integer mYearCategory;
  private static int sBaseYear = 2012;
  private static float sCpuRate = 0.5F;
  
  private static int categorizeByYear(Context paramContext)
  {
    int j = getClockSpeedYear();
    int k = getRamYear(paramContext);
    int i = -1;
    if ((j != -1) || (-1 != k))
    {
      float f;
      if (j >= sBaseYear) {
        f = j * sCpuRate;
      } else {
        f = 0.0F;
      }
      if (f <= 0.0F) {
        f = k;
      } else if (k >= sBaseYear) {
        f += k * (1.0F - sCpuRate);
      } else {
        f = j;
      }
      i = (int)(f + 0.5F);
    }
    paramContext = new StringBuilder();
    paramContext.append("手机配置所属年份为：");
    paramContext.append(i);
    paramContext.append(",cpuYear:");
    paramContext.append(j);
    paramContext.append(",ramYear:");
    paramContext.append(k);
    LightLogUtil.i("Phone_year", paramContext.toString());
    return i;
  }
  
  private static void conditionallyAdd(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramInt != -1) {
      paramArrayList.add(Integer.valueOf(paramInt));
    }
  }
  
  public static int get(Context paramContext)
  {
    if (mYearCategory == null)
    {
      if (paramContext == null) {
        return -1;
      }
      try
      {
        if (mYearCategory == null) {
          mYearCategory = Integer.valueOf(categorizeByYear(paramContext));
        }
      }
      finally {}
    }
    return mYearCategory.intValue();
  }
  
  private static int getClockSpeedYear()
  {
    mCPUMaxFreq = LightDeviceUtils.getMaxCpuFreq();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cpuMaxHZ:");
    localStringBuilder.append(mCPUMaxFreq);
    LightLogUtil.i("Phone_year", localStringBuilder.toString());
    long l = mCPUMaxFreq;
    if (l <= 0L) {
      return -1;
    }
    return CPUYearList.getCPUOclock(l);
  }
  
  private static int getNumCoresYear()
  {
    mCoreNum = LightDeviceUtils.getNumCores();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("corenum:");
    localStringBuilder.append(mCoreNum);
    LightLogUtil.i("Phone_year", localStringBuilder.toString());
    return CPUYearList.getCoreNumYear(mCoreNum);
  }
  
  public static String getPhonHWInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CPU core num:");
    localStringBuilder.append(mCoreNum);
    localStringBuilder.append(",CPU max freq:");
    localStringBuilder.append(mCPUMaxFreq);
    localStringBuilder.append(",total memory:");
    localStringBuilder.append(mTotalMem);
    return localStringBuilder.toString();
  }
  
  private static int getRamYear(Context paramContext)
  {
    long l = LightDeviceUtils.getTotalRamMemory(paramContext);
    mTotalMem = l;
    paramContext = new StringBuilder();
    paramContext.append("ramSize:");
    paramContext.append(mTotalMem);
    LightLogUtil.i("Phone_year", paramContext.toString());
    if (mTotalMem <= 0L) {
      return -1;
    }
    return RamYearList.getRamYear(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.YearClass
 * JD-Core Version:    0.7.0.1
 */