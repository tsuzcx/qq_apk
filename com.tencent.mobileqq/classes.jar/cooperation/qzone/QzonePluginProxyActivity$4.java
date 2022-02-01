package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import avlg;
import blwh;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class QzonePluginProxyActivity$4
  implements QZoneHelper.StartActivity
{
  QzonePluginProxyActivity$4(Intent paramIntent, String paramString, avlg paramavlg, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.getActivityNameToIntent(this.val$intent);
    Class localClass = QzonePluginProxyActivity.PluginProxyActivityClassFactory.getPluginProxyActivityClass(str);
    this.val$intent.putExtra("userQqResources", 2);
    this.val$intent.putExtra("click_time", System.currentTimeMillis());
    blwh localblwh = new blwh(0);
    localblwh.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localblwh.jdField_d_of_type_JavaLangString = "QZone";
    localblwh.jdField_a_of_type_JavaLangString = this.val$uin;
    localblwh.jdField_a_of_type_Avlg = this.val$session;
    localblwh.jdField_e_of_type_JavaLangString = str;
    localblwh.jdField_a_of_type_JavaLangClass = localClass;
    localblwh.jdField_a_of_type_AndroidContentIntent = this.val$intent;
    localblwh.jdField_b_of_type_Int = this.val$requestCode;
    if (this.val$disableActivityAnimation)
    {
      localblwh.jdField_d_of_type_Int = 2130772106;
      localblwh.jdField_e_of_type_Int = 2130772106;
    }
    localblwh.c = 60000;
    localblwh.f = null;
    localblwh.jdField_b_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivity.4.1(this, str, paramBoolean1, paramBoolean2, localblwh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4
 * JD-Core Version:    0.7.0.1
 */