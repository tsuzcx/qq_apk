import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;

class mxf
  implements Animator.AnimatorListener
{
  mxf(mxb parammxb, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    mxb.a(this.jdField_a_of_type_Mxb).a(this.jdField_a_of_type_Int, this.b);
    mxb.a(this.jdField_a_of_type_Mxb).d();
    mxb.a(this.jdField_a_of_type_Mxb, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    mxb.a(this.jdField_a_of_type_Mxb).a(this.jdField_a_of_type_Int, this.b);
    mxb.a(this.jdField_a_of_type_Mxb).d();
    mxb.a(this.jdField_a_of_type_Mxb, null);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxf
 * JD-Core Version:    0.7.0.1
 */