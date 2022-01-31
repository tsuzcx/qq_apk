package com.tencent.mobileqq.utils;

import bdbt;
import bdbv;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ContactUtils$1
  implements Runnable
{
  public ContactUtils$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, bdbv parambdbv) {}
  
  public void run()
  {
    String str = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, true);
    if (this.jdField_a_of_type_Bdbv != null) {
      this.jdField_a_of_type_Bdbv.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils.1
 * JD-Core Version:    0.7.0.1
 */