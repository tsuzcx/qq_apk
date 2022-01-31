import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.View;

final class qos
  implements ValueAnimator.AnimatorUpdateListener
{
  qos(View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    qoi.a(this.a, paramValueAnimator);
    qoi.a(this.b, paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qos
 * JD-Core Version:    0.7.0.1
 */