import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class nge
  implements View.OnClickListener
{
  nge(nfr paramnfr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Nfr.d)
    {
      this.jdField_a_of_type_Nfr.e = true;
      if (this.jdField_a_of_type_Int == 0)
      {
        axqy.b(this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + paramView);
      }
      nfr.c(this.jdField_a_of_type_Nfr, paramView);
      return;
      axqy.b(this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangString;
      continue;
      axqy.b(this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nge
 * JD-Core Version:    0.7.0.1
 */