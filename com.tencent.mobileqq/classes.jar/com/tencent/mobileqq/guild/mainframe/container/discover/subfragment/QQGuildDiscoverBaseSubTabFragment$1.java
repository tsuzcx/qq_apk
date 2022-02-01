package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class QQGuildDiscoverBaseSubTabFragment$1
  extends View.AccessibilityDelegate
{
  QQGuildDiscoverBaseSubTabFragment$1(QQGuildDiscoverBaseSubTabFragment paramQQGuildDiscoverBaseSubTabFragment) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 8) {
      i = 32768;
    }
    super.sendAccessibilityEvent(paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment.1
 * JD-Core Version:    0.7.0.1
 */