package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.os.MqqHandler;

final class QzonePluginProxyActivity$4
  implements QZoneHelper.StartActivity
{
  QzonePluginProxyActivity$4(Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.getActivityNameToIntent(this.val$intent);
    Class localClass = QzonePluginProxyActivity.PluginProxyActivityClassFactory.getPluginProxyActivityClass(str);
    this.val$intent.putExtra("userQqResources", 2);
    this.val$intent.putExtra("click_time", System.currentTimeMillis());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localPluginParams.jdField_e_of_type_JavaLangString = "QZone";
    localPluginParams.jdField_a_of_type_JavaLangString = this.val$uin;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.val$session;
    localPluginParams.jdField_f_of_type_JavaLangString = str;
    localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = this.val$intent;
    localPluginParams.c = this.val$requestCode;
    if (this.val$disableActivityAnimation)
    {
      localPluginParams.jdField_e_of_type_Int = 2130772121;
      localPluginParams.jdField_f_of_type_Int = 2130772121;
    }
    localPluginParams.d = 60000;
    localPluginParams.g = null;
    localPluginParams.jdField_b_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivity.4.1(this, str, paramBoolean1, paramBoolean2, localPluginParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4
 * JD-Core Version:    0.7.0.1
 */