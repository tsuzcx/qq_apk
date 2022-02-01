package com.tencent.qcircle.tavcut.timeline;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.cover.CoverListener;

class TimelineView$5
  implements CoverListener
{
  TimelineView$5(TimelineView paramTimelineView) {}
  
  public void onCover(int paramInt, Bitmap paramBitmap)
  {
    this.this$0.post(new TimelineView.5.1(this, paramInt, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineView.5
 * JD-Core Version:    0.7.0.1
 */