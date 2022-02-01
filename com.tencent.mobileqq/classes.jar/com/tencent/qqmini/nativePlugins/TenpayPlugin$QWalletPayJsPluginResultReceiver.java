package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.utils.H5HbUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import mqq.util.WeakReference;

public class TenpayPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected RequestEvent a;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  
  public TenpayPlugin$QWalletPayJsPluginResultReceiver(RequestEvent paramRequestEvent, Handler paramHandler, AppInterface paramAppInterface, WeakReference<Activity> paramWeakReference)
  {
    super(paramHandler);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("TenpayPlugin", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent == null) || (paramBundle == null) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {}
    do
    {
      return;
      paramBundle = H5HbUtil.a(paramInt, paramBundle, (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    } while (paramBundle == null);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */