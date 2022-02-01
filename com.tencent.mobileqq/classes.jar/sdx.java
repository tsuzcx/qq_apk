import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class sdx
  extends AnimatorListenerAdapter
{
  sdx(sdu paramsdu, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (sdu.a(this.jdField_a_of_type_Sdu) != null) {
      sdu.a(this.jdField_a_of_type_Sdu).b(sdu.a(this.jdField_a_of_type_Sdu));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b) {
        break label124;
      }
      sdu.a(this.jdField_a_of_type_Sdu).A.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(afur.a(8.0F, sdu.a(this.jdField_a_of_type_Sdu).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      sdu.a(this.jdField_a_of_type_Sdu).z.setBackgroundDrawable(paramAnimator);
      sdu.a(this.jdField_a_of_type_Sdu, false, false);
    }
    for (;;)
    {
      if (sdu.a(this.jdField_a_of_type_Sdu) != null) {
        sdu.a(this.jdField_a_of_type_Sdu).c(sdu.a(this.jdField_a_of_type_Sdu));
      }
      return;
      label124:
      sdu.a(this.jdField_a_of_type_Sdu).z.setVisibility(8);
      sdu.a(this.jdField_a_of_type_Sdu).j.setVisibility(0);
      sdu.a(this.jdField_a_of_type_Sdu, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    rxy localrxy;
    if (sdu.a(this.jdField_a_of_type_Sdu) != null)
    {
      paramAnimator = this.jdField_a_of_type_Sdu;
      localrxy = sdu.a(this.jdField_a_of_type_Sdu);
      if (this.b) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      sdu.a(paramAnimator, localrxy, bool);
      if ((this.jdField_a_of_type_Boolean) && (!this.b) && (sdu.a(this.jdField_a_of_type_Sdu).y != null)) {
        sdu.a(this.jdField_a_of_type_Sdu).y.setVisibility(8);
      }
      if (sdu.a(this.jdField_a_of_type_Sdu) != null) {
        sdu.a(this.jdField_a_of_type_Sdu).a(sdu.a(this.jdField_a_of_type_Sdu));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (sdu.a(this.jdField_a_of_type_Sdu) != null) {
          paramAnimator = sdu.a(this.jdField_a_of_type_Sdu).a();
        }
        if ((this.jdField_a_of_type_Sdu.a() == 0) || (this.jdField_a_of_type_Sdu.a() == 3)) {
          sdu.a(this.jdField_a_of_type_Sdu, sdu.a(this.jdField_a_of_type_Sdu).j, paramAnimator, afur.a(5.2F, sdu.a(this.jdField_a_of_type_Sdu).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdx
 * JD-Core Version:    0.7.0.1
 */