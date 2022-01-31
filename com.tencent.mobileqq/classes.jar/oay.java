import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class oay
  extends AnimatorListenerAdapter
{
  oay(oaw paramoaw, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(4);
    oaw.a(this.jdField_a_of_type_Oaw).a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oay
 * JD-Core Version:    0.7.0.1
 */