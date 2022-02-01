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
  private float jdField_a_of_type_Float;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  protected ViewPager a;
  private BannerView.AutoSidleTimer jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer;
  private BannerView.BannerViewAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
  private BannerView.DotsIndicator jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = DisplayUtil.a(getContext(), 25.0F);
  private int c;
  private int d = 1;
  private int e = 3500;
  private int f = 81;
  
  public BannerView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130843225;
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130843225;
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2130843225;
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if (localBannerViewAdapter != null)
    {
      if (paramInt == 0)
      {
        this.c = (localBannerViewAdapter.a() - 2);
        this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.c, false);
        return;
      }
      if (paramInt == localBannerViewAdapter.a() - 1)
      {
        this.c = 1;
        this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.c, false);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = new ViewPager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setLayoutParams(paramContext);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.a() - 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
      if ((localBannerViewAdapter != null) && (!localBannerViewAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer != null))
      {
        if (this.c == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.a() - 1)
        {
          this.c = 1;
          this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.c, false);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer.b();
          return;
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer != null))
        {
          this.c += 1;
          this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.c);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer.b(this.e);
        }
      }
    }
  }
  
  public void a()
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if (localBannerViewAdapter != null)
    {
      if (localBannerViewAdapter.b() <= 1) {
        return;
      }
      if (this.d == 0) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer.a(this.e);
      }
    }
  }
  
  public void b()
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if (localBannerViewAdapter != null)
    {
      if (localBannerViewAdapter.b() <= 1) {
        return;
      }
      if (this.d == 1) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.d = 1;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
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
    BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if ((localBannerViewAdapter != null) && (localBannerViewAdapter.b() > 1))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 2)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        else
        {
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          if (Math.abs(f1 - this.jdField_a_of_type_Float) >= Math.abs(f2 - this.jdField_b_of_type_Float)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          } else {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        if (this.jdField_a_of_type_Float > this.jdField_b_of_type_Int)
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
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if (localBannerViewAdapter == null) {
      return;
    }
    if (localBannerViewAdapter.b() == 1) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener != null) && (!a(paramInt1))) {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener.onPageScrolled(paramInt1 - 1, paramFloat, paramInt2);
    }
    if ((a(paramInt1)) && (paramInt2 == 0)) {
      a(paramInt1);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
    if (localObject == null) {
      return;
    }
    if (((BannerView.BannerViewAdapter)localObject).b() == 1) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener != null) && (!a(paramInt))) {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener.onPageSelected(paramInt - 1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator;
    if (localObject != null)
    {
      BannerView.BannerViewAdapter localBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter;
      if (localBannerViewAdapter != null) {
        if (paramInt == 0) {
          ((BannerView.DotsIndicator)localObject).setDotsSelected(localBannerViewAdapter.a() - 3);
        } else if (paramInt == localBannerViewAdapter.a() - 1) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(paramInt - 1);
        }
      }
    }
    this.c = paramInt;
  }
  
  public void setAdapter(BannerView.BannerViewAdapter paramBannerViewAdapter)
  {
    if (paramBannerViewAdapter != null)
    {
      if (paramBannerViewAdapter.a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter = paramBannerViewAdapter;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$AutoSidleTimer = new BannerView.AutoSidleTimer(this);
        b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.b() > 1)
      {
        paramBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator;
        if (paramBannerViewAdapter != null) {
          paramBannerViewAdapter.removeAllViews();
        }
        this.c = 1;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator = new BannerView.DotsIndicator(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.b(), this.f);
        paramBannerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator;
        paramBannerViewAdapter.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramBannerViewAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(this.c - 1);
      }
      else
      {
        this.c = 0;
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.a());
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter);
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.c);
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOverScrollMode(2);
      removeAllViews();
      addView(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$BannerViewAdapter.b() > 1) {
        addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerView$DotsIndicator);
      }
    }
  }
  
  public void setDotsGravity(int paramInt)
  {
    if ((paramInt != 81) && (paramInt != 8388691) && (paramInt != 8388693)) {
      return;
    }
    this.f = paramInt;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager != null) {
      localViewPager.setOffscreenPageLimit(paramInt);
    }
  }
  
  public void setPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager != null) {
      localViewPager.setPageTransformer(paramBoolean, paramPageTransformer);
    }
  }
  
  public void setTimeInterval(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerView
 * JD-Core Version:    0.7.0.1
 */