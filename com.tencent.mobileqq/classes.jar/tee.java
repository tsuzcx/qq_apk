import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySlideAnimLayout;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class tee
  implements ValueAnimator.AnimatorUpdateListener
{
  public tee(SlideActiveAnimController paramSlideActiveAnimController, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.setTranslationY(this.jdField_a_of_type_Float - paramValueAnimator.floatValue());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setTranslationY(-paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tee
 * JD-Core Version:    0.7.0.1
 */