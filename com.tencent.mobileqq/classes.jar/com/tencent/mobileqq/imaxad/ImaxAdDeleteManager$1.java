package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.mobileqq.app.QQAppInterface;

class ImaxAdDeleteManager$1
  implements Runnable
{
  ImaxAdDeleteManager$1(ImaxAdDeleteManager paramImaxAdDeleteManager, AdvertisementItem paramAdvertisementItem, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    AdvertisementItem localAdvertisementItem2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
    AdvertisementItem localAdvertisementItem1 = localAdvertisementItem2;
    if (localAdvertisementItem2 == null) {
      localAdvertisementItem1 = AdvertisementItem.a(ImaxAdUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_JavaLangString));
    }
    ImaxAdDeleteManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localAdvertisementItem1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */