import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class rwj
  implements DialogInterface.OnClickListener
{
  public rwj(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1, 8);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Int == 5) {}
    for (paramInt = 2;; paramInt = 3)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X80063FB", "0X80063FB", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwj
 * JD-Core Version:    0.7.0.1
 */