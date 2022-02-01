package com.tencent.mobileqq.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ChatBackgroundManager$ReportChatBgHandler
  extends Handler
{
  public ChatBackgroundManager$ReportChatBgHandler() {}
  
  public ChatBackgroundManager$ReportChatBgHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1 = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ChatBackgroundManager.c < 3)
      {
        paramMessage = (String)localObject1[0];
        localObject1 = (QQAppInterface)localObject1[1];
        ChatBackgroundManager.a((QQAppInterface)localObject1, paramMessage, StatisticCollector.getInstance(BaseApplication.getContext()));
        ChatBackgroundManager.c += 1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportTimes is:");
          ((StringBuilder)localObject2).append(ChatBackgroundManager.c);
          QLog.d("ThemeDownloadTrace", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ChatBackgroundManager.a.obtainMessage();
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = new Object[] { paramMessage, localObject1 };
        ChatBackgroundManager.a.sendMessageDelayed((Message)localObject2, 120000L);
        return;
      }
      ChatBackgroundManager.c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.ReportChatBgHandler
 * JD-Core Version:    0.7.0.1
 */