package me.ele.uetool;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class UETMenu$10
  implements ValueAnimator.AnimatorUpdateListener
{
  UETMenu$10(UETMenu paramUETMenu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    UETMenu.access$1700(this.this$0).setTranslationX(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETMenu.10
 * JD-Core Version:    0.7.0.1
 */