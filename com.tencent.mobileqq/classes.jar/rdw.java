import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.View;

final class rdw
  implements ValueAnimator.AnimatorUpdateListener
{
  rdw(View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    rdm.a(this.a, paramValueAnimator);
    rdm.a(this.b, paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdw
 * JD-Core Version:    0.7.0.1
 */