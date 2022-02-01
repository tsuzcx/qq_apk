package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildDiscoverSlidingIndicator$2
  implements View.OnClickListener
{
  GuildDiscoverSlidingIndicator$2(GuildDiscoverSlidingIndicator paramGuildDiscoverSlidingIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.b == this.a) && (this.b.b >= 0) && (GuildDiscoverSlidingIndicator.a(this.b) != null)) {
      GuildDiscoverSlidingIndicator.a(this.b).a(this.a);
    }
    this.b.a(this.a, true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator.2
 * JD-Core Version:    0.7.0.1
 */