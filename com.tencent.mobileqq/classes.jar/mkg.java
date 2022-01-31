import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager.PageItemScrollListener;

public class mkg
  implements ValueAnimator.AnimatorUpdateListener
{
  public mkg(ReadInJoyAtlasViewPager paramReadInJoyAtlasViewPager) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.getChildAt(this.a.getCurrentItem()).setScrollY(((Float)paramValueAnimator.getAnimatedValue()).intValue());
    if (ReadInJoyAtlasViewPager.a(this.a) != null) {
      ReadInJoyAtlasViewPager.a(this.a).a(0.0F, this.a.getChildAt(this.a.getCurrentItem()).getScrollY(), null);
    }
    if ((paramValueAnimator.getAnimatedFraction() == 1.0F) && (ReadInJoyAtlasViewPager.a(this.a) != null)) {
      ReadInJoyAtlasViewPager.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkg
 * JD-Core Version:    0.7.0.1
 */