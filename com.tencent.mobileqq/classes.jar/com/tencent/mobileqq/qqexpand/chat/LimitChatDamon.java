package com.tencent.mobileqq.qqexpand.chat;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LimitChatDamon
{
  private static volatile LimitChatDamon a;
  private Runnable b = null;
  private Handler c = null;
  private long d = -1L;
  
  public static LimitChatDamon a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new LimitChatDamon();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendMessageReadConfirm invoke, uin:");
        localStringBuilder.append(paramString);
        QLog.d("LimitChatDamon", 2, localStringBuilder.toString());
      }
      try
      {
        if (this.b != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm last request do not finish");
          }
          return;
        }
        this.b = new LimitChatDamon.1(this, paramString, paramQQAppInterface);
        if (this.b != null) {
          ThreadManager.getSubThreadHandler().postDelayed(this.b, 60000L);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.LimitChatDamon
 * JD-Core Version:    0.7.0.1
 */