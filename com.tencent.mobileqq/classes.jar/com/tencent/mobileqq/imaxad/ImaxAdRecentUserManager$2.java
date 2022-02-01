package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ImaxAdRecentUserManager$2
  implements Runnable
{
  ImaxAdRecentUserManager$2(ImaxAdRecentUserManager paramImaxAdRecentUserManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null) {
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", PublicAccountAdUtil.a(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null)
      {
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.l == 2) {
          ImaxAdPresenter.a().b(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2
 * JD-Core Version:    0.7.0.1
 */