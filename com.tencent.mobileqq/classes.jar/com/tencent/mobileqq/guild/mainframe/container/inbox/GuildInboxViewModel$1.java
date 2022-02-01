package com.tencent.mobileqq.guild.mainframe.container.inbox;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.NoticeRedUpdateListener;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildInboxViewModel$1
  extends IGuildInboxRedService.NoticeRedUpdateListener
{
  GuildInboxViewModel$1(GuildInboxViewModel paramGuildInboxViewModel) {}
  
  public void a(List<GuildNoticeRedPoint> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNoticeGroupListUpdate ");
    localStringBuilder.append(paramList);
    QLog.d("QQGuildNoticeViewModel", 1, localStringBuilder.toString());
    GuildInboxViewModel.a(this.a).setValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxViewModel.1
 * JD-Core Version:    0.7.0.1
 */