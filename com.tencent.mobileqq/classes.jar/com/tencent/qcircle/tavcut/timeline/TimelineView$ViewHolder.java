package com.tencent.qcircle.tavcut.timeline;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.cover.CoverProvider;

class TimelineView$ViewHolder
  extends RecyclerView.ViewHolder
{
  TimelineView$ViewHolder(TimelineView paramTimelineView, View paramView)
  {
    super(paramView);
  }
  
  private void setCover()
  {
    int i = getAdapterPosition();
    if ((i != 0) && (i != TimelineView.access$1900(this.this$0) + 1))
    {
      Bitmap localBitmap;
      if (TimelineView.access$2400(this.this$0) != null)
      {
        localBitmap = TimelineView.access$2400(this.this$0).getCover(i - 1);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {}
      }
      else
      {
        localBitmap = null;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ((ImageView)this.itemView).setImageBitmap(localBitmap);
        return;
      }
      ((ImageView)this.itemView).setImageDrawable(TimelineView.access$2500(this.this$0));
      return;
    }
    ((ImageView)this.itemView).setImageBitmap(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */