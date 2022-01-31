import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Map;

public final class sax
  implements DialogInterface.OnClickListener
{
  public sax(QQAppInterface paramQQAppInterface, boolean paramBoolean1, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map paramMap, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyRelevantHandler localNearbyRelevantHandler = (NearbyRelevantHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localNearbyRelevantHandler != null) {
      localNearbyRelevantHandler.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap, this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sax
 * JD-Core Version:    0.7.0.1
 */