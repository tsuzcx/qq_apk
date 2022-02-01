import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;

class myp
  implements Animator.AnimatorListener
{
  myp(myl parammyl, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    myl.a(this.jdField_a_of_type_Myl).a(this.jdField_a_of_type_Int, this.b);
    myl.a(this.jdField_a_of_type_Myl).d();
    myl.a(this.jdField_a_of_type_Myl, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    myl.a(this.jdField_a_of_type_Myl).a(this.jdField_a_of_type_Int, this.b);
    myl.a(this.jdField_a_of_type_Myl).d();
    myl.a(this.jdField_a_of_type_Myl, null);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myp
 * JD-Core Version:    0.7.0.1
 */