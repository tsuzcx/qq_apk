package com.tencent.mobileqq.contactsync;

class ContactSyncManager$RefreshContactRunnable
  implements Runnable
{
  volatile int a = 0;
  
  private ContactSyncManager$RefreshContactRunnable(ContactSyncManager paramContactSyncManager) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.RefreshContactRunnable
 * JD-Core Version:    0.7.0.1
 */