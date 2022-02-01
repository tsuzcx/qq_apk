package com.tencent.qcircle.tavcut.timeline;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimelineView$4
  extends RecyclerView.Adapter
{
  TimelineView$4(TimelineView paramTimelineView) {}
  
  public int getItemCount()
  {
    return TimelineView.access$1900(this.this$0) + 2;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    TimelineView.ViewHolder.access$1700((TimelineView.ViewHolder)paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    if (localLayoutParams != null)
    {
      if (paramInt == 0) {
        localLayoutParams.width = TimelineView.access$1800(this.this$0);
      } else if (paramInt == TimelineView.access$1900(this.this$0) + 1) {
        localLayoutParams.width = TimelineView.access$2000(this.this$0);
      } else if (paramInt == TimelineView.access$1900(this.this$0)) {
        localLayoutParams.width = TimelineView.access$2100(this.this$0);
      } else {
        localLayoutParams.width = TimelineView.access$1600(this.this$0);
      }
      paramViewHolder.itemView.setBackgroundColor(0);
      paramViewHolder.itemView.setLayoutParams(localLayoutParams);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new ImageView(paramViewGroup.getContext());
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(TimelineView.access$1600(this.this$0), -1));
    return new TimelineView.ViewHolder(this.this$0, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineView.4
 * JD-Core Version:    0.7.0.1
 */