import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class orr
  implements Runnable
{
  orr(orq paramorq, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Orq.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          QRUtils.a(1, 2131429987);
        } while (this.jdField_a_of_type_Orq.a.jdField_c_of_type_Int != 2);
        if (this.jdField_a_of_type_Orq.a.h == 2) {}
        for (String str = "qr_wechat";; str = "qr_circle")
        {
          TroopReportor.a("Grp_share", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_Orq.a.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Orq.a.a), "1" });
          return;
        }
        if (this.jdField_a_of_type_Orq.a.h != 2) {
          break;
        }
        WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Orq.a.b, 0);
        if (this.jdField_a_of_type_Orq.a.jdField_c_of_type_Int == 2)
        {
          ReportController.b(this.jdField_a_of_type_Orq.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.jdField_a_of_type_Orq.a.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Orq.a.a), "");
          return;
        }
      } while (this.jdField_a_of_type_Orq.a.jdField_c_of_type_Int != 5);
      ReportController.b(this.jdField_a_of_type_Orq.a.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
      return;
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Orq.a.b, 1);
      if (this.jdField_a_of_type_Orq.a.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.jdField_a_of_type_Orq.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.jdField_a_of_type_Orq.a.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Orq.a.a), "");
        return;
      }
    } while (this.jdField_a_of_type_Orq.a.jdField_c_of_type_Int != 5);
    ReportController.b(this.jdField_a_of_type_Orq.a.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */