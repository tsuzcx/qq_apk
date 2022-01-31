import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class lau
  extends AnimateUtils.AnimationAdapter
{
  lau(lat paramlat, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Lat.a.e, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new lav(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.jdField_a_of_type_Lat.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lau
 * JD-Core Version:    0.7.0.1
 */