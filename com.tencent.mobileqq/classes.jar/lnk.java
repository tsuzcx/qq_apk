import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;

public class lnk
  implements ValueAnimator.AnimatorUpdateListener
{
  public lnk(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getAnimatedFraction() == 1.0F) && (ReadInJoyAtlasFragment.a(this.a) != null))
    {
      ReadInJoyAtlasFragment.a(this.a, true);
      ReadInJoyAtlasFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnk
 * JD-Core Version:    0.7.0.1
 */