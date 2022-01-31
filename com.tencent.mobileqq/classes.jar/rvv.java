import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;

public class rvv
  implements Animation.AnimationListener
{
  public rvv(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout).setVisibility(8);
    CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout).a(true, this.jdField_a_of_type_Int, this.b);
    CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout, this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvv
 * JD-Core Version:    0.7.0.1
 */