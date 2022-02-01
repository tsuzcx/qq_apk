package com.vivo.vms;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IPCCallback
  extends IInterface
{
  public abstract void call(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCCallback
 * JD-Core Version:    0.7.0.1
 */