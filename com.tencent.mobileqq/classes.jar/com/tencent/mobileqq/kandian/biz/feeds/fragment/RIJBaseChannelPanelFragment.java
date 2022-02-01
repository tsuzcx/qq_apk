package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.NestedScrollView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.mobileqq.widget.SlideDownFrameLayout.OnSlideListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class RIJBaseChannelPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SlideDownFrameLayout.OnSlideListener
{
  protected int a = 0;
  protected SlideDownFrameLayout b;
  protected TextView c;
  private LinearLayout d;
  private NestedScrollView e;
  private View f;
  private View g;
  private View h;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.d = ((LinearLayout)this.b.findViewById(2131431349));
    this.e = ((NestedScrollView)this.b.findViewById(2131430510));
    paramLayoutInflater = paramLayoutInflater.inflate(a(), this.e, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    this.e.addView(paramLayoutInflater, localLayoutParams);
    this.h = this.b.findViewById(2131430821);
    this.c = ((TextView)this.b.findViewById(2131439094));
    ((TextView)this.b.findViewById(2131444245)).setText(b());
    this.f = this.b.findViewById(2131437989);
    this.b.setOnSlideListener(this);
    this.d.setOnTouchListener(new RIJBaseChannelPanelFragment.1(this));
    onPostThemeChanged();
    paramLayoutInflater = ((ViewGroup)((FrameLayout)getBaseActivity().findViewById(16908290)).getParent()).getChildAt(1);
    if (((paramLayoutInflater instanceof FrameLayout)) && (paramLayoutInflater.getId() != 16908290)) {
      paramLayoutInflater.setVisibility(8);
    }
    this.d.setAlpha(0.0F);
    this.d.post(new RIJBaseChannelPanelFragment.2(this));
  }
  
  private void b(View paramView)
  {
    this.b.b();
  }
  
  private void f()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      BaseActivity localBaseActivity = getBaseActivity();
      localBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getBaseActivity().getWindow(), true);
      if (localBaseActivity.mSystemBarComp == null) {
        localBaseActivity.mSystemBarComp = new SystemBarCompact(localBaseActivity, true, -1);
      }
      localBaseActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localBaseActivity.mSystemBarComp.setStatusBarColor(0);
        return;
      }
      if (!SystemUtil.g())
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
      localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  private void g()
  {
    this.h.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public abstract int a();
  
  public void a(float paramFloat, int paramInt)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(paramFloat, paramInt);
    this.f.setAlpha(1.0F - paramFloat / paramInt);
  }
  
  protected void a(View paramView) {}
  
  public abstract String b();
  
  public boolean c()
  {
    return this.e.getScrollY() == 0;
  }
  
  public void d()
  {
    if (getBaseActivity() != null)
    {
      getBaseActivity().finish();
      getBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public View e()
  {
    return this.d;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    this.b.b();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430821)
    {
      if (i != 2131439094) {
        return;
      }
      a(paramView);
      return;
    }
    b(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = AIOUtils.b(8.0F, getResources());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getBaseActivity().setTheme(2131952009);
    this.b = ((SlideDownFrameLayout)paramLayoutInflater.inflate(2131629124, paramViewGroup, false));
    a(paramLayoutInflater);
    g();
    return this.b;
  }
  
  public void onPostThemeChanged()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.b(), false, null))
    {
      if (this.g == null) {
        this.g = ((ViewStub)this.b.findViewById(2131444309)).inflate();
      }
      localView = this.g;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.g;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.RIJBaseChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */