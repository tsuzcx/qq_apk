import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;

public class pbj
  implements Animation.AnimationListener
{
  public pbj(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, TranslateAnimation paramTranslateAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pbj
 * JD-Core Version:    0.7.0.1
 */