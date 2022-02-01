package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class GuildDiscoverSlidingIndicator$1
  extends View.AccessibilityDelegate
{
  GuildDiscoverSlidingIndicator$1(GuildDiscoverSlidingIndicator paramGuildDiscoverSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator.1
 * JD-Core Version:    0.7.0.1
 */