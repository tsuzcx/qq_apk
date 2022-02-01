import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class nwc
  implements bjoe
{
  public nwc(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.o) {
      return;
    }
    this.a.o = true;
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
      this.a.y();
      if (((ofx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).a(this.a.e)) {
        ((ogr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88)).a(134243868, this.a.e, null, null, null, 2L, false);
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = false;
      if ("2290230341".equals(this.a.e))
      {
        bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
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
        akmc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, paramView);
        break;
        if (!TextUtils.equals(String.valueOf(2062433139L), this.a.e)) {
          break label177;
        }
        odq.a(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", ofe.a(null), false);
        break label177;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwc
 * JD-Core Version:    0.7.0.1
 */