import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Map;

public final class rtb
  implements DialogInterface.OnClickListener
{
  public rtb(Map paramMap, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_JavaUtilMap.put("PstnLevel", "LEVEL2");
    this.jdField_a_of_type_JavaUtilMap.put("ipPstnEnterType", String.valueOf(0));
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilMap);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_b_of_type_Int == 6) {}
    for (paramInt = 1;; paramInt = 4)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X80063FA", "0X80063FA", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtb
 * JD-Core Version:    0.7.0.1
 */