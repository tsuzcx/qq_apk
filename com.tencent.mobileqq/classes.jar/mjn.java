import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mjn
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = 0;
  
  public mjn(VideoControlUI paramVideoControlUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(11)
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString, 1, "onAnimationEnd, mToolBarType[" + this.jdField_a_of_type_Int + "], animation[" + paramAnimation + "], mToolbarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h + "], seq[" + l + "]");
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c.setVisibility(4);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
      }
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
      }
      maf.b(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.w = 0;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((paramAnimation.F == 2) || (paramAnimation.F == 1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().s())) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l, 360 - this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.l = false;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setAlpha(1.0F);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString, 2, "onAnimationEnd, change member list ui to visible");
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, true);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.w = 5;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramAnimation.F == 2) || (paramAnimation.F == 1)) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l, 0.0F);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.l = true;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString, 1, "[" + this.jdField_a_of_type_Int + "]onAnimationStart[" + paramAnimation + "]");
    VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, (int)(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewAnimationAnimation.getDuration() / 5L));
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.w = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.w = 5;
      VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjn
 * JD-Core Version:    0.7.0.1
 */