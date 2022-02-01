package com.tencent.mobileqq.flashshow.redpoint;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.api.events.FSRedPointUpdateEvent;
import com.tencent.mobileqq.flashshow.api.handler.FSHandler;
import com.tencent.mobileqq.flashshow.data.ReportExtraInfo;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.flashshow.helper.FSTempRedPointHelper;
import com.tencent.mobileqq.flashshow.request.redpoint.FSClearCountRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qflash.QFlashBadge.BadgeDisplayInfo;
import qflash.QFlashBadge.BadgeJumpInfo;
import qflash.QFlashBadge.BadgeTypeInfo;
import qflash.QFlashBadge.QFlashBadgeContentInfo;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class EeveeRedPointManagerDelegate
  implements BaseRedPoinManagerDelegate
{
  private FSRedPointData a = new FSRedPointData(new QFlashBadge.QFlashBadgeInfo());
  private FSRedPointData b = new FSRedPointData(new QFlashBadge.QFlashBadgeInfo());
  private final List<FSRedPointData> c = new CopyOnWriteArrayList();
  private FSRedPointData d = new FSRedPointData(new QFlashBadge.QFlashBadgeInfo());
  private final Object e = new Object();
  
  private void a(FSRedPointData paramFSRedPointData)
  {
    if (paramFSRedPointData == null)
    {
      QLog.e("FSEeveeRedPoint", 1, "handleRedPointInfo error  redPointData is null");
      return;
    }
    int i = paramFSRedPointData.getBadgeMainTypeValue();
    int j = paramFSRedPointData.getBadgeSubTypeValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRedPointInfo seq =");
    localStringBuilder.append(paramFSRedPointData.getSeq());
    localStringBuilder.append(" badgeMainTypeValue =");
    localStringBuilder.append(i);
    localStringBuilder.append(" badgeSubTypeValue =");
    localStringBuilder.append(j);
    QLog.d("FSEeveeRedPoint", 1, localStringBuilder.toString());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.d = paramFSRedPointData;
        return;
      }
      i();
      this.b = paramFSRedPointData;
      a(true);
      return;
    }
    this.c.add(paramFSRedPointData);
  }
  
  private void a(boolean paramBoolean)
  {
    SimpleEventBus.getInstance().dispatchEvent(new FSRedPointUpdateEvent(paramBoolean));
    if (FSHandler.getFSHandler() != null) {
      FSHandler.getFSHandler().updateRedPoint();
    }
  }
  
  private void i()
  {
    this.a = this.b;
  }
  
  private void j()
  {
    if (k()) {
      return;
    }
    c();
    Object localObject = new QFlashBadge.BadgeTypeInfo();
    ((QFlashBadge.BadgeTypeInfo)localObject).badgeMainTypeValue.set(2);
    localObject = new FSClearCountRequest((QFlashBadge.BadgeTypeInfo)localObject, 1, 0L);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new EeveeRedPointManagerDelegate.1(this));
  }
  
  private boolean k()
  {
    FSRedPointData localFSRedPointData = this.b;
    return (localFSRedPointData != null) && (localFSRedPointData.getBadgeSubTypeValue() == 1);
  }
  
  public FSRedPointData a()
  {
    synchronized (this.e)
    {
      FSRedPointData localFSRedPointData = this.b;
      return localFSRedPointData;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        FSRedPointData localFSRedPointData = (FSRedPointData)localIterator.next();
        if (localFSRedPointData == null) {
          return;
        }
        if (localFSRedPointData.getBadgeSubTypeValue() == paramInt)
        {
          this.c.remove(localFSRedPointData);
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(ReportExtraInfo paramReportExtraInfo) {}
  
  public void a(List<QFlashBadge.QFlashBadgeInfo> paramList)
  {
    Object localObject = this.e;
    if (paramList != null) {}
    try
    {
      if (paramList.size() != 0)
      {
        this.c.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = (QFlashBadge.QFlashBadgeInfo)paramList.next();
          FSRedPointData localFSRedPointData = new FSRedPointData(localQFlashBadgeInfo);
          boolean bool = FSEeveeRedPointHelper.getInstance().isValidRedPointInfo(localFSRedPointData);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("seq: ");
          localStringBuilder.append(localFSRedPointData.getSeq());
          localStringBuilder.append(",badgeMainTypeValue: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.typeInfo.badgeMainTypeValue.get());
          localStringBuilder.append(", badgeSubTypeValue: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.typeInfo.badgeSubTypeValue.get());
          localStringBuilder.append(", showBadge: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.displayInfo.showBadge.get());
          localStringBuilder.append(", jumpLink: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.displayInfo.jumpInfo.jumpLink.get());
          localStringBuilder.append(", wording: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.displayInfo.wording.get());
          localStringBuilder.append(", number: ");
          localStringBuilder.append(localQFlashBadgeInfo.contentInfo.displayInfo.number.get());
          localStringBuilder.append(", lastClearTimestamp: ");
          localStringBuilder.append(localQFlashBadgeInfo.lastClearTimestamp.get());
          localStringBuilder.append(", isValid: ");
          localStringBuilder.append(bool);
          QLog.d("FSEeveeRedPoint", 1, new Object[] { localStringBuilder });
          if (!bool) {
            return;
          }
          a(localFSRedPointData);
        }
        return;
      }
      ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).doPreload();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    FSTempRedPointHelper.getInstance().saveBottomRedPointInfo(((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getBottomRedPointInfo());
    FSTempRedPointHelper.getInstance().saveTabRedPointInfos(((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getTabRedPointInfos());
    j();
  }
  
  public void c()
  {
    synchronized (this.e)
    {
      if (this.b.getLastClearTimestamp() <= 0L) {
        return;
      }
      FSEeveeRedPointHelper.getInstance().saveLastReadedBottomRedPointTimestamp(this.b.getLastClearTimestamp());
      i();
      this.b.clearBadgeInfo();
      a(false);
      return;
    }
  }
  
  public List<FSRedPointData> d()
  {
    synchronized (this.e)
    {
      List localList = this.c;
      return localList;
    }
  }
  
  public FSRedPointData e()
  {
    synchronized (this.e)
    {
      FSRedPointData localFSRedPointData = this.a;
      return localFSRedPointData;
    }
  }
  
  public void f()
  {
    synchronized (this.e)
    {
      if (this.d == null) {
        return;
      }
      long l = this.b.getLastClearTimestamp();
      if (l <= 0L) {
        return;
      }
      FSEeveeRedPointHelper.getInstance().saveLastReadBubbleRedPointTimestamp(l);
      this.d.clearBadgeInfo();
      return;
    }
  }
  
  public FSRedPointData g()
  {
    synchronized (this.e)
    {
      FSRedPointData localFSRedPointData = this.d;
      return localFSRedPointData;
    }
  }
  
  public void h()
  {
    synchronized (this.e)
    {
      this.b = new FSRedPointData(new QFlashBadge.QFlashBadgeInfo());
      this.c.clear();
      this.d = new FSRedPointData(new QFlashBadge.QFlashBadgeInfo());
      a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.redpoint.EeveeRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */