package com.tencent.mobileqq.kandian.biz.message.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class ReadInJoyNewBaseActivity
  extends BaseActivity
{
  public ImageView A;
  public int B = -1;
  protected ImmersiveTitleBar2 C;
  protected View.OnClickListener D = new ReadInJoyNewBaseActivity.1(this);
  protected float o;
  protected boolean p = false;
  public View q;
  protected ViewGroup r;
  public ViewGroup s;
  public ImageView t;
  public TextView u;
  public TextView v;
  public TextView w;
  public TextView x;
  public LinearLayout y;
  protected View z;
  
  private View a()
  {
    this.w = ((TextView)findViewById(2131436227));
    this.y = ((LinearLayout)findViewById(2131436229));
    this.A = ((ImageView)findViewById(2131436228));
    return this.y;
  }
  
  @TargetApi(11)
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130852235));
    this.r = ((ViewGroup)findViewById(2131444899));
    b(this.r);
    a();
    s();
    t();
    b(paramIntent);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.u;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = this.v;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.u;
      localObject = paramIntent.getExtras().getString("leftViewText");
      int i = paramIntent.getExtras().getInt("individuation_url_type");
      paramIntent = (Intent)localObject;
      if (i >= 40300)
      {
        paramIntent = (Intent)localObject;
        if (i <= 40313)
        {
          paramIntent = (Intent)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramIntent = (Intent)localObject;
            if (((String)localObject).contains(HardCodeUtil.a(2131910238))) {
              paramIntent = getString(2131887625);
            }
          }
        }
      }
      if (paramIntent != null)
      {
        localObject = paramIntent;
        if (!paramIntent.contains("http")) {}
      }
      else
      {
        localObject = getString(2131887625);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject = this.u.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131887625)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(getString(2131887625));
          paramIntent.append((String)localObject);
          paramIntent = paramIntent.toString();
        }
        this.u.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  protected void d(boolean paramBoolean)
  {
    ImageView localImageView = this.t;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void g(int paramInt)
  {
    ImageView localImageView = this.A;
    if ((localImageView != null) && (paramInt != localImageView.getVisibility()))
    {
      this.A.clearAnimation();
      this.A.setVisibility(paramInt);
    }
  }
  
  public void h(int paramInt)
  {
    if (this.B == paramInt) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDisplayMode from ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" to ");
      localStringBuilder.append(this.B);
      QLog.d("ReadInJoyBaseActivity", 2, localStringBuilder.toString());
    }
    this.B = paramInt;
    paramInt = this.B;
    if (paramInt == 0)
    {
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        super.getWindow().addFlags(67108864);
        if (this.mSystemBarComp == null) {
          this.mSystemBarComp = new SystemBarCompact(this, true, -1);
        }
        this.mSystemBarComp.init();
        if (this.p)
        {
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
          }
          else
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
            this.mSystemBarComp.setStatusBarDarkMode(true);
          }
        }
        else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          a(true);
          this.mSystemBarComp.setStatusBarColor(-1);
        }
        else if (!SystemUtil.g())
        {
          this.mSystemBarComp.setStatusBarColor(-2368549);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-1);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      this.w.setTextColor(-14408926);
      this.u.setTextColor(-14408926);
      this.u.setBackgroundResource(2130851519);
      this.t.setImageResource(2130851517);
      this.r.setBackgroundColor(-1);
      return;
    }
    if (paramInt == 1)
    {
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        super.getWindow().addFlags(67108864);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, -14408926);
          this.mSystemBarComp.init();
        }
        this.mSystemBarComp.setStatusBarDarkMode(false);
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          a(false);
          this.mSystemBarComp.setStatusBarColor(-14408926);
        }
        else
        {
          this.mSystemBarComp.init();
          this.mSystemBarComp.setStatusBarColor(-14408926);
        }
      }
      this.w.setTextColor(-1);
      this.u.setTextColor(-1);
      this.u.setBackgroundResource(2130851520);
      this.t.setImageResource(2130851518);
      this.r.setBackgroundColor(-14408926);
    }
  }
  
  protected void i(int paramInt)
  {
    ImageView localImageView = this.t;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  protected View s()
  {
    this.u = ((TextView)findViewById(2131436180));
    this.u.setOnClickListener(this.D);
    b(this.u);
    if (AppSetting.e) {
      AccessibilityUtil.b(this.u, Button.class.getName());
    }
    return this.u;
  }
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      getWindow().setFeatureInt(7, 2131624579);
    }
    else
    {
      Object localObject2 = LayoutInflater.from(this);
      View localView = ((LayoutInflater)localObject2).inflate(2131626297, null);
      int i = 1;
      try
      {
        this.s = ((ViewGroup)localView.findViewById(2131447595));
        this.C = ((ImmersiveTitleBar2)localView.findViewById(2131447582));
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, this.s, false);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.s.addView((View)localObject2, 0, localLayoutParams);
        super.setContentView(localView);
        this.p = ThemeUtil.isInNightMode(this.app);
        i = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      catch (InflateException localInflateException)
      {
        localInflateException.printStackTrace();
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject1).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject1).toString());
        }
        super.setContentView(paramInt);
        getWindow().setFeatureInt(7, 2131624579);
        localObject1 = this.q;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        this.o = getResources().getDisplayMetrics().density;
        a(getIntent());
        return;
      }
    }
    Object localObject1 = this.q;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    this.o = getResources().getDisplayMetrics().density;
    a(getIntent());
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.w;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      int i = ReadInJoyNaviController.d;
      Object localObject = paramCharSequence;
      if (paramCharSequence.length() > i)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCharSequence.subSequence(0, i));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      localTextView.setText((CharSequence)localObject);
      super.setTitle((CharSequence)localObject);
    }
  }
  
  protected View t()
  {
    this.t = ((ImageView)findViewById(2131436194));
    b(this.t);
    return this.x;
  }
  
  public void u()
  {
    this.p = true;
    this.z = ((ViewStub)findViewById(2131447594)).inflate();
    View localView = this.z;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoyNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */