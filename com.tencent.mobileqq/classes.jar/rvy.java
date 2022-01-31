import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class rvy
  implements DialogInterface.OnClickListener
{
  public rvy(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1, 16);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.c();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067FC", "0X80067FC", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvy
 * JD-Core Version:    0.7.0.1
 */