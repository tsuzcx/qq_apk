package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FilterDetailAnimationLayout
  extends LinearLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public int a = -1;
  
  public FilterDetailAnimationLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FilterDetailAnimationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.a != -1) {
      paramCanvas.clipRect(0, 0, this.a, getHeight());
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a = -1;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a = 0;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.FilterDetailAnimationLayout
 * JD-Core Version:    0.7.0.1
 */