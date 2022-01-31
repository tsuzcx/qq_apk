import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class rvv
  implements DialogInterface.OnClickListener
{
  public rvv(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 12);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.a();
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Int == 6) {}
    for (paramInt = 1;; paramInt = 4)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X80063F9", "0X80063F9", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvv
 * JD-Core Version:    0.7.0.1
 */