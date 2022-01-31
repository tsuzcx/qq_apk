package com.tencent.mobileqq.imaxad;

import aqiw;
import aqiy;
import aqja;
import aqjb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mxu;
import mxv;

public class ImaxAdRecentUserManager$1
  implements Runnable
{
  public ImaxAdRecentUserManager$1(aqiy paramaqiy, boolean paramBoolean, QQAppInterface paramQQAppInterface, mxu parammxu, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      aqiw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Mxu);
    }
    if (this.jdField_a_of_type_Mxu != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_Mxu.a.iterator();
      while (localIterator.hasNext()) {
        aqjb.b(((mxv)localIterator.next()).b);
      }
    }
    aqja.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */