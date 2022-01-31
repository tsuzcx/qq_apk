import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class osc
  extends AnimatorListenerAdapter
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private int b;
  
  public osc(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramView.getLayerType();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setLayerType(this.b, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setLayerType(this.b, null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setLayerType(this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osc
 * JD-Core Version:    0.7.0.1
 */