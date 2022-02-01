package com.tencent.mobileqq.kandian.biz.pts;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class PTSFragment$6
  extends RecyclerView.OnScrollListener
{
  PTSFragment$6(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.b().a("list_kandian_daily_new", false);
      return;
    }
    DropFrameMonitor.b().a("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.PTSFragment.6
 * JD-Core Version:    0.7.0.1
 */