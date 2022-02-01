package com.tencent.mobileqq.guild.message.unread.api.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.message.unread.logic.ChannelUnreadCntProcess;
import com.tencent.mobileqq.guild.message.unread.logic.GuildUnreadCntProcess;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GuildUnreadCntServiceImpl
  extends Observable
  implements IGuildUnreadCntService, Observer
{
  private static final String TAG = "GuildUnreadCntServiceImpl";
  private AppRuntime app;
  private final ConcurrentHashMap<String, ChannelUnreadCntProcess> channelUnreadProcesses = new ConcurrentHashMap();
  private GPServiceObserver gpServiceObserver = new GuildUnreadCntServiceImpl.1(this);
  private final ConcurrentHashMap<String, GuildUnreadCntProcess> guildUnreadProcesses = new ConcurrentHashMap();
  
  private boolean filterGetUnreadCnt()
  {
    if (!((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      QLog.e("GuildUnreadCntServiceImpl", 1, "filterGetUnreadCnt notshowguildtab");
      return true;
    }
    return false;
  }
  
  private void notifyObserversMain(IGuildUnreadCntService.NotifyObj paramNotifyObj)
  {
    ThreadManager.getUIHandler().post(new GuildUnreadCntServiceImpl.2(this, paramNotifyObj));
  }
  
  public IGuildUnreadCntService.UnreadCntInfo getAllGuildAtUnreadCntInfo()
  {
    if (filterGetUnreadCnt()) {
      return new IGuildUnreadCntService.UnreadCntInfo();
    }
    IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo1 = new IGuildUnreadCntService.UnreadCntInfo();
    Object localObject = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildList();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return localUnreadCntInfo1;
      }
      localObject = ((List)localObject).iterator();
      long l2 = 0L;
      long l1 = 0L;
      while (((Iterator)localObject).hasNext())
      {
        IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo2 = getGuildUnreadCnt(((IGProGuildInfo)((Iterator)localObject).next()).getGuildID());
        if (localUnreadCntInfo2.b == 1) {
          l2 += localUnreadCntInfo2.a;
        } else if (localUnreadCntInfo2.b == 2) {
          l1 += localUnreadCntInfo2.a;
        }
      }
      localUnreadCntInfo1.a(l2, l1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getAllGuildAtUnreadCntInfo] unreadCntInfo: ");
        ((StringBuilder)localObject).append(localUnreadCntInfo1.toString());
        QLog.i("GuildUnreadCntServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localUnreadCntInfo1;
  }
  
  public IGuildUnreadCntService.UnreadCntInfo getChannelUnreadCnt(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!filterGetUnreadCnt()))
    {
      if (!this.channelUnreadProcesses.containsKey(paramString))
      {
        ChannelUnreadCntProcess localChannelUnreadCntProcess = new ChannelUnreadCntProcess(this.app, paramString);
        localChannelUnreadCntProcess.b();
        this.channelUnreadProcesses.put(paramString, localChannelUnreadCntProcess);
      }
      return ((ChannelUnreadCntProcess)this.channelUnreadProcesses.get(paramString)).a(paramInt);
    }
    return new IGuildUnreadCntService.UnreadCntInfo();
  }
  
  public Pair<Long, Long> getChannelUnreadCntToShow(IGProChannelInfo paramIGProChannelInfo)
  {
    boolean bool = filterGetUnreadCnt();
    long l2 = 0L;
    Object localObject = Long.valueOf(0L);
    if (bool) {
      return new Pair(localObject, localObject);
    }
    if (paramIGProChannelInfo != null)
    {
      localObject = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildInfoForGuest(paramIGProChannelInfo.getGuildId());
      int i;
      if ((localObject != null) && (!((IGProGuildInfo)localObject).isMember())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = getChannelUnreadCnt(paramIGProChannelInfo.getChannelUin(), 1);
        IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = getChannelUnreadCnt(paramIGProChannelInfo.getChannelUin(), 6);
        if (paramIGProChannelInfo.getFinalMsgNotify() == 1) {}
        for (l1 = ((IGuildUnreadCntService.UnreadCntInfo)localObject).a;; l1 = localUnreadCntInfo.a)
        {
          l2 = l1 + 0L;
          l1 = 0L;
          break label188;
          if (paramIGProChannelInfo.getFinalMsgNotify() != 2) {
            break label185;
          }
          if (localUnreadCntInfo.a <= 0L) {
            break;
          }
        }
        l1 = ((IGuildUnreadCntService.UnreadCntInfo)localObject).a + 0L;
        break label188;
        label185:
        l1 = 0L;
        label188:
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getChannelUnreadCntToShow] guildId: ");
        localStringBuilder.append(paramIGProChannelInfo.getGuildId());
        localStringBuilder.append(" channelId: ");
        localStringBuilder.append(paramIGProChannelInfo.getChannelUin());
        localStringBuilder.append(" unreadCntInfoAll: ");
        localStringBuilder.append(((IGuildUnreadCntService.UnreadCntInfo)localObject).toString());
        localStringBuilder.append(", unreadCntInfoAt: ");
        localStringBuilder.append(localUnreadCntInfo.toString());
        localStringBuilder.append(", getFinalMsgNotify: ");
        localStringBuilder.append(paramIGProChannelInfo.getFinalMsgNotify());
        localStringBuilder.append(", redCnt: ");
        localStringBuilder.append(l2);
        localStringBuilder.append(", grayCnt: ");
        localStringBuilder.append(l1);
        QLog.i("GuildUnreadCntServiceImpl", 1, localStringBuilder.toString());
        break label399;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getChannelUnreadCntToShow] channelId: ");
        ((StringBuilder)localObject).append(paramIGProChannelInfo.getChannelUin());
        ((StringBuilder)localObject).append(" isGuest: true");
        QLog.i("GuildUnreadCntServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    long l1 = 0L;
    label399:
    return new Pair(Long.valueOf(l2), Long.valueOf(l1));
  }
  
  public IGuildUnreadCntService.UnreadCntInfo getGuildUnreadCnt(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!filterGetUnreadCnt()))
    {
      if (!this.guildUnreadProcesses.containsKey(paramString))
      {
        localObject = new GuildUnreadCntProcess(this.app, paramString);
        ((GuildUnreadCntProcess)localObject).a();
        this.guildUnreadProcesses.put(paramString, localObject);
      }
      Object localObject = ((GuildUnreadCntProcess)this.guildUnreadProcesses.get(paramString)).b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getAllGuildAtUnreadCntInfo] guildId: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" unreadCntInfo: ");
        if (localObject == null) {
          paramString = "null";
        } else {
          paramString = ((IGuildUnreadCntService.UnreadCntInfo)localObject).toString();
        }
        localStringBuilder.append(paramString);
        QLog.i("GuildUnreadCntServiceImpl", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    return new IGuildUnreadCntService.UnreadCntInfo();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    ((IGuildMsgSeqTimeService)this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "")).addObserver(this);
    ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).addObserver(this.gpServiceObserver);
  }
  
  public void onDestroy()
  {
    ((IGuildMsgSeqTimeService)this.app.getRuntimeService(IGuildMsgSeqTimeService.class, "")).deleteObserver(this);
    ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).deleteObserver(this.gpServiceObserver);
  }
  
  public boolean refreshAndNotifyChannelUnreadCntInfo(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!this.channelUnreadProcesses.containsKey(paramString)) {
      this.channelUnreadProcesses.put(paramString, new ChannelUnreadCntProcess(this.app, paramString));
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAndNotifyChannelUnreadCnt key:");
      localStringBuilder.append(paramString);
      QLog.i("GuildUnreadCntServiceImpl", 2, localStringBuilder.toString());
    }
    if (((ChannelUnreadCntProcess)this.channelUnreadProcesses.get(paramString)).c())
    {
      bool1 = true;
      notifyObserversMain(new IGuildUnreadCntService.NotifyObj(1, paramString));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAndNotifyChannelUnreadCnt: channelid:");
      localStringBuilder.append(paramString);
      QLog.i("GuildUnreadCntServiceImpl", 1, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean refreshAndNotifyGuildUnreadCntInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!this.guildUnreadProcesses.containsKey(paramString)) {
      this.guildUnreadProcesses.put(paramString, new GuildUnreadCntProcess(this.app, paramString));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAndNotifyGuildUnreadCntInfo key:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("GuildUnreadCntServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getAllGuildAtUnreadCntInfo();
    if (((GuildUnreadCntProcess)this.guildUnreadProcesses.get(paramString)).c())
    {
      notifyObserversMain(new IGuildUnreadCntService.NotifyObj(2, paramString));
      notifyObserversMain(new IGuildUnreadCntService.NotifyObj(3, "", (IGuildUnreadCntService.UnreadCntInfo)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAndNotifyChannelUnreadCnt. hasChanged. guildId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("GuildUnreadCntServiceImpl", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObservable = (String)paramObject;
      if (TextUtils.isEmpty(paramObservable)) {
        return;
      }
      if (refreshAndNotifyChannelUnreadCntInfo(paramObservable)) {
        refreshAndNotifyGuildUnreadCntInfo(((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildIdOf(paramObservable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntServiceImpl
 * JD-Core Version:    0.7.0.1
 */