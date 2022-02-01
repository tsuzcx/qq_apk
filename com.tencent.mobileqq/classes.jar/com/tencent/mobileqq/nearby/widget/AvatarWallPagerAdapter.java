package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public abstract class AvatarWallPagerAdapter<T>
{
  protected boolean c = false;
  protected AvatarWallPagerAdapter<T>.InnerPagerAdapter d;
  protected AvatarWallViewPager e;
  protected SoftReference<View> f;
  protected SoftReference<View> g;
  protected final List<T> h = new ArrayList();
  
  public AvatarWallPagerAdapter(AvatarWallViewPager paramAvatarWallViewPager)
  {
    this.e = paramAvatarWallViewPager;
    this.d = new AvatarWallPagerAdapter.InnerPagerAdapter(this);
  }
  
  protected int a(int paramInt)
  {
    int i = c();
    if (i <= 1) {
      return 0;
    }
    if (paramInt == 0) {
      return i - 3;
    }
    if (paramInt == i - 1) {
      return 0;
    }
    return paramInt - 1;
  }
  
  public abstract View a(int paramInt, T paramT);
  
  public abstract View a(boolean paramBoolean, int paramInt);
  
  public void a()
  {
    this.c = true;
    this.e = null;
    this.g = null;
    this.f = null;
  }
  
  public void a(int paramInt, View paramView) {}
  
  public void a(List<T> paramList)
  {
    if (this.c) {
      return;
    }
    this.g = null;
    this.f = null;
    this.h.clear();
    if (paramList != null) {
      this.h.addAll(paramList);
    }
    if ((this.h.size() > 1) || ((this.h.size() == 1) && (this.e.v)))
    {
      int i = paramList.size();
      this.h.add(paramList.get(0));
      this.h.add(0, paramList.get(i - 1));
    }
    this.e.e();
    this.d.notifyDataSetChanged();
    this.e.getRollViewPager().setCurrentItem(1);
  }
  
  public boolean a(T paramT1, T paramT2)
  {
    if ((paramT1 != null) && (paramT2 != null)) {
      return paramT1.equals(paramT2);
    }
    return false;
  }
  
  protected PagerAdapter b()
  {
    return this.d;
  }
  
  protected int c()
  {
    return this.h.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter
 * JD-Core Version:    0.7.0.1
 */