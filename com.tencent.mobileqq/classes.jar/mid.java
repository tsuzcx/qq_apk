import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;

class mid
  implements Animation.AnimationListener
{
  mid(mia parammia) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
    }
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().as = false;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().at = false;
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
      if (this.a.jdField_a_of_type_Mif != null) {
        this.a.jdField_a_of_type_Mif.b();
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
      if (this.a.jdField_a_of_type_Mif != null) {
        this.a.jdField_a_of_type_Mif.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mid
 * JD-Core Version:    0.7.0.1
 */