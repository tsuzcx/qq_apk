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
  protected RequestEvent a;
  private AppInterface b;
  private WeakReference<Activity> c;
  
  public TenpayPlugin$QWalletPayJsPluginResultReceiver(RequestEvent paramRequestEvent, Handler paramHandler, AppInterface paramAppInterface, WeakReference<Activity> paramWeakReference)
  {
    super(paramHandler);
    this.a = paramRequestEvent;
    this.b = paramAppInterface;
    this.c = paramWeakReference;
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
    if ((this.a != null) && (paramBundle != null))
    {
      localObject = this.c;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        paramBundle = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapHbResult(paramInt, paramBundle, (Activity)this.c.get());
        if (paramBundle != null) {
          this.a.ok(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */