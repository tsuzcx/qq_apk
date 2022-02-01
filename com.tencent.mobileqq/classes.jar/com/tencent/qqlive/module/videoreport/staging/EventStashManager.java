package com.tencent.qqlive.module.videoreport.staging;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.staging.data.StashEvent;
import com.tencent.qqlive.module.videoreport.storage.DataStorageFactory;
import com.tencent.qqlive.module.videoreport.storage.IDataStorage;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventStashManager
  extends DefaultEventListener
{
  private static final String TAG = "EventStashManager";
  private volatile boolean mLaunchReported;
  private Map<String, StashEvent> mPendingStashEvents;
  private IDataStorage mStorage;
  
  public static EventStashManager getInstance()
  {
    return EventStashManager.InstanceHolder.INSTANCE;
  }
  
  private void init()
  {
    this.mPendingStashEvents = new ConcurrentHashMap();
    this.mStorage = DataStorageFactory.getInstance(ReportUtils.getContext(), 1);
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private void movePendingToStore()
  {
    for (;;)
    {
      synchronized (this.mPendingStashEvents)
      {
        if (!this.mPendingStashEvents.isEmpty())
        {
          Object localObject1 = new HashMap(this.mPendingStashEvents);
          this.mPendingStashEvents.clear();
          if (localObject1 == null) {
            return;
          }
          ??? = new ArrayList(((Map)localObject1).keySet());
          localObject1 = new ArrayList(((Map)localObject1).values());
          this.mStorage.storeOrUpdate((List)localObject1, (List)???);
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  private void realCancelStashEvent(String paramString)
  {
    if (!this.mStorage.contains(StashEvent.class, paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("realRemoveStashEvent, not found stash event, stashKey: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", report stash event is ignored!");
      Log.i("EventStashManager", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realCancelStashEvent, remove stash event, stashKey: ");
    localStringBuilder.append(paramString);
    Log.i("EventStashManager", localStringBuilder.toString());
    this.mStorage.delete(StashEvent.class, paramString);
  }
  
  private void realReportEvent()
  {
    Object localObject1 = this.mStorage.loadAll(StashEvent.class);
    if (BaseUtils.isEmpty((Collection)localObject1))
    {
      Log.w("EventStashManager", "realReportEvent, stash event is empty, report stash event is ignored!");
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("realReportEvent, stash event count: ");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    Log.w("EventStashManager", ((StringBuilder)localObject2).toString());
    this.mStorage.deleteAll(StashEvent.class);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StashEvent)((Iterator)localObject1).next();
      FinalDataTarget.reportStashEvent(null, ((StashEvent)localObject2).getEventKey(), ((StashEvent)localObject2).getEventParams(), ((StashEvent)localObject2).getAppKey());
    }
  }
  
  private void realStashEvent(String paramString, StashEvent paramStashEvent)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realStashEvent, stash event, stashKey: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", stashEvent: ");
      localStringBuilder.append(paramStashEvent);
      Log.i("EventStashManager", localStringBuilder.toString());
    }
    if (!this.mLaunchReported) {
      this.mPendingStashEvents.put(paramString, paramStashEvent);
    } else {
      this.mStorage.storeOrUpdate(paramStashEvent, paramString);
    }
    reportStashEventIfNeed();
  }
  
  private void reportStashEventIfNeed()
  {
    ThreadUtils.execTask(new EventStashManager.3(this));
  }
  
  public void cancelStashEvent(String paramString, Map<String, Object> paramMap)
  {
    paramString = StashKeyExtractor.getStashKey(paramString, paramMap);
    if (paramString == null) {
      return;
    }
    ThreadUtils.execTask(new EventStashManager.2(this, paramString));
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    super.onActivityResume(paramActivity);
    reportStashEventIfNeed();
  }
  
  public void stashEvent(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    String str = StashKeyExtractor.getStashKey(paramString1, paramMap);
    if (str == null)
    {
      paramMap = new StringBuilder();
      paramMap.append("stashEvent, The event key: ");
      paramMap.append(paramString1);
      paramMap.append("hasn't specified stashId, stash event is ignored!");
      Log.w("EventStashManager", paramMap.toString());
      return;
    }
    ThreadUtils.execTask(new EventStashManager.1(this, str, new StashEvent(paramString1, paramMap, paramString2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.EventStashManager
 * JD-Core Version:    0.7.0.1
 */