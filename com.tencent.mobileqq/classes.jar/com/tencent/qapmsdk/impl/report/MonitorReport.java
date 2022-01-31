package com.tencent.qapmsdk.impl.report;

import android.os.Handler;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.meta.SingleItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
import java.util.Vector;

public class MonitorReport
{
  static volatile boolean hasReport = false;
  private static volatile MonitorReport instance = null;
  private Vector<TagItem> monitorItems = new Vector();
  private Vector<SingleItem> singleItems = new Vector();
  
  public static MonitorReport getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MonitorReport();
      }
      return instance;
    }
    finally {}
  }
  
  public void addMonitorMetric(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramLong3 - paramLong2 < 0L) {
      return;
    }
    TagItem localTagItem = new TagItem();
    localTagItem.duringTime = 0.0D;
    localTagItem.stage = paramString1;
    localTagItem.subStage = paramString2;
    localTagItem.extraInfo = "";
    localTagItem.eventTime = (paramLong2 / 1000.0D);
    localTagItem.tagId = paramLong1;
    localTagItem.type = 0;
    localTagItem.isSlow = paramBoolean;
    this.monitorItems.add(localTagItem);
    localTagItem = new TagItem();
    localTagItem.duringTime = (paramLong3 - paramLong2);
    localTagItem.stage = paramString1;
    localTagItem.subStage = paramString2;
    localTagItem.extraInfo = "";
    localTagItem.eventTime = (paramLong3 / 1000.0D);
    localTagItem.tagId = paramLong1;
    localTagItem.isSlow = paramBoolean;
    localTagItem.type = 1;
    this.monitorItems.add(localTagItem);
  }
  
  public void addMonitorSingle(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    SingleItem localSingleItem = new SingleItem();
    localSingleItem.costTime = paramLong1;
    localSingleItem.stage = paramString1;
    localSingleItem.extraData = paramString2;
    localSingleItem.eventTime = paramLong2;
    this.singleItems.add(localSingleItem);
  }
  
  public void doReport()
  {
    if (!hasReport)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(ReportRunnable.getInstance(), 5000L);
      hasReport = true;
    }
  }
  
  Vector<TagItem> getMonitorItems()
  {
    return this.monitorItems;
  }
  
  Vector<SingleItem> getSingleItems()
  {
    return this.singleItems;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.report.MonitorReport
 * JD-Core Version:    0.7.0.1
 */