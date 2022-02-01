package eipc;

import android.os.IInterface;

public abstract interface EIPCCallback
  extends IInterface
{
  public abstract void callback(EIPCResult paramEIPCResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCCallback
 * JD-Core Version:    0.7.0.1
 */