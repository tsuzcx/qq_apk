import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.widget.HorizontalListView;

public class ovv
  implements ValueAnimator.AnimatorUpdateListener
{
  public ovv(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = ReadInJoySelfFragment.a(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    ReadInJoySelfFragment.a(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovv
 * JD-Core Version:    0.7.0.1
 */