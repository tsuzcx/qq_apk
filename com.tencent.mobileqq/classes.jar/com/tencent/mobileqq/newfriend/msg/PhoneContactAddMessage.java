package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;

public class PhoneContactAddMessage
  extends NewFriendMessage
{
  public PhoneContactAdd a;
  
  public PhoneContactAddMessage(PhoneContactAdd paramPhoneContactAdd)
  {
    this.a = paramPhoneContactAdd;
    this.d = paramPhoneContactAdd.timestamp;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage
 * JD-Core Version:    0.7.0.1
 */