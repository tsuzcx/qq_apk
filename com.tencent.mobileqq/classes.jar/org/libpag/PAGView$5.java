package org.libpag;

import android.animation.ValueAnimator;

class PAGView$5
  implements Runnable
{
  PAGView$5(PAGView paramPAGView) {}
  
  public void run()
  {
    PAGView.access$202(this.this$0, PAGView.access$300(this.this$0).getCurrentPlayTime());
    PAGView.access$300(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.PAGView.5
 * JD-Core Version:    0.7.0.1
 */