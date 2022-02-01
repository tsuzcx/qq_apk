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
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  private NestedScrollView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetNestedScrollView;
  protected SlideDownFrameLayout a;
  private View b;
  private View c;
  
  public RIJBaseChannelPanelFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131365187));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetNestedScrollView = ((NestedScrollView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364466));
    paramLayoutInflater = paramLayoutInflater.inflate(a(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetNestedScrollView, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetNestedScrollView.addView(paramLayoutInflater, localLayoutParams);
    this.c = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364715);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371673));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376045)).setText(a());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370711);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.setOnSlideListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new RIJBaseChannelPanelFragment.1(this));
    onPostThemeChanged();
    paramLayoutInflater = ((ViewGroup)((FrameLayout)getBaseActivity().findViewById(16908290)).getParent()).getChildAt(1);
    if (((paramLayoutInflater instanceof FrameLayout)) && (paramLayoutInflater.getId() != 16908290)) {
      paramLayoutInflater.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new RIJBaseChannelPanelFragment.2(this));
  }
  
  private void b()
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localBaseActivity.mSystemBarComp.setStatusBarColor(0);
        return;
      }
      if (!SystemUtil.d())
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
      localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
  }
  
  private void c()
  {
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public abstract String a();
  
  public void a()
  {
    if (getBaseActivity() != null)
    {
      getBaseActivity().finish();
      getBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(paramFloat, paramInt);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - paramFloat / paramInt);
  }
  
  protected void a(View paramView) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetNestedScrollView.getScrollY() == 0;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364715)
    {
      if (i != 2131371673) {
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
    this.jdField_a_of_type_Int = AIOUtils.b(8.0F, getResources());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getBaseActivity().setTheme(2131755316);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout = ((SlideDownFrameLayout)paramLayoutInflater.inflate(2131562693, paramViewGroup, false));
    a(paramLayoutInflater);
    c();
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  }
  
  public void onPostThemeChanged()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376106)).inflate();
      }
      localView = this.b;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.b;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.RIJBaseChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */