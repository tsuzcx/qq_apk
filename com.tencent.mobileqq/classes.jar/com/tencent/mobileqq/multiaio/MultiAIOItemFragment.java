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
  private SessionInfo a = new SessionInfo();
  private MiniPie b;
  private int c;
  private GestureDetector d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private MultiAIOBaseViewPager.SimpleOnPageChangeListener k;
  private ViewStub l;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  @Nullable
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    MultiAioContext localMultiAioContext = c();
    if (localMultiAioContext == null)
    {
      getBaseActivity().finish();
      return null;
    }
    this.b = localMultiAioContext.a(this);
    if (this.b == null)
    {
      getBaseActivity().finish();
      return null;
    }
    if (paramBundle == null) {
      getUserVisibleHint();
    }
    paramBundle = localMultiAioContext.a(this.c);
    paramLayoutInflater = this.b.a(paramLayoutInflater, paramBundle, paramViewGroup);
    this.b.a();
    this.e = true;
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
      this.c = paramBundle.getInt("KEY_POSITION");
    }
    paramBundle = a(getBaseActivity());
    Object localObject = c(this.c);
    if (localObject == null)
    {
      QLog.e("MultiAIOItemFragment", 1, "initData: recentBaseData == null");
      return;
    }
    this.a.b = ((RecentBaseData)localObject).getRecentUserUin();
    this.a.a = ((RecentBaseData)localObject).getRecentUserType();
    this.a.e = ((RecentBaseData)localObject).getTitleName();
    this.a.B = paramBundle.getIntExtra("key_mini_from", 0);
    paramBundle = this.a;
    paramBundle.c = paramBundle.b;
    this.a.H = new ChatBackground();
    this.a.H.c = getResources().getDrawable(2130852164);
    this.a.H.b = getResources().getColorStateList(2131165558);
    this.a.r = ChatTextSizeSettingActivity.a(getBaseActivity());
    localObject = this.a.b();
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putBoolean("KEY_DELAY_SET_READ", isVisible() ^ true);
    paramBundle.putBoolean("KEY_IS_IN_MULTI_AIO", true);
    this.a.a(paramBundle);
  }
  
  private void a(View paramView)
  {
    FitSystemWindowsRelativeLayout localFitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout)paramView.findViewById(2131427887);
    if (localFitSystemWindowsRelativeLayout == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "initAIORootView() afRoot == null");
      }
      return;
    }
    this.d = new GestureDetector(paramView.getContext(), new MultiAIOItemFragment.1(this), new Handler(Looper.getMainLooper()));
    localFitSystemWindowsRelativeLayout.setDispatchTouchEventListener(new MultiAIOItemFragment.2(this));
    localFitSystemWindowsRelativeLayout.setOnInterceptTouchEventListener(new MultiAIOItemFragment.3(this));
    paramView = getParentFragment();
    if ((paramView != null) && ((paramView instanceof MultiAIOFragment)))
    {
      paramView = ((MultiAIOFragment)paramView).a();
      int m = paramView.getMeasuredWidth();
      int n = paramView.getPaddingLeft();
      int i1 = paramView.getPaddingRight();
      int i2 = paramView.getMeasuredHeight();
      int i3 = paramView.getPaddingTop();
      int i4 = paramView.getPaddingBottom();
      paramView = localFitSystemWindowsRelativeLayout.getLayoutParams();
      paramView.width = getResources().getDisplayMetrics().widthPixels;
      float f1 = (m - n - i1) * 1.0F / paramView.width;
      paramView.height = ((int)((i2 - i3 - i4) * 1.0F / f1 + 0.5F));
      localFitSystemWindowsRelativeLayout.setPivotX(-1.0F);
      localFitSystemWindowsRelativeLayout.setPivotY(-1.0F);
      localFitSystemWindowsRelativeLayout.setScaleX(f1);
      localFitSystemWindowsRelativeLayout.setScaleY(f1);
    }
  }
  
  private RecentBaseData c(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a(paramInt);
    }
    return null;
  }
  
  private MultiAioContext c()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).b();
    }
    return null;
  }
  
  private void d()
  {
    ListView localListView = (ListView)getView().findViewById(2131437281);
    Object localObject = localListView.getOnScrollListener();
    localListView.setOnScrollListener(new MultiAIOItemFragment.4(this, (AbsListView.OnScrollListener)localObject));
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = g();
    if (localMultiAIOBaseViewPager != null)
    {
      this.k = new MultiAIOItemFragment.5(this, (AbsListView.OnScrollListener)localObject, localListView);
      localMultiAIOBaseViewPager.a(this.k);
    }
    if ((this.c == 0) && (this.b != null) && ((localListView instanceof ChatXListView)))
    {
      localObject = f();
      if ((localObject != null) && (localObject.length == 2) && (localObject[0] >= 0))
      {
        localListView.post(new MultiAIOItemFragment.6(this, localListView, (int[])localObject));
        this.b.b(true);
        localListView.postDelayed(new MultiAIOItemFragment.7(this), 500L);
      }
      localListView.addOnLayoutChangeListener(new MultiAIOItemFragment.8(this, localListView));
    }
  }
  
  private int[] e()
  {
    int[] arrayOfInt = new int[2];
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      arrayOfInt = ((MultiAIOFragment)localFragment).d();
    }
    return arrayOfInt;
  }
  
  private int[] f()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).c();
    }
    return new int[0];
  }
  
  private MultiAIOBaseViewPager g()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  public SessionInfo a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null)
    {
      boolean bool;
      if (this.c != paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localMiniPie.d(bool);
      this.b.z();
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    MiniPie localMiniPie = this.b;
    if ((localMiniPie != null) && (paramInt == this.c)) {
      localMiniPie.n();
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
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.t();
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
      ((StringBuilder)localObject).append(this.c);
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
      if (this.b == null) {
        break label48;
      }
      this.b.r();
      this.j = true;
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
      localObject = ((View)localObject).findViewById(2131427887);
      MultiAioContext localMultiAioContext = c();
      if (localMultiAioContext != null) {
        localMultiAioContext.a((View)localObject);
      }
    }
    localObject = g();
    if (localObject != null) {
      ((MultiAIOBaseViewPager)localObject).b(this.k);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.b;
    if (paramIntent != null) {
      paramIntent.l();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() called ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if ((localObject != null) && (this.e) && (this.f) && (this.g))
    {
      ((MiniPie)localObject).o();
      this.h = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(this.c);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.b != null) && (getUserVisibleHint()))
    {
      this.b.m();
      this.g = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("KEY_POSITION", this.c);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() called ");
      localStringBuilder.append(this.c);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.b != null) && (getUserVisibleHint()) && (this.e))
    {
      this.b.p();
      this.f = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onStop() called");
    }
    MiniPie localMiniPie = this.b;
    if ((localMiniPie != null) && (this.h))
    {
      localMiniPie.q();
      this.i = true;
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
      localStringBuilder.append(this.c);
      localStringBuilder.append("], savedInstanceState = ");
      localStringBuilder.append(paramBundle);
      QLog.d("MultiAIOItemFragment", 2, localStringBuilder.toString());
    }
    paramView.setTag(Integer.valueOf(this.c));
    a(paramView);
    if ((paramView instanceof ViewGroup))
    {
      paramBundle = new View(getBaseActivity());
      paramBundle.setId(2131439021);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((ViewGroup)paramView).addView(paramBundle);
    }
    if (this.e) {
      d();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniPie localMiniPie = this.b;
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
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((MiniPie)localObject).d(false);
      if (!this.e)
      {
        localObject = this.l.inflate();
        localObject = this.b.a(null, (View)localObject, null);
        this.b.a();
        this.e = true;
        a((View)localObject);
        d();
      }
      if (!this.f)
      {
        this.b.p();
        this.f = true;
      }
      this.b.m();
      this.g = true;
      return;
    }
    ((MiniPie)localObject).d(true);
    if ((this.e) && (this.f) && (this.g))
    {
      this.b.o();
      this.h = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment
 * JD-Core Version:    0.7.0.1
 */