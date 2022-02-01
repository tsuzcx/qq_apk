package com.tencent.mobileqq.troop.activity;

import android.view.animation.DecelerateInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;

class TroopBarPublishActivity$6
  implements Runnable
{
  TroopBarPublishActivity$6(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.this$0.a, "scrollY", new int[] { this.jdField_a_of_type_Int }).setDuration(this.b);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.addListener(new TroopBarPublishActivity.6.1(this));
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.6
 * JD-Core Version:    0.7.0.1
 */