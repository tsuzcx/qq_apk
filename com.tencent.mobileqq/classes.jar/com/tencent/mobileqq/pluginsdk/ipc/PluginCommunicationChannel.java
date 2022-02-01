package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface PluginCommunicationChannel
  extends IInterface
{
  public abstract String getNickName();
  
  public abstract String getSKey();
  
  public abstract String getSid();
  
  public abstract long getUin();
  
  public abstract Bundle transfer(String paramString, Bundle paramBundle);
  
  public abstract void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */