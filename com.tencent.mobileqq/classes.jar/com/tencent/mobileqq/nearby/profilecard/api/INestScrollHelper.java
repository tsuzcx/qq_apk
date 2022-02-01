package com.tencent.mobileqq.nearby.profilecard.api;

import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INestScrollHelper
  extends QRouteApi
{
  public abstract boolean isTop();
  
  public abstract void setPosition(int paramInt);
  
  public abstract void setViewPager(ViewPager paramViewPager);
  
  public abstract void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.INestScrollHelper
 * JD-Core Version:    0.7.0.1
 */