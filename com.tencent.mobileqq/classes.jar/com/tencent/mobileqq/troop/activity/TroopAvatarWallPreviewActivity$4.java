package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class TroopAvatarWallPreviewActivity$4
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$4(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.post(new TroopAvatarWallPreviewActivity.4.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */