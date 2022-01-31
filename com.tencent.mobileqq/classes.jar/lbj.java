import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class lbj
  extends AnimateUtils.AnimationAdapter
{
  lbj(lbi paramlbi, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Lbi.a.e, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new lbk(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.jdField_a_of_type_Lbi.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbj
 * JD-Core Version:    0.7.0.1
 */