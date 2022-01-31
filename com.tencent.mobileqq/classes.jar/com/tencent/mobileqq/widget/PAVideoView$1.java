package com.tencent.mobileqq.widget;

import android.widget.ImageView;

class PAVideoView$1
  implements Runnable
{
  PAVideoView$1(PAVideoView paramPAVideoView, ImageView paramImageView) {}
  
  public void run()
  {
    this.a.setVisibility(0);
    this.a.setImageResource(2130842554);
    this.a.clearAnimation();
    this.a.startAnimation(this.this$0.a);
    if (this.this$0.j == 4) {
      this.this$0.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAVideoView.1
 * JD-Core Version:    0.7.0.1
 */