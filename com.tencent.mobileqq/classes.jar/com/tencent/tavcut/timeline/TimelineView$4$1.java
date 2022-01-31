package com.tencent.tavcut.timeline;

import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

class TimelineView$4$1
  implements Runnable
{
  TimelineView$4$1(TimelineView.4 param4, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)TimelineView.access$1900(this.this$1.this$0).findViewByPosition(this.val$index + 1);
    if (localImageView != null) {}
    try
    {
      if ((this.val$bm != null) && (!this.val$bm.isRecycled())) {
        localImageView.setImageBitmap(this.val$bm);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.4.1
 * JD-Core Version:    0.7.0.1
 */