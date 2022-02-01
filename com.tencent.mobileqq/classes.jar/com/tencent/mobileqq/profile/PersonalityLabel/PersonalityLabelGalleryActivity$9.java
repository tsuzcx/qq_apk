package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class PersonalityLabelGalleryActivity$9
  implements ValueAnimator.AnimatorUpdateListener
{
  PersonalityLabelGalleryActivity$9(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.a.getAnimatedValue()).intValue();
    paramValueAnimator = this.b.getLayoutParams();
    paramValueAnimator.height = i;
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.9
 * JD-Core Version:    0.7.0.1
 */