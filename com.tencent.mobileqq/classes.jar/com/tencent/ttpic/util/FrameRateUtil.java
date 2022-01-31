package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.util.RenderLevelHelper;
import com.tencent.ttpic.openapi.util.RenderLevelHelper.DOWNGRADE_LEVEL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FrameRateUtil
{
  private static ConcurrentHashMap<FrameRateUtil.Operation, FrameRateUtil> sSavedFrameRates = new ConcurrentHashMap();
  private int FPS_LIST_MAX_COUNT = 500;
  private final String TAG = FrameRateUtil.class.getSimpleName();
  private int batchRecordCount = 0;
  private long batchStartTime;
  private List<Long> fpsListForDataReport = new LinkedList();
  private List<Long> fpsListForDowngrade = new LinkedList();
  private FrameRateUtil.DowngradeListener listener;
  private FrameRateUtil.Operation mOperation;
  private long totalRecordStartTime = 0L;
  
  private FrameRateUtil(FrameRateUtil.Operation paramOperation)
  {
    this.mOperation = paramOperation;
  }
  
  private void downgrade()
  {
    if ((RenderLevelHelper.getDowngradeLevel() == null) || (this.listener == null)) {}
    do
    {
      return;
      if (RenderLevelHelper.getDowngradeLevel().equals(RenderLevelHelper.DOWNGRADE_LEVEL.HIGH))
      {
        RenderLevelHelper.setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM);
        this.listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
        return;
      }
    } while (!RenderLevelHelper.getDowngradeLevel().equals(RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM));
    RenderLevelHelper.setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL.LOW);
    this.listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
  }
  
  public static FrameRateUtil getInstance(FrameRateUtil.Operation paramOperation)
  {
    if (sSavedFrameRates.containsKey(paramOperation)) {
      return (FrameRateUtil)sSavedFrameRates.get(paramOperation);
    }
    FrameRateUtil localFrameRateUtil = new FrameRateUtil(paramOperation);
    sSavedFrameRates.put(paramOperation, localFrameRateUtil);
    return localFrameRateUtil;
  }
  
  public void checkFps(long paramLong)
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
  
  public void clearFpsList()
  {
    try
    {
      sSavedFrameRates.remove(this.mOperation);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<Long> getFpsListForDataReport()
  {
    return this.fpsListForDataReport;
  }
  
  public void recordFps(boolean paramBoolean)
  {
    int j = 0;
    try
    {
      if (this.totalRecordStartTime <= 0L) {
        this.totalRecordStartTime = System.currentTimeMillis();
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.totalRecordStartTime > 5000)
      {
        if (this.batchStartTime <= 0L) {
          this.batchStartTime = System.currentTimeMillis();
        }
        this.batchRecordCount += 1;
        if (this.batchRecordCount >= 30)
        {
          long l2 = 30000 / (l1 - this.batchStartTime);
          LogUtils.d(this.TAG, "module: " + this.mOperation.tag + ", my fps = " + l2);
          if (this.fpsListForDataReport.size() >= this.FPS_LIST_MAX_COUNT) {
            this.fpsListForDataReport.remove(0);
          }
          this.fpsListForDataReport.add(Long.valueOf(l2));
          if (paramBoolean)
          {
            this.fpsListForDowngrade.add(Long.valueOf(l2));
            if ((!RenderLevelHelper.getDowngradeLevel().equals(RenderLevelHelper.DOWNGRADE_LEVEL.LOW)) && (this.fpsListForDowngrade.size() >= 12))
            {
              Collections.sort(this.fpsListForDowngrade);
              int i = 4;
              while (i < this.fpsListForDowngrade.size() - 4)
              {
                j = (int)(j + ((Long)this.fpsListForDowngrade.get(i)).longValue());
                i += 1;
              }
              if (j / (this.fpsListForDowngrade.size() - 8) < 10)
              {
                downgrade();
                this.fpsListForDowngrade.clear();
              }
            }
          }
          this.batchStartTime = l1;
          this.batchRecordCount = 0;
        }
      }
      return;
    }
    finally {}
  }
  
  public void setListener(FrameRateUtil.DowngradeListener paramDowngradeListener)
  {
    this.listener = paramDowngradeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtil
 * JD-Core Version:    0.7.0.1
 */