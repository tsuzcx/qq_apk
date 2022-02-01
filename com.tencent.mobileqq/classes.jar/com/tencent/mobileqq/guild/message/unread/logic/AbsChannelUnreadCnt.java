package com.tencent.mobileqq.guild.message.unread.logic;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class AbsChannelUnreadCnt
{
  protected AppRuntime a;
  protected String b;
  protected IGuildUnreadCntService.UnreadCntInfo c = new IGuildUnreadCntService.UnreadCntInfo();
  
  public AbsChannelUnreadCnt(AppRuntime paramAppRuntime, String paramString)
  {
    this.a = paramAppRuntime;
    this.b = paramString;
  }
  
  protected void a()
  {
    try
    {
      if (((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.b) == null)
      {
        QLog.e("AbsChannelUnreadCnt", 1, "updateUnreadCntInfo channelInfo == null");
        this.c = new IGuildUnreadCntService.UnreadCntInfo();
      }
      else
      {
        d();
      }
      return;
    }
    finally {}
  }
  
  protected IGuildUnreadCntService.UnreadCntInfo b()
  {
    try
    {
      if ((QLog.isColorLevel()) && (this.c.a != 0L))
      {
        localObject1 = c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUnreadCntInfo cut = ");
        localStringBuilder.append(this.c.a);
        localStringBuilder.append("  channelId = ");
        localStringBuilder.append(this.b);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      Object localObject1 = this.c;
      return localObject1;
    }
    finally {}
  }
  
  public abstract String c();
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.AbsChannelUnreadCnt
 * JD-Core Version:    0.7.0.1
 */