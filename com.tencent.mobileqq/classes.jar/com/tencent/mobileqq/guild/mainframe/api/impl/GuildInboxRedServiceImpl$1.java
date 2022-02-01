package com.tencent.mobileqq.guild.mainframe.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GuildInboxRedServiceImpl$1
  extends GPServiceObserver
{
  GuildInboxRedServiceImpl$1(GuildInboxRedServiceImpl paramGuildInboxRedServiceImpl) {}
  
  protected void a(GuildNoticeRedPoint paramGuildNoticeRedPoint, byte[] paramArrayOfByte)
  {
    if (paramGuildNoticeRedPoint == null)
    {
      QLog.w("GuildInboxRedServiceImpl", 1, "onGuildNoticeListUpdate red can't be null!");
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onGuildNoticeListUpdate ");
    paramArrayOfByte.append(paramGuildNoticeRedPoint.toString());
    QLog.i("GuildInboxRedServiceImpl", 1, paramArrayOfByte.toString());
    paramArrayOfByte = (GuildNoticeRedPoint)GuildInboxRedServiceImpl.access$000(this.a).get(Integer.valueOf(paramGuildNoticeRedPoint.a));
    if (paramArrayOfByte == null)
    {
      GuildInboxRedServiceImpl.access$000(this.a).put(Integer.valueOf(paramGuildNoticeRedPoint.a), paramGuildNoticeRedPoint);
      paramArrayOfByte = paramGuildNoticeRedPoint;
    }
    else
    {
      paramArrayOfByte.b = paramGuildNoticeRedPoint.b;
      paramArrayOfByte.c = paramGuildNoticeRedPoint.c;
    }
    GuildInboxRedServiceImpl localGuildInboxRedServiceImpl = this.a;
    GuildInboxRedServiceImpl.access$100(localGuildInboxRedServiceImpl, localGuildInboxRedServiceImpl.getNoticeRedCount(), paramGuildNoticeRedPoint);
    GuildInboxRedServiceImpl.access$200(this.a, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */