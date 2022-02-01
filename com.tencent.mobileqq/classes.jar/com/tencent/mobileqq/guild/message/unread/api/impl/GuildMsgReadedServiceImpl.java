package com.tencent.mobileqq.guild.message.unread.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.message.GuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageManagerCallback;
import com.tencent.mobileqq.guild.message.unread.ChannelMsgReadedReportHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildMsgReadedServiceImpl
  implements IGuildMsgReadedService
{
  private final String TAG = "GuildMsgReadedServiceImpl";
  private AppRuntime app;
  
  private void clearAtMeMsgEvent(String paramString, List<String> paramList)
  {
    IGuildMessageBoxDataService localIGuildMessageBoxDataService = (IGuildMessageBoxDataService)this.app.getRuntimeService(IGuildMessageBoxDataService.class, "");
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (localIGuildMessageBoxDataService == null) {
        return;
      }
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localIGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(str, 1L);
          if (((IGuildUnreadCntService)this.app.getRuntimeService(IGuildUnreadCntService.class, "")).refreshAndNotifyChannelUnreadCntInfo(str)) {
            i = 1;
          }
        }
      }
      if (i != 0) {
        ((IGuildUnreadCntService)this.app.getRuntimeService(IGuildUnreadCntService.class, "")).refreshAndNotifyGuildUnreadCntInfo(paramString);
      }
    }
  }
  
  private void refreshRecentUser(String paramString)
  {
    paramString = ((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().c(paramString, 10014);
    if (paramString != null) {
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(paramString);
    }
  }
  
  private void setMessageRecordReadedFrom(String paramString, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      paramString = (IGuildMsgSeqTimeService)this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "");
      BaseMsgProxy localBaseMsgProxy = ((GuildMessageManager)((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.app).a(10014)).a(10014);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = paramString.getReadedMsgSeq(str);
        if ((localMsgSeqTimeItem.a()) && (localMsgSeqTimeItem.a > 0L)) {
          localBaseMsgProxy.j(str, 10014, localMsgSeqTimeItem.a);
        }
      }
    }
  }
  
  public void checkAndcleanMsgAndMsgData(String paramString)
  {
    Object localObject1 = GuildMessageManager.c().a((AppInterface)this.app);
    Object localObject2 = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
    int i = 0;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (IGProChannelInfo)localIterator.next();
        if (!TextUtils.isEmpty(((IGProChannelInfo)localObject2).getChannelUin()))
        {
          List localList = ((BaseAioNavigateBarManager)localObject1).b(((IGProChannelInfo)localObject2).getChannelUin(), 0);
          if ((localList != null) && (localList.size() > 0))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkAndcleanMsgAndMsgData key:");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(" channelId:");
            ((StringBuilder)localObject1).append(((IGProChannelInfo)localObject2).getChannelUin());
            ((StringBuilder)localObject1).append(" hasnavigate");
            QLog.i("GuildMsgReadedServiceImpl", 1, ((StringBuilder)localObject1).toString());
            break label188;
          }
        }
      }
    }
    i = 1;
    label188:
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAndcleanMsgAndMsgData key:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" needClean: true");
      QLog.i("GuildMsgReadedServiceImpl", 1, ((StringBuilder)localObject1).toString());
      localObject1 = ((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      localObject2 = ((RecentUserProxy)localObject1).c(paramString, 10014);
      if (localObject2 != null)
      {
        ((RecentUser)localObject2).cleanMsgAndMsgData(((RecentUser)localObject2).msgType);
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        refreshRecentUser(paramString);
      }
    }
  }
  
  public boolean clearMsgNavigateInfo(String paramString, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return false;
      }
      Object localObject = (AppInterface)this.app;
      localObject = GuildMessageManager.c().a((AppInterface)localObject);
      paramList = paramList.iterator();
      for (boolean bool = false; paramList.hasNext(); bool = true)
      {
        label50:
        String str = (String)paramList.next();
        List localList = ((BaseAioNavigateBarManager)localObject).b(str, 0);
        if ((localList == null) || (localList.size() <= 0)) {
          break label50;
        }
        ((BaseAioNavigateBarManager)localObject).c(str, 0);
      }
      if (bool) {
        checkAndcleanMsgAndMsgData(paramString);
      }
      return bool;
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void onMsgReadedNotify(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramMsgSeqTimeItem == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgReadedNotify key:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" seqTimeItem:");
      localStringBuilder.append(paramMsgSeqTimeItem.toString());
      QLog.i("GuildMsgReadedServiceImpl", 1, localStringBuilder.toString());
      if (((IGuildMsgSeqTimeService)this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "")).setReadedMsgSeq(paramString1, paramString2, paramMsgSeqTimeItem, true))
      {
        long l = ((IGuildUnreadCntService)this.app.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(paramString2, 1).a;
        paramMsgSeqTimeItem = new StringBuilder();
        paramMsgSeqTimeItem.append("onMsgReadedNotify key:");
        paramMsgSeqTimeItem.append(paramString1);
        paramMsgSeqTimeItem.append(" channelId:");
        paramMsgSeqTimeItem.append(paramString2);
        paramMsgSeqTimeItem.append(" unreadCnt:");
        paramMsgSeqTimeItem.append(l);
        QLog.i("GuildMsgReadedServiceImpl", 1, paramMsgSeqTimeItem.toString());
        paramMsgSeqTimeItem = new ArrayList();
        paramMsgSeqTimeItem.add(paramString2);
        setMessageRecordReadedFrom(paramString1, paramMsgSeqTimeItem);
        clearMsgNavigateInfo(paramString1, paramMsgSeqTimeItem);
        clearAtMeMsgEvent(paramString1, paramMsgSeqTimeItem);
        refreshRecentUser(paramString1);
      }
    }
  }
  
  public void onRegisterProxyMsgReaded(String paramString, List<String> paramList)
  {
    clearMsgNavigateInfo(paramString, paramList);
    setMessageRecordReadedFrom(paramString, paramList);
  }
  
  public void setChannelMsgReaded(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setChannelMsgReaded key:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" channelId:");
        localStringBuilder.append(str);
        localStringBuilder.append(" from:");
        localStringBuilder.append(paramInt);
        QLog.i("GuildMsgReadedServiceImpl", 1, localStringBuilder.toString());
      }
      setMessageRecordReaded(paramString, paramArrayList);
      setMsgReadedAndReport(paramString, paramArrayList, paramInt);
      clearMsgNavigateInfo(paramString, paramArrayList);
      refreshRecentUser(paramString);
    }
  }
  
  public void setGuildReaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = ((GuildUnreadCntServiceImpl)this.app.getRuntimeService(IGuildUnreadCntService.class, "")).getGuildUnreadCnt(paramString).a;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setGuildReaded key:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" unreadCnt:");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(" from:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("GuildMsgReadedServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (l <= 0L) {
      return;
    }
    localObject1 = new ArrayList();
    Object localObject2 = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(localIGProChannelInfo.getChannelUin())) {
          ((ArrayList)localObject1).add(localIGProChannelInfo.getChannelUin());
        }
      }
    }
    setChannelMsgReaded(paramString, (ArrayList)localObject1, paramInt);
  }
  
  public void setMessageRecordReaded(String paramString, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      paramString = (IGuildUnreadCntService)this.app.getRuntimeService(IGuildUnreadCntService.class, "");
      BaseMsgProxy localBaseMsgProxy = ((GuildMessageManager)((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.app).a(10014)).a(10014);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (paramString.getChannelUnreadCnt(str, 1).a > 0L) {
          localBaseMsgProxy.a(str, 10014, null, 0);
        }
      }
    }
  }
  
  public void setMsgReadedAndReport(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    ((ChannelMsgReadedReportHandler)((AppInterface)this.app).getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).a(paramString1, paramString2, paramMsgSeqTimeItem);
  }
  
  public void setMsgReadedAndReport(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    ((ChannelMsgReadedReportHandler)((AppInterface)this.app).getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).a(paramString, paramArrayList, false, paramInt);
  }
  
  public void setMsgReadedAndReportForce(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    ((ChannelMsgReadedReportHandler)((AppInterface)this.app).getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).a(paramString, paramArrayList, true, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.impl.GuildMsgReadedServiceImpl
 * JD-Core Version:    0.7.0.1
 */