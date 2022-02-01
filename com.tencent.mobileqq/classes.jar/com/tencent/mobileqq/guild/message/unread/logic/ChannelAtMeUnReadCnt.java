package com.tencent.mobileqq.guild.message.unread.logic;

import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ChannelAtMeUnReadCnt
  extends AbsChannelUnreadCnt
{
  public ChannelAtMeUnReadCnt(AppRuntime paramAppRuntime, String paramString)
  {
    super(paramAppRuntime, paramString);
  }
  
  public String c()
  {
    return "ChannelAtMeUnReadCnt";
  }
  
  protected void d()
  {
    this.c.b = 1;
    e();
  }
  
  void e()
  {
    Object localObject = (IGuildMessageBoxDataService)this.a.getRuntimeService(IGuildMessageBoxDataService.class, "");
    this.c.a = ((IGuildMessageBoxDataService)localObject).getChannelMsgEventUnreadCount(this.b, 1L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUnreadCnt unreadCnt: ");
      ((StringBuilder)localObject).append(this.c.a);
      QLog.i("ChannelAtMeUnReadCnt", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.ChannelAtMeUnReadCnt
 * JD-Core Version:    0.7.0.1
 */