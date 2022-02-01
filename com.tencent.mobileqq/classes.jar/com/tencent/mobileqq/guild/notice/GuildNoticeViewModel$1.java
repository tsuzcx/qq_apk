package com.tencent.mobileqq.guild.notice;

import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.NoticeRedUpdateListener;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GuildNoticeViewModel$1
  extends IGuildInboxRedService.NoticeRedUpdateListener
{
  GuildNoticeViewModel$1(GuildNoticeViewModel paramGuildNoticeViewModel) {}
  
  public void a(List<GuildNoticeRedPoint> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNoticeGroupListUpdate ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("GuildNoticeViewModel", 1, ((StringBuilder)localObject).toString());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (GuildNoticeRedPoint)paramList.next();
      if (((GuildNoticeRedPoint)localObject).a == 1)
      {
        GuildNoticeViewModel localGuildNoticeViewModel = this.a;
        boolean bool;
        if (((GuildNoticeRedPoint)localObject).b > 0) {
          bool = true;
        } else {
          bool = false;
        }
        localGuildNoticeViewModel.a(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */