package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.ContactMatch;

public class ContactMatchMessage
  extends NewFriendMessage
{
  public ContactMatch a;
  
  public ContactMatchMessage(ContactMatch paramContactMatch)
  {
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactDataContactMatch = paramContactMatch;
    this.jdField_a_of_type_Long = paramContactMatch.timestamp;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPhonecontactDataContactMatch.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.ContactMatchMessage
 * JD-Core Version:    0.7.0.1
 */