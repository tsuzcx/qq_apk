package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

class RefreshAnimView$3
  implements Animation.AnimationListener
{
  RefreshAnimView$3(RefreshAnimView paramRefreshAnimView, String paramString, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    RefreshAnimView.c(this.c).postDelayed(new RefreshAnimView.3.1(this), RefreshAnimView.b(this.c));
    paramAnimation = new RefreshAnimView.3.2(this);
    if (RefreshAnimView.d(this.c) != null)
    {
      paramAnimation.run();
      return;
    }
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.c.getContext(), "readinjoy_refresh_animation.json", new RefreshAnimView.3.3(this, paramAnimation));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.e("RefreshAnimView", 2, "fromAssetFileName", paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView.3
 * JD-Core Version:    0.7.0.1
 */