package com.tencent.tkd.comment.adapt;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class BaseBottomSheetDialogFragment$2
  implements Animation.AnimationListener
{
  BaseBottomSheetDialogFragment$2(BaseBottomSheetDialogFragment paramBaseBottomSheetDialogFragment, BaseBottomSheetDialogFragment.MyDialog paramMyDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$dialog.superDismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */