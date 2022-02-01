package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.ContactMatch;

public class ContactMatchMessage
  extends NewFriendMessage
{
  public ContactMatch a;
  
  public ContactMatchMessage(ContactMatch paramContactMatch)
  {
    this.a = paramContactMatch;
    this.d = paramContactMatch.timestamp;
  }
  
  public boolean b()
  {
    return this.a.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.ContactMatchMessage
 * JD-Core Version:    0.7.0.1
 */