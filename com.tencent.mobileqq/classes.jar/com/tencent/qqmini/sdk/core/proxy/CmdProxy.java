package com.tencent.qqmini.sdk.core.proxy;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

public abstract interface CmdProxy
{
  public abstract void handleMiniAppCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.CmdProxy
 * JD-Core Version:    0.7.0.1
 */