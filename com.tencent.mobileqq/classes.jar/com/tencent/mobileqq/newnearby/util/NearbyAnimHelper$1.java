package com.tencent.mobileqq.newnearby.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class NearbyAnimHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TextView localTextView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramValueAnimator.getAnimatedValue().toString());
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyAnimHelper.1
 * JD-Core Version:    0.7.0.1
 */