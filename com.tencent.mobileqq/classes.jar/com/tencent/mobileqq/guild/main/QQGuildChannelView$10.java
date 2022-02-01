package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

class QQGuildChannelView$10
  implements Observer
{
  QQGuildChannelView$10(QQGuildChannelView paramQQGuildChannelView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof IGuildUnreadCntService.NotifyObj)) && (QQGuildChannelView.a(this.a) != null))
    {
      Object localObject = ((IGuildAdapterService)QQGuildChannelView.d(this.a).a().getRuntimeService(IGuildAdapterService.class, "")).getChannelList(QQGuildChannelView.a(this.a).getGuildID(), true, QQGuildChannelView.b(this.a).a);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        paramObservable = (IGuildUnreadCntService.NotifyObj)paramObject;
        if (paramObservable.a != 1)
        {
          paramObject = new StringBuilder();
          paramObject.append("GuildUnreadObserver update type=");
          paramObject.append(paramObservable.toString());
          QLog.d("QQGuildChannelView", 4, paramObject.toString());
          return;
        }
        paramObject = ((List)localObject).iterator();
      }
      while (paramObject.hasNext())
      {
        localObject = (IGProChannelInfo)paramObject.next();
        if (((IGProChannelInfo)localObject).getChannelUin().equals(paramObservable.b))
        {
          localObject = QQGuildChannelView.a(this.a, (IGProChannelInfo)localObject);
          if (localObject != null)
          {
            QQGuildChannelView.e(this.a).a((QQChannelItemData)localObject);
            return;
            QLog.i("QQGuildChannelView", 1, "GuildUnreadObserver update: channelItemList is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.10
 * JD-Core Version:    0.7.0.1
 */