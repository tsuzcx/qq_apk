package com.tencent.mobileqq.nearby.widget;

import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.qphone.base.util.QLog;

public class AvatarWallViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  public int a = 0;
  
  protected AvatarWallViewPager$RollerChangeListener(AvatarWallViewPager paramAvatarWallViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AvatarWallViewPager localAvatarWallViewPager = this.b;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localAvatarWallViewPager.e = bool;
    if (!this.b.e) {
      return;
    }
    int i = this.b.d.getCurrentItem();
    localAvatarWallViewPager = this.b;
    localAvatarWallViewPager.w = i;
    paramInt = localAvatarWallViewPager.f.c();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.b.f.b().instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.b.f.b().instantiateItem(null, 1);
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
      localAvatarWallViewPager.w = paramInt;
      localAvatarWallViewPager.d.setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.b.f.c() <= 1)
    {
      this.a = 0;
      return;
    }
    paramInt = this.b.f.a(paramInt);
    if ((this.a < this.b.h.getChildCount()) && (paramInt < this.b.h.getChildCount()))
    {
      this.b.h.removeViewAt(this.a);
      this.b.h.addView(this.b.a(false, this.a), this.a);
      this.b.h.removeViewAt(paramInt);
      this.b.h.addView(this.b.a(true, paramInt), paramInt);
      this.a = paramInt;
      return;
    }
    this.a = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected error, lastPos = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", pos = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", childCount = ");
      localStringBuilder.append(this.b.h.getChildCount());
      QLog.e("AvatarWallViewPager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */