import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.CharacterUtil;

public class kdd
  implements QavInOutAnimation.QavOutAnimationListener
{
  public kdd(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364272, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365419, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365418, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365416, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365414, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364274, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kdd
 * JD-Core Version:    0.7.0.1
 */