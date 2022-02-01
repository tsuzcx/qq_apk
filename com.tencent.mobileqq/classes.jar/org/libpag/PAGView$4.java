package org.libpag;

import android.animation.ValueAnimator;
import android.util.Log;

class PAGView$4
  implements Runnable
{
  PAGView$4(PAGView paramPAGView) {}
  
  public void run()
  {
    if (PAGView.access$700(this.this$0))
    {
      PAGView.access$300(this.this$0).start();
      return;
    }
    Log.e("PAGView", "AnimatorStartRunnable: PAGView is not attached to window");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.PAGView.4
 * JD-Core Version:    0.7.0.1
 */