package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;

class g
  implements Runnable
{
  g(PluginManagerClient paramPluginManagerClient, String paramString) {}
  
  public void run()
  {
    try
    {
      this.b.a.installPlugin(this.a, null);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */