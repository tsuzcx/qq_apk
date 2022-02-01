package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

class MessengerService$4
  extends VipFunCallObserver
{
  MessengerService$4(MessengerService paramMessengerService) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramObject = (Bundle)paramObject;
        if (paramObject == null)
        {
          QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver.onUpdate dataBundle=null");
          return;
        }
        int i = paramObject.getInt("result", -1);
        if (!QLog.isColorLevel()) {
          break label253;
        }
        QLog.d("Q.emoji.web.MessengerService", 2, "fcObserver.onUpdate ret=" + i + ", type=" + paramInt + ", isSuccess=" + paramBoolean);
      }
      catch (Exception paramObject)
      {
        QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Err:" + paramObject.getMessage());
        return;
      }
      QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Error type=" + paramInt);
      paramObject = (QQAppInterface)MessengerService.a(this.a);
      if (paramObject != null)
      {
        Object localObject = (VipSetFunCallHandler)paramObject.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
        paramObject.removeObserver(this);
        return;
        if (this.a.a != null)
        {
          localObject = Message.obtain(null, 5);
          paramObject.putInt("srcType", 7);
          ((Message)localObject).setData(paramObject);
          this.a.a.send((Message)localObject);
          continue;
          if (this.a.a != null)
          {
            localObject = Message.obtain(null, 5);
            ((Message)localObject).setData(paramObject);
            this.a.a.send((Message)localObject);
          }
        }
      }
      else
      {
        return;
        label253:
        switch (paramInt)
        {
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.4
 * JD-Core Version:    0.7.0.1
 */