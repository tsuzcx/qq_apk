package com.tencent.mobileqq.guild.base;

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
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class QQGuildCustomTitleBarFragment
  extends QPublicBaseFragment
{
  public TextView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public ImageView e;
  protected TextView f;
  protected ImageView g;
  protected GuildDefaultThemeNavBarCommon h;
  protected float i;
  public View j = null;
  public RelativeLayout k;
  protected View l;
  protected boolean m = false;
  protected View.OnClickListener n = new QQGuildCustomTitleBarFragment.1(this);
  private boolean o;
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.setEnabled(false);
      this.d.setAlpha(0.5F);
      return;
    }
    this.d.setEnabled(true);
    this.d.setAlpha(1.0F);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.a.setVisibility(8);
    this.b = ((TextView)this.k.findViewById(2131436182));
    a(this.b);
    this.b.setVisibility(0);
    this.b.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.b.setOnClickListener(this.n);
      return;
    }
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Bundle paramBundle)
  {
    if (getActivity() == null) {
      return;
    }
    ((FrameLayout)getActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130840818));
    if ((c()) && (needImmersive()) && (needStatusTrans()))
    {
      ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
    if (this.a == null)
    {
      this.h = ((GuildDefaultThemeNavBarCommon)this.k.findViewById(2131444897));
      d();
      try
      {
        if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.a != null)) {
          this.a.setBackgroundDrawable(null);
        }
        f();
        g();
        b(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("QQGuildCustomTitleBarFragment", 1, "", paramBundle);
      }
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {}
  
  protected void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setText(paramInt);
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTextView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131903787));
      paramTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.h.setTitle(paramCharSequence);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.a.setVisibility(8);
    this.b = ((TextView)this.k.findViewById(2131436182));
    if (TextUtils.isEmpty(paramString))
    {
      this.b.setVisibility(8);
      return;
    }
    a(this.b);
    this.b.setVisibility(0);
    this.b.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.b.setOnClickListener(this.n);
      return;
    }
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
  }
  
  protected abstract int b();
  
  public void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.o = false;
    this.d.setVisibility(0);
    a(this.d, paramInt);
    this.d.setEnabled(true);
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.h.setLeftViewName(paramBundle);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected View d()
  {
    this.a = ((TextView)this.k.findViewById(2131436180));
    this.a.setOnClickListener(this.n);
    this.f = ((TextView)this.k.findViewById(2131448219));
    this.g = ((ImageView)this.k.findViewById(2131436666));
    TextView localTextView = this.f;
    if ((localTextView != null) && (this.g != null))
    {
      localTextView.setOnClickListener(this.n);
      this.g.setOnClickListener(this.n);
    }
    return this.a;
  }
  
  public View e()
  {
    return this.k.findViewById(2131444897);
  }
  
  protected View f()
  {
    this.c = ((TextView)this.k.findViewById(2131436227));
    return this.c;
  }
  
  protected View g()
  {
    this.d = ((TextView)this.k.findViewById(2131436211));
    this.e = ((ImageView)this.k.findViewById(2131436194));
    a(this.d);
    a(this.e);
    return this.d;
  }
  
  public void h()
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    a(this.a);
    this.a.setVisibility(0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
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
  public final View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    View localView3 = paramLayoutInflater.inflate(2131625030, paramViewGroup, false);
    View localView2;
    try
    {
      View localView1 = paramLayoutInflater.inflate(b(), (ViewGroup)localView3, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, localThrowable, new Object[0]);
      localView2 = null;
    }
    try
    {
      this.k = ((RelativeLayout)localView3.findViewById(2131447595));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.k.setFitsSystemWindows(true);
        this.k.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + 5, 0, 0);
        QQGuildUIUtil.a(getActivity(), -1);
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131444897);
      this.k.addView(localView2, localLayoutParams);
      this.l = localView2;
    }
    catch (InflateException localInflateException)
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, localInflateException, new Object[0]);
    }
    Object localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    this.i = getResources().getDisplayMetrics().density;
    a(getArguments());
    localObject = this.h;
    if (localObject != null) {
      ((GuildDefaultThemeNavBarCommon)localObject).a(true);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView3);
    return localView3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */