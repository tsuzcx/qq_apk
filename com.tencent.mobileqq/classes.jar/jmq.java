import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class jmq
  implements Runnable
{
  jmq(jmp paramjmp, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jmp.a.getActivity() == null) || (this.jdField_a_of_type_Jmp.a.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_Jmp.a);
      QRUtils.a(1, 2131429987);
      return;
    }
    this.jdField_a_of_type_Jmp.a.a(false);
    String str = String.format(BaseApplication.getContext().getString(2131429664), new Object[] { RedPacketShareFragment.b(this.jdField_a_of_type_Jmp.a), RedPacketShareFragment.c(this.jdField_a_of_type_Jmp.a) });
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    if (this.jdField_a_of_type_Jmp.a.a != null)
    {
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Jmp.a.a.getAccount();
      localUserInfo.b = this.jdField_a_of_type_Jmp.a.a.getDisplayName(0, this.jdField_a_of_type_Jmp.a.a.getCurrentAccountUin(), null);
    }
    QZoneHelper.a(this.jdField_a_of_type_Jmp.a.getActivity(), localUserInfo, this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getString(2131429952), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmq
 * JD-Core Version:    0.7.0.1
 */