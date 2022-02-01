package com.tencent.qcircle.tavcut.timeline;

import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

class TimelineView$5$1
  implements Runnable
{
  TimelineView$5$1(TimelineView.5 param5, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)TimelineView.access$2200(this.this$1.this$0).findViewByPosition(this.val$index + 1);
    if (localImageView != null) {
      try
      {
        if ((this.val$bm != null) && (!this.val$bm.isRecycled()))
        {
          localImageView.setImageBitmap(this.val$bm);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineView.5.1
 * JD-Core Version:    0.7.0.1
 */