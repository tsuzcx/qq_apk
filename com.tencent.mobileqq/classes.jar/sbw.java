import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class sbw
  extends AnimatorListenerAdapter
{
  sbw(sbt paramsbt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (sbt.a(this.jdField_a_of_type_Sbt) != null) {
      sbt.a(this.jdField_a_of_type_Sbt).b(sbt.a(this.jdField_a_of_type_Sbt));
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
      sbt.a(this.jdField_a_of_type_Sbt).A.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(AIOUtils.dp2px(8.0F, sbt.a(this.jdField_a_of_type_Sbt).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      sbt.a(this.jdField_a_of_type_Sbt).z.setBackgroundDrawable(paramAnimator);
      sbt.a(this.jdField_a_of_type_Sbt, false, false);
    }
    for (;;)
    {
      if (sbt.a(this.jdField_a_of_type_Sbt) != null) {
        sbt.a(this.jdField_a_of_type_Sbt).c(sbt.a(this.jdField_a_of_type_Sbt));
      }
      return;
      label124:
      sbt.a(this.jdField_a_of_type_Sbt).z.setVisibility(8);
      sbt.a(this.jdField_a_of_type_Sbt).j.setVisibility(0);
      sbt.a(this.jdField_a_of_type_Sbt, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    rvv localrvv;
    if (sbt.a(this.jdField_a_of_type_Sbt) != null)
    {
      paramAnimator = this.jdField_a_of_type_Sbt;
      localrvv = sbt.a(this.jdField_a_of_type_Sbt);
      if (this.b) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      sbt.a(paramAnimator, localrvv, bool);
      if ((this.jdField_a_of_type_Boolean) && (!this.b) && (sbt.a(this.jdField_a_of_type_Sbt).y != null)) {
        sbt.a(this.jdField_a_of_type_Sbt).y.setVisibility(8);
      }
      if (sbt.a(this.jdField_a_of_type_Sbt) != null) {
        sbt.a(this.jdField_a_of_type_Sbt).a(sbt.a(this.jdField_a_of_type_Sbt));
      }
      if (this.b)
      {
        paramAnimator = "";
        if (sbt.a(this.jdField_a_of_type_Sbt) != null) {
          paramAnimator = sbt.a(this.jdField_a_of_type_Sbt).a();
        }
        if ((this.jdField_a_of_type_Sbt.a() == 0) || (this.jdField_a_of_type_Sbt.a() == 3)) {
          sbt.a(this.jdField_a_of_type_Sbt, sbt.a(this.jdField_a_of_type_Sbt).j, paramAnimator, AIOUtils.dp2px(5.2F, sbt.a(this.jdField_a_of_type_Sbt).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbw
 * JD-Core Version:    0.7.0.1
 */