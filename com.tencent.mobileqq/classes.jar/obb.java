import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class obb
  extends AnimatorListenerAdapter
{
  obb(oaz paramoaz, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(4);
    oaz.a(this.jdField_a_of_type_Oaz).a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obb
 * JD-Core Version:    0.7.0.1
 */