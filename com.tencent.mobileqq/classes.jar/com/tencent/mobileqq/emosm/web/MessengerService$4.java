package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

class MessengerService$4
  extends VipFunCallObserver
{
  MessengerService$4(MessengerService paramMessengerService) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fcObserver.onUpdate ret=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", type=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", isSuccess=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("Q.emoji.web.MessengerService", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              break label239;
            }
            if (paramInt != 5)
            {
              paramObject = new StringBuilder();
              paramObject.append("fcObserver onUpdate Error type=");
              paramObject.append(paramInt);
              QLog.e("Q.emoji.web.MessengerService", 1, paramObject.toString());
              break label239;
            }
          }
          if (this.a.a != null)
          {
            localObject = Message.obtain(null, 5);
            ((Message)localObject).setData(paramObject);
            this.a.a.send((Message)localObject);
          }
        }
      }
      else if (this.a.a != null)
      {
        localObject = Message.obtain(null, 5);
        paramObject.putInt("srcType", 7);
        ((Message)localObject).setData(paramObject);
        this.a.a.send((Message)localObject);
      }
      label239:
      paramObject = (QQAppInterface)MessengerService.a(this.a);
      if (paramObject == null) {
        return;
      }
      localObject = (VipSetFunCallHandler)paramObject.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      paramObject.removeObserver(this);
      return;
    }
    catch (Exception paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fcObserver onUpdate Err:");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("Q.emoji.web.MessengerService", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.4
 * JD-Core Version:    0.7.0.1
 */