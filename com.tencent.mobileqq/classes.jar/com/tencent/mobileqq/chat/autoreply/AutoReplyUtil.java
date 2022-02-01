package com.tencent.mobileqq.chat.autoreply;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AutoReplyUtil
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyUtil", 2, new Object[] { "[report] reportReplyMessageExposed: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    }
    if (paramInt != 0) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new AutoReplyUtil.1(paramQQAppInterface, paramString));
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus != AppRuntime.Status.away) && (paramStatus != AppRuntime.Status.dnd) && (paramStatus != AppRuntime.Status.busy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.autoreply.AutoReplyUtil
 * JD-Core Version:    0.7.0.1
 */