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
import java.util.Iterator;
import java.util.List;

public final class rsj
  implements Runnable
{
  public rsj(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, NewestFeedInfo paramNewestFeedInfo, String paramString) {}
  
  public void run()
  {
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          }
        }
      }
      localObject = MessageRecordFactory.a(-2015);
      long l = MessageCache.a();
      ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), this.jdField_a_of_type_JavaLangString, l, -2015, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      ((MessageRecord)localObject).isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage addMessage,time:" + l);
        }
        l = ((MessageRecord)localObject).time;
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((MessageRecord)localObject).frienduin, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsj
 * JD-Core Version:    0.7.0.1
 */