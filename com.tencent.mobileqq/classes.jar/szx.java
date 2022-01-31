import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AlertReport.ButtonAction;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqprotect.common.QPMiscUtils;

public class szx
  implements DialogInterface.OnClickListener
{
  public szx(NotificationActivity paramNotificationActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      Object localObject;
      String str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app.getCurrentAccountUin();
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", paramDialogInterface);
        str = this.jdField_a_of_type_JavaLangString;
        if (str.indexOf("?") != -1) {
          break label203;
        }
        paramDialogInterface = str + "?uin=" + paramDialogInterface;
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("url", paramDialogInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity((Intent)localObject);
        try
        {
          paramDialogInterface = new AlertReport.ButtonAction();
          paramDialogInterface.uint32_cmd.set(1);
          paramDialogInterface.uint32_button_id.set(this.jdField_a_of_type_Int);
          paramDialogInterface.str_package_name.set(QPMiscUtils.c());
          paramDialogInterface.uint32_app_id.set(AppSetting.jdField_a_of_type_Int);
          ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
          ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.jdField_a_of_type_Int, 0, this.b, "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
          return;
          label203:
          paramDialogInterface = str + "&uin=" + paramDialogInterface;
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            paramDialogInterface.printStackTrace();
          }
        }
      }
      try
      {
        localObject = new AlertReport.ButtonAction();
        ((AlertReport.ButtonAction)localObject).uint32_cmd.set(1);
        ((AlertReport.ButtonAction)localObject).uint32_button_id.set(this.jdField_a_of_type_Int);
        ((AlertReport.ButtonAction)localObject).str_package_name.set(QPMiscUtils.c());
        ((AlertReport.ButtonAction)localObject).uint32_app_id.set(AppSetting.jdField_a_of_type_Int);
        ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, ((AlertReport.ButtonAction)localObject).toByteArray(), 34, "SecuritySvc.AlertReport");
        ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.jdField_a_of_type_Int, 0, this.b, "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
        throw paramDialogInterface;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface = paramDialogInterface;
      paramDialogInterface.printStackTrace();
      try
      {
        paramDialogInterface = new AlertReport.ButtonAction();
        paramDialogInterface.uint32_cmd.set(1);
        paramDialogInterface.uint32_button_id.set(this.jdField_a_of_type_Int);
        paramDialogInterface.str_package_name.set(QPMiscUtils.c());
        paramDialogInterface.uint32_app_id.set(AppSetting.jdField_a_of_type_Int);
        ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
        ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.jdField_a_of_type_Int, 0, this.b, "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
        return;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          paramDialogInterface.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */