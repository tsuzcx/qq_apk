package com.tencent.mobileqq.multiaio;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MultiAIOUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.OnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.mobileqq.multiaio.widget.TouchEventConsumer;
import com.tencent.mobileqq.multiaio.widget.ZoomOutPageTransformer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;

public class MultiAIOFragment
  extends PublicBaseFragment
  implements MultiAioContainer, TouchEventConsumer, BusinessObserver
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private MultiAIOUnreadListener jdField_a_of_type_ComTencentMobileqqAppMultiAIOUnreadListener = new MultiAIOFragment.17(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiAIOFragment.MiniAIOScrollToNewMsg jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg = new MultiAIOFragment.MiniAIOScrollToNewMsg(this, null);
  private MultiAIOFragment.UpdateMsgReadTimer jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer = new MultiAIOFragment.UpdateMsgReadTimer(this, null);
  private MultiAIOPagerAdapter jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter;
  private MultiAIOViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  private TabPageIndicator jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator;
  private String jdField_a_of_type_JavaLangString;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public MultiAIOFragment()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.identityHashCode(this));
      localStringBuilder.append(" MultiAIOFragment() called");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
  }
  
  private int a(View paramView)
  {
    paramView = ((ChatXListView)paramView.findViewById(2131370119)).getAdapter();
    int i = 0;
    int k;
    for (int j = 0; i < paramView.getCount(); j = k)
    {
      Object localObject = paramView.getItem(i);
      if (localObject == null)
      {
        k = j;
      }
      else
      {
        k = j;
        if ((localObject instanceof ChatMessage)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
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
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleUpdateMsgReadState() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg, 100L);
  }
  
  private void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      this.jdField_a_of_type_JavaLangString = paramActivity.getStringExtra("conversation_tab_flag");
      this.jdField_b_of_type_JavaLangString = paramActivity.getStringExtra("uin");
      this.jdField_a_of_type_Int = paramActivity.getIntExtra("uintype", -1);
      this.jdField_c_of_type_JavaLangString = paramActivity.getStringExtra("uinname");
      this.jdField_b_of_type_Int = paramActivity.getIntExtra("OPEN_MULTI_AIO_CONTEXT", 0);
      this.jdField_a_of_type_ArrayOfInt = paramActivity.getIntArrayExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM");
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt1, RecentBaseData paramRecentBaseData, boolean paramBoolean, Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openAIO() called with: recentBaseData = [");
      paramContext.append(paramRecentBaseData);
      paramContext.append("], showKeyBoard = [");
      paramContext.append(paramBoolean);
      paramContext.append("]");
      QLog.d("MultiAioFragment", 2, paramContext.toString());
    }
    paramContext = getBaseActivity();
    if (paramContext == null)
    {
      QLog.e("MultiAioFragment", 1, "openAIO: activity == null 1");
      return;
    }
    paramView = paramContext.getIntent();
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUser localRecentUser = ((RecentUserBaseData)paramRecentBaseData).a();
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
      localBundle.putBoolean("open_chatfragment_withanim", false);
      localBundle.putInt("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", this.jdField_b_of_type_Int);
      localBundle.putBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", true);
      if (SplashActivity.sWeakInstance != null) {
        paramContext = (Activity)SplashActivity.sWeakInstance.get();
      }
      paramView = paramView.getStringExtra("OPEN_MULTI_FROM_ACTIVITY");
      paramBoolean = ChatActivity.class.getSimpleName().equals(paramView);
      if (paramBoolean)
      {
        localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        paramContext = null;
      }
      paramView = paramContext;
      if (paramContext == null) {
        paramView = getBaseActivity();
      }
      if (paramView == null)
      {
        QLog.e("MultiAioFragment", 1, "openAIO: activity == null 2");
        return;
      }
      paramContext = a();
      paramContext.a(true);
      paramContext.b(paramInt2);
      if (!paramBoolean)
      {
        RecentUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, null);
        a(paramBitmap, paramArrayOfInt);
        return;
      }
      Intent[] arrayOfIntent = new Intent[1];
      RecentUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, arrayOfIntent);
      paramContext.a(arrayOfIntent[0]);
      a(paramBitmap, paramArrayOfInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData is wrong type");
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryToPlayEnterAnimation() called with: decorViewBitmap = [");
        localStringBuilder.append(paramBitmap);
        localStringBuilder.append("]");
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
      if ("open_from_aio".equals(this.jdField_a_of_type_JavaLangString)) {
        b(paramBitmap);
      }
    }
  }
  
  private void a(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    ViewGroup localViewGroup = (ViewGroup)getView();
    ImageView localImageView = new ImageView(localViewGroup.getContext());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(i, j);
    localMarginLayoutParams.leftMargin = paramArrayOfInt[0];
    localMarginLayoutParams.topMargin = paramArrayOfInt[1];
    int k = localMarginLayoutParams.topMargin;
    int m = localMarginLayoutParams.leftMargin;
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).addView(localImageView);
    int n = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getWidth();
    int i2 = localViewGroup.getHeight();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramBitmap = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    long l = 400;
    paramBitmap.setDuration(l);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiAIOFragment.14(this, localImageView, m, k, n, i, i1, j, i2 - n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new MultiAIOFragment.15(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(1.0F, 0.0F);
    paramBitmap.setDuration(l);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
  }
  
  private void a(View paramView, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryToSetBlurBackground() called with: root = [");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append("], blurBitmap = [");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = getView();
    }
    if (localObject == null) {
      return;
    }
    if (paramBitmap == null)
    {
      ((View)localObject).setBackgroundColor(Color.parseColor("#7F000000"));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() setBackgroundColor");
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    paramView = getBaseActivity();
    if ((paramView != null) && (!paramView.isFinishing()))
    {
      paramView = new BitmapDrawable(paramBitmap);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryToSetBlurBackground() called with: root = [");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], blurBitmap = [");
        localStringBuilder.append(paramBitmap);
        localStringBuilder.append("]");
        QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
      }
      ((View)localObject).setBackgroundDrawable(paramView);
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator = ((TabPageIndicator)paramView.findViewById(2131368768));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131380822));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(2);
    paramBundle = getResources();
    int i = (int)((paramBundle.getDisplayMetrics().widthPixels - AIOUtils.b(42.0F, paramBundle) * 2) * (1.0F - ZoomOutPageTransformer.a) * 0.5F);
    int j = AIOUtils.b(2.0F, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(i + j));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new ZoomOutPageTransformer());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new MultiAIOFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnClickListener(new MultiAIOFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setTouchEventConsumer(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter = new MultiAIOPagerAdapter(getChildFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    paramBundle = a();
    j = this.jdField_a_of_type_JavaUtilList.size();
    i = j;
    if (j > 0) {
      i = 0;
    }
    paramBundle.a(getBaseActivity().getLayoutInflater(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager, i);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setActTAG("MultiWindowAIOFPS");
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new MultiAIOFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new MultiAIOFragment.5(this));
    Object localObject = new MultiAIOFragment.6(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnPageChangeListener((MultiAIOBaseViewPager.OnPageChangeListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnTabClickListener(new MultiAIOFragment.7(this));
    ((MultiAIOBaseViewPager.SimpleOnPageChangeListener)localObject).b(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(new MultiAIOFragment.8(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnActionUpNotFling(new MultiAIOFragment.9(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOverScrollMode(2);
    localObject = a(getBaseActivity());
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptScrollLRFlag(false);
    }
    localObject = paramBundle.b();
    paramBundle.b(null);
    a((Bitmap)localObject);
    a(paramView, paramBundle.c());
    paramBundle.c(null);
  }
  
  private void a(ImageView paramImageView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramImageView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramImageView);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], fromType = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.findViewById(2131368874);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setMultiAIOUnreadListener(this.jdField_a_of_type_ComTencentMobileqqAppMultiAIOUnreadListener);
  }
  
  private void b(Bitmap paramBitmap)
  {
    FrameLayout localFrameLayout = (FrameLayout)getBaseActivity().getWindow().getDecorView();
    int i = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    ImageView localImageView = new ImageView(getBaseActivity());
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight());
    localMarginLayoutParams.leftMargin = 0;
    localMarginLayoutParams.topMargin = i;
    i = localMarginLayoutParams.leftMargin;
    int j = localMarginLayoutParams.topMargin;
    int k = localMarginLayoutParams.width;
    int m = localMarginLayoutParams.height;
    int n = getResources().getDimensionPixelSize(2131296417);
    int i2 = getResources().getDimensionPixelSize(2131296417);
    int i1 = getResources().getDimensionPixelOffset(2131296418);
    i2 = getResources().getDisplayMetrics().widthPixels - n - i2;
    int i3 = getResources().getDisplayMetrics().heightPixels - i1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterAnimation() called with: destinationWidth = [");
      localStringBuilder.append(i2);
      localStringBuilder.append("], destinationHeight = [");
      localStringBuilder.append(i3);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localFrameLayout.addView(localImageView);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramBitmap = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    long l = 400;
    paramBitmap.setDuration(l);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiAIOFragment.12(this, localImageView, i, n, j, i1, k, i2, i3, m));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new MultiAIOFragment.13(this, localImageView));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(0.0F, 1.0F);
    paramBitmap.setDuration(l);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
  }
  
  private void c()
  {
    e();
    Object localObject = getBaseActivity();
    ViewGroup localViewGroup = (ViewGroup)((BaseActivity)localObject).getWindow().getDecorView();
    this.jdField_c_of_type_AndroidViewView = ((BaseActivity)localObject).getLayoutInflater().inflate(2131560940, localViewGroup, false);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131363970).setOnClickListener(new MultiAIOFragment.10(this));
    this.jdField_c_of_type_AndroidViewView.findViewById(2131363843).setOnClickListener(new MultiAIOFragment.11(this));
    localObject = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379968);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131707026));
    localStringBuilder.append(VelocityUtil.jdField_a_of_type_Int);
    ((TextView)localObject).setText(localStringBuilder.toString());
    d();
    localViewGroup.addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void d()
  {
    float f = VelocityUtil.jdField_a_of_type_Int * 1.0F / 20.0F;
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.b(f);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(f);
  }
  
  private void e()
  {
    ((FrameLayout)getBaseActivity().getWindow().getDecorView()).removeView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.c();
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MultiAIOFragment.16(this), 500L);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void h()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localBaseActivity.finish();
    }
  }
  
  public RecentBaseData a(int paramInt)
  {
    try
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return localRecentBaseData;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAioFragment", 1, "getData: ", localException);
      h();
    }
    return null;
  }
  
  public MultiAioContext a()
  {
    return ((MultiAIOManager)getBaseActivity().app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).b(this.jdField_b_of_type_Int);
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public ListView a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      return (ListView)localView.findViewById(2131370119);
    }
    return null;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
  }
  
  /* Error */
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 94
    //   6: iconst_1
    //   7: ldc_w 864
    //   10: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 867	android/view/View:getTag	()Ljava/lang/Object;
    //   18: checkcast 869	java/lang/Integer
    //   21: invokevirtual 872	java/lang/Integer:intValue	()I
    //   24: istore_3
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 874	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   31: istore 5
    //   33: aload_1
    //   34: ldc_w 875
    //   37: invokevirtual 110	android/view/View:findViewById	(I)Landroid/view/View;
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   45: aload_1
    //   46: iconst_1
    //   47: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   50: aload_2
    //   51: ifnull +9 -> 60
    //   54: aload_2
    //   55: bipush 8
    //   57: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   60: aload_1
    //   61: invokevirtual 885	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   64: astore 6
    //   66: aload 6
    //   68: aload 6
    //   70: invokevirtual 365	android/graphics/Bitmap:getWidth	()I
    //   73: i2f
    //   74: aload_1
    //   75: invokevirtual 888	android/view/View:getScaleX	()F
    //   78: fmul
    //   79: f2i
    //   80: aload 6
    //   82: invokevirtual 368	android/graphics/Bitmap:getHeight	()I
    //   85: i2f
    //   86: aload_1
    //   87: invokevirtual 891	android/view/View:getScaleY	()F
    //   90: fmul
    //   91: f2i
    //   92: iconst_1
    //   93: invokestatic 895	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   96: astore 6
    //   98: iconst_2
    //   99: newarray int
    //   101: astore 7
    //   103: aload_1
    //   104: aload 7
    //   106: invokevirtual 694	android/view/View:getLocationOnScreen	([I)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 897	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/view/View;)I
    //   114: istore 4
    //   116: aload_0
    //   117: aload_1
    //   118: putfield 857	com/tencent/mobileqq/multiaio/MultiAIOFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 898	android/view/View:getContext	()Landroid/content/Context;
    //   126: aload_1
    //   127: iload_3
    //   128: aload_0
    //   129: getfield 565	com/tencent/mobileqq/multiaio/MultiAIOFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   132: iload_3
    //   133: invokeinterface 829 2 0
    //   138: checkcast 321	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   141: iload 5
    //   143: aload 6
    //   145: aload 7
    //   147: iload 4
    //   149: invokespecial 900	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mobileqq/activity/recent/RecentBaseData;ZLandroid/graphics/Bitmap;[II)V
    //   152: iload 5
    //   154: ifeq +83 -> 237
    //   157: iconst_2
    //   158: istore_3
    //   159: goto +3 -> 162
    //   162: ldc_w 902
    //   165: iload_3
    //   166: invokestatic 904	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Ljava/lang/String;I)V
    //   169: aload_2
    //   170: ifnull +36 -> 206
    //   173: goto +28 -> 201
    //   176: astore 6
    //   178: goto +38 -> 216
    //   181: astore 6
    //   183: ldc 94
    //   185: iconst_1
    //   186: ldc_w 906
    //   189: aload 6
    //   191: invokestatic 834	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: invokestatic 910	com/tencent/mobileqq/multiaio/utils/GC:a	()V
    //   197: aload_2
    //   198: ifnull +8 -> 206
    //   201: aload_2
    //   202: iconst_0
    //   203: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   206: aload_1
    //   207: iconst_0
    //   208: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   211: aload_1
    //   212: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   215: return
    //   216: aload_2
    //   217: ifnull +8 -> 225
    //   220: aload_2
    //   221: iconst_0
    //   222: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   225: aload_1
    //   226: iconst_0
    //   227: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   230: aload_1
    //   231: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   234: aload 6
    //   236: athrow
    //   237: iconst_1
    //   238: istore_3
    //   239: goto -77 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	MultiAIOFragment
    //   0	242	1	paramView	View
    //   0	242	2	paramMotionEvent	MotionEvent
    //   24	215	3	i	int
    //   114	34	4	j	int
    //   31	122	5	bool	boolean
    //   64	80	6	localBitmap	Bitmap
    //   176	1	6	localObject	Object
    //   181	54	6	localThrowable	Throwable
    //   101	45	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   41	50	176	finally
    //   54	60	176	finally
    //   60	152	176	finally
    //   162	169	176	finally
    //   183	197	176	finally
    //   41	50	181	java/lang/Throwable
    //   54	60	181	java/lang/Throwable
    //   60	152	181	java/lang/Throwable
    //   162	169	181	java/lang/Throwable
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.equals(paramView)) && (!this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f())) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f();
    }
  }
  
  public int[] b()
  {
    return this.jdField_b_of_type_ArrayOfInt;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    a(paramActivity);
    int i;
    if (!"open_from_aio".equals(this.jdField_a_of_type_JavaLangString)) {
      i = 2130772008;
    } else {
      i = 0;
    }
    paramActivity.overridePendingTransition(i, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAttach() called with: activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    MultiAioContext localMultiAioContext = a();
    int j = 2;
    Object localObject = localMultiAioContext;
    if (localMultiAioContext == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCreate() called with: savedInstanceState = [");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append("], multiAioContext == null");
        QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
      }
      localObject = MultiAioContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_Int = ((MultiAioContext)localObject).a();
    }
    ((MultiAioContext)localObject).a(this);
    this.jdField_a_of_type_JavaUtilList = ((MultiAioContext)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState != null finish Activity");
      }
      i = 1;
    }
    if (i != 0) {
      h();
    }
    if ("open_from_aio".equals(this.jdField_a_of_type_JavaLangString)) {
      i = 1;
    } else if ("conversation_tab_bottom".equals(this.jdField_a_of_type_JavaLangString)) {
      i = j;
    } else if ("conversation_tab_list".equals(this.jdField_a_of_type_JavaLangString)) {
      i = 3;
    } else {
      i = 0;
    }
    a("0X8009F7D", i);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    Object localObject2;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131560941, paramViewGroup, false);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MultiAioFragment", 1, "onCreateView: ", localThrowable);
        GC.a();
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
    } while (localObject2 == null);
    a(localObject2, paramBundle);
    b();
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append(System.identityHashCode(this));
      paramLayoutInflater.append(" onCreateView() cost = ");
      paramLayoutInflater.append(SystemClock.elapsedRealtime() - l);
      paramLayoutInflater.append(" ms");
      QLog.d("MultiAioFragment", 2, paramLayoutInflater.toString());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localObject2);
    return localObject2;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = getBaseActivity();
    if ((localObject != null) && (((BaseActivity)localObject).isFinishing()))
    {
      MultiAIOHelper.a();
      ((MultiAIOManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a(this.jdField_b_of_type_Int);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).setMultiAIOUnreadListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    }
    MultiAIOStarter.jdField_a_of_type_Boolean = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = a(getBaseActivity());
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollLRFlag(true);
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.d();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      h();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.g();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive() called with: type = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isSuccess = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP_BLURED");
        localObject = getView();
        paramBundle = (Bundle)localObject;
        if (localObject != null) {
          paramBundle = ((View)localObject).findViewById(2131371586);
        }
        a(paramBundle, localBitmap);
      }
    }
    else if (paramBoolean)
    {
      a((Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP"));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SystemBarCompact localSystemBarCompact = getBaseActivity().mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    boolean bool = VelocityUtil.jdField_a_of_type_Boolean;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment
 * JD-Core Version:    0.7.0.1
 */