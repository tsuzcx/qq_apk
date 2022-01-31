import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;

public class dl
  implements ValueAnimator.AnimatorUpdateListener
{
  public dl(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LiteActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    LiteActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dl
 * JD-Core Version:    0.7.0.1
 */