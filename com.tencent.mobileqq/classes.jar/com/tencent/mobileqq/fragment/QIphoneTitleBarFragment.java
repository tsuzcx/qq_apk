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
  private boolean a;
  public TextView h;
  public TextView i;
  public TextView j;
  public TextView k;
  public TextView l;
  public ImageView m;
  protected TextView n;
  protected ImageView o;
  protected NavBarCommon p;
  protected float q;
  public View r = null;
  public RelativeLayout s;
  protected View t;
  protected boolean u = false;
  protected View.OnClickListener v = new QIphoneTitleBarFragment.1(this);
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  protected abstract int a();
  
  public View a(String paramString, int paramInt)
  {
    return this.p.setBottomTitleLayoutIdAndInflateIt(paramString, paramInt);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.h.setVisibility(8);
    this.i = ((TextView)this.s.findViewById(2131436182));
    a(this.i);
    this.i.setVisibility(0);
    this.i.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.i.setOnClickListener(this.v);
      return;
    }
    this.i.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Bundle paramBundle)
  {
    if (getActivity() == null) {
      return;
    }
    ((FrameLayout)getActivity().findViewById(16908290)).setForeground(getResources().getDrawable(2130852235));
    if ((i()) && (needImmersive()) && (needStatusTrans()))
    {
      ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
    if (this.h == null)
    {
      this.p = ((NavBarCommon)this.s.findViewById(2131444897));
      j();
      try
      {
        if ((paramBundle.getBoolean("hide_title_left_arrow", false)) && (this.h != null)) {
          this.h.setBackgroundDrawable(null);
        }
        n();
        o();
        a_(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("IphoneTitleBarFragment", 1, "", paramBundle);
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
    this.p.setTitle(paramCharSequence);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.h.setVisibility(8);
    this.i = ((TextView)this.s.findViewById(2131436182));
    if (TextUtils.isEmpty(paramString))
    {
      this.i.setVisibility(8);
      return;
    }
    a(this.i);
    this.i.setVisibility(0);
    this.i.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.i.setOnClickListener(this.v);
      return;
    }
    this.i.setOnClickListener(paramOnClickListener);
  }
  
  public void a_(Bundle paramBundle)
  {
    this.p.setLeftViewName(paramBundle);
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.a = true;
    Object localObject = this.k;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.k.setText(paramInt);
      this.k.setEnabled(false);
      this.l = ((TextView)LayoutInflater.from(getActivity()).inflate(2131624584, null));
      a(this.l);
      this.l.setText(paramInt);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.q * 8.0F));
      this.p.addView(this.l, (ViewGroup.LayoutParams)localObject);
      this.l.setVisibility(8);
      if (paramOnClickListener != null) {
        this.l.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.a = false;
    this.k.setVisibility(0);
    this.k.setText(paramString);
    this.k.setEnabled(true);
    if (paramOnClickListener != null) {
      this.k.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.l != null)
    {
      if (!this.a) {
        return;
      }
      if (paramBoolean)
      {
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        return;
      }
      this.k.setVisibility(0);
      this.l.setVisibility(8);
    }
  }
  
  public void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.a = false;
    this.k.setVisibility(0);
    a(this.k, paramInt);
    this.k.setEnabled(true);
    if (paramOnClickListener != null) {
      this.k.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean i()
  {
    return false;
  }
  
  protected View j()
  {
    this.h = ((TextView)this.s.findViewById(2131436180));
    this.h.setOnClickListener(this.v);
    this.n = ((TextView)this.s.findViewById(2131448219));
    this.o = ((ImageView)this.s.findViewById(2131436666));
    TextView localTextView = this.n;
    if ((localTextView != null) && (this.o != null))
    {
      localTextView.setOnClickListener(this.v);
      this.o.setOnClickListener(this.v);
    }
    return this.h;
  }
  
  public void k()
  {
    try
    {
      this.r = this.s.findViewById(2131444897);
      this.r.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public View l()
  {
    this.k = ((TextView)this.s.findViewById(2131436211));
    a(this.k);
    return this.k;
  }
  
  public View m()
  {
    return this.s.findViewById(2131444897);
  }
  
  protected View n()
  {
    this.j = ((TextView)this.s.findViewById(2131436227));
    return this.j;
  }
  
  public void n_(boolean paramBoolean)
  {
    this.k.setEnabled(paramBoolean);
  }
  
  protected View o()
  {
    this.k = ((TextView)this.s.findViewById(2131436211));
    this.m = ((ImageView)this.s.findViewById(2131436194));
    a(this.k);
    a(this.m);
    return this.k;
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
    View localView4 = paramLayoutInflater.inflate(2131624581, paramViewGroup, false);
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
      this.s = ((RelativeLayout)localView4.findViewById(2131447595));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.s.setFitsSystemWindows(true);
        this.s.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131444897);
      this.s.addView(localView2, localLayoutParams);
      this.t = localView2;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localRuntimeException, new Object[0]);
    }
    catch (InflateException localInflateException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localInflateException, new Object[0]);
    }
    View localView3 = this.r;
    if (localView3 != null) {
      localView3.setVisibility(0);
    }
    this.q = getResources().getDisplayMetrics().density;
    a(getArguments());
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView4);
    return localView4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
 * JD-Core Version:    0.7.0.1
 */