import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class ort
  extends bkxp
{
  public ort(ReadInJoyNaviController.1 param1, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, ors.e, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new oru(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController$1.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ort
 * JD-Core Version:    0.7.0.1
 */