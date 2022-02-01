package com.tencent.ttpic.util;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.light.device.LightDeviceUtils;

public class FrameRateUtilForWesee
{
  private static final int BASE_COUNT = 6;
  private static final int FPS_AVG_FACTOR = 30;
  private static int FPS_LIST_MAX_COUNT = 500;
  private static final int FPS_REPORT_SKIP_TIME = 5000;
  public static final int MAX_FPS = 18;
  private static final String TAG = FrameRateUtil.class.getSimpleName();
  private static final long TIME_INTERVAL = 55L;
  private static int batchRecordCount = 0;
  private static long batchStartTime;
  private static int count;
  private static List<Long> fpsListForDataReport;
  private static List<Long> fpsListForDowngrade;
  private static FrameRateUtilForWesee.DowngradeListener listener;
  private static FrameRateUtilForWesee.DOWNGRADE_LEVEL mDowngradeLevel = null;
  public static int mFrameCount;
  public static long mRecordStartTime;
  public static boolean previewSizeSwitch = true;
  private static long start;
  private static long totalRecordStartTime = 0L;
  
  static
  {
    fpsListForDowngrade = new LinkedList();
    fpsListForDataReport = new LinkedList();
  }
  
  public static void checkFps(long paramLong)
  {
    if (55L - paramLong > 0L) {}
    try
    {
      Thread.sleep(100L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void clearFpsList()
  {
    try
    {
      LogUtils.d(TAG, "clearFpsList");
      fpsListForDowngrade.clear();
      fpsListForDataReport.clear();
      count = 0;
      batchStartTime = 0L;
      batchRecordCount = 0;
      totalRecordStartTime = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void downgrade()
  {
    if ((mDowngradeLevel == null) || (listener == null)) {
      return;
    }
    if (mDowngradeLevel.equals(FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH))
    {
      mDowngradeLevel = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
      listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
    }
    for (;;)
    {
      Log.d(TAG, "[downgrade] " + mDowngradeLevel.value);
      return;
      if (mDowngradeLevel.equals(FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM))
      {
        mDowngradeLevel = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
        listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
      }
    }
  }
  
  public static List<Long> getFpsListForDataReport()
  {
    return fpsListForDataReport;
  }
  
  public static FrameRateUtilForWesee.DOWNGRADE_LEVEL getInitRenderLevel()
  {
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL1;
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      localDOWNGRADE_LEVEL1 = FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
    }
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL2;
    for (;;)
    {
      localDOWNGRADE_LEVEL2 = getScreenLevel();
      if (localDOWNGRADE_LEVEL1.value <= localDOWNGRADE_LEVEL2.value) {
        break;
      }
      return localDOWNGRADE_LEVEL1;
      if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
        localDOWNGRADE_LEVEL1 = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
      } else {
        localDOWNGRADE_LEVEL1 = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
      }
    }
    return localDOWNGRADE_LEVEL2;
  }
  
  @NonNull
  public static FrameRateUtilForWesee.DOWNGRADE_LEVEL getRenderLevel()
  {
    if (mDowngradeLevel != null) {
      return mDowngradeLevel;
    }
    initRenderLevel(FrameRateUtilForWesee.RenderLevelType.PUDDING);
    return mDowngradeLevel;
  }
  
  public static FrameRateUtilForWesee.DOWNGRADE_LEVEL getScreenLevel()
  {
    int i = LightDeviceUtils.getScreenWidth(AEModule.getContext());
    if (i >= 1080) {
      return FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
    }
    if (i >= 720) {
      return FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
    }
    return FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
  }
  
  public static void initRenderLevel(FrameRateUtilForWesee.RenderLevelType paramRenderLevelType)
  {
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL;
    if (paramRenderLevelType == FrameRateUtilForWesee.RenderLevelType.PUDDING) {
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext()))
      {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
        localDOWNGRADE_LEVEL = getScreenLevel();
        if (paramRenderLevelType.value <= localDOWNGRADE_LEVEL.value) {
          break label102;
        }
      }
    }
    for (;;)
    {
      setDowngradeLevel(paramRenderLevelType);
      return;
      if (DeviceUtils.hasDeviceLow(AEModule.getContext()))
      {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
        break;
      }
      paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
      break;
      if (DeviceUtils.hasDeviceVHigh(AEModule.getContext()))
      {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
        break;
      }
      if (DeviceUtils.hasDeviceLow(AEModule.getContext()))
      {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
        break;
      }
      paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
      break;
      label102:
      paramRenderLevelType = localDOWNGRADE_LEVEL;
    }
  }
  
  public static long recordFps(boolean paramBoolean)
  {
    long l2 = 0L;
    try
    {
      if (totalRecordStartTime <= 0L) {
        totalRecordStartTime = System.currentTimeMillis();
      }
      long l3 = System.currentTimeMillis();
      long l1 = l2;
      if (l3 - totalRecordStartTime > 5000L)
      {
        if (batchStartTime <= 0L) {
          batchStartTime = System.currentTimeMillis();
        }
        batchRecordCount += 1;
        l1 = l2;
        if (batchRecordCount >= 30)
        {
          l1 = 30000L / (l3 - batchStartTime);
          Log.e(TAG, "my fps = " + l1);
          if (fpsListForDataReport.size() >= FPS_LIST_MAX_COUNT) {
            fpsListForDataReport.remove(0);
          }
          fpsListForDataReport.add(Long.valueOf(l1));
          if (paramBoolean)
          {
            fpsListForDowngrade.add(Long.valueOf(l1));
            if ((!mDowngradeLevel.equals(FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW)) && (fpsListForDowngrade.size() >= 12))
            {
              Collections.sort(fpsListForDowngrade);
              int i = 4;
              int j = 0;
              while (i < fpsListForDowngrade.size() - 4)
              {
                j = (int)(j + ((Long)fpsListForDowngrade.get(i)).longValue());
                i += 1;
              }
              if (j / (fpsListForDowngrade.size() - 8) < 10)
              {
                downgrade();
                fpsListForDowngrade.clear();
              }
            }
          }
          batchStartTime = l3;
          batchRecordCount = 0;
        }
      }
      return l1;
    }
    finally {}
  }
  
  private static void setDowngradeLevel(FrameRateUtilForWesee.DOWNGRADE_LEVEL paramDOWNGRADE_LEVEL)
  {
    mDowngradeLevel = paramDOWNGRADE_LEVEL;
  }
  
  public static void setListener(FrameRateUtilForWesee.DowngradeListener paramDowngradeListener)
  {
    listener = paramDowngradeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtilForWesee
 * JD-Core Version:    0.7.0.1
 */