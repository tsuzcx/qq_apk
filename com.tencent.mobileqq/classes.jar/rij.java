import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class rij
  extends AnimatorListenerAdapter
{
  rij(rig paramrig, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (rig.a(this.jdField_a_of_type_Rig) != null) {
      rig.a(this.jdField_a_of_type_Rig).b(rig.a(this.jdField_a_of_type_Rig));
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
      rig.a(this.jdField_a_of_type_Rig).w.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(aepi.a(8.0F, rig.a(this.jdField_a_of_type_Rig).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      rig.a(this.jdField_a_of_type_Rig).v.setBackgroundDrawable(paramAnimator);
      rig.a(this.jdField_a_of_type_Rig, false, false);
    }
    for (;;)
    {
      if (rig.a(this.jdField_a_of_type_Rig) != null) {
        rig.a(this.jdField_a_of_type_Rig).c(rig.a(this.jdField_a_of_type_Rig));
      }
      return;
      label124:
      rig.a(this.jdField_a_of_type_Rig).v.setVisibility(8);
      rig.a(this.jdField_a_of_type_Rig).j.setVisibility(0);
      rig.a(this.jdField_a_of_type_Rig, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    rbt localrbt;
    if (rig.a(this.jdField_a_of_type_Rig) != null)
    {
      paramAnimator = this.jdField_a_of_type_Rig;
      localrbt = rig.a(this.jdField_a_of_type_Rig);
      if (this.b) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      rig.a(paramAnimator, localrbt, bool);
      if (rig.a(this.jdField_a_of_type_Rig) != null) {
        rig.a(this.jdField_a_of_type_Rig).a(rig.a(this.jdField_a_of_type_Rig));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (rig.a(this.jdField_a_of_type_Rig) != null) {
          paramAnimator = rig.a(this.jdField_a_of_type_Rig).a();
        }
        if (this.jdField_a_of_type_Rig.a() == 0) {
          rig.a(this.jdField_a_of_type_Rig, rig.a(this.jdField_a_of_type_Rig).j, paramAnimator, aepi.a(5.2F, rig.a(this.jdField_a_of_type_Rig).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rij
 * JD-Core Version:    0.7.0.1
 */