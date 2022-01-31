import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;

class mot
  implements Animation.AnimationListener
{
  mot(mos parammos) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null) {
      PublicFragmentActivity.a(this.a.a, ReadInJoyBBCircleFragment.class);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */