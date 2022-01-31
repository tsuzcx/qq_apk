import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;

public final class ryb
  implements DialogInterface.OnClickListener
{
  public ryb(PstnManager paramPstnManager, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map paramMap, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = ((QQCustomDialog)paramDialogInterface).getCheckBoxState();
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a(true);
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.d, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Int, false);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool) {}
    for (paramInt = 1;; paramInt = 2)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8006402", "0X8006402", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryb
 * JD-Core Version:    0.7.0.1
 */