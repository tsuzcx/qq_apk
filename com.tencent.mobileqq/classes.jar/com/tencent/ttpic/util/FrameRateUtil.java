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
    if (RenderLevelHelper.getDowngradeLevel() != null)
    {
      if (this.listener == null) {
        return;
      }
      if (RenderLevelHelper.getDowngradeLevel().equals(RenderLevelHelper.DOWNGRADE_LEVEL.HIGH))
      {
        RenderLevelHelper.setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM);
        this.listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
        return;
      }
      if (RenderLevelHelper.getDowngradeLevel().equals(RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM))
      {
        RenderLevelHelper.setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL.LOW);
        this.listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
      }
    }
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
  
  /* Error */
  public void checkFps(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 120
    //   5: lload_1
    //   6: lsub
    //   7: lconst_0
    //   8: lcmp
    //   9: ifle +28 -> 37
    //   12: ldc2_w 122
    //   15: invokestatic 128	java/lang/Thread:sleep	(J)V
    //   18: goto +19 -> 37
    //   21: astore_3
    //   22: goto +11 -> 33
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 131	java/lang/InterruptedException:printStackTrace	()V
    //   30: goto +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	FrameRateUtil
    //   0	40	1	paramLong	long
    //   21	1	3	localObject	Object
    //   25	11	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   12	18	21	finally
    //   26	30	21	finally
    //   12	18	25	java/lang/InterruptedException
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
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("module: ");
          localStringBuilder.append(this.mOperation.tag);
          localStringBuilder.append(", my fps = ");
          localStringBuilder.append(l2);
          LogUtils.d(str, localStringBuilder.toString());
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
              int j = 0;
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
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setListener(FrameRateUtil.DowngradeListener paramDowngradeListener)
  {
    this.listener = paramDowngradeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtil
 * JD-Core Version:    0.7.0.1
 */