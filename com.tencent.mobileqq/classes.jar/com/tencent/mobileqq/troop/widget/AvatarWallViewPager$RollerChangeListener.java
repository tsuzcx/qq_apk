package com.tencent.mobileqq.troop.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

public class AvatarWallViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int a = 0;
  
  protected AvatarWallViewPager$RollerChangeListener(AvatarWallViewPager paramAvatarWallViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.b.q != null) {
      this.b.q.onPageScrollStateChanged(paramInt);
    }
    AvatarWallViewPager localAvatarWallViewPager = this.b;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localAvatarWallViewPager.d = bool;
    if (!this.b.d) {
      return;
    }
    int i = this.b.c.getCurrentItem();
    localAvatarWallViewPager = this.b;
    localAvatarWallViewPager.p = i;
    paramInt = localAvatarWallViewPager.e.getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.b.e.instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.b.e.instantiateItem(null, 1);
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
      localAvatarWallViewPager = this.b;
      localAvatarWallViewPager.p = paramInt;
      localAvatarWallViewPager.c.setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.b.q != null) {
      this.b.q.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.b.e.getCount();
    if (paramInt == 0) {
      i -= 2;
    } else if (paramInt == i - 1) {
      i = 1;
    } else {
      i = paramInt;
    }
    i -= 1;
    if ((i >= 0) && (this.a >= 0) && (this.b.h.length > i) && (this.b.h.length > this.a))
    {
      this.b.h[this.a].setBackgroundDrawable(this.b.i);
      this.b.h[i].setBackgroundDrawable(this.b.j);
      this.a = i;
    }
    if (this.b.q != null) {
      this.b.q.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */