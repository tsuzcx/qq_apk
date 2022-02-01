package com.tencent.mobileqq.multicard;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TouchEventConsumer;
import com.tencent.mobileqq.multiaio.widget.ZoomOutPageTransformer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MultiCardFragment
  extends PublicBaseFragment
  implements TouchEventConsumer, MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener
{
  private int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiAIOViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  private MultiCardContext jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
  private MultiCardFragment.MultiCardShowArrow jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow = new MultiCardFragment.MultiCardShowArrow(this, null);
  private MultiCardFragment.ReportRunnable jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ReportRunnable = new MultiCardFragment.ReportRunnable();
  private MultiCardFragment.ZoomParam jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam;
  private MultiCardPageIndicator jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
  private MultiCardPagerAdapter jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter;
  private WeakReference<MultiCardContainer> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private int c = -1;
  
  public MultiCardFragment()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.identityHashCode(this));
      localStringBuilder.append(" MultiCardFragment() called");
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
  }
  
  private ViewGroup a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        return (ViewGroup)((MultiCardContainer)localObject).a();
      }
    }
    return null;
  }
  
  private TopGestureLayout a(Activity paramActivity)
  {
    paramActivity = (FrameLayout)paramActivity.getWindow().getDecorView();
    int i = 0;
    while (i < paramActivity.getChildCount())
    {
      View localView = paramActivity.getChildAt(i);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = ((MultiCardPageIndicator)paramView.findViewById(2131368768));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramBundle != null)
    {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setMultiCardContext(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131380822));
    paramView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramView != null) {
      paramView.setOffscreenPageLimit(3);
    }
    paramView = getResources();
    int i = (int)((paramView.getDisplayMetrics().widthPixels - AIOUtils.b(42.0F, paramView) * 2) * (1.0F - ZoomOutPageTransformer.jdField_a_of_type_Float) * 0.5F);
    int j = AIOUtils.b(2.0F, paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramView != null)
    {
      paramView.setPageMargin(-(i + j));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new ZoomOutPageTransformer());
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new MultiCardFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramView != null)
    {
      paramView.setOnClickListener(new MultiCardFragment.3(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setTouchEventConsumer(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = new MultiCardPagerAdapter(getChildFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext);
    paramView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramView != null) {
      paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramView != null) {
      paramView.setViewPager(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramView != null)
    {
      paramView.setActTAG("MultiWindowCardFPS");
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new MultiCardFragment.4(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new MultiCardFragment.5(this));
    }
    paramView = new MultiCardFragment.6(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramBundle != null)
    {
      paramBundle.setOnPageChangeListener(paramView);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnTabClickListener(new MultiCardFragment.7(this));
    }
    paramView.b(0);
    paramView = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramView != null)
    {
      paramView.a(new MultiCardFragment.8(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnActionUpNotFling(new MultiCardFragment.9(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOverScrollMode(2);
    }
    paramView = a(getBaseActivity());
    if (paramView != null) {
      paramView.setInterceptScrollLRFlag(false);
    }
  }
  
  private void a(MultiCardFragment.ZoomParam paramZoomParam)
  {
    if (paramZoomParam == null) {
      return;
    }
    if (paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.j();
    }
    float f5 = paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getWidth();
    float f1 = paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getHeight();
    float f3 = f5 / 2.0F;
    float f2 = f1 / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotX(f3);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotY(f2);
    f3 = paramZoomParam.jdField_a_of_type_Float;
    paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth();
    int i = paramZoomParam.jdField_b_of_type_Int;
    f3 = paramZoomParam.jdField_b_of_type_Float * paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / 2.0F;
    float f4 = paramZoomParam.c;
    f5 = paramZoomParam.jdField_a_of_type_Float * paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth() / f5;
    float f6 = paramZoomParam.jdField_b_of_type_Float * paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / f1;
    float f7 = (1.0F - f6 / f5) * f1 * f5 / 2.0F;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiCardFragment.12(this, paramZoomParam, f5, f2 - (f3 + f4) - f7, f1, f6));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new MultiCardFragment.13(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    paramZoomParam = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        ((MultiCardContainer)localObject).a(paramString);
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkPreLoadData, nPos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" requestPos:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" preloadcountL");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_b_of_type_Int == 0) {
      return false;
    }
    if (paramInt == -1) {}
    try
    {
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_b_of_type_Int + paramInt < this.jdField_a_of_type_Int) {
        return false;
      }
      do
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a() > this.jdField_a_of_type_Int))
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            localObject1 = (MultiCardContainer)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject1 != null)
            {
              ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              if ((localArrayList != null) && (localArrayList.size() > 0))
              {
                ((MultiCardContainer)localObject1).a(localArrayList, true, true);
                this.jdField_a_of_type_Int += localArrayList.size();
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkPreLoadData, end, requestPos:");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
            QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
      } while (this.jdField_a_of_type_Int < paramInt);
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void b()
  {
    float f = VelocityUtil.jdField_a_of_type_Int * 1.0F / 20.0F;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).b(f);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).a(f);
    }
  }
  
  private void b(MultiCardFragment.ZoomParam paramZoomParam)
  {
    if (paramZoomParam == null) {
      return;
    }
    if (paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.i();
    }
    Object localObject = (ViewGroup)paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent();
    float f1 = ((ViewGroup)localObject).getHeight();
    float f4 = paramZoomParam.jdField_b_of_type_Float;
    float f5 = paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight();
    float f2 = paramZoomParam.jdField_a_of_type_Float * paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getWidth() / ((ViewGroup)localObject).getWidth();
    float f3 = paramZoomParam.jdField_b_of_type_Float * paramZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getHeight() / ((ViewGroup)localObject).getHeight();
    f4 = paramZoomParam.c + (int)(f4 * f5) / 2;
    f5 = ((ViewGroup)localObject).getWidth() / 2;
    float f6 = ((ViewGroup)localObject).getHeight() / 2;
    float f7 = (1.0F - f3 / f2) * f1 * f2 / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotX(f5);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotY(f6);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiCardFragment.14(this, paramZoomParam, f2, f4 - f6 + f7, f1, f3));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new MultiCardFragment.15(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    paramZoomParam = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = new AlphaAnimation(1.0F, 0.0F);
    paramZoomParam.setDuration(400L);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).startAnimation(paramZoomParam);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).startAnimation(paramZoomParam);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    a(null);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
      if ((localObject != null) && (this.c != ((MultiAIOViewPager)localObject).a()))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
        if (localObject != null) {
          ((MultiCardPageIndicator)localObject).c();
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
      if (localObject != null) {
        ((MultiCardPageIndicator)localObject).c();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow);
  }
  
  private void c()
  {
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
      if (localObject1 != null)
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
        if (localObject3 == null) {
          return;
        }
        CardContent localCardContent = ((MultiCardContext)localObject1).a(((MultiAIOViewPager)localObject3).a());
        if (localCardContent == null) {
          return;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(localCardContent.a());
        localObject1 = localObject3;
        Object localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = localCardContent.a();
          localObject1 = localObject3;
          try
          {
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              localObject4 = (MultiCardContainer)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                localObject1 = new ArrayList();
                ((ArrayList)localObject1).add(Long.valueOf(localCardContent.a()));
                ((MultiCardContainer)localObject4).a((ArrayList)localObject1, true, true);
                localObject1 = localObject3;
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("checkShowNickName exception:");
            ((StringBuilder)localObject4).append(localException);
            ((StringBuilder)localObject4).append("  ");
            ((StringBuilder)localObject4).append(localCardContent.a());
            QLog.e("MultiCardFragment", 2, ((StringBuilder)localObject4).toString());
            localObject2 = localObject3;
          }
        }
        a(localObject2);
        return;
      }
      return;
    }
    a(null);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "scheduleShowArrow() ");
    }
    b(false);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow, 100L);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "unInit");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter;
    if (localObject != null)
    {
      ((MultiCardPagerAdapter)localObject).a(null);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = null;
    MultiCardItemFragment.a.a();
    for (localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.c.a(); localObject != null; localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.c.a()) {
      ((MultiCardCustomViewDelegate)localObject).a();
    }
    MultiCardItemFragment.c.a();
    for (localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.b.a(); localObject != null; localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.b.a()) {
      ((MultiCardCustomViewDelegate)localObject).a();
    }
    MultiCardItemFragment.b.a();
    for (localObject = (View)MultiCardItemFragment.d.a(); localObject != null; localObject = (View)MultiCardItemFragment.d.a()) {}
    MultiCardItemFragment.d.a();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam != null)
    {
      ViewGroup localViewGroup = a();
      if ((localViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationY(0.0F);
        localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.b();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam = null;
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam;
    if (localObject != null)
    {
      ((MultiCardFragment.ZoomParam)localObject).jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationX(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationY(0.0F);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).setVisibility(8);
    }
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        ((MultiCardContainer)localObject).e();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((!a(paramInt)) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext != null))
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (MultiCardContainer)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(paramInt, 1);
          if ((localArrayList != null) && (localArrayList.size() > 0)) {
            ((MultiCardContainer)localObject).a(localArrayList, true, true);
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MultiCardContainer paramMultiCardContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext = MultiCardContext.a(paramQQAppInterface, String.valueOf(paramString));
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMultiCardContainer);
    this.jdField_b_of_type_Int = GroupIntimateRelationshipConfProcessor.a().jdField_a_of_type_Int;
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = 0;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init, preload count:");
      paramQQAppInterface.append(this.jdField_b_of_type_Int);
      QLog.d("MultiCardFragment", 2, paramQQAppInterface.toString());
    }
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam);
    }
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    a("0X800A214", 1);
    if ((paramMultiCardCustomViewDelegate instanceof StrangerIntimateViewDelegate)) {
      a("0X800A217", 1);
    } else if ((paramMultiCardCustomViewDelegate instanceof IntimateInfoViewDelegate)) {
      if ((paramMultiCardCustomViewDelegate != null) && (paramMultiCardCustomViewDelegate.a != null) && (paramMultiCardCustomViewDelegate.a.a())) {
        a("0X800A217", 3);
      } else {
        a("0X800A217", 2);
      }
    }
    if (paramMultiCardRootLayout == null)
    {
      QLog.e("MultiCardFragment", 1, "onClick: view == null, activity was destroyed ?");
      return;
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam != null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam = new MultiCardFragment.ZoomParam(this, paramMultiCardRootLayout, paramMultiCardCustomLayout, paramMultiCardCustomViewDelegate, this);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a();
      paramMultiCardRootLayout = a();
      if (paramMultiCardRootLayout != null) {
        paramMultiCardRootLayout.addView(paramMultiCardCustomLayout, new RelativeLayout.LayoutParams(-1, -1));
      }
      b(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam);
    }
  }
  
  public void a(List<Long> paramList, Map<Long, IntimateInfo> paramMap, Map<Long, String> paramMap1)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardFragment.1(this, paramList, paramMap, paramMap1));
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = getView();
    if ((localView != null) && ((localView instanceof ViewGroup))) {
      ((ViewGroup)localView).requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        return ((MultiCardContainer)localObject).jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() != 0) {
      return;
    }
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if ((paramMotionEvent != null) && (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) && (paramMotionEvent.equals(paramView)) && (!this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f())) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f();
    }
  }
  
  public void b(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam == null) {
      return;
    }
    a(paramMultiCardCustomViewDelegate);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator == null))
    {
      a(null);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    Object localObject3;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131559265, paramViewGroup, false);
        localObject1 = localView;
        Object localObject2 = localView;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          localObject1 = localView;
          localObject2 = localView;
          if (((MultiCardContainer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Boolean)
          {
            localObject1 = localView;
            localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
            localObject1 = localView;
            ((FrameLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(20.0F, getResources());
            localObject1 = localView;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = localView;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MultiCardFragment", 1, "onCreateView: ", localThrowable);
        GC.a();
        localObject3 = localObject1;
      }
      localObject1 = localObject3;
    } while (localObject3 == null);
    a(localObject3, paramBundle);
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append(System.identityHashCode(this));
      paramLayoutInflater.append(" onCreateView() cost = ");
      paramLayoutInflater.append(SystemClock.elapsedRealtime() - l);
      paramLayoutInflater.append(" ms");
      QLog.d("MultiCardFragment", 2, paramLayoutInflater.toString());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localObject3);
    return localObject3;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroy");
    }
    e();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroyView");
    }
    Object localObject = a(getBaseActivity());
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptScrollLRFlag(true);
    }
    c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).d();
    }
    e();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MultiAIOViewPager localMultiAIOViewPager = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
    if (localMultiAIOViewPager != null) {
      localMultiAIOViewPager.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment
 * JD-Core Version:    0.7.0.1
 */