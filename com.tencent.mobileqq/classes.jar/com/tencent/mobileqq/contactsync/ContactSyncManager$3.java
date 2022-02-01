package com.tencent.mobileqq.contactsync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ContactSyncManager$3
  extends Handler
{
  ContactSyncManager$3(ContactSyncManager paramContactSyncManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ContactSyncManager.a(this.a);
      return;
    }
    ContactSyncManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.3
 * JD-Core Version:    0.7.0.1
 */