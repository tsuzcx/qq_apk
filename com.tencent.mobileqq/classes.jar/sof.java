import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class sof
  extends AnimatorListenerAdapter
{
  sof(sod paramsod, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (sod.a(this.jdField_a_of_type_Sod).w != null) {
      sod.a(this.jdField_a_of_type_Sod).w.setTag(2131362716, null);
    }
    this.jdField_a_of_type_Sod.b(sod.a(this.jdField_a_of_type_Sod));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.jdField_a_of_type_Sod.a();
    sod.a(this.jdField_a_of_type_Sod, sod.a(this.jdField_a_of_type_Sod).g, paramAnimator, this.jdField_a_of_type_Int, 18, -1);
    if (sod.a(this.jdField_a_of_type_Sod).w != null) {
      sod.a(this.jdField_a_of_type_Sod).w.setTag(2131362716, null);
    }
    this.jdField_a_of_type_Sod.c(sod.a(this.jdField_a_of_type_Sod));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_Sod.a(sod.a(this.jdField_a_of_type_Sod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */