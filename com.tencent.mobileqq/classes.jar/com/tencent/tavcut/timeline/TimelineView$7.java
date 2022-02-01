package com.tencent.tavcut.timeline;

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
    Log.d("lingeng_ui", "onScrolled:  dx = " + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.7
 * JD-Core Version:    0.7.0.1
 */