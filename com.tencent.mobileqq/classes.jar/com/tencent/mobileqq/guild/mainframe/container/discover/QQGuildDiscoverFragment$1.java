package com.tencent.mobileqq.guild.mainframe.container.discover;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.GuildDiscoverViewPager;
import com.tencent.qphone.base.util.QLog;

class QQGuildDiscoverFragment$1
  extends ViewPager.SimpleOnPageChangeListener
{
  QQGuildDiscoverFragment$1(QQGuildDiscoverFragment paramQQGuildDiscoverFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.a;
      QQGuildDiscoverFragment.b((QQGuildDiscoverFragment)localObject, QQGuildDiscoverFragment.c((QQGuildDiscoverFragment)localObject).getCurrentItem());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:");
      ((StringBuilder)localObject).append(QQGuildDiscoverFragment.a(this.a));
      ((StringBuilder)localObject).append("  mPageChangedByIndicator:");
      ((StringBuilder)localObject).append(QQGuildDiscoverFragment.b(this.a));
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (QQGuildDiscoverFragment.b(this.a)) {
      QQGuildDiscoverFragment.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QQGuildDiscoverFragment.a(this.a, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mViewPager onPageSelected mOccurSwitchAccountChangeTab:");
      localStringBuilder.append(QQGuildDiscoverFragment.a(this.a));
      localStringBuilder.append(" mPageChangedByIndicator:");
      localStringBuilder.append(QQGuildDiscoverFragment.b(this.a));
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
    QQGuildDiscoverFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment.1
 * JD-Core Version:    0.7.0.1
 */