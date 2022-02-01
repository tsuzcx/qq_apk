package com.tencent.mobileqq.profilecard.vas.view;

import android.view.animation.Animation;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class VasProfileSimpleView$1
  extends VasProfileSimpleView.SimpleAnimationListener
{
  VasProfileSimpleView$1(VasProfileSimpleView paramVasProfileSimpleView, ProfileCardInfo paramProfileCardInfo)
  {
    super(null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VasProfileSimpleView.access$102(this.this$0, true);
    this.this$0.updateJueban(this.val$cardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView.1
 * JD-Core Version:    0.7.0.1
 */