package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.utils.H5HbUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
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
    if (QLog.isColorLevel()) {
      QLog.i("TenpayPlugin", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.mJsPlugin == null) || (paramBundle == null)) {}
    do
    {
      return;
      paramBundle = H5HbUtil.a(paramInt, paramBundle, this.mJsPlugin.getActivity());
    } while (paramBundle == null);
    this.mJsPlugin.evaluateCallback(true, paramBundle, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */