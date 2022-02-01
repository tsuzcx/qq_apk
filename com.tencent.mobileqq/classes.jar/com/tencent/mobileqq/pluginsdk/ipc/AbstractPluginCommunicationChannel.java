package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;

public abstract class AbstractPluginCommunicationChannel
  extends PluginCommunicationChannel.Stub
{
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */