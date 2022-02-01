package com.tencent.mobileqq.multiaio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniPie;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;

public class MultiAIOItemFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private MiniPie jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
  private MultiAIOBaseViewPager.SimpleOnPageChangeListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$SimpleOnPageChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  @Nullable
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    MultiAioContext localMultiAioContext = a();
    if (localMultiAioContext == null)
    {
      getBaseActivity().finish();
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie = localMultiAioContext.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie == null)
    {
      getBaseActivity().finish();
      return null;
    }
    if (paramBundle == null) {
      getUserVisibleHint();
    }
    paramBundle = localMultiAioContext.a(this.jdField_a_of_type_Int);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a(paramLayoutInflater, paramBundle, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a();
    this.jdField_a_of_type_Boolean = true;
    if (paramLayoutInflater == null)
    {
      getBaseActivity().finish();
      return null;
    }
    paramViewGroup = new FrameLayout(getBaseActivity());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.addView(paramLayoutInflater);
    return paramViewGroup;
  }
  
  private RecentBaseData a(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a(paramInt);
    }
    return null;
  }
  
  private MultiAioContext a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  private MultiAIOBaseViewPager a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  private void a()
  {
    ListView localListView = (ListView)getView().findViewById(2131370119);
    Object localObject = localListView.getOnScrollListener();
    localListView.setOnScrollListener(new MultiAIOItemFragment.4(this, (AbsListView.OnScrollListener)localObject));
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = a();
    if (localMultiAIOBaseViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$SimpleOnPageChangeListener = new MultiAIOItemFragment.5(this, (AbsListView.OnScrollListener)localObject, localListView);
      localMultiAIOBaseViewPager.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$SimpleOnPageChangeListener);
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie != null) && ((localListView instanceof ChatXListView)))
    {
      localObject = b();
      if ((localObject != null) && (localObject.length == 2) && (localObject[0] >= 0))
      {
        localListView.post(new MultiAIOItemFragment.6(this, localListView, (int[])localObject));
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.b(true);
        localListView.postDelayed(new MultiAIOItemFragment.7(this), 500L);
      }
      localListView.addOnLayoutChangeListener(new MultiAIOItemFragment.8(this, localListView));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      ((MultiAIOFragment)localFragment).a(paramInt1, paramInt2);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("KEY_POSITION");
    }
    paramBundle = a(getBaseActivity());
    Object localObject = a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.e("MultiAIOItemFragment", 1, "initData: recentBaseData == null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((RecentBaseData)localObject).getRecentUserUin();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = ((RecentBaseData)localObject).getRecentUserType();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((RecentBaseData)localObject).getTitleName();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = paramBundle.getIntExtra("key_mini_from", 0);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    paramBundle.jdField_b_of_type_JavaLangString = paramBundle.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850373);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131165321);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getBaseActivity());
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putBoolean("KEY_DELAY_SET_READ", isVisible() ^ true);
    paramBundle.putBoolean("KEY_IS_IN_MULTI_AIO", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(paramBundle);
  }
  
  private void a(View paramView)
  {
    FitSystemWindowsRelativeLayout localFitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout)paramView.findViewById(2131362288);
    if (localFitSystemWindowsRelativeLayout == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "initAIORootView() afRoot == null");
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramView.getContext(), new MultiAIOItemFragment.1(this), new Handler(Looper.getMainLooper()));
    localFitSystemWindowsRelativeLayout.setDispatchTouchEventListener(new MultiAIOItemFragment.2(this));
    localFitSystemWindowsRelativeLayout.setOnInterceptTouchEventListener(new MultiAIOItemFragment.3(this));
    paramView = getParentFragment();
    if ((paramView != null) && ((paramView instanceof MultiAIOFragment)))
    {
      paramView = ((MultiAIOFragment)paramView).a();
      int i = paramView.getMeasuredWidth();
      int j = paramView.getPaddingLeft();
      int k = paramView.getPaddingRight();
      int m = paramView.getMeasuredHeight();
      int n = paramView.getPaddingTop();
      int i1 = paramView.getPaddingBottom();
      paramView = localFitSystemWindowsRelativeLayout.getLayoutParams();
      paramView.width = getResources().getDisplayMetrics().widthPixels;
      float f1 = (i - j - k) * 1.0F / paramView.width;
      paramView.height = ((int)((m - n - i1) * 1.0F / f1 + 0.5F));
      localFitSystemWindowsRelativeLayout.setPivotX(-1.0F);
      localFitSystemWindowsRelativeLayout.setPivotY(-1.0F);
      localFitSystemWindowsRelativeLayout.setScaleX(f1);
      localFitSystemWindowsRelativeLayout.setScaleY(f1);
    }
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      arrayOfInt = ((MultiAIOFragment)localFragment).b();
    }
    return arrayOfInt;
  }
  
  private int[] b()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return new int[0];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a(int paramInt)
  {
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null)
    {
      boolean bool;
      if (this.jdField_a_of_type_Int != paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localMiniPie.d(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.x();
    }
  }
  
  public void b(int paramInt)
  {
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if ((localMiniPie != null) && (paramInt == this.jdField_a_of_type_Int)) {
      localMiniPie.l();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.r();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate() called with: savedInstanceState = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("], ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getArguments();
    if (paramBundle == null) {
      paramBundle = (Bundle)localObject;
    }
    a(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onDestroy() called");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie == null) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.p();
      this.f = true;
      return;
    }
    catch (Exception localException)
    {
      label39:
      label48:
      break label39;
    }
    QLog.e("MultiAIOItemFragment", 2, "onDestroy() called Exception");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131362288);
      MultiAioContext localMultiAioContext = a();
      if (localMultiAioContext != null) {
        localMultiAioContext.a((View)localObject);
      }
    }
    localObject = a();
    if (localObject != null) {
      ((MultiAIOBaseViewPager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$SimpleOnPageChangeListener);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (paramIntent != null) {
      paramIntent.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() called ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if ((localObject != null) && (this.jdField_a_of_type_Boolean) && (this.b) && (this.c))
    {
      ((MiniPie)localObject).m();
      this.d = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie != null) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.k();
      this.c = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("KEY_POSITION", this.jdField_a_of_type_Int);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() called ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie != null) && (getUserVisibleHint()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.n();
      this.b = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onStop() called");
    }
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if ((localMiniPie != null) && (this.d))
    {
      localMiniPie.o();
      this.e = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCreated() called with: view = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("], mPosition = [");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], savedInstanceState = ");
      localStringBuilder.append(paramBundle);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    a(paramView);
    if ((paramView instanceof ViewGroup))
    {
      paramBundle = new View(getBaseActivity());
      paramBundle.setId(2131371609);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((ViewGroup)paramView).addView(paramBundle);
    }
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.c(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUserVisibleHint() called with: isVisibleToUser = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.setUserVisibleHint(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((MiniPie)localObject).d(false);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a(null, (View)localObject, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a();
        this.jdField_a_of_type_Boolean = true;
        a((View)localObject);
        a();
      }
      if (!this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.n();
        this.b = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.k();
      this.c = true;
      return;
    }
    ((MiniPie)localObject).d(true);
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (this.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.m();
      this.d = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment
 * JD-Core Version:    0.7.0.1
 */