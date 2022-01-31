import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class joc
  implements Runnable
{
  joc(job paramjob, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Job.a.getActivity() == null) || (this.jdField_a_of_type_Job.a.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_Job.a);
      QRUtils.a(1, 2131430006);
      return;
    }
    this.jdField_a_of_type_Job.a.a(false);
    String str = String.format(BaseApplication.getContext().getString(2131429670), new Object[] { RedPacketShareFragment.b(this.jdField_a_of_type_Job.a), RedPacketShareFragment.c(this.jdField_a_of_type_Job.a) });
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    if (this.jdField_a_of_type_Job.a.a != null)
    {
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Job.a.a.getAccount();
      localUserInfo.b = this.jdField_a_of_type_Job.a.a.getDisplayName(0, this.jdField_a_of_type_Job.a.a.getCurrentAccountUin(), null);
    }
    QZoneHelper.a(this.jdField_a_of_type_Job.a.getActivity(), localUserInfo, this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getString(2131429970), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     joc
 * JD-Core Version:    0.7.0.1
 */