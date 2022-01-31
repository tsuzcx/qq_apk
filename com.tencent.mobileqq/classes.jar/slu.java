import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

class slu
  implements DialogInterface.OnClickListener
{
  slu(slt paramslt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramDialogInterface.dismiss();
        this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_AndroidAppDialog = null;
        return;
      }
      catch (Exception paramDialogInterface) {}
      if (SettingCloneUtil.readValue(this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
        this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "logout");
      }
      this.a.jdField_a_of_type_Sls.a.a(this.a.jdField_a_of_type_Sls.a.a(), this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      if (this.a.jdField_a_of_type_JavaLangString.startsWith("http")) {}
      for (;;)
      {
        try
        {
          Intent localIntent = new Intent(this.a.jdField_a_of_type_Sls.a.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", this.a.jdField_a_of_type_JavaLangString);
          this.a.jdField_a_of_type_Sls.a.a().startActivity(localIntent);
          ReportController.b(this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008273", "0X8008273", 0, 0, "", "", "", "");
        }
        catch (Exception localException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (this.a.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
          JumpParser.a(this.a.jdField_a_of_type_Sls.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_Sls.a.a(), this.a.jdField_a_of_type_JavaLangString).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slu
 * JD-Core Version:    0.7.0.1
 */