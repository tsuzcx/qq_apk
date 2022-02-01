package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayoutCompat$Tab
{
  TabLayoutCompat a;
  TabLayoutCompat.TabView b;
  private Object c;
  private Drawable d;
  private CharSequence e;
  private CharSequence f;
  private int g = -1;
  private View h;
  
  @NonNull
  public Tab a(int paramInt)
  {
    return a(LayoutInflater.from(this.b.getContext()).inflate(paramInt, this.b, false));
  }
  
  @NonNull
  public Tab a(@Nullable View paramView)
  {
    this.h = paramView;
    k();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    k();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable Object paramObject)
  {
    this.c = paramObject;
    return this;
  }
  
  @Nullable
  public Object a()
  {
    return this.c;
  }
  
  @Nullable
  public View b()
  {
    return this.h;
  }
  
  void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  @Nullable
  public Drawable c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.g;
  }
  
  @Nullable
  public CharSequence e()
  {
    return this.e;
  }
  
  public void f()
  {
    TabLayoutCompat localTabLayoutCompat = this.a;
    if (localTabLayoutCompat != null)
    {
      localTabLayoutCompat.e(this);
      return;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  public void g()
  {
    TabLayoutCompat localTabLayoutCompat = this.a;
    if (localTabLayoutCompat != null)
    {
      localTabLayoutCompat.c(this, true);
      return;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  public boolean h()
  {
    TabLayoutCompat localTabLayoutCompat = this.a;
    if (localTabLayoutCompat != null) {
      return localTabLayoutCompat.getSelectedTabPosition() == this.g;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  @Nullable
  public CharSequence i()
  {
    return this.f;
  }
  
  public View j()
  {
    return this.b;
  }
  
  void k()
  {
    TabLayoutCompat.TabView localTabView = this.b;
    if (localTabView != null) {
      localTabView.b();
    }
  }
  
  void l()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = -1;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.Tab
 * JD-Core Version:    0.7.0.1
 */