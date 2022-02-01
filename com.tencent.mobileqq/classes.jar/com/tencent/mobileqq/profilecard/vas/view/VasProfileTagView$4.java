package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.RatioLayout;

class VasProfileTagView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  VasProfileTagView$4(VasProfileTagView paramVasProfileTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = VasProfileTagView.access$500(this.this$0).getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      VasProfileTagView.access$500(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = (FrameLayout)VasProfileTagView.access$1000(this.this$0).findViewById(16908290);
        if (localObject == null) {
          return;
        }
        if (((FrameLayout)localObject).getChildCount() > 0)
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if (localObject == null) {
            return;
          }
          localObject = ((View)localObject).getBackground();
          if ((localObject instanceof BitmapDrawable))
          {
            int j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
            int i = j;
            if (paramValueAnimator == VasProfileTagView.access$1100(this.this$0)) {
              i = 255 - j;
            }
            ((Drawable)localObject).setAlpha(i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.4
 * JD-Core Version:    0.7.0.1
 */