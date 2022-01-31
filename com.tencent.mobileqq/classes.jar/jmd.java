import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class jmd
  implements Runnable
{
  jmd(jmc paramjmc, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.getActivity() == null) || (this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
      QRUtils.a(1, 2131430004);
      return;
    }
    this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a(false);
    if (this.jdField_a_of_type_Jmc.jdField_a_of_type_Int == 2)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a, 0);
      return;
    }
    if (this.jdField_a_of_type_Jmc.jdField_a_of_type_Int == 3)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a, 1);
      return;
    }
    RedPacketShareFragment.a(this.jdField_a_of_type_Jmc.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmd
 * JD-Core Version:    0.7.0.1
 */