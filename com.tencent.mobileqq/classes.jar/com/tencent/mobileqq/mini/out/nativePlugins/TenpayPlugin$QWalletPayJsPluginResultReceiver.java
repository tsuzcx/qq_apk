package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.qphone.base.util.QLog;

public class TenpayPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  private AppInterface mApp;
  protected JSContext mJsPlugin;
  
  public TenpayPlugin$QWalletPayJsPluginResultReceiver(JSContext paramJSContext, Handler paramHandler, AppInterface paramAppInterface)
  {
    super(paramHandler);
    this.mJsPlugin = paramJSContext;
    this.mApp = paramAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" resultData = ");
      localStringBuilder.append(paramBundle);
      QLog.i("TenpayPlugin", 2, localStringBuilder.toString());
    }
    if (this.mJsPlugin != null)
    {
      if (paramBundle == null) {
        return;
      }
      paramBundle = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapHbResult(paramInt, paramBundle, this.mJsPlugin.getActivity());
      if (paramBundle != null) {
        this.mJsPlugin.evaluateCallback(true, paramBundle, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */