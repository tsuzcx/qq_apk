package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

final class DrawRedpacketPannelPreviewFragment$DisplayNextView
  implements Animation.AnimationListener
{
  private final boolean b;
  private final View c;
  private final View d;
  
  private DrawRedpacketPannelPreviewFragment$DisplayNextView(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, boolean paramBoolean, View paramView1, View paramView2)
  {
    this.b = paramBoolean;
    this.c = paramView1;
    this.d = paramView2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DrawRedpacketPannelPreviewFragment.s(this.a).post(new DrawRedpacketPannelPreviewFragment.SwapViews(this.a, this.b, this.c, this.d));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.DisplayNextView
 * JD-Core Version:    0.7.0.1
 */