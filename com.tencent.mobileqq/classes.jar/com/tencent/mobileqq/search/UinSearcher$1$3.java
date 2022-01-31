package com.tencent.mobileqq.search;

import aowl;
import ayin;
import ayio;
import ayms;
import azqs;
import bhuf;
import com.tencent.mobileqq.app.QQAppInterface;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(ayio paramayio, bhuf parambhuf, ayms[] paramArrayOfayms1, ayms[] paramArrayOfayms2, aowl paramaowl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bhuf.show();
    String str1;
    String str2;
    if (this.jdField_a_of_type_ArrayOfAyms[0] == null) {
      if (this.b[0] == null)
      {
        str1 = "0X800A923";
        if ((this.jdField_a_of_type_ArrayOfAyms[0] != null) || (this.b[0] != null)) {
          break label127;
        }
        str2 = "";
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, ayin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ayin.b(this.jdField_a_of_type_Ayio.a), ayin.d(this.jdField_a_of_type_Ayio.a)), 0, str2, "", "", "");
      return;
      str1 = "0X800A921";
      break;
      if (this.b[0] == null)
      {
        str1 = "0X800A920";
        break;
      }
      str1 = "0X800A922";
      break;
      label127:
      if (this.jdField_a_of_type_Aowl.a()) {
        str2 = aowl.a + "";
      } else {
        str2 = aowl.b + "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */