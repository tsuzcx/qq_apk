package com.tencent.tkd.comment.panel.base;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.tkd.comment.panel.base.view.PageIndicator;
import com.tencent.tkd.comment.util.LogUtil;

class BaseEmotionPanel$2
  implements ViewPager.OnPageChangeListener
{
  BaseEmotionPanel$2(BaseEmotionPanel paramBaseEmotionPanel) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (BaseEmotionPanel.a(this.a) != null) {
      BaseEmotionPanel.a(this.a).a(paramInt1, paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected:");
    localStringBuilder.append(paramInt);
    LogUtil.logD("EmotionPanelTAG", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionPanel.2
 * JD-Core Version:    0.7.0.1
 */