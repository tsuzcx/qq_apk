package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView.StatusListener;

class DancePlayFilter$1
  implements GLRecognizeRegionView.StatusListener
{
  DancePlayFilter$1(DancePlayFilter paramDancePlayFilter) {}
  
  public void onStatusChanged(int paramInt)
  {
    if (paramInt == 2)
    {
      DancePlayFilter.access$002(this.this$0, DancePlayFilter.access$200(this.this$0).setupSingleVibrateAnimation(DancePlayFilter.access$100(this.this$0), 75, 1));
      DancePlayFilter.access$100(this.this$0).clearAnimation();
      DancePlayFilter.access$100(this.this$0).startAnimation(DancePlayFilter.access$000(this.this$0));
    }
    if (paramInt == 3)
    {
      DancePlayFilter.access$302(this.this$0, DancePlayFilter.access$200(this.this$0).setupSingleVibrateAnimation(DancePlayFilter.access$100(this.this$0), 75, 2));
      DancePlayFilter.access$100(this.this$0).clearAnimation();
      DancePlayFilter.access$100(this.this$0).startAnimation(DancePlayFilter.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DancePlayFilter.1
 * JD-Core Version:    0.7.0.1
 */