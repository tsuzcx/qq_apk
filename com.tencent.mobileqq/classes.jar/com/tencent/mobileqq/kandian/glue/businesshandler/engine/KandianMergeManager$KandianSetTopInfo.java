package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class KandianMergeManager$KandianSetTopInfo
  implements Serializable
{
  public int count;
  private int fixNumOfTimes;
  private long lastSetTopMsgUniseq;
  private long setTopCountResetTime;
  
  private void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.setTopCountResetTime;
    if (l1 >= l2)
    {
      this.count = this.fixNumOfTimes;
      this.setTopCountResetTime = (l2 + 86400000L);
      RIJSPUtils.a("kandian_msgtab_settop", this, true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset kandian SetTopInfo count : ");
      localStringBuilder.append(this);
      QLog.d("KandianMergeManager.SETTOP", 2, localStringBuilder.toString());
    }
  }
  
  public static KandianSetTopInfo get(int paramInt1, int paramInt2)
  {
    KandianSetTopInfo localKandianSetTopInfo = new KandianSetTopInfo();
    localKandianSetTopInfo.fixNumOfTimes = paramInt1;
    localKandianSetTopInfo.count = paramInt1;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    localKandianSetTopInfo.setTopCountResetTime = (localCalendar.getTimeInMillis() + paramInt2 * 1000);
    return localKandianSetTopInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fixNumOfTimes : ");
    localStringBuilder.append(this.fixNumOfTimes);
    localStringBuilder.append(", count : ");
    localStringBuilder.append(this.count);
    localStringBuilder.append(", resetTime : ");
    localStringBuilder.append(this.setTopCountResetTime);
    localStringBuilder.append(", lastMsgUniseq : ");
    localStringBuilder.append(this.lastSetTopMsgUniseq);
    return localStringBuilder.toString();
  }
  
  public void trySetTopKandianMsg(QQAppInterface paramQQAppInterface)
  {
    a();
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!RIJMergeKanDianMessage.a(AppConstants.KANDIAN_MERGE_UIN)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq) && (this.count != 0))
    {
      if (paramQQAppInterface.mAutomator.d())
      {
        long l = System.currentTimeMillis() / 1000L;
        RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
        RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if (localRecentUser == null) {
          return;
        }
        localRecentUser.lastmsgtime = l;
        paramQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, localMessageRecord.uniseq, "time", Long.valueOf(l));
        localRecentUserProxy.b(localRecentUser);
        paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(1009);
        }
        this.count -= 1;
        this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
        RIJSPUtils.a("kandian_msgtab_settop", this, true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("successful setTop !  newTime : ");
        paramQQAppInterface.append(l);
        paramQQAppInterface.append(this);
        QLog.d("KandianMergeManager.SETTOP", 2, paramQQAppInterface.toString());
        return;
      }
      RIJMergeKanDianMessage.a = true;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiving msg , wait callback ! ");
      paramQQAppInterface.append(this);
      QLog.d("KandianMergeManager.SETTOP", 2, paramQQAppInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.KandianSetTopInfo
 * JD-Core Version:    0.7.0.1
 */