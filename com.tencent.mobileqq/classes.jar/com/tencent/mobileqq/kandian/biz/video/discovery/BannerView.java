package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.tencent.mobileqq.util.DisplayUtil;

public class BannerView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  protected ViewPager a;
  public int b = 2130844179;
  int c = DisplayUtil.a(getContext(), 25.0F);
  private BannerView.DotsIndicator d;
  private BannerView.AutoSidleTimer e;
  private BannerView.BannerViewAdapter f;
  private Context g;
  private ViewPager.OnPageChangeListener h;
  private boolean i = true;
  private int j;
  private int k = 1;
  private int l = 3500;
  private int m = 81;
  private float n;
  private float o;
  
  public BannerView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = paramContext;
    this.a = new ViewPager(this.g);
    this.a.setOnPageChangeListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.a.setLayoutParams(paramContext);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == this.f.a() - 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void c()
  {
    if (this.i)
    {
      BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
      if ((localBannerViewAdapter != null) && (!localBannerViewAdapter.c()) && (this.e != null))
      {
        if (this.j == this.f.a() - 1)
        {
          this.j = 1;
          this.a.setCurrentItem(this.j, false);
          this.e.b();
          return;
        }
        if ((this.i) && (this.e != null))
        {
          this.j += 1;
          this.a.setCurrentItem(this.j);
          this.e.b(this.l);
        }
      }
    }
  }
  
  private void setVirtualItem(int paramInt)
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
    if (localBannerViewAdapter != null)
    {
      if (paramInt == 0)
      {
        this.j = (localBannerViewAdapter.a() - 2);
        this.a.setCurrentItem(this.j, false);
        return;
      }
      if (paramInt == localBannerViewAdapter.a() - 1)
      {
        this.j = 1;
        this.a.setCurrentItem(this.j, false);
      }
    }
  }
  
  public void a()
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
    if (localBannerViewAdapter != null)
    {
      if (localBannerViewAdapter.b() <= 1) {
        return;
      }
      if (this.k == 0) {
        return;
      }
      if (this.i)
      {
        this.k = 0;
        this.e.a(this.l);
      }
    }
  }
  
  public void b()
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
    if (localBannerViewAdapter != null)
    {
      if (localBannerViewAdapter.b() <= 1) {
        return;
      }
      if (this.k == 1) {
        return;
      }
      if (this.i)
      {
        this.k = 1;
        this.e.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
        a();
      }
    }
    else {
      b();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
    if ((localBannerViewAdapter != null) && (localBannerViewAdapter.b() > 1))
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        else
        {
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          if (Math.abs(f1 - this.n) >= Math.abs(f2 - this.o)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          } else {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
      }
      else
      {
        this.n = paramMotionEvent.getX();
        this.o = paramMotionEvent.getY();
        if (this.n > this.c)
        {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.h;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
    if (localBannerViewAdapter == null) {
      return;
    }
    if (localBannerViewAdapter.b() == 1) {
      return;
    }
    if ((this.h != null) && (!a(paramInt1))) {
      this.h.onPageScrolled(paramInt1 - 1, paramFloat, paramInt2);
    }
    if ((a(paramInt1)) && (paramInt2 == 0)) {
      setVirtualItem(paramInt1);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if (((BannerView.BannerViewAdapter)localObject).b() == 1) {
      return;
    }
    if ((this.h != null) && (!a(paramInt))) {
      this.h.onPageSelected(paramInt - 1);
    }
    localObject = this.d;
    if (localObject != null)
    {
      BannerView.BannerViewAdapter localBannerViewAdapter = this.f;
      if (localBannerViewAdapter != null) {
        if (paramInt == 0) {
          ((BannerView.DotsIndicator)localObject).setDotsSelected(localBannerViewAdapter.a() - 3);
        } else if (paramInt == localBannerViewAdapter.a() - 1) {
          this.d.setDotsSelected(0);
        } else {
          this.d.setDotsSelected(paramInt - 1);
        }
      }
    }
    this.j = paramInt;
  }
  
  public void setAdapter(BannerView.BannerViewAdapter paramBannerViewAdapter)
  {
    if (paramBannerViewAdapter != null)
    {
      if (paramBannerViewAdapter.c()) {
        return;
      }
      this.f = paramBannerViewAdapter;
      if ((this.i) && (this.e == null))
      {
        this.e = new BannerView.AutoSidleTimer(this);
        b();
      }
      if (this.f.b() > 1)
      {
        paramBannerViewAdapter = this.d;
        if (paramBannerViewAdapter != null) {
          paramBannerViewAdapter.removeAllViews();
        }
        this.j = 1;
        this.d = new BannerView.DotsIndicator(this.g, this.f.b(), this.m);
        paramBannerViewAdapter = this.d;
        paramBannerViewAdapter.a = this.b;
        paramBannerViewAdapter.a();
        this.d.setDotsSelected(this.j - 1);
      }
      else
      {
        this.j = 0;
      }
      this.a.setOffscreenPageLimit(this.f.a());
      this.a.setAdapter(this.f);
      this.a.setCurrentItem(this.j);
      this.a.setOverScrollMode(2);
      removeAllViews();
      addView(this.a);
      if (this.f.b() > 1) {
        addView(this.d);
      }
    }
  }
  
  public void setDotsGravity(int paramInt)
  {
    if ((paramInt != 81) && (paramInt != 8388691) && (paramInt != 8388693)) {
      return;
    }
    this.m = paramInt;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    ViewPager localViewPager = this.a;
    if (localViewPager != null) {
      localViewPager.setOffscreenPageLimit(paramInt);
    }
  }
  
  public void setPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.h = paramOnPageChangeListener;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    ViewPager localViewPager = this.a;
    if (localViewPager != null) {
      localViewPager.setPageTransformer(paramBoolean, paramPageTransformer);
    }
  }
  
  public void setTimeInterval(int paramInt)
  {
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerView
 * JD-Core Version:    0.7.0.1
 */