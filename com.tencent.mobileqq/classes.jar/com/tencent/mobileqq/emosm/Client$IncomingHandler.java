package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class Client$IncomingHandler
  extends Handler
{
  public Client$IncomingHandler(Client paramClient, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 4)
    {
      if (i != 5)
      {
        super.handleMessage(paramMessage);
        return;
      }
      this.a.onPushMsgFromServer(paramMessage.getData());
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
      }
    }
    else
    {
      this.a.onRespFromServer(paramMessage.getData());
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_CLIENT_RESP");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */