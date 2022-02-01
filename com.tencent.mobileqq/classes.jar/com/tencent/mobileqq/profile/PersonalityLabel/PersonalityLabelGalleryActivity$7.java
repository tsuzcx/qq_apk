package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class PersonalityLabelGalleryActivity$7
  implements ValueAnimator.AnimatorUpdateListener
{
  PersonalityLabelGalleryActivity$7(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.a.getAnimatedValue()).intValue();
    paramValueAnimator = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    paramValueAnimator.height = i;
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.7
 * JD-Core Version:    0.7.0.1
 */