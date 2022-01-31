package com.tencent.mobileqq.imaxad;

import ardd;
import ardf;
import ardh;
import ardi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import nis;
import nit;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(ardf paramardf, boolean paramBoolean, QQAppInterface paramQQAppInterface, nis paramnis, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      ardd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nis);
    }
    if (this.jdField_a_of_type_Nis != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_Nis.a.iterator();
      while (localIterator.hasNext()) {
        ardi.b(((nit)localIterator.next()).b);
      }
    }
    ardh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */