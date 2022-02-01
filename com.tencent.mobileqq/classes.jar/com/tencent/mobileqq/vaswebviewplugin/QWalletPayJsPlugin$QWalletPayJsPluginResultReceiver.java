package com.tencent.mobileqq.vaswebviewplugin;

import akwr;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  private WeakReference<Activity> mActivityWeakReference;
  private AppInterface mApp;
  protected QWalletPayJsPlugin mJsPlugin;
  
  public QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver(QWalletPayJsPlugin paramQWalletPayJsPlugin, Handler paramHandler, AppInterface paramAppInterface, WeakReference<Activity> paramWeakReference)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletPayJsPlugin;
    this.mApp = paramAppInterface;
    this.mActivityWeakReference = paramWeakReference;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.mJsPlugin == null) || (paramBundle == null)) {}
    do
    {
      return;
      if (this.mActivityWeakReference == null) {
        break label112;
      }
      Activity localActivity = (Activity)this.mActivityWeakReference.get();
      if (localActivity == null) {
        break;
      }
      paramBundle = akwr.a(paramInt, paramBundle, localActivity);
    } while (paramBundle == null);
    QWalletPayJsPlugin.access$000(this.mJsPlugin, paramBundle.toString());
    return;
    QLog.i("QWalletPayJsHandler", 1, "activity is null");
    return;
    label112:
    QLog.i("QWalletPayJsHandler", 1, "mActivityWeakReference is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */