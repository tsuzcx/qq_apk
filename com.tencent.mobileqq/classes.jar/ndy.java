import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class ndy
  implements bhuk
{
  ndy(bhuf parambhuf, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
      try
      {
        ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOMessageEngineFalse");
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("CrmUtils", 2, "Start ivr audio error", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ndy
 * JD-Core Version:    0.7.0.1
 */