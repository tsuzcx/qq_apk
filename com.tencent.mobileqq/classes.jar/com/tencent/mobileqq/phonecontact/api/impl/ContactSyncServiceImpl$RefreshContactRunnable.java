package com.tencent.mobileqq.phonecontact.api.impl;

class ContactSyncServiceImpl$RefreshContactRunnable
  implements Runnable
{
  volatile int a = 0;
  
  private ContactSyncServiceImpl$RefreshContactRunnable(ContactSyncServiceImpl paramContactSyncServiceImpl) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    this.this$0.onQQContactRefreshed(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.RefreshContactRunnable
 * JD-Core Version:    0.7.0.1
 */