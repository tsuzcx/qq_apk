import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class nja
  implements View.OnClickListener
{
  nja(nin paramnin, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Nin.d)
    {
      this.jdField_a_of_type_Nin.e = true;
      if (this.jdField_a_of_type_Int == 0)
      {
        azqs.b(this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.jdField_a_of_type_Nin.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + paramView);
      }
      nin.c(this.jdField_a_of_type_Nin, paramView);
      return;
      azqs.b(this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.jdField_a_of_type_Nin.jdField_a_of_type_JavaLangString;
      continue;
      azqs.b(this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramView = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.jdField_a_of_type_Nin.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */