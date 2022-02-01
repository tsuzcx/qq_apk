package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface MiniCmdCallback
  extends IInterface
{
  public abstract void onCmdResult(boolean paramBoolean, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
 * JD-Core Version:    0.7.0.1
 */