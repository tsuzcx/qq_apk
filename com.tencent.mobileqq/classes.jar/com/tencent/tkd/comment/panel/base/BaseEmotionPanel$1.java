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
    if ((this.a.getEmotionRecyclerViewList().size() > 0) && (paramInt < this.a.getEmotionRecyclerViewList().size()))
    {
      paramViewGroup.removeView((View)this.a.getEmotionRecyclerViewList().get(paramInt));
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("destroyItem:");
      paramViewGroup.append(paramInt);
      LogUtil.logD("EmotionPanelTAG", paramViewGroup.toString());
    }
  }
  
  public int getCount()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCount:");
    localStringBuilder.append(this.a.getEmotionRecyclerViewList().size());
    LogUtil.logD("EmotionPanelTAG", localStringBuilder.toString());
    return this.a.getEmotionRecyclerViewList().size();
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.a.getEmotionRecyclerViewList().get(paramInt));
    return this.a.getEmotionRecyclerViewList().get(paramInt);
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    return paramObject == paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionPanel.1
 * JD-Core Version:    0.7.0.1
 */