package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bkyw;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class NavigationJsPlugin$6
  extends ResultReceiver
{
  public NavigationJsPlugin$6(bkyw parambkyw, Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener.onLaunchResult(true, null);
      }
      if ((bkyw.a(this.jdField_a_of_type_Bkyw).getAttachedActivity() != null) && (!bkyw.b(this.jdField_a_of_type_Bkyw).getAttachedActivity().isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        bkyw.c(this.jdField_a_of_type_Bkyw).getAttachedActivity().finish();
      }
    }
    do
    {
      return;
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
    } while (this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener == null);
    this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener.onLaunchResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */