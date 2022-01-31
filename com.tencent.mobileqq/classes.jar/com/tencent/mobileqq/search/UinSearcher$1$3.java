package com.tencent.mobileqq.search;

import aosc;
import ayee;
import ayef;
import ayij;
import azmj;
import bhpy;
import com.tencent.mobileqq.app.QQAppInterface;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(ayef paramayef, bhpy parambhpy, ayij[] paramArrayOfayij1, ayij[] paramArrayOfayij2, aosc paramaosc, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bhpy.show();
    String str1;
    String str2;
    if (this.jdField_a_of_type_ArrayOfAyij[0] == null) {
      if (this.b[0] == null)
      {
        str1 = "0X800A923";
        if ((this.jdField_a_of_type_ArrayOfAyij[0] != null) || (this.b[0] != null)) {
          break label127;
        }
        str2 = "";
      }
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, ayee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ayee.b(this.jdField_a_of_type_Ayef.a), ayee.d(this.jdField_a_of_type_Ayef.a)), 0, str2, "", "", "");
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
      if (this.jdField_a_of_type_Aosc.a()) {
        str2 = aosc.a + "";
      } else {
        str2 = aosc.b + "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */