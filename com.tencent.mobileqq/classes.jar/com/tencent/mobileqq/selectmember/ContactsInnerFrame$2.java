package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class ContactsInnerFrame$2
  extends ContactBindObserver
{
  ContactsInnerFrame$2(ContactsInnerFrame paramContactsInnerFrame) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    int i = ContactsInnerFrame.a(this.a).getSelfBindState();
    if (i != 0) {
      if ((i != 1) && (i != 5))
      {
        if (i != 6)
        {
          if ((i != 7) && (i != 9)) {
            ContactsInnerFrame.c(this.a);
          }
        }
        else
        {
          if (ContactsInnerFrame.a(this.a).getSelfBindInfo().lastUsedFlag == 2L)
          {
            ContactsInnerFrame.a(this.a);
            return;
          }
          ContactsInnerFrame.b(this.a);
        }
      }
      else
      {
        ContactsInnerFrame.b(this.a);
        return;
      }
    }
    ContactsInnerFrame.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */