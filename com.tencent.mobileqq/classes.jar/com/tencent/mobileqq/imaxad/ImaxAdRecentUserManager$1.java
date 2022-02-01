package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ImaxAdRecentUserManager$1
  implements Runnable
{
  ImaxAdRecentUserManager$1(ImaxAdRecentUserManager paramImaxAdRecentUserManager, boolean paramBoolean, QQAppInterface paramQQAppInterface, AdvertisementItem paramAdvertisementItem, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      ImaxAdPresenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem disk  uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.iterator();
      while (localIterator.hasNext()) {
        ImaxAdVideoPreloadManager.b(((VideoCoverItem)localIterator.next()).b);
      }
    }
    ImaxAdUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */