import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.qphone.base.util.QLog;

public class tew
  extends AnimatorListenerAdapter
{
  public tew(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet cancel");
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton).postDelayed(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.b, 1800L);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet pause");
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tew
 * JD-Core Version:    0.7.0.1
 */