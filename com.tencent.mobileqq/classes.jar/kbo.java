import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.CharacterUtil;

public class kbo
  implements QavInOutAnimation.QavOutAnimationListener
{
  public kbo(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364223, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365392, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365389, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365387, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364225, false);
    }
  }
  
  public void b()
  {
    this.a.d = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.a.h) {
        break label107;
      }
      long l = CharacterUtil.a(this.a.c);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      if (!this.a.g)
      {
        this.a.g = true;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, 2);
      }
      this.a.e = true;
      this.a.finish();
    }
    for (;;)
    {
      this.a.overridePendingTransition(0, 2131034269);
      return;
      label107:
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(246);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.c, 0);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbo
 * JD-Core Version:    0.7.0.1
 */