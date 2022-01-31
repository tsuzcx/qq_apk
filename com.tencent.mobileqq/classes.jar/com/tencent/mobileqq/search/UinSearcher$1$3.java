package com.tencent.mobileqq.search;

import anav;
import awje;
import awjf;
import axqy;
import bfpc;
import com.tencent.mobileqq.app.QQAppInterface;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(awjf paramawjf, bfpc parambfpc, anav paramanav, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfpc.show();
    String str1;
    String str2;
    if (awje.a(this.jdField_a_of_type_Awjf.a) == null) {
      if (awje.b(this.jdField_a_of_type_Awjf.a) == null)
      {
        str1 = "0X800A923";
        if ((awje.a(this.jdField_a_of_type_Awjf.a) != null) || (awje.b(this.jdField_a_of_type_Awjf.a) != null)) {
          break label147;
        }
        str2 = "";
      }
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, awje.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, awje.b(this.jdField_a_of_type_Awjf.a), awje.d(this.jdField_a_of_type_Awjf.a)), 0, str2, "", "", "");
      return;
      str1 = "0X800A921";
      break;
      if (awje.b(this.jdField_a_of_type_Awjf.a) == null)
      {
        str1 = "0X800A920";
        break;
      }
      str1 = "0X800A922";
      break;
      label147:
      if (this.jdField_a_of_type_Anav.a()) {
        str2 = anav.a + "";
      } else {
        str2 = anav.b + "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */