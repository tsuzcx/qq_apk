import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;

public class tej
  implements ValueAnimator.AnimatorUpdateListener
{
  public tej(VariableSizeTextView paramVariableSizeTextView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.b)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setFocusable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setClickable(true);
    }
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(f + 0.5F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tej
 * JD-Core Version:    0.7.0.1
 */