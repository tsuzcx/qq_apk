import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

class osb
  implements ValueAnimator.AnimatorUpdateListener
{
  osb(osa paramosa, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (osd)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(paramValueAnimator.a, paramValueAnimator.b, paramValueAnimator.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osb
 * JD-Core Version:    0.7.0.1
 */