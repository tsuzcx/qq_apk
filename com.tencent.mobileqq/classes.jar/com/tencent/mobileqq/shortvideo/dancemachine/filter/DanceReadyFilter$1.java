package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar.ProgressBarListener;

class DanceReadyFilter$1
  implements GLProgressBar.ProgressBarListener
{
  DanceReadyFilter$1(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void progressMax()
  {
    DanceReadyFilter.access$100(this.this$0).startAnimation(DanceReadyFilter.access$000(this.this$0));
    DanceReadyFilter.access$200(this.this$0).setVisibility(false);
    DanceReadyFilter.access$300(this.this$0).setVisibility(false);
    DanceReadyFilter.access$400(this.this$0).setVisibility(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.1
 * JD-Core Version:    0.7.0.1
 */