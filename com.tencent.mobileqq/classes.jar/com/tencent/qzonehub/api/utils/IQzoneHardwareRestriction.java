package com.tencent.qzonehub.api.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneHardwareRestriction
  extends QRouteApi
{
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files/";
  public static final int BUFFER_SIZE = 1024;
  public static final int HARDWARE_HIGHLEVEL = 2;
  public static final int HARDWARE_LOWLEVEL = 0;
  public static final int HARDWARE_MIDDLELEVEL = 1;
  public static final int HARDWARE_SUPERLEVEL = 3;
  public static final String TAG = "QzoneHardwareRestriction";
  
  public abstract boolean equalHardwareRestriction(int paramInt1, int paramInt2);
  
  public abstract long getAvailableMem();
  
  public abstract long getCpuMaxFreq();
  
  public abstract int getCurrentCpuFreSumLevel();
  
  public abstract int getCurrentCpuLevel();
  
  public abstract int getCurrentMemLevel();
  
  public abstract int getCurrentMemLevelNew();
  
  @SuppressLint({"NewApi"})
  public abstract int getNumberOfCores();
  
  public abstract long getSDCardAllSize();
  
  public abstract long getSDCardAvailableSize();
  
  public abstract long getSystemAvailableSize();
  
  public abstract long getTotalMem();
  
  public abstract boolean meetHardwareRestriction(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
 * JD-Core Version:    0.7.0.1
 */