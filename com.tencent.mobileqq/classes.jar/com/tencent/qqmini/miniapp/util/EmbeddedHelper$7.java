package com.tencent.qqmini.miniapp.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class EmbeddedHelper$7
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      QMLog.e("EmbeddedHelper", "killProcess " + Process.myPid());
      AppBrandCmdProxy.g().sendCmd("cmd_exit_qq", new Bundle(), null);
      Process.killProcess(Process.myPid());
      paramDialogInterface.dismiss();
      EmbeddedHelper.access$300(781, "killProcess");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("EmbeddedHelper", "onClick error ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.7
 * JD-Core Version:    0.7.0.1
 */