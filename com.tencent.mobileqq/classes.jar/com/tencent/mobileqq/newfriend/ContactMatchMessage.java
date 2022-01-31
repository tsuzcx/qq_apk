package com.tencent.mobileqq.newfriend;

import com.tencent.mobileqq.data.ContactMatch;

public class ContactMatchMessage
  extends NewFriendMessage
{
  public ContactMatch a;
  
  public ContactMatchMessage(ContactMatch paramContactMatch)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataContactMatch = paramContactMatch;
    this.jdField_a_of_type_Long = paramContactMatch.timestamp;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataContactMatch.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ContactMatchMessage
 * JD-Core Version:    0.7.0.1
 */