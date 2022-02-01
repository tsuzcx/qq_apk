package com.tencent.mobileqq.nearby.now.utils.impl;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.widget.FitXImageView;

public class StoryRelayoutUtilImpl
  implements IStoryRelayoutUtil
{
  public boolean dynamicChangeStoryContainerView(Object paramObject, float paramFloat1, float paramFloat2)
  {
    return StoryRelayoutUtil.a((VideoPlayerPagerAdapter.VideoViewHolder)paramObject, paramFloat1, paramFloat2);
  }
  
  public boolean dynamicLayoutStoryImageContainerView(Object paramObject1, float paramFloat1, float paramFloat2, Object paramObject2, Object paramObject3)
  {
    return StoryRelayoutUtil.a((VideoPlayerPagerAdapter.VideoViewHolder)paramObject1, paramFloat1, paramFloat2, (VideoData)paramObject2, (IShortVideoCommentsView)paramObject3);
  }
  
  public boolean isSameHeight(View paramView, Rect paramRect)
  {
    return StoryRelayoutUtil.a(paramView, paramRect);
  }
  
  public boolean reLayoutPreBkg(Object paramObject, int paramInt1, int paramInt2)
  {
    return StoryRelayoutUtil.a((FitXImageView)paramObject, paramInt1, paramInt2);
  }
  
  public boolean updateLayoutForTxtFeeds(Object paramObject)
  {
    return StoryRelayoutUtil.a((VideoPlayerPagerAdapter.VideoViewHolder)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.StoryRelayoutUtilImpl
 * JD-Core Version:    0.7.0.1
 */