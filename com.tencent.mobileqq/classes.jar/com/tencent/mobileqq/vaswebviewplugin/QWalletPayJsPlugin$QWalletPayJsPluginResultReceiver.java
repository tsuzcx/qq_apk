package com.tencent.mobileqq.vaswebviewplugin;

import akfz;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  protected WeakReference<QWalletPayJsPlugin> mJsPluginRef;
  
  public QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver(QWalletPayJsPlugin paramQWalletPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPluginRef = new WeakReference(paramQWalletPayJsPlugin);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if (this.mJsPluginRef == null) {}
    QWalletPayJsPlugin localQWalletPayJsPlugin;
    Activity localActivity;
    do
    {
      do
      {
        return;
        localQWalletPayJsPlugin = (QWalletPayJsPlugin)this.mJsPluginRef.get();
      } while ((localQWalletPayJsPlugin == null) || (paramBundle == null));
      localActivity = QWalletPayJsPlugin.access$000(localQWalletPayJsPlugin);
      if (localActivity == null) {
        break;
      }
      QLog.d("QWalletPayJsHandler", 4, "activity.isFinishing():" + localActivity.isFinishing());
      paramBundle = akfz.a(paramInt, paramBundle, localActivity);
    } while (paramBundle == null);
    QWalletPayJsPlugin.access$100(localQWalletPayJsPlugin, paramBundle.toString());
    return;
    paramBundle = new StringBuilder().append("activity==null:");
    if (localActivity == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QWalletPayJsHandler", 1, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */