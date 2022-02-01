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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, System.identityHashCode(this) + " MultiAIOFragment() called");
    }
  }
  
  private int a(View paramView)
  {
    int j = 0;
    paramView = ((ChatXListView)paramView.findViewById(2131370460)).getAdapter();
    int i = 0;
    if (i < paramView.getCount())
    {
      Object localObject = paramView.getItem(i);
      int k;
      if (localObject == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if ((localObject instanceof ChatMessage)) {
          k = j + 1;
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "scheduleUpdateMsgReadState() called with: position = [" + paramInt + "]");
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData = [" + paramRecentBaseData + "], showKeyBoard = [" + paramBoolean + "]");
    }
    paramContext = getActivity();
    if (paramContext == null)
    {
      QLog.e("MultiAioFragment", 1, "openAIO: activity == null 1");
      return;
    }
    paramView = paramContext.getIntent();
    RecentUser localRecentUser;
    Bundle localBundle;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      localRecentUser = ((RecentUserBaseData)paramRecentBaseData).a();
      localBundle = new Bundle();
      localBundle.putBoolean("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
      localBundle.putBoolean("open_chatfragment_withanim", false);
      localBundle.putInt("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", this.jdField_b_of_type_Int);
      localBundle.putBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", true);
      if (SplashActivity.sWeakInstance == null) {
        break label332;
      }
      paramContext = (Activity)SplashActivity.sWeakInstance.get();
    }
    label332:
    for (;;)
    {
      paramView = paramView.getStringExtra("OPEN_MULTI_FROM_ACTIVITY");
      paramBoolean = ChatActivity.class.getSimpleName().equals(paramView);
      if (paramBoolean)
      {
        localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        paramContext = null;
      }
      paramView = paramContext;
      if (paramContext == null) {
        paramView = getActivity();
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
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData is wrong type");
      return;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "tryToPlayEnterAnimation() called with: decorViewBitmap = [" + paramBitmap + "]");
      }
    } while (!"open_from_aio".equals(this.jdField_a_of_type_JavaLangString));
    b(paramBitmap);
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
    ((FrameLayout)getActivity().getWindow().getDecorView()).addView(localImageView);
    int n = ImmersiveUtils.getStatusBarHeight(getActivity());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getWidth();
    int i2 = localViewGroup.getHeight();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiAIOFragment.14(this, localImageView, m, k, n, i, i1, j, i2 - n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new MultiAIOFragment.15(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(1.0F, 0.0F);
    paramBitmap.setDuration(400);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
  }
  
  private void a(View paramView, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() called with: root = [" + paramView + "], blurBitmap = [" + paramBitmap + "]");
    }
    if (this.jdField_b_of_type_Boolean) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = paramView;
          if (paramView == null) {
            localView = getView();
          }
        } while (localView == null);
        if (paramBitmap != null) {
          break;
        }
        localView.setBackgroundColor(Color.parseColor("#7F000000"));
      } while (!QLog.isColorLevel());
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() setBackgroundColor");
      return;
      this.jdField_b_of_type_Boolean = true;
      paramView = getActivity();
    } while ((paramView == null) || (paramView.isFinishing()));
    paramView = new BitmapDrawable(paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() called with: root = [" + localView + "], blurBitmap = [" + paramBitmap + "]");
    }
    localView.setBackgroundDrawable(paramView);
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator = ((TabPageIndicator)paramView.findViewById(2131369046));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131381588));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(2);
    paramBundle = getResources();
    int i = (int)((paramBundle.getDisplayMetrics().widthPixels - AIOUtils.a(42.0F, paramBundle) * 2) * (1.0F - ZoomOutPageTransformer.a) * 0.5F);
    int j = AIOUtils.a(2.0F, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(j + i));
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
    paramBundle.a(getActivity().getLayoutInflater(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager, i);
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
    localObject = a(getActivity());
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt + "]");
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.findViewById(2131369141);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[0];
    int m = paramView.getWidth();
    int n = arrayOfInt[1];
    localRect.set(i, j, k + m, paramView.getHeight() + n);
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setMultiAIOUnreadListener(this.jdField_a_of_type_ComTencentMobileqqAppMultiAIOUnreadListener);
  }
  
  private void b(Bitmap paramBitmap)
  {
    FrameLayout localFrameLayout = (FrameLayout)getActivity().getWindow().getDecorView();
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    ImageView localImageView = new ImageView(getActivity());
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight());
    localMarginLayoutParams.leftMargin = 0;
    localMarginLayoutParams.topMargin = i;
    i = localMarginLayoutParams.leftMargin;
    int j = localMarginLayoutParams.topMargin;
    int k = localMarginLayoutParams.width;
    int m = localMarginLayoutParams.height;
    int n = getResources().getDimensionPixelSize(2131296438);
    int i2 = getResources().getDimensionPixelSize(2131296438);
    int i1 = getResources().getDimensionPixelOffset(2131296439);
    i2 = getResources().getDisplayMetrics().widthPixels - n - i2;
    int i3 = getResources().getDisplayMetrics().heightPixels - i1;
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "enterAnimation() called with: destinationWidth = [" + i2 + "], destinationHeight = [" + i3 + "]");
    }
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localFrameLayout.addView(localImageView);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MultiAIOFragment.12(this, localImageView, i, n, j, i1, k, i2, i3, m));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new MultiAIOFragment.13(this, localImageView));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(0.0F, 1.0F);
    paramBitmap.setDuration(400);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
  }
  
  private void c()
  {
    e();
    FragmentActivity localFragmentActivity = getActivity();
    ViewGroup localViewGroup = (ViewGroup)localFragmentActivity.getWindow().getDecorView();
    this.jdField_c_of_type_AndroidViewView = localFragmentActivity.getLayoutInflater().inflate(2131561076, localViewGroup, false);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131364045).setOnClickListener(new MultiAIOFragment.10(this));
    this.jdField_c_of_type_AndroidViewView.findViewById(2131363915).setOnClickListener(new MultiAIOFragment.11(this));
    ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380694)).setText(HardCodeUtil.a(2131707004) + VelocityUtil.jdField_a_of_type_Int);
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
    ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.jdField_c_of_type_AndroidViewView);
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
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localFragmentActivity.finish();
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
    return ((MultiAIOManager)getActivity().app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).b(this.jdField_b_of_type_Int);
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public ListView a()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return (ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370460);
    }
    return null;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_ArrayOfInt[0] = paramInt1;
    this.jdField_b_of_type_ArrayOfInt[1] = paramInt2;
  }
  
  /* Error */
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 76
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
    //   154: ifeq +31 -> 185
    //   157: iconst_2
    //   158: istore_3
    //   159: ldc_w 902
    //   162: iload_3
    //   163: invokestatic 904	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Ljava/lang/String;I)V
    //   166: aload_2
    //   167: ifnull +8 -> 175
    //   170: aload_2
    //   171: iconst_0
    //   172: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   175: aload_1
    //   176: iconst_0
    //   177: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   180: aload_1
    //   181: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   184: return
    //   185: iconst_1
    //   186: istore_3
    //   187: goto -28 -> 159
    //   190: astore 6
    //   192: ldc 76
    //   194: iconst_1
    //   195: ldc_w 906
    //   198: aload 6
    //   200: invokestatic 834	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: invokestatic 910	com/tencent/mobileqq/multiaio/utils/GC:a	()V
    //   206: aload_2
    //   207: ifnull +8 -> 215
    //   210: aload_2
    //   211: iconst_0
    //   212: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   215: aload_1
    //   216: iconst_0
    //   217: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   220: aload_1
    //   221: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   224: return
    //   225: astore 6
    //   227: aload_2
    //   228: ifnull +8 -> 236
    //   231: aload_2
    //   232: iconst_0
    //   233: invokevirtual 882	android/view/View:setVisibility	(I)V
    //   236: aload_1
    //   237: iconst_0
    //   238: invokevirtual 881	android/view/View:setDrawingCacheEnabled	(Z)V
    //   241: aload_1
    //   242: invokevirtual 878	android/view/View:destroyDrawingCache	()V
    //   245: aload 6
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	MultiAIOFragment
    //   0	248	1	paramView	View
    //   0	248	2	paramMotionEvent	MotionEvent
    //   24	163	3	i	int
    //   114	34	4	j	int
    //   31	122	5	bool	boolean
    //   64	80	6	localBitmap	Bitmap
    //   190	9	6	localThrowable	Throwable
    //   225	21	6	localObject	Object
    //   101	45	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   41	50	190	java/lang/Throwable
    //   54	60	190	java/lang/Throwable
    //   60	152	190	java/lang/Throwable
    //   159	166	190	java/lang/Throwable
    //   41	50	225	finally
    //   54	60	225	finally
    //   60	152	225	finally
    //   159	166	225	finally
    //   192	206	225	finally
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.equals(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f()));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.f();
  }
  
  public int[] b()
  {
    return this.jdField_b_of_type_ArrayOfInt;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    a(paramActivity);
    if (!"open_from_aio".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 2130771996;; i = 0)
    {
      paramActivity.overridePendingTransition(i, 0);
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onAttach() called with: activity = [" + paramActivity + "]");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    MultiAioContext localMultiAioContext2 = a();
    MultiAioContext localMultiAioContext1 = localMultiAioContext2;
    if (localMultiAioContext2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], multiAioContext == null");
      }
      localMultiAioContext1 = MultiAioContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_Int = localMultiAioContext1.a();
    }
    localMultiAioContext1.a(this);
    this.jdField_a_of_type_JavaUtilList = localMultiAioContext1.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    int i;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      i = 1;
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
      if (!"open_from_aio".equals(this.jdField_a_of_type_JavaLangString)) {
        break label210;
      }
      i = 1;
    }
    for (;;)
    {
      a("0X8009F7D", i);
      return;
      i = 0;
      break;
      label210:
      if ("conversation_tab_bottom".equals(this.jdField_a_of_type_JavaLangString)) {
        i = 2;
      } else if ("conversation_tab_list".equals(this.jdField_a_of_type_JavaLangString)) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    try
    {
      View localView;
      do
      {
        localView = paramLayoutInflater.inflate(2131561077, paramViewGroup, false);
        localObject1 = localView;
      } while (localView == null);
      a(localView, paramBundle);
      b();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, System.identityHashCode(this) + " onCreateView() cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MultiAioFragment", 1, "onCreateView: ", localThrowable);
        GC.a();
        Object localObject2 = localObject1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing()))
    {
      MultiAIOHelper.a();
      ((MultiAIOManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a(this.jdField_b_of_type_Int);
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setMultiAIOUnreadListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    }
    MultiAIOStarter.jdField_a_of_type_Boolean = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = a(getActivity());
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
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = " + paramBoolean);
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onReceive() called with: type = [" + paramInt + "], isSuccess = [" + paramBoolean + "]");
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      a((Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP"));
      return;
    } while (!paramBoolean);
    Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP_BLURED");
    View localView = getView();
    paramBundle = localView;
    if (localView != null) {
      paramBundle = localView.findViewById(2131371979);
    }
    a(paramBundle, localBitmap);
  }
  
  public void onResume()
  {
    super.onResume();
    SystemBarCompact localSystemBarCompact = getActivity().mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (VelocityUtil.jdField_a_of_type_Boolean) {}
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment
 * JD-Core Version:    0.7.0.1
 */