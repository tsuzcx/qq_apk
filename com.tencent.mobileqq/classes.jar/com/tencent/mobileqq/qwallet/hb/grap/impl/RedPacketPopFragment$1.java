package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;

class RedPacketPopFragment$1
  implements Runnable
{
  RedPacketPopFragment$1(RedPacketPopFragment paramRedPacketPopFragment) {}
  
  public void run()
  {
    this.this$0.A.setAlpha(0.3F);
    this.this$0.A.animate().alpha(1.0F).setDuration(200L);
    this.this$0.B.setAlpha(0.3F);
    this.this$0.B.setVisibility(0);
    this.this$0.B.setPivotX(this.this$0.B.getWidth() / 2);
    this.this$0.B.setPivotY(this.this$0.B.getHeight() / 2);
    this.this$0.B.setScaleX(0.5F);
    this.this$0.B.setScaleY(0.5F);
    this.this$0.B.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator(new OvershootInterpolator(1.6F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketPopFragment.1
 * JD-Core Version:    0.7.0.1
 */