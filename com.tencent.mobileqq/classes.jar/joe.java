import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class joe
  implements Runnable
{
  joe(jod paramjod, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.getActivity() == null) || (this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
      QRUtils.a(1, 2131430006);
      return;
    }
    this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a(false);
    Object localObject;
    if (this.jdField_a_of_type_Jod.jdField_a_of_type_Int == 2)
    {
      localObject = new jof(this);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      RedPacketShareFragment.a(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a, 0, true, RedPacketShareFragment.d(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment));
      return;
    }
    if (this.jdField_a_of_type_Jod.jdField_a_of_type_Int == 3)
    {
      localObject = new jog(this);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      RedPacketShareFragment.a(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment.a, 1, true, RedPacketShareFragment.d(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment));
      return;
    }
    RedPacketShareFragment.a(this.jdField_a_of_type_Jod.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     joe
 * JD-Core Version:    0.7.0.1
 */