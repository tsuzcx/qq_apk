package com.tencent.qqlive.module.videoreport.utils;

import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.ActivityConfigurationChangedNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.DispatchTouchEventNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReusablePool
{
  private static final int MAX_LIST_SIZE = 30;
  private static final SparseArray<List<Object>> POOL = new SparseArray();
  private static final String TAG = "ReusablePool";
  public static final int TYPE_ACTIVITY_CONFIGURATION_CHANGED = 9;
  public static final int TYPE_DISPATCH_TOUCH_EVENT = 10;
  public static final int TYPE_FINAL_DATA_REUSE = 6;
  public static final int TYPE_LIST_SCROLL = 1;
  public static final int TYPE_RECYCLER_VIEW_SCROLL_POSITION = 7;
  public static final int TYPE_RECYCLER_VIEW_SET_ADAPTER = 2;
  public static final int TYPE_REPORT_DATA = 8;
  public static final int TYPE_VIEW_CLICK = 3;
  public static final int TYPE_VIEW_PAGER_SET_ADAPTER = 4;
  public static final int TYPE_VIEW_REUSE = 5;
  
  private static Object createObject(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 10: 
      return new DispatchTouchEventNotifier();
    case 9: 
      return new ActivityConfigurationChangedNotifier();
    case 8: 
      return new ReportData();
    case 7: 
      return new RecyclerViewScrollPositionNotifier();
    case 6: 
      return new FinalData();
    case 5: 
      return new ViewReuseNotifier();
    case 4: 
      return new ViewPagerSetAdapterNotifier();
    case 3: 
      return new ViewClickNotifier();
    case 2: 
      return new RecyclerViewSetAdapterNotifier();
    }
    return new ListScrollNotifier();
  }
  
  public static Object obtain(int paramInt)
  {
    synchronized (POOL)
    {
      Object localObject4 = (List)POOL.get(paramInt);
      Object localObject2;
      while ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        localObject2 = ((List)localObject4).remove(0);
        if (localObject2 != null)
        {
          if (VideoReportInner.getInstance().isDebugMode())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("obtain: reuse, reuseType = ");
            ((StringBuilder)localObject4).append(paramInt);
            Log.d("ReusablePool", ((StringBuilder)localObject4).toString());
          }
          return localObject2;
        }
      }
      ??? = createObject(paramInt);
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("obtain: create, reuseType = ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", reusable=");
        ((StringBuilder)localObject2).append(???);
        Log.d("ReusablePool", ((StringBuilder)localObject2).toString());
      }
      if (??? != null) {
        return ???;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Reusable reuseType illegal, reuseType = ");
      ((StringBuilder)???).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)???).toString());
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public static void recycle(Object paramObject, int paramInt)
  {
    synchronized (POOL)
    {
      Object localObject2 = (List)POOL.get(paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Collections.synchronizedList(new ArrayList());
        POOL.put(paramInt, localObject1);
      }
      if (((List)localObject1).size() < 30) {
        ((List)localObject1).add(paramObject);
      }
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recycle: reuseType = ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" list size=");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append("， reusable=");
        ((StringBuilder)localObject2).append(paramObject);
        Log.d("ReusablePool", ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ReusablePool
 * JD-Core Version:    0.7.0.1
 */