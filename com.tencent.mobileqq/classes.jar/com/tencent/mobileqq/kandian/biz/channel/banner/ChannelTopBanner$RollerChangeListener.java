package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

public class ChannelTopBanner$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int a = 0;
  
  protected ChannelTopBanner$RollerChangeListener(ChannelTopBanner paramChannelTopBanner) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.b.k != null) {
      this.b.k.onPageScrollStateChanged(paramInt);
    }
    ChannelTopBanner localChannelTopBanner = this.b;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localChannelTopBanner.c = bool;
    if (!this.b.c) {
      return;
    }
    int i = this.b.b.getCurrentItem();
    localChannelTopBanner = this.b;
    localChannelTopBanner.j = i;
    paramInt = localChannelTopBanner.d.getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.b.d.instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.b.d.instantiateItem(null, 1);
    }
    if (i == 0) {
      paramInt -= 2;
    } else if (i == paramInt - 1) {
      paramInt = j;
    } else {
      paramInt = i;
    }
    if (i != paramInt)
    {
      localChannelTopBanner = this.b;
      localChannelTopBanner.j = paramInt;
      localChannelTopBanner.b.setCurrentItem(paramInt, false);
      ChannelTopBanner.a(this.b, paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.b.k != null) {
      this.b.k.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.b.d.b(paramInt);
    if ((i >= 0) && (this.a >= 0) && (this.b.g != null) && (this.b.g.length > i) && (this.b.g.length > this.a))
    {
      this.b.g[this.a].setBackgroundDrawable(this.b.h);
      this.b.g[i].setBackgroundDrawable(this.b.i);
      this.a = i;
    }
    if (this.b.k != null) {
      this.b.k.onPageSelected(paramInt);
    }
    this.b.d.d(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */