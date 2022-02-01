package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface RemoteCallback
  extends IInterface
{
  public abstract void onRemoteCallback(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback
 * JD-Core Version:    0.7.0.1
 */