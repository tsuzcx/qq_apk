import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;

public class rpa
  implements ValueAnimator.AnimatorUpdateListener
{
  public rpa(BezierSideBarView paramBezierSideBarView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BezierSideBarView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.invalidate();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener.onAnimationUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rpa
 * JD-Core Version:    0.7.0.1
 */