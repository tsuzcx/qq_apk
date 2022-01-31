import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class kbe
  extends GAudioUIObserver
{
  public kbe(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "VideoInviteActivity onDestroyInviteUI, relationId:" + paramLong);
    }
    boolean bool = this.a.h;
    if ((bool) && (this.a.c != null) && (this.a.c.equals(String.valueOf(paramLong))))
    {
      super.c(paramLong);
      TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a("VideoInviteActivity.onDestroyInviteUI");
      if ((bool) && (this.a.c.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.a.c).longValue();
        if (!this.a.g)
        {
          this.a.g = true;
          if (paramInt != 1) {
            break label217;
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 7);
        }
      }
    }
    for (;;)
    {
      this.a.e = true;
      if ((this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) || (!(this.a instanceof VideoInviteFull))) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kbf(this));
      return;
      label217:
      if (paramInt == 2) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 2);
      }
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbe
 * JD-Core Version:    0.7.0.1
 */