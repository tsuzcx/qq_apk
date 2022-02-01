package com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar;

import com.tencent.mobileqq.banner.TipsBar;

class QQGuildSubTopBarLiveFragment$1$1
  implements Runnable
{
  QQGuildSubTopBarLiveFragment$1$1(QQGuildSubTopBarLiveFragment.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    TipsBar localTipsBar = QQGuildSubTopBarLiveFragment.a(this.b.a);
    int i;
    if (this.a) {
      i = 8;
    } else {
      i = 0;
    }
    localTipsBar.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment.1.1
 * JD-Core Version:    0.7.0.1
 */