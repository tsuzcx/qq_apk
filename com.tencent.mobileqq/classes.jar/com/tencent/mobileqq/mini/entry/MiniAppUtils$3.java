package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class MiniAppUtils$3
  extends Handler
{
  MiniAppUtils$3(Looper paramLooper, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.obj instanceof WebSoCgiService.WebSoCgiState))
    {
      WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)paramMessage.obj;
      if (localWebSoCgiState.i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage() called with: msg = [");
        localStringBuilder.append(paramMessage);
        localStringBuilder.append("]");
        QLog.d("MiniAppUtils", 2, localStringBuilder.toString());
        ThreadManager.getFileThreadHandler().post(new MiniAppUtils.3.1(this, localWebSoCgiState));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.3
 * JD-Core Version:    0.7.0.1
 */