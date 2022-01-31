import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class qsx
  extends AnimatorListenerAdapter
{
  qsx(qsu paramqsu, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (qsu.a(this.jdField_a_of_type_Qsu) != null) {
      qsu.a(this.jdField_a_of_type_Qsu).b(qsu.a(this.jdField_a_of_type_Qsu));
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
      qsu.a(this.jdField_a_of_type_Qsu).v.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(actj.a(8.0F, qsu.a(this.jdField_a_of_type_Qsu).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      qsu.a(this.jdField_a_of_type_Qsu).u.setBackgroundDrawable(paramAnimator);
      qsu.a(this.jdField_a_of_type_Qsu, false, false);
    }
    for (;;)
    {
      if (qsu.a(this.jdField_a_of_type_Qsu) != null) {
        qsu.a(this.jdField_a_of_type_Qsu).c(qsu.a(this.jdField_a_of_type_Qsu));
      }
      return;
      label124:
      qsu.a(this.jdField_a_of_type_Qsu).u.setVisibility(8);
      qsu.a(this.jdField_a_of_type_Qsu).i.setVisibility(0);
      qsu.a(this.jdField_a_of_type_Qsu, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    qmp localqmp;
    if (qsu.a(this.jdField_a_of_type_Qsu) != null)
    {
      paramAnimator = this.jdField_a_of_type_Qsu;
      localqmp = qsu.a(this.jdField_a_of_type_Qsu);
      if (this.b) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      qsu.a(paramAnimator, localqmp, bool);
      if (qsu.a(this.jdField_a_of_type_Qsu) != null) {
        qsu.a(this.jdField_a_of_type_Qsu).a(qsu.a(this.jdField_a_of_type_Qsu));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (qsu.a(this.jdField_a_of_type_Qsu) != null) {
          paramAnimator = qsu.a(this.jdField_a_of_type_Qsu).a();
        }
        if (this.jdField_a_of_type_Qsu.a() == 0) {
          qsu.a(this.jdField_a_of_type_Qsu, qsu.a(this.jdField_a_of_type_Qsu).i, paramAnimator, actj.a(5.2F, qsu.a(this.jdField_a_of_type_Qsu).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsx
 * JD-Core Version:    0.7.0.1
 */