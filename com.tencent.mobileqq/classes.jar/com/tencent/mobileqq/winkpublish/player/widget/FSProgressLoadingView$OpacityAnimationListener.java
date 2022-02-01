package com.tencent.mobileqq.winkpublish.player.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

class FSProgressLoadingView$OpacityAnimationListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<FSProgressLoadingView> a;
  
  FSProgressLoadingView$OpacityAnimationListener(FSProgressLoadingView paramFSProgressLoadingView)
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
        if ((localObject != null) && (((View)localObject).getBackground() != null)) {
          ((View)localObject).getBackground().setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.FSProgressLoadingView.OpacityAnimationListener
 * JD-Core Version:    0.7.0.1
 */