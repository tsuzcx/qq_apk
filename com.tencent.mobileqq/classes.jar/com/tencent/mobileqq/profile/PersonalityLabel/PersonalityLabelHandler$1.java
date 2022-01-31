package com.tencent.mobileqq.profile.PersonalityLabel;

import awqt;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PersonalityLabelHandler$1
  implements Runnable
{
  public PersonalityLabelHandler$1(String paramString, QQAppInterface paramQQAppInterface, awqt paramawqt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_a_of_type_Awqt.a.vPersonalityLabelV2 = this.jdField_a_of_type_ArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler.1
 * JD-Core Version:    0.7.0.1
 */