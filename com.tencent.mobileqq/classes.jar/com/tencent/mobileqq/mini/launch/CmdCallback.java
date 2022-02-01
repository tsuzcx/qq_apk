package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface CmdCallback
  extends IInterface
{
  public abstract void onCmdResult(boolean paramBoolean, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.CmdCallback
 * JD-Core Version:    0.7.0.1
 */