package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener;
import com.tencent.qphone.base.util.QLog;

class MiniAppCmdServlet$1
  implements BaseLibManager.UpdateListener
{
  MiniAppCmdServlet$1(MiniAppCmdServlet paramMiniAppCmdServlet, CmdCallback paramCmdCallback, String paramString) {}
  
  public void onUpdateResult(int paramInt)
  {
    CmdCallback localCmdCallback = this.val$callback;
    if (localCmdCallback == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1)) {}
    try
    {
      localCmdCallback.onCmdResult(false, new Bundle());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd response exception. cmd=");
      localStringBuilder.append(this.val$cmd);
      QLog.e("MiniAppCmdServlet", 1, localStringBuilder.toString(), localException);
    }
    this.val$callback.onCmdResult(true, new Bundle());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.1
 * JD-Core Version:    0.7.0.1
 */