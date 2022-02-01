package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.ContactBinded;

public class ContactBindedMessage
  extends NewFriendMessage
{
  public ContactBinded a;
  
  public ContactBindedMessage(ContactBinded paramContactBinded)
  {
    this.a = paramContactBinded;
    this.d = paramContactBinded.timestamp;
  }
  
  public boolean b()
  {
    return this.a.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.ContactBindedMessage
 * JD-Core Version:    0.7.0.1
 */