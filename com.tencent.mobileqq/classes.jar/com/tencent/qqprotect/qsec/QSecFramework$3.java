package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QSecFramework$3
  extends Handler
{
  QSecFramework$3(QSecFramework paramQSecFramework, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      if ((paramMessage.what == 1) && (!TextUtils.isEmpty((CharSequence)paramMessage.obj)))
      {
        long l = Long.parseLong((String)paramMessage.obj);
        if (l != 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QSecFramework", 2, "handle native msg for cookie:" + l);
          }
          QSecFramework.a(6L, l, 0L, 0L, null, null, null, null);
        }
      }
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework.3
 * JD-Core Version:    0.7.0.1
 */