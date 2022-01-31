import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class otc
  implements Runnable
{
  otc(ota paramota, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ota.a.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Ota.a.jdField_c_of_type_Int == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_Ota.a.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ota.a.jdField_a_of_type_Int), "1" });
      }
      QRUtils.a(1, 2131430004);
      return;
    }
    String str;
    if (this.jdField_a_of_type_Ota.a.jdField_c_of_type_Int == 2) {
      str = this.jdField_a_of_type_Ota.a.getString(2131429971, new Object[] { this.jdField_a_of_type_Ota.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ota.a.jdField_c_of_type_JavaLangString });
    }
    for (;;)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ota.a.app.getAccount();
      localUserInfo.b = ContactUtils.j(this.jdField_a_of_type_Ota.a.app, this.jdField_a_of_type_Ota.a.app.getAccount());
      QZoneHelper.a(this.jdField_a_of_type_Ota.a, localUserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ota.a.getString(2131429969), str, 1);
      return;
      if (this.jdField_a_of_type_Ota.a.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_Ota.a.getString(2131429970, new Object[] { this.jdField_a_of_type_Ota.a.jdField_a_of_type_JavaLangString });
      } else {
        str = this.jdField_a_of_type_Ota.a.getString(2131429972);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otc
 * JD-Core Version:    0.7.0.1
 */