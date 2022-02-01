package com.tencent.mobileqq.guild.mainframe.container.discover.tab;

import com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverSubTabCommonFragment;

public class SubTabFragmentFactory
{
  public static QQGuildDiscoverBaseSubTabFragment a(int paramInt1, int paramInt2, QQGuildDiscoverFragment paramQQGuildDiscoverFragment)
  {
    QQGuildDiscoverSubTabCommonFragment localQQGuildDiscoverSubTabCommonFragment;
    if (paramInt1 != 0) {
      localQQGuildDiscoverSubTabCommonFragment = new QQGuildDiscoverSubTabCommonFragment();
    } else {
      localQQGuildDiscoverSubTabCommonFragment = new QQGuildDiscoverSubTabCommonFragment();
    }
    localQQGuildDiscoverSubTabCommonFragment.a(paramQQGuildDiscoverFragment);
    localQQGuildDiscoverSubTabCommonFragment.a(paramInt2);
    return localQQGuildDiscoverSubTabCommonFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.tab.SubTabFragmentFactory
 * JD-Core Version:    0.7.0.1
 */