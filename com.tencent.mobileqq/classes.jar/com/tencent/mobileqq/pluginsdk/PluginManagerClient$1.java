package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;

class PluginManagerClient$1
  implements Runnable
{
  PluginManagerClient$1(PluginManagerClient paramPluginManagerClient, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.mRemote.installPlugin(this.val$pluginId, null);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient.1
 * JD-Core Version:    0.7.0.1
 */