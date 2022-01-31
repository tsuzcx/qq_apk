package com.tencent.mobileqq.fragment;

import admu;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

@TargetApi(11)
public abstract class IphoneTitleBarFragment
  extends PublicBaseFragment
{
  public float a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  public ImageView a;
  public RelativeLayout a;
  public NavBarCommon a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public ImageView b;
  private RelativeLayout b;
  public TextView b;
  private ImageView c;
  public TextView c;
  public View d;
  public TextView d;
  public View e;
  public TextView e;
  protected boolean e;
  public TextView f;
  
  public IphoneTitleBarFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new admu(this);
  }
  
  public static void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public abstract int a();
  
  protected View a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363245));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.f = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363995));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363994));
    if ((this.f != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363473));
    c(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(Bundle paramBundle)
  {
    if (getActivity() == null) {}
    do
    {
      return;
      ((FrameLayout)getActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130845874));
      if ((f()) && (b()) && (a()))
      {
        ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
        if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
          ((FrameLayout)localViewParent).setVisibility(8);
        }
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView != null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363244));
    a();
    try
    {
      if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      d();
      e();
      b(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("IphoneTitleBarFragment", 1, "", paramBundle);
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramCharSequence);
  }
  
  public View b()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363428));
    c(this.jdField_e_of_type_AndroidWidgetTextView);
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftViewName(paramInt);
  }
  
  public void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(true);
    if (paramOnClickListener != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.b) {
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_e_of_type_AndroidWidgetTextView.getText() + "按钮");
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftViewName(paramBundle);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363473));
    c(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public View c()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363244);
  }
  
  protected View d()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363381));
    return this.jdField_d_of_type_AndroidWidgetTextView;
  }
  
  public boolean d()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    return false;
  }
  
  protected View e()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363428));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363474));
    c(this.jdField_e_of_type_AndroidWidgetTextView);
    c(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  @TargetApi(11)
  public void f(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (getActivity() == null)) {
      return false;
    }
    Object localObject1;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363380);
      if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
        localObject2 = this.jdField_d_of_type_AndroidWidgetTextView.getParent();
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != localObject2))
        {
          if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getParent() == this.jdField_b_of_type_AndroidWidgetRelativeLayout))
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetImageView);
            this.jdField_c_of_type_AndroidWidgetImageView = null;
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
        }
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) && ((localObject2 instanceof RelativeLayout))) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.jdField_c_of_type_AndroidWidgetImageView != null)
          {
            int i = ((View)localObject1).getId();
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
            localObject2 = localObject1;
            if (localLayoutParams.getRules()[0] != i)
            {
              localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localLayoutParams.addRule(0, i);
              this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            }
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
      {
        if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          break label533;
        }
        if (this.jdField_c_of_type_AndroidWidgetImageView == null)
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getActivity());
          this.jdField_c_of_type_AndroidWidgetImageView.setId(2131365708);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(15);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(7.0F * DeviceInfoUtil.a()));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = getActivity().getResources().getDrawable(2130838598);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          if ((localObject1 instanceof Animatable)) {
            ((Animatable)localObject1).start();
          }
        }
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return true;
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getVisibility() != 0)) {
          break label535;
        }
        localObject2 = ((RelativeLayout)localObject1).getParent();
        break;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838598);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_d_of_type_AndroidWidgetTextView.getCompoundDrawables();
        this.jdField_a_of_type_Int = this.jdField_d_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        return true;
      }
      label533:
      return false;
      label535:
      localObject2 = null;
      localObject1 = null;
      break;
    }
  }
  
  public boolean h()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return true;
      }
    }
    else if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void j()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    c(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  @TargetApi(14)
  @Nullable
  public final View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130968837, paramViewGroup, false);
    try
    {
      View localView2 = paramLayoutInflater.inflate(a(), (ViewGroup)localView1, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView1.findViewById(2131364019));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.a(paramLayoutInflater.getContext()), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131363244);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView2, localLayoutParams);
      this.jdField_e_of_type_AndroidViewView = localView2;
    }
    catch (InflateException localInflateException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("IphoneTitleBarFragment", 2, "create view error ", localInflateException);
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        localRuntimeException.printStackTrace();
      }
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getArguments());
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.IphoneTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */