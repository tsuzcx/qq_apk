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
  
  /* Error */
  public static void checkFps(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 20
    //   6: lload_0
    //   7: lsub
    //   8: lconst_0
    //   9: lcmp
    //   10: ifle +29 -> 39
    //   13: ldc2_w 76
    //   16: invokestatic 82	java/lang/Thread:sleep	(J)V
    //   19: goto +20 -> 39
    //   22: astore_2
    //   23: goto +11 -> 34
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 85	java/lang/InterruptedException:printStackTrace	()V
    //   31: goto +8 -> 39
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramLong	long
    //   22	1	2	localObject	Object
    //   26	12	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   13	19	22	finally
    //   27	31	22	finally
    //   13	19	26	java/lang/InterruptedException
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
    Object localObject = mDowngradeLevel;
    if (localObject != null)
    {
      if (listener == null) {
        return;
      }
      if (((FrameRateUtilForWesee.DOWNGRADE_LEVEL)localObject).equals(FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH))
      {
        mDowngradeLevel = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
        listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
      }
      else if (mDowngradeLevel.equals(FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM))
      {
        mDowngradeLevel = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
        listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downgrade] ");
      localStringBuilder.append(mDowngradeLevel.value);
      Log.d((String)localObject, localStringBuilder.toString());
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
    } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
      localDOWNGRADE_LEVEL1 = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
    } else {
      localDOWNGRADE_LEVEL1 = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
    }
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL2 = getScreenLevel();
    if (localDOWNGRADE_LEVEL1.value > localDOWNGRADE_LEVEL2.value) {
      return localDOWNGRADE_LEVEL1;
    }
    return localDOWNGRADE_LEVEL2;
  }
  
  @NonNull
  public static FrameRateUtilForWesee.DOWNGRADE_LEVEL getRenderLevel()
  {
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = mDowngradeLevel;
    if (localDOWNGRADE_LEVEL != null) {
      return localDOWNGRADE_LEVEL;
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
    if (paramRenderLevelType == FrameRateUtilForWesee.RenderLevelType.PUDDING)
    {
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
      } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
      } else {
        paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
      }
    }
    else if (DeviceUtils.hasDeviceVHigh(AEModule.getContext())) {
      paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.HIGH;
    } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
      paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.MEDIUM;
    } else {
      paramRenderLevelType = FrameRateUtilForWesee.DOWNGRADE_LEVEL.LOW;
    }
    FrameRateUtilForWesee.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = getScreenLevel();
    if (paramRenderLevelType.value <= localDOWNGRADE_LEVEL.value) {
      paramRenderLevelType = localDOWNGRADE_LEVEL;
    }
    setDowngradeLevel(paramRenderLevelType);
  }
  
  public static long recordFps(boolean paramBoolean)
  {
    try
    {
      if (totalRecordStartTime <= 0L) {
        totalRecordStartTime = System.currentTimeMillis();
      }
      long l1 = System.currentTimeMillis();
      if (l1 - totalRecordStartTime > 5000L)
      {
        if (batchStartTime <= 0L) {
          batchStartTime = System.currentTimeMillis();
        }
        batchRecordCount += 1;
        if (batchRecordCount >= 30)
        {
          long l2 = 30000L / (l1 - batchStartTime);
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("my fps = ");
          localStringBuilder.append(l2);
          Log.e(str, localStringBuilder.toString());
          if (fpsListForDataReport.size() >= FPS_LIST_MAX_COUNT) {
            fpsListForDataReport.remove(0);
          }
          fpsListForDataReport.add(Long.valueOf(l2));
          if (paramBoolean)
          {
            fpsListForDowngrade.add(Long.valueOf(l2));
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
          batchStartTime = l1;
          batchRecordCount = 0;
          return l2;
        }
      }
      return 0L;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtilForWesee
 * JD-Core Version:    0.7.0.1
 */