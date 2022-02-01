package com.tencent.viola.ui.view.list;

import android.os.Handler;

class DefaultRecycleItemAnimator$1
  implements Runnable
{
  DefaultRecycleItemAnimator$1(DefaultRecycleItemAnimator paramDefaultRecycleItemAnimator) {}
  
  public void run()
  {
    if (this.this$0.isRunning())
    {
      DefaultRecycleItemAnimator.access$000(this.this$0).postDelayed(this, 200L);
      return;
    }
    DefaultRecycleItemAnimator.access$102(this.this$0, false);
    if (DefaultRecycleItemAnimator.access$200(this.this$0) != null) {
      DefaultRecycleItemAnimator.access$200(this.this$0).onAnimFinish();
    }
    DefaultRecycleItemAnimator.access$000(this.this$0).removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */