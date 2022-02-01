package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.ContactBinded;

public class ContactBindedMessage
  extends NewFriendMessage
{
  public ContactBinded a;
  
  public ContactBindedMessage(ContactBinded paramContactBinded)
  {
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactDataContactBinded = paramContactBinded;
    this.jdField_a_of_type_Long = paramContactBinded.timestamp;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPhonecontactDataContactBinded.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.ContactBindedMessage
 * JD-Core Version:    0.7.0.1
 */