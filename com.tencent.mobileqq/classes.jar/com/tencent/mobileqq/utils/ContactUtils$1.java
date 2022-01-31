package com.tencent.mobileqq.utils;

import bbcz;
import bbdb;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ContactUtils$1
  implements Runnable
{
  public ContactUtils$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, bbdb parambbdb) {}
  
  public void run()
  {
    String str = bbcz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, true);
    if (this.jdField_a_of_type_Bbdb != null) {
      this.jdField_a_of_type_Bbdb.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils.1
 * JD-Core Version:    0.7.0.1
 */