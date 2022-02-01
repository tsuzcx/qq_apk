package com.tencent.mobileqq.phonecontact.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ContactSyncServiceImpl$3
  extends Handler
{
  ContactSyncServiceImpl$3(ContactSyncServiceImpl paramContactSyncServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      ContactSyncServiceImpl.access$500(this.a);
      return;
    }
    ContactSyncServiceImpl.access$400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */