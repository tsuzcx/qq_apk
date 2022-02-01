package com.tencent.qqlive.module.videoreport.staging;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomEventStagingManager
{
  private static final String TAG = "StagingManager";
  private List<CustomEventStagingData> mCustomEventStagingDataList = new CopyOnWriteArrayList();
  
  public static CustomEventStagingManager getInstance()
  {
    return CustomEventStagingManager.InstanceHolder.INSTANCE;
  }
  
  private boolean isDebug()
  {
    return VideoReportInner.getInstance().isDebugMode();
  }
  
  private boolean isStagingListEmpty()
  {
    return this.mCustomEventStagingDataList.isEmpty();
  }
  
  private void supplementStagingEvent()
  {
    try
    {
      if (this.mCustomEventStagingDataList.isEmpty())
      {
        Log.i("StagingManager", "supplementStagingEvent dataList is empty");
        return;
      }
      if (isDebug()) {
        Log.i("StagingManager", "supplementStagingEvent");
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mCustomEventStagingDataList.iterator();
      while (localIterator.hasNext())
      {
        CustomEventStagingData localCustomEventStagingData = (CustomEventStagingData)localIterator.next();
        VideoReportInner.getInstance().reportEvent(localCustomEventStagingData.getEventId(), localCustomEventStagingData.getObject(), localCustomEventStagingData.getMap());
        localArrayList.add(localCustomEventStagingData);
      }
      this.mCustomEventStagingDataList.removeAll(localArrayList);
      localArrayList.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void save(String paramString, @Nullable Object paramObject, Map<String, ?> paramMap)
  {
    if (isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eventId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ,object");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("map size:");
      localStringBuilder.append(paramMap.size());
      Log.i("StagingManager", localStringBuilder.toString());
    }
    this.mCustomEventStagingDataList.add(new CustomEventStagingData(paramString, paramObject, paramMap));
  }
  
  public void supplementReportsEvent()
  {
    if (isStagingListEmpty()) {
      return;
    }
    ThreadUtils.execTask(new CustomEventStagingManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager
 * JD-Core Version:    0.7.0.1
 */