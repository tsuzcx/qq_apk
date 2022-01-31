package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;

public abstract class AbstractPluginCommunicationChannel
  extends PluginCommunicationChannel.Stub
{
  public Bundle transfer(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    return null;
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
    throws RemoteException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */