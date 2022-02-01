package com.vivo.vms;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IPCInvoke
  extends IInterface
{
  public abstract Bundle asyncCall(Bundle paramBundle, IPCCallback paramIPCCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCInvoke
 * JD-Core Version:    0.7.0.1
 */