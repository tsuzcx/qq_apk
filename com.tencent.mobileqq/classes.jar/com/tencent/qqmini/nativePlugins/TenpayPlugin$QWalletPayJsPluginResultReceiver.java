package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" resultData = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent != null) && (paramBundle != null))
    {
      localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        paramBundle = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapHbResult(paramInt, paramBundle, (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
        if (paramBundle != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */