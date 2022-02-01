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
    boolean bool = true;
    if (!TimelineView.access$000(this.this$0)) {
      return;
    }
    Logger.d("TimelineView", "onScrollStateChanged: newState is " + paramInt);
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      TimelineView.access$200(this.this$0, bool);
      return;
      TimelineView.access$100(this.this$0);
      continue;
      this.this$0.hasEditStartAndEnd = true;
      bool = false;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    TimelineView.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.1
 * JD-Core Version:    0.7.0.1
 */