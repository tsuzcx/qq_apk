import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class qij
  implements ValueAnimator.AnimatorUpdateListener
{
  qij(qid paramqid) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    qid.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    qid.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qij
 * JD-Core Version:    0.7.0.1
 */