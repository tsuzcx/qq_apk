import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public final class rzz
  implements Runnable
{
  public rzz(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, NewestFeedInfo paramNewestFeedInfo, String paramString) {}
  
  public void run()
  {
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      ChatActivityFacade.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2015);
      long l = MessageCache.a();
      localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), this.jdField_a_of_type_JavaLangString, l, -2015, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage addMessage,time:" + l);
        }
        l = localMessageRecord.time;
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localMessageRecord.frienduin, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzz
 * JD-Core Version:    0.7.0.1
 */