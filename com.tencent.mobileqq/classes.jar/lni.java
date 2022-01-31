import android.view.View;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;

public class lni
  implements ValueAnimator.AnimatorUpdateListener
{
  public lni(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.jdField_a_of_type_AndroidViewView.setAlpha(f);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setAlpha(f);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setAlpha(f);
    if (f == 0.0F)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(4);
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lni
 * JD-Core Version:    0.7.0.1
 */