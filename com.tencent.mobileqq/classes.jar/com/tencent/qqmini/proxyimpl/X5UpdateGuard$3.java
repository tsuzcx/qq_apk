package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;

class X5UpdateGuard$3
  implements DialogInterface.OnClickListener
{
  X5UpdateGuard$3(X5UpdateGuard paramX5UpdateGuard, IMiniAppContext paramIMiniAppContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard).postDelayed(X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard), 15000L);
    QbSdk.setTbsListener(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard);
    TbsDownloader.startDownload(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getContext(), true);
    if (X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard) == null) {
      X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard, new X5UpdateGuard.LoadingDialog(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity()));
    }
    X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard).a(HardCodeUtil.a(2131705965));
    if (!X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard).isShowing()) {
      X5UpdateGuard.a(this.jdField_a_of_type_ComTencentQqminiProxyimplX5UpdateGuard).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.3
 * JD-Core Version:    0.7.0.1
 */