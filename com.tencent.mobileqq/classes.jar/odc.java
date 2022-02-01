import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;

public class odc
  implements bkzq
{
  public odc(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.o) {
      return;
    }
    this.a.o = true;
    switch (paramInt)
    {
    }
    label275:
    label279:
    for (;;)
    {
      this.a.b.dismiss();
      return;
      this.a.j = false;
      this.a.y();
      if (((onq)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.a.e)) {
        ((ook)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.a.e, null, null, null, 2L, false);
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = false;
      if ("2290230341".equals(this.a.e))
      {
        bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
        label179:
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
          break label275;
        }
      }
      for (paramView = this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;; paramView = "")
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
          break label279;
        }
        alhu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, paramView);
        break;
        if (!TextUtils.equals(String.valueOf(2062433139L), this.a.e)) {
          break label179;
        }
        olh.a(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", omx.a(null), false);
        break label179;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odc
 * JD-Core Version:    0.7.0.1
 */