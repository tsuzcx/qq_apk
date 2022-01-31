package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class PluginCommunicationHandler$PluginCommunicationChannelImpl$TransferRunnable$1
  implements RemoteCommand.OnInvokeFinishLinstener
{
  PluginCommunicationHandler$PluginCommunicationChannelImpl$TransferRunnable$1(PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable paramTransferRunnable, PluginCommunicationHandler.PluginCommunicationChannelImpl paramPluginCommunicationChannelImpl) {}
  
  public void onInvokeFinish(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.access$200(this.this$2).onRemoteCallback(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("plugin_tag", 2, "tranferAsync ", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.1
 * JD-Core Version:    0.7.0.1
 */