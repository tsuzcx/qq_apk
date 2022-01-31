import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;

class rki
  implements rjq
{
  rki(rkg paramrkg, ViewGroup paramViewGroup, FrameLayout paramFrameLayout) {}
  
  public void a(int paramInt)
  {
    if (rkg.a(this.jdField_a_of_type_Rkg) != null) {
      rkg.a(this.jdField_a_of_type_Rkg).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (rkg.a(this.jdField_a_of_type_Rkg) == null) {
        rkg.a(this.jdField_a_of_type_Rkg, (TranslateAnimation)AnimationUtils.loadAnimation(rkg.a(this.jdField_a_of_type_Rkg).getActivity(), 2130772001));
      }
      rkg.a(this.jdField_a_of_type_Rkg).setAnimationListener(new rkj(this));
      rkg.a(this.jdField_a_of_type_Rkg).setDuration(200L);
      rkg.a(this.jdField_a_of_type_Rkg).setInterpolator(new AccelerateInterpolator());
      this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(rkg.a(this.jdField_a_of_type_Rkg));
    }
    for (;;)
    {
      this.jdField_a_of_type_Rkg.a(false);
      return;
      if (rkg.b(this.jdField_a_of_type_Rkg) == null) {
        rkg.b(this.jdField_a_of_type_Rkg, (TranslateAnimation)AnimationUtils.loadAnimation(rkg.a(this.jdField_a_of_type_Rkg).getActivity(), 2130772134));
      }
      rkg.b(this.jdField_a_of_type_Rkg).setAnimationListener(new rkk(this));
      rkg.b(this.jdField_a_of_type_Rkg).setDuration(200L);
      rkg.b(this.jdField_a_of_type_Rkg).setInterpolator(new AccelerateInterpolator());
      this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(rkg.b(this.jdField_a_of_type_Rkg));
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 2) && (rkg.a(this.jdField_a_of_type_Rkg).b()) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rki
 * JD-Core Version:    0.7.0.1
 */