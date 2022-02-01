package com.tencent.qqmini.sdk.launcher.core.proxy;

public abstract interface ChannelProxy$ICommandListenr
{
  public abstract void onFailure(String paramString);
  
  public abstract void onFinish(boolean paramBoolean);
  
  public abstract void onProgress(String paramString);
  
  public abstract void onStart();
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
 * JD-Core Version:    0.7.0.1
 */