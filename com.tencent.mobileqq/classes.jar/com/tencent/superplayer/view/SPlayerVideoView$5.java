package com.tencent.superplayer.view;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

class SPlayerVideoView$5
  implements Runnable
{
  SPlayerVideoView$5(SPlayerVideoView paramSPlayerVideoView) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((SPlayerVideoView)localObject).removeView((View)SPlayerVideoView.access$500((SPlayerVideoView)localObject));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    SPlayerVideoView localSPlayerVideoView = this.this$0;
    localSPlayerVideoView.addView((View)SPlayerVideoView.access$500(localSPlayerVideoView), (ViewGroup.LayoutParams)localObject);
    this.this$0.enableViewCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.5
 * JD-Core Version:    0.7.0.1
 */