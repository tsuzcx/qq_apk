package cooperation.qzone.birthdaynotice;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import aezm;
import bbko;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BirthDayNoticeManager$1
  implements Runnable
{
  BirthDayNoticeManager$1(DouFuInfo paramDouFuInfo, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, long paramLong) {}
  
  public void run()
  {
    String str = String.valueOf(this.val$doFuInfo.uin);
    if (BirthDayNoticeManager.isBirthDayNoticeEnable(this.val$app, str))
    {
      long l1 = this.val$app.getMsgCache().a(str);
      long l2 = System.currentTimeMillis();
      if (Math.abs(l1 - l2) > 432000000L)
      {
        aezm localaezm = (aezm)this.val$app.getManager(282);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.val$jsonOb.toString();
        localBeancurdMsg.busiid = 6;
        localBeancurdMsg.frienduin = String.valueOf(str);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.startTime = bbko.a();
        localBeancurdMsg.validTime = 432000L;
        localBeancurdMsg.token = this.val$token;
        if (QLog.isColorLevel()) {
          QLog.i("BirthDayNoticeManager", 2, "addBirthDayFeedMessage receiveBeancurd:" + String.valueOf(localBeancurdMsg));
        }
        localaezm.a(localBeancurdMsg);
        this.val$app.getMsgCache().d(String.valueOf(str), l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.birthdaynotice.BirthDayNoticeManager.1
 * JD-Core Version:    0.7.0.1
 */