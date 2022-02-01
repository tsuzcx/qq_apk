package com.tencent.mobileqq.emosm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class Client$1
  implements ServiceConnection
{
  Client$1(Client paramClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.mIsBound = true;
      this.a.mService = new Messenger(paramIBinder);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "ServiceConnection Attached.");
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).onBindSuc();
      paramComponentName = Message.obtain(null, 1);
      paramComponentName.replyTo = this.a.mMessenger;
      this.a.mService.send(paramComponentName);
      return;
    }
    catch (Exception paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.Client", 2, paramComponentName.getMessage());
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = this.a;
    paramComponentName.mService = null;
    paramComponentName.onDisconnectWithService();
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.Client", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.1
 * JD-Core Version:    0.7.0.1
 */