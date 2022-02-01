package com.tencent.mobileqq.selectmember;

import android.os.Message;
import mqq.os.MqqHandler;

class ContactsInnerFrame$1
  extends MqqHandler
{
  ContactsInnerFrame$1(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return;
      }
      ContactsInnerFrame.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */