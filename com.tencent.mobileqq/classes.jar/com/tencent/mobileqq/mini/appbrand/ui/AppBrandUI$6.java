package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.qphone.base.util.QLog;

class AppBrandUI$6
  implements DialogInterface.OnClickListener
{
  AppBrandUI$6(AppBrandUI paramAppBrandUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "confirm");
    AppLoaderFactory.getMiniAppInterface().exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.6
 * JD-Core Version:    0.7.0.1
 */