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
  private int a = 0;
  private QQAppInterface b;
  private MultiAIOViewPager c;
  private MultiCardPagerAdapter d;
  private MultiCardPageIndicator e;
  private MultiCardContext f;
  private ValueAnimator g;
  private ValueAnimator h;
  private View i;
  private MultiCardFragment.ZoomParam j;
  private Handler k = new Handler(Looper.getMainLooper());
  private MultiCardFragment.MultiCardShowArrow l = new MultiCardFragment.MultiCardShowArrow(this, null);
  private WeakReference<MultiCardContainer> m;
  private boolean n;
  private int o = 0;
  private MultiCardFragment.ReportRunnable p = new MultiCardFragment.ReportRunnable();
  private int q = -1;
  
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
  
  private TopGestureLayout a(Activity paramActivity)
  {
    paramActivity = (FrameLayout)paramActivity.getWindow().getDecorView();
    int i1 = 0;
    while (i1 < paramActivity.getChildCount())
    {
      View localView = paramActivity.getChildAt(i1);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.e = ((MultiCardPageIndicator)paramView.findViewById(2131435686));
    paramBundle = this.e;
    if (paramBundle != null)
    {
      paramBundle.a(this.b, getBaseActivity());
      this.e.setMultiCardContext(this.f);
    }
    this.c = ((MultiAIOViewPager)paramView.findViewById(2131449793));
    paramView = this.c;
    if (paramView != null) {
      paramView.setOffscreenPageLimit(3);
    }
    paramView = getResources();
    int i1 = (int)((paramView.getDisplayMetrics().widthPixels - AIOUtils.b(42.0F, paramView) * 2) * (1.0F - ZoomOutPageTransformer.a) * 0.5F);
    int i2 = AIOUtils.b(2.0F, paramView);
    paramView = this.c;
    if (paramView != null)
    {
      paramView.setPageMargin(-(i1 + i2));
      this.c.setPageTransformer(false, new ZoomOutPageTransformer());
      this.c.setOnClickListener(new MultiCardFragment.2(this));
      this.c.setTouchEventConsumer(this);
    }
    paramView = this.e;
    if (paramView != null)
    {
      paramView.setOnClickListener(new MultiCardFragment.3(this));
      this.e.setTouchEventConsumer(this);
    }
    this.d = new MultiCardPagerAdapter(getChildFragmentManager());
    this.d.a(this.f);
    paramView = this.c;
    if (paramView != null) {
      paramView.setAdapter(this.d);
    }
    paramView = this.e;
    if (paramView != null) {
      paramView.setViewPager(this.c);
    }
    paramView = this.c;
    if (paramView != null)
    {
      paramView.setActTAG("MultiWindowCardFPS");
      this.c.setIdleListener(new MultiCardFragment.4(this));
      this.c.setFlingListener(new MultiCardFragment.5(this));
    }
    paramView = new MultiCardFragment.6(this);
    paramBundle = this.e;
    if (paramBundle != null)
    {
      paramBundle.setOnPageChangeListener(paramView);
      this.e.setOnTabClickListener(new MultiCardFragment.7(this));
    }
    paramView.b(0);
    paramView = this.e;
    if (paramView != null)
    {
      paramView.a(new MultiCardFragment.8(this));
      this.e.setOnActionUpNotFling(new MultiCardFragment.9(this));
      this.e.setOverScrollMode(2);
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
    if (paramZoomParam.g != null) {
      paramZoomParam.g.j();
    }
    float f5 = paramZoomParam.f.getWidth();
    float f1 = paramZoomParam.f.getHeight();
    float f3 = f5 / 2.0F;
    float f2 = f1 / 2.0F;
    this.j.f.setPivotX(f3);
    this.j.f.setPivotY(f2);
    f3 = paramZoomParam.b;
    paramZoomParam.e.getWidth();
    int i1 = paramZoomParam.h;
    f3 = paramZoomParam.c * paramZoomParam.e.getHeight() / 2.0F;
    float f4 = paramZoomParam.i;
    f5 = paramZoomParam.b * paramZoomParam.e.getWidth() / f5;
    float f6 = paramZoomParam.c * paramZoomParam.e.getHeight() / f1;
    float f7 = (1.0F - f6 / f5) * f1 * f5 / 2.0F;
    this.h = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.h.setDuration(400L);
    this.h.addUpdateListener(new MultiCardFragment.12(this, paramZoomParam, f5, f2 - (f3 + f4) - f7, f1, f6));
    this.h.addListener(new MultiCardFragment.13(this));
    this.h.start();
    paramZoomParam = this.c;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = this.e;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.m;
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
  
  private void b(MultiCardFragment.ZoomParam paramZoomParam)
  {
    if (paramZoomParam == null) {
      return;
    }
    if (paramZoomParam.g != null) {
      paramZoomParam.g.i();
    }
    Object localObject = (ViewGroup)paramZoomParam.f.getParent();
    float f1 = ((ViewGroup)localObject).getHeight();
    float f4 = paramZoomParam.c;
    float f5 = paramZoomParam.e.getHeight();
    float f2 = paramZoomParam.b * paramZoomParam.f.getWidth() / ((ViewGroup)localObject).getWidth();
    float f3 = paramZoomParam.c * paramZoomParam.f.getHeight() / ((ViewGroup)localObject).getHeight();
    f4 = paramZoomParam.i + (int)(f4 * f5) / 2;
    f5 = ((ViewGroup)localObject).getWidth() / 2;
    float f6 = ((ViewGroup)localObject).getHeight() / 2;
    float f7 = (1.0F - f3 / f2) * f1 * f2 / 2.0F;
    this.j.f.setPivotX(f5);
    this.j.f.setPivotY(f6);
    this.g = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.g.setDuration(400L);
    this.g.addUpdateListener(new MultiCardFragment.14(this, paramZoomParam, f2, f4 - f6 + f7, f1, f3));
    this.g.addListener(new MultiCardFragment.15(this));
    this.g.start();
    paramZoomParam = this.c;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = this.e;
    if (paramZoomParam != null) {
      paramZoomParam.setVisibility(0);
    }
    paramZoomParam = new AlphaAnimation(1.0F, 0.0F);
    paramZoomParam.setDuration(400L);
    localObject = this.c;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).startAnimation(paramZoomParam);
    }
    localObject = this.e;
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
      localObject = this.c;
      if ((localObject != null) && (this.q != ((MultiAIOViewPager)localObject).getCurrentItem()))
      {
        this.q = this.c.getCurrentItem();
        localObject = this.e;
        if (localObject != null) {
          ((MultiCardPageIndicator)localObject).d();
        }
      }
    }
    else
    {
      localObject = this.e;
      if (localObject != null) {
        ((MultiCardPageIndicator)localObject).d();
      }
    }
    this.k.removeCallbacks(this.l);
  }
  
  private boolean b(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkPreLoadData, nPos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" requestPos:");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(" preloadcountL");
      ((StringBuilder)localObject1).append(this.o);
      QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.o == 0) {
      return false;
    }
    if (paramInt == -1) {}
    try
    {
      this.a = 0;
      if (this.o + paramInt < this.a) {
        return false;
      }
      do
      {
        if ((this.f != null) && (this.f.b() > this.a))
        {
          if (this.m != null)
          {
            localObject1 = (MultiCardContainer)this.m.get();
            if (localObject1 != null)
            {
              ArrayList localArrayList = this.f.a(this.a, this.o);
              if ((localArrayList != null) && (localArrayList.size() > 0))
              {
                ((MultiCardContainer)localObject1).a(localArrayList, true, true);
                this.a += localArrayList.size();
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkPreLoadData, end, requestPos:");
            ((StringBuilder)localObject1).append(this.a);
            QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
      } while (this.a < paramInt);
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
    if (paramBoolean)
    {
      Object localObject1 = this.f;
      if (localObject1 != null)
      {
        Object localObject3 = this.c;
        if (localObject3 == null) {
          return;
        }
        CardContent localCardContent = ((MultiCardContext)localObject1).b(((MultiAIOViewPager)localObject3).getCurrentItem());
        if (localCardContent == null) {
          return;
        }
        localObject3 = this.f.a(localCardContent.c());
        localObject1 = localObject3;
        Object localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = localCardContent.c();
          localObject1 = localObject3;
          try
          {
            if (this.m != null)
            {
              localObject4 = (MultiCardContainer)this.m.get();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                localObject1 = new ArrayList();
                ((ArrayList)localObject1).add(Long.valueOf(localCardContent.c()));
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
            ((StringBuilder)localObject4).append(localCardContent.c());
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
    float f1 = VelocityUtil.a * 1.0F / 20.0F;
    Object localObject = this.c;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).c(f1);
    }
    localObject = this.e;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).a(f1);
    }
  }
  
  private void e()
  {
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).removeView(this.i);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "scheduleShowArrow() ");
    }
    b(false);
    this.k.postDelayed(this.l, 100L);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "unInit");
    }
    this.k.removeCallbacksAndMessages(null);
    Object localObject = this.g;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.g.cancel();
      this.g = null;
    }
    localObject = this.h;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      this.h.cancel();
      this.h = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((MultiCardPagerAdapter)localObject).a(null);
      this.d = null;
    }
    if (this.f != null) {
      this.f = null;
    }
    this.m = null;
    this.b = null;
    this.e = null;
    MultiCardItemFragment.a.b();
    for (localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.c.a(); localObject != null; localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.c.a()) {
      ((MultiCardCustomViewDelegate)localObject).a();
    }
    MultiCardItemFragment.c.b();
    for (localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.b.a(); localObject != null; localObject = (MultiCardCustomViewDelegate)MultiCardItemFragment.b.a()) {
      ((MultiCardCustomViewDelegate)localObject).a();
    }
    MultiCardItemFragment.b.b();
    for (localObject = (View)MultiCardItemFragment.d.a(); localObject != null; localObject = (View)MultiCardItemFragment.d.a()) {}
    MultiCardItemFragment.d.b();
  }
  
  private ViewGroup h()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        return (ViewGroup)((MultiCardContainer)localObject).b();
      }
    }
    return null;
  }
  
  private void i()
  {
    if (this.j != null)
    {
      ViewGroup localViewGroup = h();
      if ((localViewGroup != null) && (this.j.f != null))
      {
        this.j.f.setScaleX(1.0F);
        this.j.f.setScaleY(1.0F);
        this.j.f.setTranslationX(0.0F);
        this.j.f.setTranslationY(0.0F);
        localViewGroup.removeView(this.j.f);
      }
      this.j.b();
      this.j = null;
    }
    this.h = null;
  }
  
  private void j()
  {
    this.g = null;
    Object localObject = this.j;
    if (localObject != null)
    {
      ((MultiCardFragment.ZoomParam)localObject).f.setScaleX(1.0F);
      this.j.f.setScaleY(1.0F);
      this.j.f.setTranslationX(0.0F);
      this.j.f.setTranslationY(0.0F);
    }
    localObject = this.e;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).setVisibility(8);
    }
    localObject = this.c;
    if (localObject != null) {
      ((MultiAIOViewPager)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if ((!b(paramInt)) && (this.f != null))
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        localObject = (MultiCardContainer)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ArrayList localArrayList = this.f.a(paramInt, 1);
          if ((localArrayList != null) && (localArrayList.size() > 0)) {
            ((MultiCardContainer)localObject).a(localArrayList, true, true);
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MultiCardContainer paramMultiCardContainer)
  {
    this.b = paramQQAppInterface;
    this.f = MultiCardContext.a(paramQQAppInterface, String.valueOf(paramString));
    this.m = new WeakReference(paramMultiCardContainer);
    this.o = GroupIntimateRelationshipConfProcessor.a().b;
    if (this.o < 0) {
      this.o = 0;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init, preload count:");
      paramQQAppInterface.append(this.o);
      QLog.d("MultiCardFragment", 2, paramQQAppInterface.toString());
    }
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    if (this.g == null)
    {
      if (this.h != null) {
        return;
      }
      a(this.j);
    }
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    a("0X800A214", 1);
    if ((paramMultiCardCustomViewDelegate instanceof StrangerIntimateViewDelegate)) {
      a("0X800A217", 1);
    } else if ((paramMultiCardCustomViewDelegate instanceof IntimateInfoViewDelegate)) {
      if ((paramMultiCardCustomViewDelegate != null) && (paramMultiCardCustomViewDelegate.e != null) && (paramMultiCardCustomViewDelegate.e.e())) {
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
    if (this.h == null)
    {
      if (this.g != null) {
        return;
      }
      if (this.j != null) {
        return;
      }
      this.j = new MultiCardFragment.ZoomParam(this, paramMultiCardRootLayout, paramMultiCardCustomLayout, paramMultiCardCustomViewDelegate, this);
      this.j.a();
      paramMultiCardRootLayout = h();
      if (paramMultiCardRootLayout != null) {
        paramMultiCardRootLayout.addView(paramMultiCardCustomLayout, new RelativeLayout.LayoutParams(-1, -1));
      }
      b(this.j);
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
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        return ((MultiCardContainer)localObject).h;
      }
    }
    return false;
  }
  
  public MultiAIOBaseViewPager b()
  {
    return this.c;
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() != 0) {
      return;
    }
    paramMotionEvent = this.e;
    if ((paramMotionEvent != null) && (this.c != null) && (paramMotionEvent.equals(paramView)) && (!this.c.k())) {
      this.c.l();
    }
  }
  
  public void b(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    if (this.j == null) {
      return;
    }
    a(paramMultiCardCustomViewDelegate);
  }
  
  public void c()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = (MultiCardContainer)((WeakReference)localObject).get();
      if (localObject != null) {
        ((MultiCardContainer)localObject).g();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.g;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    localValueAnimator = this.h;
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
    if ((this.j != null) && (this.h == null))
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
    long l1 = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    Object localObject3;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131625186, paramViewGroup, false);
        localObject1 = localView;
        Object localObject2 = localView;
        if (this.m.get() != null)
        {
          localObject1 = localView;
          localObject2 = localView;
          if (((MultiCardContainer)this.m.get()).h)
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
      paramLayoutInflater.append(SystemClock.elapsedRealtime() - l1);
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
    g();
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
    e();
    localObject = this.e;
    if (localObject != null) {
      ((MultiCardPageIndicator)localObject).e();
    }
    g();
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
      c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MultiAIOViewPager localMultiAIOViewPager = this.c;
    if (localMultiAIOViewPager != null) {
      localMultiAIOViewPager.m();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment
 * JD-Core Version:    0.7.0.1
 */