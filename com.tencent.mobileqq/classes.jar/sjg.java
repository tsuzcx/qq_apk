import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class sjg
  extends AnimatorListenerAdapter
{
  public sjg(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, false);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, true);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjg
 * JD-Core Version:    0.7.0.1
 */