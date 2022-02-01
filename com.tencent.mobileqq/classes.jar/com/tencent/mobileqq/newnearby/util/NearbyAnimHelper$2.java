package com.tencent.mobileqq.newnearby.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearbyActivity;

final class NearbyAnimHelper$2
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == 0)
    {
      this.a.setText(this.b.getResources().getString(1946615814));
      return;
    }
    if (i == 1)
    {
      this.a.setText(this.b.getResources().getString(1946615815));
      return;
    }
    this.a.setText(this.b.getResources().getString(1946615816));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyAnimHelper.2
 * JD-Core Version:    0.7.0.1
 */