import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;

class rkm
  implements Animation.AnimationListener
{
  rkm(rkg paramrkg, ViewGroup paramViewGroup) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    rkg.a(this.jdField_a_of_type_Rkg).getActivity().doOnBackPressed();
    rkg.a(this.jdField_a_of_type_Rkg).getActivity().overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkm
 * JD-Core Version:    0.7.0.1
 */