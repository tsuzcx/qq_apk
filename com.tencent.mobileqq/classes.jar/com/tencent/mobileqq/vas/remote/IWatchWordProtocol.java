package com.tencent.mobileqq.vas.remote;

import eipc.EIPCModule;
import eipc.EIPCResultCallback;

public abstract interface IWatchWordProtocol
{
  public abstract void a(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
  
  public abstract void a(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.remote.IWatchWordProtocol
 * JD-Core Version:    0.7.0.1
 */