package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public abstract interface EIPCChannel
  extends IInterface
{
  public abstract EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2);
  
  public abstract void callback(int paramInt, EIPCResult paramEIPCResult);
  
  public abstract String getProcName();
  
  public abstract int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2);
  
  public abstract IBinder setStubBinder(int paramInt, IBinder paramIBinder);
  
  public abstract EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCChannel
 * JD-Core Version:    0.7.0.1
 */