package com.tencent.mobileqq.guild.channel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.Iterator;
import java.util.List;

class QQGuildChannelInfoSettingFragment$2
  implements Runnable
{
  QQGuildChannelInfoSettingFragment$2(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void run()
  {
    Object localObject = ((IGPSService)this.this$0.l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.this$0.o.getGuildId());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ICategoryInfo localICategoryInfo = (ICategoryInfo)((Iterator)localObject).next();
        List localList = localICategoryInfo.c();
        int i = 0;
        while ((localList != null) && (i < localList.size()))
        {
          IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localList.get(i);
          if (this.this$0.o.getChannelUin().equals(localIGProChannelInfo.getChannelUin()))
          {
            QQGuildChannelInfoSettingFragment.a(this.this$0, localICategoryInfo.a());
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */