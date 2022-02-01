package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.RedBagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class PasswdRedBagServiceImpl$1
  extends Handler
{
  PasswdRedBagServiceImpl$1(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    if (paramMessage.arg1 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive passwdredbags from group or disgroup, isSuccess = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return;
    }
    if ((i == 1) || (i == 0))
    {
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.1.1(this, i));
      paramMessage = (List)paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = paramMessage.iterator();
      while (paramMessage.hasNext())
      {
        localObject = (oidb_0x438.RedBagInfo)paramMessage.next();
        PasswdRedBagServiceImpl.access$300(this.a, (oidb_0x438.RedBagInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */