package com.tencent.mobileqq.fragment;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class QIphoneTitleBarFragment
  extends QPublicBaseFragment
{
  protected float a;
  protected View.OnClickListener a;
  public View a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  protected NavBarCommon a;
  private boolean a;
  protected View b;
  protected ImageView b;
  public TextView b;
  protected boolean b;
  public TextView c;
  public TextView d;
  public TextView e;
  protected TextView f;
  
  public QIphoneTitleBarFragment()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QIphoneTitleBarFragment.1(this);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  protected abstract int a();
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.f = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379476));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369563));
    TextView localTextView = this.f;
    if ((localTextView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public View a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBottomTitleLayoutIdAndInflateIt(paramString, paramInt);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369204));
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Bundle paramBundle)
  {
    if (getActivity() == null) {
      return;
    }
    ((FrameLayout)getActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130850439));
    if ((a()) && (needImmersive()) && (needStatusTrans()))
    {
      ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636));
      a();
      try
      {
        if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        }
        d();
        e();
        a_(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("IphoneTitleBarFragment", 1, "", paramBundle);
      }
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  protected void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setText(paramInt);
    if (AppSetting.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTextView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131705906));
      paramTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramCharSequence);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369204));
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void a_(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftViewName(paramBundle);
  }
  
  public View b()
  {
    this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369233));
    a(this.d);
    return this.d;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.d;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.d.setText(paramInt);
      this.d.setEnabled(false);
      this.e = ((TextView)LayoutInflater.from(getActivity()).inflate(2131558951, null));
      a(this.e);
      this.e.setText(paramInt);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_Float * 8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.addView(this.e, (ViewGroup.LayoutParams)localObject);
      this.e.setVisibility(8);
      if (paramOnClickListener != null) {
        this.e.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.d.setVisibility(0);
    this.d.setText(paramString);
    this.d.setEnabled(true);
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.e != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (paramBoolean)
      {
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        return;
      }
      this.d.setVisibility(0);
      this.e.setVisibility(8);
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636);
  }
  
  public void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.d.setVisibility(0);
    a(this.d, paramInt);
    this.d.setEnabled(true);
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected View d()
  {
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369249));
    return this.c;
  }
  
  protected View e()
  {
    this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369216));
    a(this.d);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.d;
  }
  
  public void i_(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    return false;
  }
  
  @TargetApi(14)
  @Nullable
  public final View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView4 = paramLayoutInflater.inflate(2131558948, paramViewGroup, false);
    View localView2;
    try
    {
      View localView1 = paramLayoutInflater.inflate(a(), (ViewGroup)localView4, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IphoneTitleBarFragment", 1, localThrowable, new Object[0]);
      localView2 = null;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView4.findViewById(2131378893));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131376636);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView2, localLayoutParams);
      this.jdField_b_of_type_AndroidViewView = localView2;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localRuntimeException, new Object[0]);
    }
    catch (InflateException localInflateException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localInflateException, new Object[0]);
    }
    View localView3 = this.jdField_a_of_type_AndroidViewView;
    if (localView3 != null) {
      localView3.setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getArguments());
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView4);
    return localView4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */