package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import aufm;
import bkkz;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class QzonePluginProxyActivity$4
  implements QZoneHelper.StartActivity
{
  QzonePluginProxyActivity$4(Intent paramIntent, String paramString, aufm paramaufm, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.getActivityNameToIntent(this.val$intent);
    Class localClass = QzonePluginProxyActivity.PluginProxyActivityClassFactory.getPluginProxyActivityClass(str);
    this.val$intent.putExtra("userQqResources", 2);
    this.val$intent.putExtra("click_time", System.currentTimeMillis());
    bkkz localbkkz = new bkkz(0);
    localbkkz.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localbkkz.jdField_d_of_type_JavaLangString = "QZone";
    localbkkz.jdField_a_of_type_JavaLangString = this.val$uin;
    localbkkz.jdField_a_of_type_Aufm = this.val$session;
    localbkkz.jdField_e_of_type_JavaLangString = str;
    localbkkz.jdField_a_of_type_JavaLangClass = localClass;
    localbkkz.jdField_a_of_type_AndroidContentIntent = this.val$intent;
    localbkkz.jdField_b_of_type_Int = this.val$requestCode;
    if (this.val$disableActivityAnimation)
    {
      localbkkz.jdField_d_of_type_Int = 2130772106;
      localbkkz.jdField_e_of_type_Int = 2130772106;
    }
    localbkkz.c = 60000;
    localbkkz.f = null;
    localbkkz.jdField_b_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivity.4.1(this, str, paramBoolean1, paramBoolean2, localbkkz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4
 * JD-Core Version:    0.7.0.1
 */