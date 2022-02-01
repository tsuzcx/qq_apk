import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class rus
  extends AnimatorListenerAdapter
{
  rus(rup paramrup, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (rup.a(this.jdField_a_of_type_Rup) != null) {
      rup.a(this.jdField_a_of_type_Rup).b(rup.a(this.jdField_a_of_type_Rup));
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
      rup.a(this.jdField_a_of_type_Rup).z.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(agej.a(8.0F, rup.a(this.jdField_a_of_type_Rup).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      rup.a(this.jdField_a_of_type_Rup).y.setBackgroundDrawable(paramAnimator);
      rup.a(this.jdField_a_of_type_Rup, false, false);
    }
    for (;;)
    {
      if (rup.a(this.jdField_a_of_type_Rup) != null) {
        rup.a(this.jdField_a_of_type_Rup).c(rup.a(this.jdField_a_of_type_Rup));
      }
      return;
      label124:
      rup.a(this.jdField_a_of_type_Rup).y.setVisibility(8);
      rup.a(this.jdField_a_of_type_Rup).j.setVisibility(0);
      rup.a(this.jdField_a_of_type_Rup, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    rot localrot;
    if (rup.a(this.jdField_a_of_type_Rup) != null)
    {
      paramAnimator = this.jdField_a_of_type_Rup;
      localrot = rup.a(this.jdField_a_of_type_Rup);
      if (this.b) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      rup.a(paramAnimator, localrot, bool);
      if ((this.jdField_a_of_type_Boolean) && (!this.b) && (rup.a(this.jdField_a_of_type_Rup).x != null)) {
        rup.a(this.jdField_a_of_type_Rup).x.setVisibility(8);
      }
      if (rup.a(this.jdField_a_of_type_Rup) != null) {
        rup.a(this.jdField_a_of_type_Rup).a(rup.a(this.jdField_a_of_type_Rup));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (rup.a(this.jdField_a_of_type_Rup) != null) {
          paramAnimator = rup.a(this.jdField_a_of_type_Rup).a();
        }
        if ((this.jdField_a_of_type_Rup.a() == 0) || (this.jdField_a_of_type_Rup.a() == 3)) {
          rup.a(this.jdField_a_of_type_Rup, rup.a(this.jdField_a_of_type_Rup).j, paramAnimator, agej.a(5.2F, rup.a(this.jdField_a_of_type_Rup).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rus
 * JD-Core Version:    0.7.0.1
 */