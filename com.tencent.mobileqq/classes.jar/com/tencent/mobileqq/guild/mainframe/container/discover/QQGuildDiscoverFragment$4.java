package com.tencent.mobileqq.guild.mainframe.container.discover;

import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverDataCenter;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverObserver;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.GuildDiscoverViewPagerAdapter;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.QQGuildDisSubTabInfo;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQGuildDiscoverFragment$4
  extends QQGuildDiscoverObserver
{
  QQGuildDiscoverFragment$4(QQGuildDiscoverFragment paramQQGuildDiscoverFragment) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    if (paramBoolean)
    {
      if (QQGuildDiscoverDataCenter.a(QQGuildDiscoverFragment.f(this.a)))
      {
        QQGuildDiscoverFragment.f(this.a).clear();
        QQGuildDiscoverFragment.f(this.a).addAll(QQGuildDiscoverDataCenter.a());
        int j = QQGuildDiscoverFragment.f(this.a).size();
        paramObject = new String[j];
        int[] arrayOfInt = new int[j];
        while (i < j)
        {
          arrayOfInt[i] = ((QQGuildDisSubTabInfo)QQGuildDiscoverFragment.f(this.a).get(i)).c;
          paramObject[i] = ((QQGuildDisSubTabInfo)QQGuildDiscoverFragment.f(this.a).get(i)).b;
          i += 1;
        }
        QQGuildDiscoverFragment.g(this.a).setTabData(paramObject, arrayOfInt);
        QQGuildDiscoverFragment.e(this.a).a(QQGuildDiscoverFragment.f(this.a));
        QQGuildDiscoverFragment.e(this.a).a(QQGuildDiscoverFragment.h(this.a), true).a(true);
      }
      paramObject = this.a;
      paramObject.a(QQGuildDiscoverFragment.h(paramObject), paramBoolean, null);
    }
    else
    {
      QQToast.makeText(this.a.getActivity(), 1, "服务器繁忙，请稍后再试～", 0).show();
    }
    paramObject = new StringBuilder();
    paramObject.append("isSuccess == ");
    paramObject.append(paramBoolean);
    paramObject.append("，data == ");
    paramObject.append(QQGuildDiscoverDataCenter.c());
    QLog.i("GuildDiscover.QQGuildDiscoverFragment", 1, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment.4
 * JD-Core Version:    0.7.0.1
 */