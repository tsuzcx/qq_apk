package com.tencent.tavcut.timeline;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.tavcut.util.Logger;

class TimelineView$1
  extends RecyclerView.OnScrollListener
{
  TimelineView$1(TimelineView paramTimelineView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    boolean bool2 = false;
    if (!TimelineView.access$000(this.this$0)) {
      return;
    }
    Logger.d("TimelineView", "onScrollStateChanged: newState is " + paramInt);
    boolean bool1 = bool2;
    switch (paramInt)
    {
    }
    for (bool1 = bool2;; bool1 = true)
    {
      TimelineView.access$200(this.this$0, bool1);
      return;
      TimelineView.access$100(this.this$0);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    TimelineView.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.1
 * JD-Core Version:    0.7.0.1
 */