package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$5
  extends IPCDownloadListener
{
  MessengerService$5(MessengerService paramMessengerService) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.a.b != null) {
      try
      {
        Message localMessage = Message.obtain(null, 5);
        if ((paramBundle.get("chatbgInfo") instanceof ChatBackgroundInfo))
        {
          ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)paramBundle.get("chatbgInfo");
          paramBundle.putString("name", localChatBackgroundInfo.name);
          paramBundle.putString("url", localChatBackgroundInfo.url);
        }
        paramBundle.putInt("type", 2);
        paramBundle.putInt("id", (int)paramLong);
        paramBundle.putInt("result", paramInt);
        localMessage.setData(paramBundle);
        this.a.b.send(localMessage);
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.a.b != null)
    {
      Message localMessage = Message.obtain(null, 5);
      localMessage.setData(paramBundle);
      try
      {
        this.a.b.send(localMessage);
        return;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.5
 * JD-Core Version:    0.7.0.1
 */