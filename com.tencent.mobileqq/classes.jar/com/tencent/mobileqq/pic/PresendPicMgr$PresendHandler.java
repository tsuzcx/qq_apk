package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class PresendPicMgr$PresendHandler
  extends Handler
{
  private final WeakReference<PresendPicMgr> a;
  
  public PresendPicMgr$PresendHandler(Looper paramLooper, PresendPicMgr paramPresendPicMgr)
  {
    super(paramLooper);
    this.a = new WeakReference(paramPresendPicMgr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PresendPicMgr localPresendPicMgr = (PresendPicMgr)this.a.get();
    if (localPresendPicMgr != null)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          super.handleMessage(paramMessage);
          return;
        }
        Logger.a("PresendPicMgr", "PresendHandler", "handleMessage MSG_UNREGISTER_CLIENT_HANDLER");
        localPresendPicMgr.a = null;
        return;
      }
      Logger.a("PresendPicMgr", "PresendHandler", "handleMessage MSG_REGISTER_CLIENT_HANDLER");
      localPresendPicMgr.a = paramMessage.replyTo;
      paramMessage = Message.obtain(null, 2);
      ArrayList localArrayList = new ArrayList();
      Object localObject = PresendPicMgr.a(localPresendPicMgr).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((PresendPicMgr.PresendReq)((Iterator)localObject).next()).a);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putParcelableArrayList("flag_compressinfolist", localArrayList);
      paramMessage.setData((Bundle)localObject);
      try
      {
        localPresendPicMgr.a.send(paramMessage);
      }
      catch (RemoteException paramMessage)
      {
        localPresendPicMgr.a = null;
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, paramMessage.getMessage(), paramMessage);
        }
        paramMessage.printStackTrace();
      }
      localPresendPicMgr.a = null;
      PresendPicMgr.a(localPresendPicMgr);
      localPresendPicMgr.b();
      return;
    }
    Logger.b("PresendPicMgr", "handleMessage", "PresendPicMgr == null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendHandler
 * JD-Core Version:    0.7.0.1
 */