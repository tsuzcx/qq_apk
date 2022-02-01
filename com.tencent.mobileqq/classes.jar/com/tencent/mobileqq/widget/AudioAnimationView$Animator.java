package com.tencent.mobileqq.widget;

import android.os.Handler;

class AudioAnimationView$Animator
  implements Runnable
{
  private AudioAnimationView$Animator(AudioAnimationView paramAudioAnimationView) {}
  
  public void run()
  {
    this.this$0.b();
    if (this.this$0.a) {
      AudioAnimationView.a(this.this$0).postDelayed(this, 100L);
    }
    this.this$0.requestLayout();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AudioAnimationView.Animator
 * JD-Core Version:    0.7.0.1
 */