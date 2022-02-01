package com.tencent.qcircle.tavcut.timeline;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;

class TimelineView$7
  extends RecyclerView.OnScrollListener
{
  TimelineView$7(TimelineView paramTimelineView) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onScrolled:  dx = ");
    paramRecyclerView.append(paramInt1);
    Log.d("lingeng_ui", paramRecyclerView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineView.7
 * JD-Core Version:    0.7.0.1
 */