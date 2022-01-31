package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;

class h
  implements Runnable
{
  h(PluginManagerClient paramPluginManagerClient, String paramString, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    try
    {
      this.c.a.installPlugin(this.a, this.b);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.h
 * JD-Core Version:    0.7.0.1
 */