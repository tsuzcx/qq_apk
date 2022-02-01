package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class PhoneContactServiceImpl$LoadContactFriendListTask$1
  implements Comparator<PhoneContact>
{
  PhoneContactServiceImpl$LoadContactFriendListTask$1(PhoneContactServiceImpl.LoadContactFriendListTask paramLoadContactFriendListTask) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.LoadContactFriendListTask.1
 * JD-Core Version:    0.7.0.1
 */