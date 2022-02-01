package com.tencent.mobileqq.guild.message.unread.logic;

import android.util.Pair;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildUnreadCntProcess
{
  protected IGuildUnreadCntService.UnreadCntInfo a = new IGuildUnreadCntService.UnreadCntInfo();
  private String b;
  private AppRuntime c;
  
  public GuildUnreadCntProcess(AppRuntime paramAppRuntime, String paramString)
  {
    this.b = paramString;
    this.c = paramAppRuntime;
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = ((IGPSService)this.c.getRuntimeService(IGPSService.class, "")).getChannelList(this.b);
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((List)localObject1).iterator();
      long l2 = 0L;
      Object localObject3;
      for (long l1 = 0L; ((Iterator)localObject1).hasNext(); l1 += ((Long)((Pair)localObject3).second).longValue())
      {
        localObject3 = (IGProChannelInfo)((Iterator)localObject1).next();
        localObject3 = ((IGuildUnreadCntService)this.c.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCntToShow((IGProChannelInfo)localObject3);
        l2 += ((Long)((Pair)localObject3).first).longValue();
      }
      this.a.a(l2, l1);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public IGuildUnreadCntService.UnreadCntInfo b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    try
    {
      IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = new IGuildUnreadCntService.UnreadCntInfo(this.a.a, this.a.b);
      a();
      if (!localUnreadCntInfo.equals(this.a))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshAndNotifyChannelUnreadCntInfo guildId:");
          localStringBuilder.append(this.b);
          localStringBuilder.append(" old:");
          localStringBuilder.append(localUnreadCntInfo.toString());
          localStringBuilder.append("new:");
          localStringBuilder.append(this.a.toString());
          QLog.i("GuildUnreadCntProcess", 2, localStringBuilder.toString());
        }
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.GuildUnreadCntProcess
 * JD-Core Version:    0.7.0.1
 */