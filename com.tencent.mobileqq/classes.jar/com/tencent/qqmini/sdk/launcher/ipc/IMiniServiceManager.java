package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.IBinder;
import android.os.IInterface;

public abstract interface IMiniServiceManager
  extends IInterface
{
  public abstract void addService(String paramString, IBinder paramIBinder);
  
  public abstract IBinder checkService(String paramString);
  
  public abstract IBinder getService(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
 * JD-Core Version:    0.7.0.1
 */