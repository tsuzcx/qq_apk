package com.tencent.qqlive.module.videoreport.report.element;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class PendingQueue
{
  private static final String TAG = "PendingQueue";
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private PendingQueue.OnQueueListener mOnQueueListener;
  private ArrayMap<Long, PendingQueue.PendingTask> mPendingTasks = new ArrayMap();
  
  void clearQueue()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  void enqueue(List<ExposureElementInfo> paramList, long paramLong)
  {
    if (paramList == null) {
      return;
    }
    this.mPendingTasks.clear();
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    while (i < j)
    {
      localObject3 = (ExposureElementInfo)paramList.get(i);
      localObject1 = ((ExposureElementInfo)localObject3).getView();
      localObject2 = ((ExposureElementInfo)paramList.get(i)).getFinalData();
      if ((localObject1 != null) && (localObject2 != null))
      {
        long l = Math.max(0L, ReportHelper.getExposureMinTime(DataBinder.getDataEntity(localObject1)) + paramLong);
        localObject2 = (PendingQueue.PendingTask)this.mPendingTasks.get(Long.valueOf(l));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new PendingQueue.PendingTask(this, null);
          this.mPendingTasks.put(Long.valueOf(l), localObject1);
        }
        ((PendingQueue.PendingTask)localObject1).add((ExposureElementInfo)localObject3);
      }
      i += 1;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramList = new StringBuilder();
      paramList.append("enqueue: mPendingTasks.size() = ");
      paramList.append(this.mPendingTasks.size());
      Log.d("PendingQueue", paramList.toString());
    }
    paramList = this.mPendingTasks.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject2 = (Map.Entry)paramList.next();
      localObject1 = (Long)((Map.Entry)localObject2).getKey();
      localObject2 = (PendingQueue.PendingTask)((Map.Entry)localObject2).getValue();
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("enqueue: delay = ");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(", view count = ");
        ((StringBuilder)localObject3).append(((PendingQueue.PendingTask)localObject2).pendingExposureElementInfoRef.size());
        Log.d("PendingQueue", ((StringBuilder)localObject3).toString());
      }
      if (((Long)localObject1).longValue() != 0L) {
        this.mHandler.postDelayed((Runnable)localObject2, ((Long)localObject1).longValue());
      } else {
        ((PendingQueue.PendingTask)localObject2).run();
      }
    }
  }
  
  void setOnQueueListener(PendingQueue.OnQueueListener paramOnQueueListener)
  {
    this.mOnQueueListener = paramOnQueueListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.PendingQueue
 * JD-Core Version:    0.7.0.1
 */