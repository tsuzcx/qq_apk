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
    int i = 2;
    if (this.a.a != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      int j = Integer.valueOf(paramEmoticonPackage.epId).intValue();
      if (paramInt == 0) {
        i = 0;
      }
      for (;;)
      {
        paramEmoticonPackage = new Bundle();
        paramEmoticonPackage.putInt("packetid", j);
        paramEmoticonPackage.putInt("peoriodtype", 1);
        paramEmoticonPackage.putInt("resultcode", i);
        localMessage.setData(paramEmoticonPackage);
        this.a.a.send(localMessage);
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
        }
        return;
        if (paramInt != 11007) {
          if (paramInt == 11001) {
            i = 1;
          } else if (paramInt == 11000) {
            i = 6;
          } else {
            i = -1;
          }
        }
      }
      return;
    }
    catch (Exception paramEmoticonPackage)
    {
      return;
    }
    catch (RemoteException paramEmoticonPackage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.1
 * JD-Core Version:    0.7.0.1
 */