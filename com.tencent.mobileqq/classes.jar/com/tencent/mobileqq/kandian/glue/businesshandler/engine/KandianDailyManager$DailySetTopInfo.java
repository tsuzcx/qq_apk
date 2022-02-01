package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class KandianDailyManager$DailySetTopInfo
  implements Serializable
{
  public static long settopOffset = -1L;
  private long lastSetTopMsgTime = 0L;
  private long lastSetTopMsgUniseq = -1L;
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = b();
    long l3 = settopOffset;
    if ((l1 - l2 > l3) && (l3 > 0L))
    {
      if (b() > this.lastSetTopMsgTime)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("allow settop lastTime : ");
        localStringBuilder.append(this.lastSetTopMsgTime);
        localStringBuilder.append(", offset : ");
        localStringBuilder.append(settopOffset);
        QLog.d("KandianDailyManager", 1, localStringBuilder.toString());
        return true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("one day only allow settop one ! ");
      localStringBuilder.append(this);
      QLog.d("KandianDailyManager", 2, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not reach time offset, give up ! ");
    localStringBuilder.append(this);
    QLog.d("KandianDailyManager", 2, localStringBuilder.toString());
    return false;
  }
  
  private long b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DailySetTopInfo{lastSetTopMsgUniseq=");
    localStringBuilder.append(this.lastSetTopMsgUniseq);
    localStringBuilder.append(", lastSetTopMsgTime=");
    localStringBuilder.append(this.lastSetTopMsgTime);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(settopOffset);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void trySetTopMsgNode(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (!a()) {
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().r(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!RIJMergeKanDianMessage.a(AppConstants.KANDIAN_DAILY_UIN)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq))
    {
      long l = NetConnInfoCenter.getServerTime();
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
      if (localRecentUserProxy == null) {
        return;
      }
      RecentUser localRecentUser = localRecentUserProxy.c(AppConstants.KANDIAN_DAILY_UIN, 1008);
      if (localRecentUser == null) {
        return;
      }
      localRecentUser.lastmsgtime = l;
      paramQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_DAILY_UIN, 1008, localMessageRecord.uniseq, "time", Long.valueOf(l));
      localRecentUserProxy.b(localRecentUser);
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
      this.lastSetTopMsgTime = b();
      RIJSPUtils.a("readinjoy_daily_settop_info_key", this, true);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("successful setTop !  ");
      paramQQAppInterface.append(this);
      QLog.d("KandianDailyManager", 2, paramQQAppInterface.toString());
      return;
    }
    QLog.d("KandianDailyManager", 2, "give up setTop!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager.DailySetTopInfo
 * JD-Core Version:    0.7.0.1
 */