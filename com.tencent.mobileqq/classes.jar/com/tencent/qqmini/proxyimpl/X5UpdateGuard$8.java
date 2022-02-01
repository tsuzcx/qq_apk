package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;

class X5UpdateGuard$8
  implements DialogInterface.OnClickListener
{
  X5UpdateGuard$8(X5UpdateGuard paramX5UpdateGuard) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    AppBrandProxy.g().sendCmd("cmd_exit_qq", new Bundle(), null);
    AppLoaderFactory.getMiniAppInterface().exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.8
 * JD-Core Version:    0.7.0.1
 */