package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  protected QWalletPayJsPlugin mJsPlugin;
  
  public QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver(QWalletPayJsPlugin paramQWalletPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletPayJsPlugin;
  }
  
  protected void onDestroy()
  {
    this.mJsPlugin = null;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" resultData = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("QWalletPayJsHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mJsPlugin;
    if (localObject != null)
    {
      if (paramBundle == null) {
        return;
      }
      if (QWalletPayJsPlugin.access$000((QWalletPayJsPlugin)localObject) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("activity.isFinishing():");
        ((StringBuilder)localObject).append(QWalletPayJsPlugin.access$000(this.mJsPlugin).isFinishing());
        QLog.d("QWalletPayJsHandler", 4, ((StringBuilder)localObject).toString());
        paramBundle = ((IH5HbUtil)QRoute.api(IH5HbUtil.class)).getGrapHbResult(paramInt, paramBundle, QWalletPayJsPlugin.access$000(this.mJsPlugin));
        if (paramBundle != null) {
          QWalletPayJsPlugin.access$100(this.mJsPlugin, paramBundle.toString());
        }
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mJsPlugin.mActivity == null:");
        boolean bool;
        if (QWalletPayJsPlugin.access$000(this.mJsPlugin) == null) {
          bool = true;
        } else {
          bool = false;
        }
        paramBundle.append(bool);
        QLog.i("QWalletPayJsHandler", 1, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */