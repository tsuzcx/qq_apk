package com.tencent.open.appcommon.js;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.MyAppDialog;

class AppInterface$1
  implements DialogInterface.OnClickListener
{
  AppInterface$1(AppInterface paramAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (paramInt == 2131691631)
    {
      StaticAnalyz.a("200", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
      paramDialogInterface = CommonDataAdapter.a().a().getSharedPreferences("package_scan", 0).edit();
      paramDialogInterface.putBoolean("qqsetting_package_scan_flag", false);
      paramDialogInterface.commit();
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
      }
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.append("','r':'0','data':'0'});}void(0);");
      paramDialogInterface = paramDialogInterface.toString();
    }
    else if (paramInt == 2131691630)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
      }
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.append("','r':'0','data':'1'});}void(0);");
      paramDialogInterface = paramDialogInterface.toString();
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.mHandler.post(new AppInterface.1.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.1
 * JD-Core Version:    0.7.0.1
 */