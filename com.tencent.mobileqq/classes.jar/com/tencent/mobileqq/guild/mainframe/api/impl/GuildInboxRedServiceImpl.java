package com.tencent.mobileqq.guild.mainframe.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.INoticeRedUpdateListener;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildInboxRedServiceImpl
  implements IGuildInboxRedService
{
  public static final String TAG = "GuildInboxRedServiceImpl";
  private GPServiceObserver mGpsObserver = new GuildInboxRedServiceImpl.1(this);
  private HashMap<Integer, GuildNoticeRedPoint> mGuildNoticeRedPointMap = new HashMap();
  private boolean mHasFetchNoticeRedPointSucc = false;
  private boolean mIsFetching = false;
  private List<IGuildInboxRedService.INoticeRedUpdateListener> mNoticeRedUpdateListeners;
  
  private GuildNoticeRedPoint copy(GuildNoticeRedPoint paramGuildNoticeRedPoint)
  {
    if (paramGuildNoticeRedPoint == null) {
      return new GuildNoticeRedPoint();
    }
    GuildNoticeRedPoint localGuildNoticeRedPoint = new GuildNoticeRedPoint();
    localGuildNoticeRedPoint.a = paramGuildNoticeRedPoint.a;
    localGuildNoticeRedPoint.b = paramGuildNoticeRedPoint.b;
    localGuildNoticeRedPoint.c = paramGuildNoticeRedPoint.c;
    return localGuildNoticeRedPoint;
  }
  
  private void notify(IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo, GuildNoticeRedPoint paramGuildNoticeRedPoint)
  {
    List localList = getNoticeGroupList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notify total count=");
    ((StringBuilder)localObject).append(paramUnreadCntInfo);
    ((StringBuilder)localObject).append(" changed redPoint=");
    ((StringBuilder)localObject).append(paramGuildNoticeRedPoint);
    QLog.i("GuildInboxRedServiceImpl", 1, ((StringBuilder)localObject).toString());
    localObject = this.mNoticeRedUpdateListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IGuildInboxRedService.INoticeRedUpdateListener localINoticeRedUpdateListener = (IGuildInboxRedService.INoticeRedUpdateListener)((Iterator)localObject).next();
      localINoticeRedUpdateListener.a(paramUnreadCntInfo);
      if (paramGuildNoticeRedPoint != null) {
        localINoticeRedUpdateListener.a(paramGuildNoticeRedPoint);
      }
      localINoticeRedUpdateListener.a(localList);
    }
  }
  
  private void redExpiredChecker(GuildNoticeRedPoint paramGuildNoticeRedPoint)
  {
    long l = paramGuildNoticeRedPoint.c - NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("redExpiredChecker remainTime:");
      localStringBuilder.append(String.valueOf(l));
      localStringBuilder.append(" getServerTime: ");
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      QLog.i("GuildInboxRedServiceImpl", 1, localStringBuilder.toString());
    }
    ThreadManager.getUIHandlerV2().postDelayed(new GuildInboxRedServiceImpl.3(this, paramGuildNoticeRedPoint), l * 1000L);
  }
  
  private void tryFetchRedPoint()
  {
    if (!this.mHasFetchNoticeRedPointSucc)
    {
      QLog.w("GuildInboxRedServiceImpl", 4, "redpoint not init yet! ");
      fetchNoticeRedPoint(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
  }
  
  public void addNoticeRedUpdateListener(IGuildInboxRedService.INoticeRedUpdateListener paramINoticeRedUpdateListener)
  {
    this.mNoticeRedUpdateListeners.add(paramINoticeRedUpdateListener);
  }
  
  public void clearNoticeRedPoint(int paramInt)
  {
    if (getNoticeRedCount().a <= 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearNoticeRedPoint type=");
    localStringBuilder.append(paramInt);
    QLog.i("GuildInboxRedServiceImpl", 1, localStringBuilder.toString());
    ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).clearNoticeRedPoint(paramInt, new GuildInboxRedServiceImpl.4(this, paramInt));
  }
  
  public void fetchNoticeRedPoint(AppRuntime paramAppRuntime)
  {
    if (this.mIsFetching)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildInboxRedServiceImpl", 4, "fetching");
      }
      return;
    }
    this.mIsFetching = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start fetchNoticeRedPoint uin=");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    QLog.i("GuildInboxRedServiceImpl", 4, localStringBuilder.toString());
    ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).fetchNoticeRedPoint(new GuildInboxRedServiceImpl.2(this));
  }
  
  public List<GuildNoticeRedPoint> getNoticeGroupList()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNoticeGroupList ");
      localStringBuilder.append(this.mGuildNoticeRedPointMap.size());
      QLog.d("GuildInboxRedServiceImpl", 4, localStringBuilder.toString());
    }
    tryFetchRedPoint();
    return Collections.unmodifiableList(new ArrayList(this.mGuildNoticeRedPointMap.values()));
  }
  
  public IGuildUnreadCntService.UnreadCntInfo getNoticeRedCount()
  {
    tryFetchRedPoint();
    IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = new IGuildUnreadCntService.UnreadCntInfo();
    Object localObject = this.mGuildNoticeRedPointMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GuildNoticeRedPoint localGuildNoticeRedPoint = (GuildNoticeRedPoint)((Iterator)localObject).next();
      if (NetConnInfoCenter.getServerTime() <= localGuildNoticeRedPoint.c)
      {
        localUnreadCntInfo.a += localGuildNoticeRedPoint.b;
        localUnreadCntInfo.b = 2;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("the redpoint is exprired ");
        localStringBuilder.append(localGuildNoticeRedPoint.toString());
        QLog.d("GuildInboxRedServiceImpl", 1, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNoticeRedCount listSize=");
      ((StringBuilder)localObject).append(this.mGuildNoticeRedPointMap.size());
      ((StringBuilder)localObject).append(" total=");
      ((StringBuilder)localObject).append(localUnreadCntInfo.toString());
      QLog.d("GuildInboxRedServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    return localUnreadCntInfo;
  }
  
  public GuildNoticeRedPoint getNoticeRedPoint(int paramInt)
  {
    return copy((GuildNoticeRedPoint)this.mGuildNoticeRedPointMap.get(Integer.valueOf(paramInt)));
  }
  
  public boolean needFetchNoticeRed()
  {
    return this.mHasFetchNoticeRedPointSucc ^ true;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.i("GuildInboxRedServiceImpl", 1, "onCreate");
    this.mNoticeRedUpdateListeners = new ArrayList();
    ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).addObserver(this.mGpsObserver);
  }
  
  public void onDestroy()
  {
    QLog.i("GuildInboxRedServiceImpl", 1, "onDestroy");
    this.mIsFetching = false;
    this.mHasFetchNoticeRedPointSucc = false;
    this.mGuildNoticeRedPointMap.clear();
    this.mNoticeRedUpdateListeners.clear();
    ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).deleteObserver(this.mGpsObserver);
  }
  
  public void removeNoticeRedUpdateListener(IGuildInboxRedService.INoticeRedUpdateListener paramINoticeRedUpdateListener)
  {
    this.mNoticeRedUpdateListeners.remove(paramINoticeRedUpdateListener);
  }
  
  public void setNoticeRedPoint(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject2 = (GuildNoticeRedPoint)this.mGuildNoticeRedPointMap.get(Integer.valueOf(paramInt1));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new GuildNoticeRedPoint();
    }
    ((GuildNoticeRedPoint)localObject1).a = paramInt1;
    ((GuildNoticeRedPoint)localObject1).b = paramInt2;
    ((GuildNoticeRedPoint)localObject1).c = paramLong;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setNoticeRedPoint ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("GuildInboxRedServiceImpl", 1, ((StringBuilder)localObject2).toString());
    notify(getNoticeRedCount(), (GuildNoticeRedPoint)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl
 * JD-Core Version:    0.7.0.1
 */