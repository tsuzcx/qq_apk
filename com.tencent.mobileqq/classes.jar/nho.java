import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class nho
  implements bfph
{
  public nho(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.p) {
      return;
    }
    this.a.p = true;
    switch (paramInt)
    {
    }
    label273:
    label277:
    for (;;)
    {
      this.a.b.dismiss();
      return;
      this.a.j = false;
      this.a.x();
      if (((nqn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).a(this.a.d)) {
        ((nrf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134243868, this.a.d, null, null, null, 2L, false);
      }
      actj.n = false;
      if ("2290230341".equals(this.a.d))
      {
        axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
        label177:
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
          break label273;
        }
      }
      for (paramView = this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;; paramView = "")
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
          break label277;
        }
        ahoo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d, paramView);
        break;
        if (!TextUtils.equals(String.valueOf(2062433139L), this.a.d)) {
          break label177;
        }
        nol.a(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", npu.a(null), false);
        break label177;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nho
 * JD-Core Version:    0.7.0.1
 */