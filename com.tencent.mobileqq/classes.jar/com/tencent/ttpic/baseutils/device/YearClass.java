package com.tencent.ttpic.baseutils.device;

import java.util.ArrayList;

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
  
  private static void conditionallyAdd(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramInt != -1) {
      paramArrayList.add(Integer.valueOf(paramInt));
    }
  }
  
  public static String getPhonHWInfo()
  {
    return "CPU core num:" + mCoreNum + ",CPU max freq:" + mCPUMaxFreq + ",total memory:" + mTotalMem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.YearClass
 * JD-Core Version:    0.7.0.1
 */