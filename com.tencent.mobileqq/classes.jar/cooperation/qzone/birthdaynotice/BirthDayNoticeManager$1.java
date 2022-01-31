package cooperation.qzone.birthdaynotice;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import aeqn;
import ayzl;
import bjhu;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class BirthDayNoticeManager$1
  implements Runnable
{
  public BirthDayNoticeManager$1(DouFuInfo paramDouFuInfo, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, long paramLong) {}
  
  public void run()
  {
    String str = String.valueOf(this.jdField_a_of_type_GIFT_MALL_PROTOCOLDouFuInfo.uin);
    if (bjhu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
      long l2 = System.currentTimeMillis();
      if (Math.abs(l1 - l2) > 432000000L)
      {
        aeqn localaeqn = (aeqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.jdField_a_of_type_OrgJsonJSONObject.toString();
        localBeancurdMsg.busiid = 6;
        localBeancurdMsg.frienduin = String.valueOf(str);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.startTime = ayzl.a();
        localBeancurdMsg.validTime = 432000L;
        localBeancurdMsg.token = this.jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.i("BirthDayNoticeManager", 2, "addBirthDayFeedMessage receiveBeancurd:" + String.valueOf(localBeancurdMsg));
        }
        localaeqn.a(localBeancurdMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(str), l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.birthdaynotice.BirthDayNoticeManager.1
 * JD-Core Version:    0.7.0.1
 */