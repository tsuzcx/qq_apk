import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import java.lang.ref.WeakReference;

public class msm
  implements Animation.AnimationListener
{
  public msm(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((ViewGroup)this.a.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.a.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.b > 0) && (this.a.c > 0)) {
      ((ImageView)((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131368249)).setLayoutParams(new LinearLayout.LayoutParams(this.a.c, this.a.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msm
 * JD-Core Version:    0.7.0.1
 */