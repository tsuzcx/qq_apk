import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ntp
  implements View.OnClickListener
{
  ntp(ntc paramntc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (this.jdField_a_of_type_Ntc.d)
    {
      this.jdField_a_of_type_Ntc.e = true;
      if (this.jdField_a_of_type_Int == 0)
      {
        bdll.b(this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + str);
      }
      ntc.c(this.jdField_a_of_type_Ntc, str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString;
      continue;
      bdll.b(this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntp
 * JD-Core Version:    0.7.0.1
 */