import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class ort
  implements ValueAnimator.AnimatorUpdateListener
{
  public ort(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ort
 * JD-Core Version:    0.7.0.1
 */