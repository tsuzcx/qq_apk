import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class nwx
  implements bkzq
{
  nwx(bkzi parambkzi, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
      try
      {
        nwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOMessageEngineFalse");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwx
 * JD-Core Version:    0.7.0.1
 */