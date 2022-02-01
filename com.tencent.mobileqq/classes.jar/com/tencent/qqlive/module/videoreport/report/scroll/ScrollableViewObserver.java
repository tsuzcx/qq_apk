package com.tencent.qqlive.module.videoreport.report.scroll;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ScrollableViewObserver
  extends DefaultEventListener
{
  private static final String TAG = "ScrollableViewObserver";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private ScrollableViewObserver.PendingTask mPendingTask = new ScrollableViewObserver.PendingTask(null);
  private ScrollableViewObserver.ScrollableHelper mScrollableHelper = new ScrollableViewObserver.ScrollableHelper(null);
  
  private ScrollableViewObserver()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  public static ScrollableViewObserver getInstance()
  {
    return ScrollableViewObserver.InstanceHolder.access$200();
  }
  
  private void handleNotify(ViewGroup paramViewGroup)
  {
    if (!isIdle()) {
      return;
    }
    this.mHandler.removeCallbacks(this.mPendingTask);
    ScrollableViewObserver.PendingTask.access$300(this.mPendingTask, paramViewGroup);
    this.mHandler.post(this.mPendingTask);
  }
  
  private boolean isIdle()
  {
    return !this.mScrollableHelper.isScrolling();
  }
  
  public void onViewReused(ViewGroup paramViewGroup, View paramView, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("ScrollableViewObserver", "onViewReused: parent=" + paramViewGroup + ", view=" + paramView);
    }
    if (paramViewGroup == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        throw new UnsupportedClassVersionError("RecyclerView.ViewHolder 23 版本以下获取不到所对应RecyclerView对象，请升级RecyclerView版本");
      }
    }
    else {
      handleNotify(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver
 * JD-Core Version:    0.7.0.1
 */