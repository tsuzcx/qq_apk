import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;

public class jzg
  implements Animation.AnimationListener
{
  public jzg(QavInOutAnimation paramQavInOutAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
    }
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().au = false;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().av = false;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
      }
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.a.b != null) {
        this.a.b.setVisibility(4);
      }
      if (this.a.c != null) {
        this.a.c.setVisibility(4);
      }
      if (this.a.d != null) {
        this.a.d.setVisibility(4);
      }
      if (this.a.e != null) {
        this.a.e.setVisibility(4);
      }
      if (this.a.g != null) {
        this.a.g.setVisibility(4);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener.b();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationEnd Exception :" + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationStart");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener.a();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationStart Exception :" + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzg
 * JD-Core Version:    0.7.0.1
 */