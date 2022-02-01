package com.tencent.mobileqq.imaxad;

import avqq;
import avqs;
import avqu;
import avqv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import oeq;
import oer;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(avqs paramavqs, boolean paramBoolean, QQAppInterface paramQQAppInterface, oeq paramoeq, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      avqq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Oeq);
    }
    if (this.jdField_a_of_type_Oeq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_Oeq.a.iterator();
      while (localIterator.hasNext()) {
        avqv.b(((oer)localIterator.next()).b);
      }
    }
    avqu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */