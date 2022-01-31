package com.tencent.mobileqq.multicard;

import aepi;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
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
import aulh;
import auma;
import aumq;
import aumr;
import aums;
import aumu;
import aumv;
import aumw;
import aumy;
import auna;
import aunb;
import aunc;
import aund;
import aune;
import aunf;
import aung;
import aunh;
import auni;
import aunj;
import aunk;
import aunl;
import aunm;
import aunn;
import auoj;
import auos;
import azqs;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MultiCardFragment
  extends PublicBaseFragment
  implements aumq, auna
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private aumw jdField_a_of_type_Aumw;
  private aunn jdField_a_of_type_Aunn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiAIOViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  private MultiCardFragment.MultiCardShowArrow jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow = new MultiCardFragment.MultiCardShowArrow(this, null);
  private MultiCardFragment.ReportRunnable jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ReportRunnable = new MultiCardFragment.ReportRunnable();
  private MultiCardPageIndicator jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
  private MultiCardPagerAdapter jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter;
  private WeakReference<aumv> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private int c = -1;
  
  public MultiCardFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, System.identityHashCode(this) + " MultiCardFragment() called");
    }
  }
  
  private ViewGroup a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaumv != null) {
        return (ViewGroup)localaumv.a();
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
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = ((MultiCardPageIndicator)paramView.findViewById(2131368230));
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setMultiCardContext(this.jdField_a_of_type_Aumw);
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131379906));
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(3);
    }
    paramView = getResources();
    int i = (int)((paramView.getDisplayMetrics().widthPixels - aepi.a(42.0F, paramView) * 2) * (1.0F - aumr.jdField_a_of_type_Float) * 0.5F);
    int j = aepi.a(2.0F, paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(j + i));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new aumr());
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new aunf(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnClickListener(new aung(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setTouchEventConsumer(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = new MultiCardPagerAdapter(getChildFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter.a(this.jdField_a_of_type_Aumw);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setActTAG("MultiWindowCardFPS");
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new aunh(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new auni(this));
    }
    paramView = new aunj(this);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnPageChangeListener(paramView);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnTabClickListener(new aunk(this));
    }
    paramView.b(0);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.a(new aunl(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnActionUpNotFling(new aunm(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOverScrollMode(2);
    }
    paramView = a(getActivity());
    if (paramView != null) {
      paramView.setInterceptScrollLRFlag(false);
    }
  }
  
  private void a(aunn paramaunn)
  {
    if (paramaunn == null) {}
    do
    {
      return;
      if (paramaunn.jdField_a_of_type_Aumy != null) {
        paramaunn.jdField_a_of_type_Aumy.j();
      }
      float f3 = paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getWidth();
      float f1 = paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getHeight();
      float f4 = f3 / 2.0F;
      float f2 = f1 / 2.0F;
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotX(f4);
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotY(f2);
      f4 = paramaunn.jdField_a_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth() / 2.0F;
      f4 = paramaunn.jdField_b_of_type_Int;
      f4 = paramaunn.jdField_b_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / 2.0F;
      float f5 = paramaunn.c;
      f3 = paramaunn.jdField_a_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth() / f3;
      float f6 = paramaunn.jdField_b_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / f1;
      float f7 = (1.0F - f6 / f3) * f1 * f3 / 2.0F;
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aunb(this, paramaunn, f3, f2 - (f4 + f5) - f7, f1, f6));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new aunc(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaumv != null) {
        localaumv.a(paramString);
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    azqs.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "checkPreLoadData, nPos:" + paramInt + " requestPos:" + this.jdField_a_of_type_Int + " preloadcountL" + this.jdField_b_of_type_Int);
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
    }
    finally {}
    do
    {
      if ((this.jdField_a_of_type_Aumw != null) && (this.jdField_a_of_type_Aumw.a() > this.jdField_a_of_type_Int))
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localaumv != null)
          {
            ArrayList localArrayList = this.jdField_a_of_type_Aumw.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
            if ((localArrayList != null) && (localArrayList.size() > 0))
            {
              localaumv.a(localArrayList, true, true);
              this.jdField_a_of_type_Int += localArrayList.size();
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardFragment", 2, "checkPreLoadData, end, requestPos:" + this.jdField_a_of_type_Int);
        }
        return true;
      }
    } while (this.jdField_a_of_type_Int < paramInt);
    return false;
  }
  
  private void b()
  {
    ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b(aunn paramaunn)
  {
    if (paramaunn == null) {}
    do
    {
      return;
      if (paramaunn.jdField_a_of_type_Aumy != null) {
        paramaunn.jdField_a_of_type_Aumy.i();
      }
      ViewGroup localViewGroup = (ViewGroup)paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent();
      float f1 = localViewGroup.getHeight();
      float f4 = paramaunn.jdField_b_of_type_Float;
      float f5 = paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight();
      float f2 = paramaunn.jdField_a_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getWidth() / localViewGroup.getWidth();
      float f3 = paramaunn.jdField_b_of_type_Float * paramaunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getHeight() / localViewGroup.getHeight();
      int i = paramaunn.c;
      f4 = (int)(f4 * f5) / 2 + i;
      f5 = localViewGroup.getWidth() / 2;
      float f6 = localViewGroup.getHeight() / 2;
      float f7 = (1.0F - f3 / f2) * f1 * f2 / 2.0F;
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotX(f5);
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setPivotY(f6);
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aund(this, paramaunn, f2, f7 + (f4 - f6), f1, f3));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aune(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(0);
      }
      paramaunn = new AlphaAnimation(1.0F, 0.0F);
      paramaunn.setDuration(400L);
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramaunn);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.startAnimation(paramaunn);
  }
  
  private void b(boolean paramBoolean)
  {
    a(null);
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) && (this.c != this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.a()))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.a();
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
          this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.c();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.c();
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "scheduleShowArrow() ");
    }
    b(false);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow, 100L);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    aums localaums;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Aumw == null) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager == null)) {}
      do
      {
        return;
        localaums = this.jdField_a_of_type_Aumw.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.a());
      } while (localaums == null);
      Object localObject2 = this.jdField_a_of_type_Aumw.a(localaums.a());
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localaums.a();
      }
      try
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject2 = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject2 != null)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(Long.valueOf(localaums.a()));
            ((aumv)localObject2).a(localArrayList, true, true);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("MultiCardFragment", 2, "checkShowNickName exception:" + localException + "  " + localaums.a());
        }
      }
      a((String)localObject1);
      return;
    }
    a(null);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "unInit");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = null;
    }
    if (this.jdField_a_of_type_Aumw != null) {
      this.jdField_a_of_type_Aumw = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = null;
    MultiCardItemFragment.a.a();
    for (Object localObject = (aumy)MultiCardItemFragment.c.a(); localObject != null; localObject = (aumy)MultiCardItemFragment.c.a()) {
      ((aumy)localObject).a();
    }
    MultiCardItemFragment.c.a();
    for (localObject = (aumy)MultiCardItemFragment.b.a(); localObject != null; localObject = (aumy)MultiCardItemFragment.b.a()) {
      ((aumy)localObject).a();
    }
    MultiCardItemFragment.b.a();
    for (localObject = (View)MultiCardItemFragment.d.a(); localObject != null; localObject = (View)MultiCardItemFragment.d.a()) {}
    MultiCardItemFragment.d.a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Aunn != null)
    {
      ViewGroup localViewGroup = a();
      if ((localViewGroup != null) && (this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null))
      {
        this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
        this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
        this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationX(0.0F);
        this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationY(0.0F);
        localViewGroup.removeView(this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
      }
      this.jdField_a_of_type_Aunn.b();
      this.jdField_a_of_type_Aunn = null;
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    if (this.jdField_a_of_type_Aunn != null)
    {
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationX(0.0F);
      this.jdField_a_of_type_Aunn.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setTranslationY(0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(8);
    }
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaumv != null) {
        localaumv.a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((!a(paramInt)) && (this.jdField_a_of_type_Aumw != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaumv != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Aumw.a(paramInt, 1);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          localaumv.a(localArrayList, true, true);
        }
      }
    }
  }
  
  public void a(aumy paramaumy)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) || (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)) {
      return;
    }
    a(this.jdField_a_of_type_Aunn);
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, aumy paramaumy)
  {
    a("0X800A214", 1);
    if ((paramaumy instanceof auoj)) {
      a("0X800A217", 1);
    }
    do
    {
      while (paramMultiCardRootLayout == null)
      {
        QLog.e("MultiCardFragment", 1, "onClick: view == null, activity was destroyed ?");
        return;
        if ((paramaumy instanceof aumu)) {
          if ((paramaumy != null) && (paramaumy.a != null) && (paramaumy.a.a())) {
            a("0X800A217", 3);
          } else {
            a("0X800A217", 2);
          }
        }
      }
    } while ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) || (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) || (this.jdField_a_of_type_Aunn != null));
    this.jdField_a_of_type_Aunn = new aunn(this, paramMultiCardRootLayout, paramMultiCardCustomLayout, paramaumy, this);
    this.jdField_a_of_type_Aunn.a();
    paramMultiCardRootLayout = a();
    if (paramMultiCardRootLayout != null) {
      paramMultiCardRootLayout.addView(paramMultiCardCustomLayout, new RelativeLayout.LayoutParams(-1, -1));
    }
    b(this.jdField_a_of_type_Aunn);
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aumv localaumv = (aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaumv != null) {
        return localaumv.jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager == null) || (!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.equals(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f()));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f();
  }
  
  public void b(aumy paramaumy)
  {
    if (this.jdField_a_of_type_Aunn == null) {
      return;
    }
    a(paramaumy);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    while ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
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
    if ((this.jdField_a_of_type_Aunn != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator == null))
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
    localObject1 = null;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131559189, paramViewGroup, false);
        localObject2 = localView;
        localObject1 = localView;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          localObject2 = localView;
          localObject1 = localView;
          if (((aumv)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Boolean)
          {
            localObject1 = localView;
            localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
            localObject1 = localView;
            ((FrameLayout.LayoutParams)localObject2).topMargin = aepi.a(20.0F, getResources());
            localObject1 = localView;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = localView;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("MultiCardFragment", 1, "onCreateView: ", localThrowable);
          aulh.a();
          Object localObject3 = localObject1;
        }
      }
      localObject1 = localObject2;
    } while (localObject2 == null);
    a((View)localObject2, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, System.identityHashCode(this) + " onCreateView() cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
    }
    return localObject2;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroy");
    }
    d();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroyView");
    }
    TopGestureLayout localTopGestureLayout = a(getActivity());
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollLRFlag(true);
    }
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.d();
    }
    d();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = " + paramBoolean);
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment
 * JD-Core Version:    0.7.0.1
 */