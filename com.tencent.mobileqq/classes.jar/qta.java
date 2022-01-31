import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class qta
  extends AnimatorListenerAdapter
{
  qta(qsx paramqsx, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (qsx.a(this.jdField_a_of_type_Qsx) != null) {
      qsx.a(this.jdField_a_of_type_Qsx).b(qsx.a(this.jdField_a_of_type_Qsx));
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
      qsx.a(this.jdField_a_of_type_Qsx).v.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(actn.a(8.0F, qsx.a(this.jdField_a_of_type_Qsx).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      qsx.a(this.jdField_a_of_type_Qsx).u.setBackgroundDrawable(paramAnimator);
      qsx.a(this.jdField_a_of_type_Qsx, false, false);
    }
    for (;;)
    {
      if (qsx.a(this.jdField_a_of_type_Qsx) != null) {
        qsx.a(this.jdField_a_of_type_Qsx).c(qsx.a(this.jdField_a_of_type_Qsx));
      }
      return;
      label124:
      qsx.a(this.jdField_a_of_type_Qsx).u.setVisibility(8);
      qsx.a(this.jdField_a_of_type_Qsx).i.setVisibility(0);
      qsx.a(this.jdField_a_of_type_Qsx, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    qms localqms;
    if (qsx.a(this.jdField_a_of_type_Qsx) != null)
    {
      paramAnimator = this.jdField_a_of_type_Qsx;
      localqms = qsx.a(this.jdField_a_of_type_Qsx);
      if (this.b) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      qsx.a(paramAnimator, localqms, bool);
      if (qsx.a(this.jdField_a_of_type_Qsx) != null) {
        qsx.a(this.jdField_a_of_type_Qsx).a(qsx.a(this.jdField_a_of_type_Qsx));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (qsx.a(this.jdField_a_of_type_Qsx) != null) {
          paramAnimator = qsx.a(this.jdField_a_of_type_Qsx).a();
        }
        if (this.jdField_a_of_type_Qsx.a() == 0) {
          qsx.a(this.jdField_a_of_type_Qsx, qsx.a(this.jdField_a_of_type_Qsx).i, paramAnimator, actn.a(5.2F, qsx.a(this.jdField_a_of_type_Qsx).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qta
 * JD-Core Version:    0.7.0.1
 */