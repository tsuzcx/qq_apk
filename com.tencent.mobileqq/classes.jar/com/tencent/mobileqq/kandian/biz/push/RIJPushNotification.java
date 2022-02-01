package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.qphone.base.util.QLog;

public class RIJPushNotification
{
  public static boolean a()
  {
    return (b()) && (!d());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt != 5) {
      return a(paramMessageRecord);
    }
    return ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).w();
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramMessageRecord.extStr != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord.extLong & 0x1) == 1)
      {
        bool1 = bool2;
        if (paramMessageRecord.extStr.contains("lockDisplay"))
        {
          bool1 = bool2;
          if (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("neadForceNotification, ret=");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", mr=");
      localStringBuilder.append(paramMessageRecord);
      QLog.d("RIJPushNotification", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static boolean b()
  {
    return RIJKanDianLockScreenPushAladdinConfig.a() == 2;
  }
  
  public static void c()
  {
    ThreadManagerV2.excute(new RIJPushNotification.1(), 64, null, true);
  }
  
  public static boolean d()
  {
    return (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) || (ReadInJoyDailyFragment.a()) || (ReadInJoyNewFeedsActivity.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotification
 * JD-Core Version:    0.7.0.1
 */