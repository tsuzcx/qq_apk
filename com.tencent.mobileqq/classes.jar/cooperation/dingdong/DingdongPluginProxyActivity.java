package cooperation.dingdong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class DingdongPluginProxyActivity
  extends PluginProxyActivity
{
  private static Class a(String paramString)
  {
    if (("com.dingdong.business.base.activity.DingdongDingActivity".equals(paramString)) || ("com.dingdong.business.Schedule.Activity.NewScheduleActivity".equals(paramString))) {
      return DingdongPluginProxyActivity.DingActivity.class;
    }
    if (("com.dingdong.business.approval.activity.ApprovalCommonActivity".equals(paramString)) || ("com.dingdong.business.approval.activity.ApprovalExpenseActivity".equals(paramString)) || ("com.dingdong.business.approval.activity.ApprovalHolidayActivity".equals(paramString))) {
      return DingdongPluginProxyActivity.ApprovalActivity.class;
    }
    return DingdongPluginProxyActivity.class;
  }
  
  public static void a(String paramString1, Activity paramActivity, String paramString2, Intent paramIntent, int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = DingdongPluginHelper.a(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginProxyActivity", 2, "launchPluginActivityForResult.isDingdongProcessExist=" + bool);
    }
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_a_of_type_JavaLangString = paramString1;
    localPluginParams.jdField_b_of_type_JavaLangString = "dingdong_plugin.apk";
    localPluginParams.d = "叮咚";
    localPluginParams.e = paramString2;
    localPluginParams.jdField_a_of_type_JavaLangClass = a(paramString2);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramQQProgressDialog;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public String getPluginID()
  {
    return "dingdong_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")) && (QLog.isColorLevel()))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = getIntent().getExtras();
      }
      paramBundle = localBundle.getString("pluginsdk_launchActivity");
      QLog.e("DingdongPluginProxyActivity", 2, "start plugin error: launch_activity_name=" + paramBundle + ", error_msg=" + this.mCreateErrorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */