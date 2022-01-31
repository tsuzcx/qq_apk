import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.View;

final class qcx
  implements ValueAnimator.AnimatorUpdateListener
{
  qcx(View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    qcn.a(this.a, paramValueAnimator);
    qcn.a(this.b, paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcx
 * JD-Core Version:    0.7.0.1
 */