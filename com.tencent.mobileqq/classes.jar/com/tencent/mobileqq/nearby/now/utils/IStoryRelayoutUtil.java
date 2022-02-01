package com.tencent.mobileqq.nearby.now.utils;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStoryRelayoutUtil
  extends QRouteApi
{
  public abstract boolean dynamicChangeStoryContainerView(Object paramObject, float paramFloat1, float paramFloat2);
  
  public abstract boolean dynamicLayoutStoryImageContainerView(Object paramObject1, float paramFloat1, float paramFloat2, Object paramObject2, Object paramObject3);
  
  public abstract boolean isSameHeight(View paramView, Rect paramRect);
  
  public abstract boolean reLayoutPreBkg(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract boolean updateLayoutForTxtFeeds(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
 * JD-Core Version:    0.7.0.1
 */