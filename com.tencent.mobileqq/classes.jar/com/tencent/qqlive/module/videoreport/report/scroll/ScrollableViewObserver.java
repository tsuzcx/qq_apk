package com.tencent.qqlive.module.videoreport.report.scroll;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;

public class ScrollableViewObserver
  extends DefaultEventListener
{
  private static final String TAG = "ScrollableViewObserver";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private ScrollableViewObserver.PendingTask mPendingTask = new ScrollableViewObserver.PendingTask(null);
  private boolean mRecyclerViewTipsToasted = false;
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
    return this.mScrollableHelper.isScrolling() ^ true;
  }
  
  private void remindRecyclerViewVersionOld(View paramView)
  {
    paramView = paramView.getContext().getString(2131718168);
    if (!this.mRecyclerViewTipsToasted)
    {
      this.mRecyclerViewTipsToasted = true;
      Toast.makeText(ReportUtils.getContext(), paramView, 1).show();
    }
    Log.e("ScrollableViewObserver", paramView);
  }
  
  public void onViewReused(ViewGroup paramViewGroup, View paramView, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewReused: parent=");
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append(", view=");
      localStringBuilder.append(paramView);
      Log.i("ScrollableViewObserver", localStringBuilder.toString());
    }
    if (paramViewGroup == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        remindRecyclerViewVersionOld(paramView);
      }
      return;
    }
    handleNotify(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver
 * JD-Core Version:    0.7.0.1
 */