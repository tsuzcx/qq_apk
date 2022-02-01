package com.tencent.mobileqq.relationx.icebreaking;

import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;

class AIOIceBreakView$1$1
  implements Runnable
{
  AIOIceBreakView$1$1(AIOIceBreakView.1 param1) {}
  
  public void run()
  {
    HotPicMainPanel localHotPicMainPanel = (HotPicMainPanel)AIOIceBreakView.a(this.a.a).b().a().b(24);
    if (localHotPicMainPanel != null) {
      localHotPicMainPanel.a.setCurrentItem(localHotPicMainPanel.e, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1.1
 * JD-Core Version:    0.7.0.1
 */