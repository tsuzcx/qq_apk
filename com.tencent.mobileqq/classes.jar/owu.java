import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;
import com.tencent.biz.qqstory.widget.circularreveal.RectangleRevealAnimator;

public class owu
  implements ValueAnimator.AnimatorUpdateListener
{
  public owu(RectangleRevealAnimator paramRectangleRevealAnimator, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RectF localRectF = new RectF();
    localRectF.top = ((Float)paramValueAnimator.getAnimatedValue("top")).floatValue();
    localRectF.left = ((Float)paramValueAnimator.getAnimatedValue("left")).floatValue();
    float f = localRectF.left;
    localRectF.right = (((Float)paramValueAnimator.getAnimatedValue("width")).floatValue() + f);
    f = localRectF.top;
    localRectF.bottom = (((Float)paramValueAnimator.getAnimatedValue("height")).floatValue() + f);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setClipRect(localRectF, ((Float)paramValueAnimator.getAnimatedValue("radius")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owu
 * JD-Core Version:    0.7.0.1
 */