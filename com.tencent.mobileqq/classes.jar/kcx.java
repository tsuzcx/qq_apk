import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class kcx
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = 0;
  
  public kcx(VideoControlUI paramVideoControlUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(11)
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_Kcy);
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_JavaLangString, 1, "[" + this.jdField_a_of_type_Int + "]onAnimationEnd[" + paramAnimation + "]");
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 19) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.v = 0;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
          if (((paramAnimation.F == 2) || (paramAnimation.F == 1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(360 - this.jdField_a_of_type_ComTencentAvUiVideoControlUI.q);
          }
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.n = false;
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_Kcy);
        return;
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_JavaLangString, 2, "onAnimationEnd, change member list ui to visible");
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.v = 5;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController == null) {
        break;
      }
      paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
      if (((paramAnimation.F != 2) && (paramAnimation.F != 1)) || (Build.VERSION.SDK_INT < 11)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(0.0F);
      break;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.n = true;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_c_of_type_JavaLangString, 1, "[" + this.jdField_a_of_type_Int + "]onAnimationStart[" + paramAnimation + "]");
    VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, (int)(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewAnimationAnimation.getDuration() / 5L));
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.v = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_Kcy);
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.v = 5;
      VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kcx
 * JD-Core Version:    0.7.0.1
 */