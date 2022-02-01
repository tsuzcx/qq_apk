package com.tencent.mobileqq.search;

import android.text.TextUtils;
import aqzl;
import bbhl;
import bbhm;
import bblw;
import bcst;
import bkho;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class UinSearcher$1$3
  implements Runnable
{
  public UinSearcher$1$3(bbhm parambbhm, bkho parambkho, bblw[] paramArrayOfbblw1, bblw[] paramArrayOfbblw2, aqzl paramaqzl, QQAppInterface paramQQAppInterface, bblw[] paramArrayOfbblw3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bkho.show();
    String str1;
    String str2;
    if (this.jdField_a_of_type_ArrayOfBblw[0] == null) {
      if (this.b[0] == null)
      {
        str1 = "0X800A923";
        if ((this.jdField_a_of_type_ArrayOfBblw[0] != null) || (this.b[0] != null)) {
          break label286;
        }
        str2 = "";
        label49:
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, bbhl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bbhl.a(this.jdField_a_of_type_Bbhm.a), bbhl.d(this.jdField_a_of_type_Bbhm.a)), 0, str2, "", "", "");
        if ((this.c[0] == null) || (TextUtils.isEmpty(this.c[0].m))) {
          break label352;
        }
        if (!this.c[0].l.equals("#808080")) {
          break label346;
        }
        str1 = "0X800B0BD";
        label143:
        if (!str1.equals("0X800B0BD")) {
          break label358;
        }
        str2 = this.c[0].j;
        label162:
        if (!str2.equals("")) {
          break label364;
        }
      }
    }
    label286:
    label346:
    label352:
    label358:
    label364:
    for (String str3 = "";; str3 = this.c[0].k)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSearcher", 2, "baoguang TValue r4 r5: " + str1 + ", " + str2 + ", " + str3);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, bbhl.a(bbhl.a(this.jdField_a_of_type_Bbhm.a)), 0, "", "", str2, str3);
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
      if (this.jdField_a_of_type_Aqzl.a())
      {
        str2 = aqzl.a + "";
        break label49;
      }
      str2 = aqzl.b + "";
      break label49;
      str1 = "0X800B0BE";
      break label143;
      str1 = "0X800B0BF";
      break label143;
      str2 = "";
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */