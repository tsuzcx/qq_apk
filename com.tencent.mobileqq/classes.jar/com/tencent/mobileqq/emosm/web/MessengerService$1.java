package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$1
  extends EmoticonPackageDownloadListener
{
  MessengerService$1(MessengerService paramMessengerService) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (this.a.a != null) {}
    for (;;)
    {
      try
      {
        Message localMessage = Message.obtain(null, 5);
        int i = Integer.valueOf(paramEmoticonPackage.epId).intValue();
        if (paramInt == 0)
        {
          paramInt = 0;
          paramEmoticonPackage = new Bundle();
          paramEmoticonPackage.putInt("packetid", i);
          paramEmoticonPackage.putInt("peoriodtype", 1);
          paramEmoticonPackage.putInt("resultcode", paramInt);
          localMessage.setData(paramEmoticonPackage);
          this.a.a.send(localMessage);
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
          }
          return;
        }
      }
      catch (RemoteException|Exception paramEmoticonPackage)
      {
        return;
      }
      if (paramInt == 11007) {
        paramInt = 2;
      } else if (paramInt == 11001) {
        paramInt = 1;
      } else if (paramInt == 11000) {
        paramInt = 6;
      } else {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.1
 * JD-Core Version:    0.7.0.1
 */