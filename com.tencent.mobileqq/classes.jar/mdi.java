import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;

public class mdi
  implements Animation.AnimationListener
{
  public mdi(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, 1, "showNoAnswerAnimation, onAnimationEnd, seq[" + this.jdField_a_of_type_Long + "]");
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a != null)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.c = true;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a.j();
    }
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, 1, "showNoAnswerAnimation, onAnimationStart, seq[" + this.jdField_a_of_type_Long + "]");
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdi
 * JD-Core Version:    0.7.0.1
 */