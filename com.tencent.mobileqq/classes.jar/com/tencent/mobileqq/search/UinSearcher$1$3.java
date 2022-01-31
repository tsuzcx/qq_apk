package com.tencent.mobileqq.search;

import anao;
import awjc;
import awjd;
import axqw;
import bfol;
import com.tencent.mobileqq.app.QQAppInterface;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(awjd paramawjd, bfol parambfol, anao paramanao, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfol.show();
    String str1;
    String str2;
    if (awjc.a(this.jdField_a_of_type_Awjd.a) == null) {
      if (awjc.b(this.jdField_a_of_type_Awjd.a) == null)
      {
        str1 = "0X800A923";
        if ((awjc.a(this.jdField_a_of_type_Awjd.a) != null) || (awjc.b(this.jdField_a_of_type_Awjd.a) != null)) {
          break label147;
        }
        str2 = "";
      }
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, awjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, awjc.b(this.jdField_a_of_type_Awjd.a), awjc.d(this.jdField_a_of_type_Awjd.a)), 0, str2, "", "", "");
      return;
      str1 = "0X800A921";
      break;
      if (awjc.b(this.jdField_a_of_type_Awjd.a) == null)
      {
        str1 = "0X800A920";
        break;
      }
      str1 = "0X800A922";
      break;
      label147:
      if (this.jdField_a_of_type_Anao.a()) {
        str2 = anao.a + "";
      } else {
        str2 = anao.b + "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */