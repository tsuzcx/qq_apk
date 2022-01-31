package com.tencent.mobileqq.imaxad;

import astr;
import astt;
import astv;
import astw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import nlo;
import nlp;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(astt paramastt, boolean paramBoolean, QQAppInterface paramQQAppInterface, nlo paramnlo, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      astr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nlo);
    }
    if (this.jdField_a_of_type_Nlo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_Nlo.a.iterator();
      while (localIterator.hasNext()) {
        astw.b(((nlp)localIterator.next()).b);
      }
    }
    astv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */