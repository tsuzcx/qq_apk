package com.tencent.mobileqq.flashshow.player.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.lang.ref.WeakReference;

class FSProgressLoadingView$ScaleXAnimationListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<FSProgressLoadingView> a;
  
  FSProgressLoadingView$ScaleXAnimationListener(FSProgressLoadingView paramFSProgressLoadingView)
  {
    this.a = new WeakReference(paramFSProgressLoadingView);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (FSProgressLoadingView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((FSProgressLoadingView)localObject).getLoadingView();
        if ((localObject != null) && (((View)localObject).getLayoutParams() != null))
        {
          ((View)localObject).getLayoutParams().width = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
          ((View)localObject).setLayoutParams(((View)localObject).getLayoutParams());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSProgressLoadingView.ScaleXAnimationListener
 * JD-Core Version:    0.7.0.1
 */