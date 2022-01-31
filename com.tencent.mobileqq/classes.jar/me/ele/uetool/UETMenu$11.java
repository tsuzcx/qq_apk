package me.ele.uetool;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;

class UETMenu$11
  implements ValueAnimator.AnimatorUpdateListener
{
  UETMenu$11(UETMenu paramUETMenu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    UETMenu.access$900(this.this$0).x = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    try
    {
      UETMenu.access$800(this.this$0).updateViewLayout(this.this$0, UETMenu.access$900(this.this$0));
      return;
    }
    catch (Exception paramValueAnimator)
    {
      paramValueAnimator.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETMenu.11
 * JD-Core Version:    0.7.0.1
 */