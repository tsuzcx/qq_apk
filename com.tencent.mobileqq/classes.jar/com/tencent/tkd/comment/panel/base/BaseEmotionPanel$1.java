package com.tencent.tkd.comment.panel.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tkd.comment.util.LogUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class BaseEmotionPanel$1
  extends PagerAdapter
{
  BaseEmotionPanel$1(BaseEmotionPanel paramBaseEmotionPanel) {}
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    if ((this.a.a().size() > 0) && (paramInt < this.a.a().size()))
    {
      paramViewGroup.removeView((View)this.a.a().get(paramInt));
      LogUtil.logD("EmotionPanelTAG", "destroyItem:" + paramInt);
    }
  }
  
  public int getCount()
  {
    LogUtil.logD("EmotionPanelTAG", "getCount:" + this.a.a().size());
    return this.a.a().size();
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.a.a().get(paramInt));
    return this.a.a().get(paramInt);
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    return paramObject == paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionPanel.1
 * JD-Core Version:    0.7.0.1
 */