package com.tencent.mobileqq.imaxad;

import avxv;
import avxx;
import avxz;
import avya;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import nwf;
import nwg;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(avxx paramavxx, boolean paramBoolean, QQAppInterface paramQQAppInterface, nwf paramnwf, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      avxv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nwf);
    }
    if (this.jdField_a_of_type_Nwf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_Nwf.a.iterator();
      while (localIterator.hasNext()) {
        avya.b(((nwg)localIterator.next()).b);
      }
    }
    avxz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */