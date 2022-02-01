package com.tencent.qqmini.sdk.server;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener;

class MiniAppCmdServlet$1
  implements BaseLibManager.UpdateListener
{
  MiniAppCmdServlet$1(MiniAppCmdServlet paramMiniAppCmdServlet, MiniCmdCallback paramMiniCmdCallback, String paramString) {}
  
  public void onUpdateResult(int paramInt)
  {
    MiniCmdCallback localMiniCmdCallback = this.val$callback;
    if (localMiniCmdCallback == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1)) {}
    try
    {
      localMiniCmdCallback.onCmdResult(false, new Bundle());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd response exception. cmd=");
      localStringBuilder.append(this.val$cmd);
      QMLog.e("MiniAppCmdServlet", localStringBuilder.toString(), localException);
    }
    this.val$callback.onCmdResult(true, new Bundle());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.MiniAppCmdServlet.1
 * JD-Core Version:    0.7.0.1
 */