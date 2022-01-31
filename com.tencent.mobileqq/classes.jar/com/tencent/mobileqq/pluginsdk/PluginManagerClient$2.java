package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;

class PluginManagerClient$2
  implements Runnable
{
  PluginManagerClient$2(PluginManagerClient paramPluginManagerClient, String paramString, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    try
    {
      this.this$0.mRemote.installPlugin(this.val$pluginId, this.val$listener);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient.2
 * JD-Core Version:    0.7.0.1
 */