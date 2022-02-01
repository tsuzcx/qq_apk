package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

class MessengerService$QWalletMsgHandler
  extends Handler
{
  protected Bundle a;
  private WeakReference<MessengerService> b;
  
  public MessengerService$QWalletMsgHandler(MessengerService paramMessengerService)
  {
    this.b = new WeakReference(paramMessengerService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessengerService$QWalletOpenMsgHandler", 2, "handleMessage, mServiceWeakRef null");
      }
      return;
    }
    localObject = (MessengerService)((WeakReference)localObject).get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessengerService$QWalletOpenMsgHandler", 2, "handleMessage, service null");
      }
      return;
    }
    int i = paramMessage.what;
    if (i != 4) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qwallet.type", i);
    i = paramMessage.arg1;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localBundle.putBoolean("qwallet.isSuccess", bool);
    localBundle.putSerializable("qwallet.data", (Serializable)paramMessage.obj);
    paramMessage = this.a;
    if (paramMessage != null)
    {
      paramMessage.putBundle("response", localBundle);
      ((MessengerService)localObject).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.QWalletMsgHandler
 * JD-Core Version:    0.7.0.1
 */