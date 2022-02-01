package com.tencent.mobileqq.guild.vas.panel;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.guild.vas.adapter.GiftListPageAdapter;

class GiftPanelController$2
  implements ViewPager.OnPageChangeListener
{
  GiftPanelController$2(GiftPanelController paramGiftPanelController, IGiftPanelController.OnSelectLastPageListener paramOnSelectLastPageListener) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (GiftPanelController.b(this.b) != null) {
      GiftPanelController.b(this.b).animate().x(GiftPanelController.e() * paramInt).setDuration(300L).start();
    }
    if (GiftPanelController.a(this.b).getCount() - 1 == paramInt) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.panel.GiftPanelController.2
 * JD-Core Version:    0.7.0.1
 */