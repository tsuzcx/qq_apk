package com.tencent.mobileqq.guild.channel.create.fragment;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelRvAdapter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class QQGuildAppChannelListFragment$1
  extends GPServiceObserver
{
  QQGuildAppChannelListFragment$1(QQGuildAppChannelListFragment paramQQGuildAppChannelListFragment) {}
  
  protected void b()
  {
    if (this.a.a() != null)
    {
      Object localObject = (IGPSService)this.a.a().getRuntimeService(IGPSService.class, "");
      QQGuildAppChannelListFragment.a(this.a, ((IGPSService)localObject).getAppInfoList());
      QQGuildAppChannelListFragment.b(this.a).a(QQGuildAppChannelListFragment.a(this.a));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAppInfoListUpdated：");
        ((StringBuilder)localObject).append(QQGuildAppChannelListFragment.a(this.a));
        QLog.i("QQGuildAppChannelListFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppChannelListFragment.1
 * JD-Core Version:    0.7.0.1
 */