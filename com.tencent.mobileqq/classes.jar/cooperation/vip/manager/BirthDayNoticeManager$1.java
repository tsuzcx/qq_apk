package cooperation.vip.manager;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BirthDayNoticeManager$1
  implements Runnable
{
  BirthDayNoticeManager$1(DouFuInfo paramDouFuInfo, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, long paramLong) {}
  
  public void run()
  {
    String str = String.valueOf(this.jdField_a_of_type_GIFT_MALL_PROTOCOLDouFuInfo.uin);
    if (BirthDayNoticeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(str);
      long l2 = System.currentTimeMillis();
      if (Math.abs(l1 - l2) > 432000000L)
      {
        BeancurdManager localBeancurdManager = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.jdField_a_of_type_OrgJsonJSONObject.toString();
        localBeancurdMsg.busiid = 6;
        localBeancurdMsg.frienduin = String.valueOf(str);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.startTime = MessageCache.a();
        localBeancurdMsg.validTime = 432000L;
        localBeancurdMsg.token = this.jdField_a_of_type_Long;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addBirthDayFeedMessage receiveBeancurd:");
          localStringBuilder.append(String.valueOf(localBeancurdMsg));
          QLog.i("BirthDayNoticeManager", 2, localStringBuilder.toString());
        }
        localBeancurdManager.a(localBeancurdMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(String.valueOf(str), l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.BirthDayNoticeManager.1
 * JD-Core Version:    0.7.0.1
 */