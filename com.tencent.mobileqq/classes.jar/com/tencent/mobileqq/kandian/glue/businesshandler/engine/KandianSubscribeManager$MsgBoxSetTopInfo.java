package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class KandianSubscribeManager$MsgBoxSetTopInfo
  implements Serializable
{
  public static final String SP_KEY = "kandian_subscribe_settop_info_key";
  public boolean allowSettop = false;
  public long lastSetTopTimeMillis = 0L;
  public int setTopPosition = 0;
  public int setTopStartTime = 0;
  
  private Pair<Integer, Long> a(int paramInt)
  {
    Pair localPair = new Pair(Integer.valueOf(-1), Long.valueOf(-1L));
    int k = RIJDisplayStyleManager.INSTANCE.getRecentListReportVisibleItemCount();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int j;
      try
      {
        localObject1 = RecentDataListManager.a().c;
        if (localObject1 == null) {
          return localPair;
        }
        localArrayList.addAll((Collection)localObject1);
        localObject1 = localArrayList.iterator();
        j = 0;
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentBaseData)((Iterator)localObject1).next();
          if (!(localObject2 instanceof RecentUserBaseData))
          {
            ((Iterator)localObject1).remove();
            continue;
          }
          if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(((RecentBaseData)localObject2).getRecentUserUin())) {
            continue;
          }
          i = 1;
          continue;
        }
        if ((i != 0) && (!localArrayList.isEmpty()))
        {
          int m = localArrayList.size();
          i = paramInt;
          paramInt = j;
          if (paramInt < m)
          {
            localObject1 = (RecentBaseData)localArrayList.get(paramInt);
            localObject2 = (RecentUserBaseData)localObject1;
            if (TextUtils.equals(((RecentUserBaseData)localObject2).getRecentUserUin(), AppConstants.KANDIAN_SUBSCRIBE_UIN))
            {
              if (paramInt < k)
              {
                QLog.d(KandianSubscribeManager.a, 2, "subscribePos is in screen, give up setTop");
                return localPair;
              }
              if (i != 0)
              {
                QLog.d(KandianSubscribeManager.a, 2, "settop pos is > ori pos, give up");
                return localPair;
              }
            }
            else
            {
              if (i == 0) {
                return new Pair(Integer.valueOf(paramInt), Long.valueOf(((RecentBaseData)localObject1).mDisplayTime + 1L));
              }
              j = i;
              if (((RecentUserBaseData)localObject2).e().showUpTime != 0L) {
                break label344;
              }
              j = i - 1;
              break label344;
            }
          }
        }
        else
        {
          QLog.d(KandianSubscribeManager.a, 2, "has not kandian subscribe recent user, give settop");
          return localPair;
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = KandianSubscribeManager.a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get settop info has error ");
        ((StringBuilder)localObject2).append(localException);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return localPair;
      label344:
      paramInt += 1;
      int i = j;
    }
  }
  
  private boolean a()
  {
    boolean bool2 = this.allowSettop;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l = localCalendar.getTimeInMillis() / 1000L;
    if (System.currentTimeMillis() / 1000L - l < this.setTopStartTime) {
      return false;
    }
    if (this.lastSetTopTimeMillis <= l * 1000L) {
      bool1 = true;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgBoxSetTopInfo{setTopStartTime=");
    localStringBuilder.append(this.setTopStartTime);
    localStringBuilder.append(", setTopPosition=");
    localStringBuilder.append(this.setTopPosition);
    localStringBuilder.append(", lastSetTopTimeMillis=");
    localStringBuilder.append(this.lastSetTopTimeMillis);
    localStringBuilder.append(", allowSettop=");
    localStringBuilder.append(this.allowSettop);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void tryToSetTop()
  {
    if (!a()) {
      return;
    }
    Pair localPair = a(this.setTopPosition);
    if (((Integer)localPair.first).intValue() >= 0)
    {
      if (((Long)localPair.second).longValue() < 0L) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
      Object localObject1 = localQQAppInterface.getMessageFacade().r(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
      if (localObject1 != null)
      {
        if (((MessageRecord)localObject1).isread) {
          return;
        }
        Object localObject2 = localQQAppInterface.getProxyManager().g();
        RecentUser localRecentUser = ((RecentUserProxy)localObject2).c(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
        if (localRecentUser == null) {
          return;
        }
        localRecentUser.lastmsgtime = ((Long)localPair.second).longValue();
        ((MessageRecord)localObject1).time = ((Long)localPair.second).longValue();
        localQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008, ((MessageRecord)localObject1).uniseq, "time", Long.valueOf(((MessageRecord)localObject1).time));
        ((RecentUserProxy)localObject2).b(localRecentUser);
        localObject1 = localQQAppInterface.getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendEmptyMessage(1009);
        }
        this.lastSetTopTimeMillis = System.currentTimeMillis();
        RIJSPUtils.a("kandian_subscribe_settop_info_key", this, true);
        localObject1 = KandianSubscribeManager.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("settop successful! pos : ");
        ((StringBuilder)localObject2).append(localPair.first);
        ((StringBuilder)localObject2).append(", msgtime : ");
        ((StringBuilder)localObject2).append(localPair.second);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        PublicAccountReportUtils.a(localQQAppInterface, "CliOper", "", "", "0X80097D5", "0X80097D5", 0, 1, String.valueOf(localPair.first), null, null, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.MsgBoxSetTopInfo
 * JD-Core Version:    0.7.0.1
 */