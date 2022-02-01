package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;

public abstract interface IQRemoteProxy
{
  public abstract void callServerAsync(String paramString, Bundle paramBundle, IQRemoteResultCallback paramIQRemoteResultCallback);
  
  public abstract QRemoteResult callServerSync(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.IQRemoteProxy
 * JD-Core Version:    0.7.0.1
 */