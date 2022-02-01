package com.tencent.mobileqq.guild.mainframe.api.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class GuildInboxRedServiceImpl$2
  implements IFetchNoticeRedPointCallback
{
  GuildInboxRedServiceImpl$2(GuildInboxRedServiceImpl paramGuildInboxRedServiceImpl) {}
  
  public void a(int paramInt, String paramString, List<GuildNoticeRedPoint> paramList)
  {
    if (paramInt == 0)
    {
      GuildInboxRedServiceImpl.access$302(this.a, true);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onFetchNoticeRedPoint succ ");
        paramString.append(paramList.toString());
        QLog.i("GuildInboxRedServiceImpl", 4, paramString.toString());
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (GuildNoticeRedPoint)paramString.next();
          if (paramList.c - NetConnInfoCenter.getServerTime() > 0L)
          {
            GuildInboxRedServiceImpl.access$000(this.a).put(Integer.valueOf(paramList.a), paramList);
            GuildInboxRedServiceImpl localGuildInboxRedServiceImpl = this.a;
            GuildInboxRedServiceImpl.access$100(localGuildInboxRedServiceImpl, localGuildInboxRedServiceImpl.getNoticeRedCount(), paramList);
            GuildInboxRedServiceImpl.access$200(this.a, paramList);
          }
        }
      }
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append("fetchNoticeRedPoint failed result=");
      paramList.append(paramInt);
      paramList.append(" msg=");
      paramList.append(paramString);
      QLog.w("GuildInboxRedServiceImpl", 1, paramList.toString());
    }
    GuildInboxRedServiceImpl.access$402(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */