package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.qphone.base.util.QLog;

class MiniAppCmdServlet$2
  implements IMiniCallback
{
  MiniAppCmdServlet$2(MiniAppCmdServlet paramMiniAppCmdServlet, CmdCallback paramCmdCallback, String paramString) {}
  
  public void onCallbackResult(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (this.val$callback != null)
      {
        this.val$callback.onCmdResult(paramBoolean, paramBundle);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd response exception. cmd=");
      localStringBuilder.append(this.val$cmd);
      QLog.e("MiniAppCmdServlet", 1, localStringBuilder.toString(), paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.2
 * JD-Core Version:    0.7.0.1
 */