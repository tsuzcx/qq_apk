import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class sbm
  implements DialogInterface.OnClickListener
{
  public sbm(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b, true, null, true, true, null, "from_internal");
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Int == 5) {}
    for (paramInt = 2;; paramInt = 3)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X80063FC", "0X80063FC", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbm
 * JD-Core Version:    0.7.0.1
 */