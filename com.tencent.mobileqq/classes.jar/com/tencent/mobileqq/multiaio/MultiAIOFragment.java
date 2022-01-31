package com.tencent.mobileqq.multiaio;

import aciy;
import ahcq;
import ajjy;
import ajmu;
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
import arsr;
import arss;
import arst;
import arsu;
import arsv;
import arsw;
import arsx;
import arsy;
import arsz;
import arta;
import artb;
import artc;
import artd;
import arte;
import artf;
import artg;
import artr;
import arts;
import artt;
import artu;
import artw;
import arui;
import arum;
import arvc;
import arvd;
import awqx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;

public class MultiAIOFragment
  extends PublicBaseFragment
  implements artw, arvc, BusinessObserver
{
  private int jdField_a_of_type_Int;
  private ajmu jdField_a_of_type_Ajmu = new arsx(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
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
    paramView = ((ChatXListView)paramView.findViewById(2131303604)).getAdapter();
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
      if (SplashActivity.a == null) {
        break label332;
      }
      paramContext = (Activity)SplashActivity.a.get();
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
        ahcq.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, null);
        a(paramBitmap, paramArrayOfInt);
        return;
      }
      Intent[] arrayOfIntent = new Intent[1];
      ahcq.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, arrayOfIntent);
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
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new arsv(this, localImageView, m, k, n, i, i1, j, i2 - n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new arsw(this));
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
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator = ((TabPageIndicator)paramView.findViewById(2131302461));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131313312));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(3);
    paramBundle = getResources();
    int i = (int)((paramBundle.getDisplayMetrics().widthPixels - aciy.a(42.0F, paramBundle) * 2) * (1.0F - arvd.a) * 0.5F);
    int j = aciy.a(2.0F, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(j + i));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new arvd());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new arsy(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnClickListener(new arsz(this));
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
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new arta(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new artb(this));
    Object localObject = new artc(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnPageChangeListener((arui)localObject);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnTabClickListener(new artd(this));
    ((arum)localObject).b(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(new arte(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnActionUpNotFling(new artf(this));
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
    awqx.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.findViewById(2131302566);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ajmu);
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
    int n = getResources().getDimensionPixelSize(2131165253);
    int i2 = getResources().getDimensionPixelSize(2131165253);
    int i1 = getResources().getDimensionPixelOffset(2131165254);
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
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new arst(this, localImageView, i, n, j, i1, k, i2, i3, m));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new arsu(this, localImageView));
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
    this.jdField_c_of_type_AndroidViewView = localFragmentActivity.getLayoutInflater().inflate(2131495053, localViewGroup, false);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131298030).setOnClickListener(new arsr(this));
    this.jdField_c_of_type_AndroidViewView.findViewById(2131297908).setOnClickListener(new arss(this));
    ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312583)).setText(ajjy.a(2131641203) + artu.jdField_a_of_type_Int);
    d();
    localViewGroup.addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void d()
  {
    float f = artu.jdField_a_of_type_Int * 1.0F / 20.0F;
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
  
  public arts a()
  {
    return ((artr)getActivity().app.getManager(325)).b(this.jdField_b_of_type_Int);
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
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public ListView a()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return (ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303604);
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
    //   7: ldc_w 857
    //   10: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 860	android/view/View:getTag	()Ljava/lang/Object;
    //   18: checkcast 862	java/lang/Integer
    //   21: invokevirtual 865	java/lang/Integer:intValue	()I
    //   24: istore_3
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 867	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   31: istore 5
    //   33: aload_1
    //   34: ldc_w 868
    //   37: invokevirtual 110	android/view/View:findViewById	(I)Landroid/view/View;
    //   40: astore 6
    //   42: aload_1
    //   43: invokevirtual 871	android/view/View:destroyDrawingCache	()V
    //   46: aload_1
    //   47: iconst_1
    //   48: invokevirtual 874	android/view/View:setDrawingCacheEnabled	(Z)V
    //   51: aload 6
    //   53: ifnull +10 -> 63
    //   56: aload 6
    //   58: bipush 8
    //   60: invokevirtual 875	android/view/View:setVisibility	(I)V
    //   63: aload_1
    //   64: invokevirtual 878	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   67: astore 7
    //   69: aload 7
    //   71: aload 7
    //   73: invokevirtual 364	android/graphics/Bitmap:getWidth	()I
    //   76: i2f
    //   77: aload_1
    //   78: invokevirtual 881	android/view/View:getScaleX	()F
    //   81: fmul
    //   82: f2i
    //   83: aload 7
    //   85: invokevirtual 367	android/graphics/Bitmap:getHeight	()I
    //   88: i2f
    //   89: aload_1
    //   90: invokevirtual 884	android/view/View:getScaleY	()F
    //   93: fmul
    //   94: f2i
    //   95: iconst_1
    //   96: invokestatic 888	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   99: astore 7
    //   101: iconst_2
    //   102: newarray int
    //   104: astore 8
    //   106: aload_1
    //   107: aload 8
    //   109: invokevirtual 693	android/view/View:getLocationOnScreen	([I)V
    //   112: aload_0
    //   113: aload_1
    //   114: invokespecial 890	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/view/View;)I
    //   117: istore 4
    //   119: aload_0
    //   120: aload_1
    //   121: putfield 850	com/tencent/mobileqq/multiaio/MultiAIOFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   124: aload_0
    //   125: aload_1
    //   126: invokevirtual 891	android/view/View:getContext	()Landroid/content/Context;
    //   129: aload_1
    //   130: iload_3
    //   131: aload_0
    //   132: getfield 564	com/tencent/mobileqq/multiaio/MultiAIOFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   135: iload_3
    //   136: invokeinterface 841 2 0
    //   141: checkcast 320	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   144: iload 5
    //   146: aload 7
    //   148: aload 8
    //   150: iload 4
    //   152: invokespecial 893	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mobileqq/activity/recent/RecentBaseData;ZLandroid/graphics/Bitmap;[II)V
    //   155: iload 5
    //   157: ifeq +33 -> 190
    //   160: iconst_2
    //   161: istore_3
    //   162: ldc_w 895
    //   165: iload_3
    //   166: invokestatic 897	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Ljava/lang/String;I)V
    //   169: aload 6
    //   171: ifnull +9 -> 180
    //   174: aload 6
    //   176: iconst_0
    //   177: invokevirtual 875	android/view/View:setVisibility	(I)V
    //   180: aload_1
    //   181: iconst_0
    //   182: invokevirtual 874	android/view/View:setDrawingCacheEnabled	(Z)V
    //   185: aload_1
    //   186: invokevirtual 871	android/view/View:destroyDrawingCache	()V
    //   189: return
    //   190: iconst_1
    //   191: istore_3
    //   192: goto -30 -> 162
    //   195: astore 7
    //   197: ldc 76
    //   199: iconst_1
    //   200: iconst_2
    //   201: anewarray 899	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc_w 901
    //   209: aastore
    //   210: dup
    //   211: iconst_1
    //   212: aload_2
    //   213: aastore
    //   214: invokestatic 904	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: invokestatic 908	artt:a	()V
    //   220: aload 6
    //   222: ifnull +9 -> 231
    //   225: aload 6
    //   227: iconst_0
    //   228: invokevirtual 875	android/view/View:setVisibility	(I)V
    //   231: aload_1
    //   232: iconst_0
    //   233: invokevirtual 874	android/view/View:setDrawingCacheEnabled	(Z)V
    //   236: aload_1
    //   237: invokevirtual 871	android/view/View:destroyDrawingCache	()V
    //   240: return
    //   241: astore_2
    //   242: aload 6
    //   244: ifnull +9 -> 253
    //   247: aload 6
    //   249: iconst_0
    //   250: invokevirtual 875	android/view/View:setVisibility	(I)V
    //   253: aload_1
    //   254: iconst_0
    //   255: invokevirtual 874	android/view/View:setDrawingCacheEnabled	(Z)V
    //   258: aload_1
    //   259: invokevirtual 871	android/view/View:destroyDrawingCache	()V
    //   262: aload_2
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	MultiAIOFragment
    //   0	264	1	paramView	View
    //   0	264	2	paramMotionEvent	MotionEvent
    //   24	168	3	i	int
    //   117	34	4	j	int
    //   31	125	5	bool	boolean
    //   40	208	6	localView	View
    //   67	80	7	localBitmap	Bitmap
    //   195	1	7	localThrowable	Throwable
    //   104	45	8	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   42	51	195	java/lang/Throwable
    //   56	63	195	java/lang/Throwable
    //   63	155	195	java/lang/Throwable
    //   162	169	195	java/lang/Throwable
    //   42	51	241	finally
    //   56	63	241	finally
    //   63	155	241	finally
    //   162	169	241	finally
    //   197	220	241	finally
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
    for (int i = 2130771994;; i = 0)
    {
      paramActivity.overridePendingTransition(i, 0);
      return;
    }
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
    arts localarts2 = a();
    arts localarts1 = localarts2;
    if (localarts2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], multiAioContext == null");
      }
      localarts1 = arts.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_Int = localarts1.a();
    }
    localarts1.a(this);
    this.jdField_a_of_type_JavaUtilList = localarts1.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
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
        localView = paramLayoutInflater.inflate(2131495054, paramViewGroup, false);
        localObject1 = localView;
      } while (localView == null);
      a(localView, paramBundle);
      b();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, System.identityHashCode(this) + " onCreateView() cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      }
      return localView;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MultiAioFragment", 1, "onCreateView: ", localThrowable);
        artt.a();
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
      artg.a();
      ((artr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(325)).a(this.jdField_b_of_type_Int);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    }
    artn.jdField_a_of_type_Boolean = false;
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
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24) && (getActivity() != null)) {
      getActivity().finish();
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
      paramBundle = localView.findViewById(2131304855);
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
    if (artu.jdField_a_of_type_Boolean) {}
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment
 * JD-Core Version:    0.7.0.1
 */