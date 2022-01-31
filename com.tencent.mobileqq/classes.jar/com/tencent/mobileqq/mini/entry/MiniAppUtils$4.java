package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bbds;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class MiniAppUtils$4
  extends Handler
{
  MiniAppUtils$4(Looper paramLooper, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.obj instanceof bbds))
    {
      bbds localbbds = (bbds)paramMessage.obj;
      if (localbbds.c == 0)
      {
        QLog.d("MiniAppUtils", 2, "handleMessage() called with: msg = [" + paramMessage + "]");
        ThreadManager.getFileThreadHandler().post(new MiniAppUtils.4.1(this, localbbds));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.4
 * JD-Core Version:    0.7.0.1
 */