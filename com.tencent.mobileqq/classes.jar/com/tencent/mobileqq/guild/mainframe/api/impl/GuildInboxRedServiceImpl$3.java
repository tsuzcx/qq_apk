package com.tencent.mobileqq.guild.mainframe.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;

class GuildInboxRedServiceImpl$3
  implements Runnable
{
  GuildInboxRedServiceImpl$3(GuildInboxRedServiceImpl paramGuildInboxRedServiceImpl, GuildNoticeRedPoint paramGuildNoticeRedPoint) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("this redPoint expired ");
    ((StringBuilder)localObject).append(this.a.toString());
    QLog.i("GuildInboxRedServiceImpl", 1, ((StringBuilder)localObject).toString());
    this.a.b = 0;
    localObject = this.this$0;
    GuildInboxRedServiceImpl.access$100((GuildInboxRedServiceImpl)localObject, ((GuildInboxRedServiceImpl)localObject).getNoticeRedCount(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */