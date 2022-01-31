package com.tencent.tavcut.timeline;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.tavcut.cover.CoverProvider;

class TimelineView$ViewHolder
  extends RecyclerView.ViewHolder
{
  TimelineView$ViewHolder(TimelineView paramTimelineView, View paramView)
  {
    super(paramView);
  }
  
  private void setCover()
  {
    Object localObject2 = null;
    int i = getAdapterPosition();
    if ((i == 0) || (i == TimelineView.access$1600(this.this$0) + 1))
    {
      ((ImageView)this.itemView).setImageBitmap(null);
      return;
    }
    Object localObject1 = localObject2;
    if (TimelineView.access$2000(this.this$0) != null)
    {
      Bitmap localBitmap = TimelineView.access$2000(this.this$0).getCover(i - 1);
      localObject1 = localObject2;
      if (localBitmap != null)
      {
        localObject1 = localObject2;
        if (!localBitmap.isRecycled()) {
          localObject1 = localBitmap;
        }
      }
    }
    if ((localObject1 != null) && (!localObject1.isRecycled()))
    {
      ((ImageView)this.itemView).setImageBitmap(localObject1);
      return;
    }
    ((ImageView)this.itemView).setImageDrawable(TimelineView.access$2100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */