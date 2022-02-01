package com.tencent.mobileqq.fragment;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.QFragmentActivity;
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
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
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
  protected boolean a;
  protected View b;
  protected ImageView b;
  public TextView b;
  private boolean b;
  public TextView c;
  public TextView d;
  protected TextView e;
  
  public QIphoneTitleBarFragment()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369487));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.e = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380148));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369878));
    if ((this.e != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369489));
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
    if (getActivity() == null) {}
    do
    {
      return;
      ((FrameLayout)getActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130850513));
      if ((a()) && (d_()) && (d()))
      {
        ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
        if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
          ((FrameLayout)localViewParent).setVisibility(8);
        }
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView != null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377159));
    a();
    try
    {
      if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      c();
      d();
      b(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("IphoneTitleBarFragment", 1, "", paramBundle);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramCharSequence);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_Boolean = false;
    this.d.setVisibility(0);
    this.d.setText(paramString);
    this.d.setEnabled(true);
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377159);
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftViewName(paramBundle);
  }
  
  protected View c()
  {
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369534));
    return this.c;
  }
  
  public boolean c()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    return false;
  }
  
  protected View d()
  {
    this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369518));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369501));
    a(this.d);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.d;
  }
  
  public void k_(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
  }
  
  @TargetApi(14)
  @Nullable
  public final View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131559054, paramViewGroup, false);
    Object localObject1 = null;
    try
    {
      localObject2 = paramLayoutInflater.inflate(a(), (ViewGroup)localView, false);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        label115:
        QLog.e("IphoneTitleBarFragment", 1, localThrowable, new Object[0]);
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379546));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
      }
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131377159);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidViewView = localObject1;
    }
    catch (InflateException localInflateException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localInflateException, new Object[0]);
      break label115;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localRuntimeException, new Object[0]);
      break label115;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getArguments());
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */