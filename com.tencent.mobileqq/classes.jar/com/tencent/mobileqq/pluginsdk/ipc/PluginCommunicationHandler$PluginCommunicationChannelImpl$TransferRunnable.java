package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

class PluginCommunicationHandler$PluginCommunicationChannelImpl$TransferRunnable
  implements Runnable
{
  private RemoteCallback mCb;
  private String mCmd;
  private RemoteCommand.OnInvokeFinishLinstener mListener;
  private Bundle mParams;
  
  PluginCommunicationHandler$PluginCommunicationChannelImpl$TransferRunnable(PluginCommunicationHandler.PluginCommunicationChannelImpl paramPluginCommunicationChannelImpl, String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
  {
    this.mCmd = paramString;
    this.mCb = paramRemoteCallback;
    this.mParams = paramBundle;
    paramString = this.mParams;
    if (paramString != null) {
      paramString.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    if (this.mCb != null) {
      this.mListener = new PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.1(this, paramPluginCommunicationChannelImpl);
    }
  }
  
  public void run()
  {
    synchronized (PluginCommunicationHandler.access$100(this.this$1.this$0))
    {
      RemoteCommand localRemoteCommand = (RemoteCommand)PluginCommunicationHandler.access$100(this.this$1.this$0).get(this.mCmd);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("tranferAsync,");
        ((StringBuilder)???).append(localRemoteCommand);
        QLog.d("plugin_tag", 2, ((StringBuilder)???).toString());
      }
      if (localRemoteCommand == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
        }
        return;
      }
      if (localRemoteCommand.isSynchronized())
      {
        ??? = PluginCommunicationHandler.PluginCommunicationChannelImpl.access$300(this.this$1, this.mCmd, this.mParams);
        if (??? != null) {}
        try
        {
          ((Bundle)???).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          this.mCb.onRemoteCallback((Bundle)???);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          if (!QLog.isColorLevel()) {
            break label170;
          }
        }
        QLog.w("plugin_tag", 2, "tranferAsync ", localRemoteException);
      }
      else
      {
        localRemoteCommand.invoke(this.mParams, this.mListener);
      }
      label170:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable
 * JD-Core Version:    0.7.0.1
 */