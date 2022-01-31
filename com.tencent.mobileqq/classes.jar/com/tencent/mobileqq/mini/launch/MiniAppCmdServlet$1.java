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
    if (this.val$callback == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      try
      {
        this.val$callback.onCmdResult(true, new Bundle());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("MiniAppCmdServlet", 1, "cmd response exception. cmd=" + this.val$cmd, localException);
        return;
      }
    }
    this.val$callback.onCmdResult(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.1
 * JD-Core Version:    0.7.0.1
 */