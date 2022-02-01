package com.tencent.superplayer.view;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class SPlayerVideoView$5
  implements Runnable
{
  SPlayerVideoView$5(SPlayerVideoView paramSPlayerVideoView) {}
  
  public void run()
  {
    this.this$0.removeView((View)SPlayerVideoView.access$500(this.this$0));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    this.this$0.addView((View)SPlayerVideoView.access$500(this.this$0), localLayoutParams);
    this.this$0.enableViewCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.5
 * JD-Core Version:    0.7.0.1
 */