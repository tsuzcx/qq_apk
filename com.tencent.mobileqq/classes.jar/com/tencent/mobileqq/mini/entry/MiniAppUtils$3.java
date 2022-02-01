package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bijj;
import com.tencent.mobileqq.app.ThreadManager;
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
    if ((paramMessage.obj instanceof bijj))
    {
      bijj localbijj = (bijj)paramMessage.obj;
      if (localbijj.c == 0)
      {
        QLog.d("MiniAppUtils", 2, "handleMessage() called with: msg = [" + paramMessage + "]");
        ThreadManager.getFileThreadHandler().post(new MiniAppUtils.3.1(this, localbijj));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.3
 * JD-Core Version:    0.7.0.1
 */