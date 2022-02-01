package com.tencent.mobileqq.richmedia;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.util.BinderWarpper;

class RichmediaClient$1
  implements ServiceConnection
{
  RichmediaClient$1(RichmediaClient paramRichmediaClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LOG.a("PTV.RichmediaClient", "onServiceConnected");
    this.a.b = new Messenger(paramIBinder);
    paramComponentName = Message.obtain(null, 1);
    paramComponentName.replyTo = this.a.a;
    paramIBinder = new BinderWarpper(this.a.h.asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ICallBack_BinderWrapper", paramIBinder);
    paramComponentName.setData(localBundle);
    try
    {
      this.a.b.send(paramComponentName);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("MSG_C2S_REGISTER_CLIENT send failed. e = ");
      paramIBinder.append(paramComponentName);
      LOG.b("PTV.RichmediaClient", paramIBinder.toString());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaClient.1
 * JD-Core Version:    0.7.0.1
 */