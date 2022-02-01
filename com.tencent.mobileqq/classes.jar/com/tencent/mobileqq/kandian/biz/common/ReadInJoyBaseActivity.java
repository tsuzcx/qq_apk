package com.tencent.mobileqq.kandian.biz.common;

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
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.LeftRedDotRadioButton;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ReadInJoyBaseActivity
  extends BaseActivity
{
  protected float a;
  protected int b = -1;
  public RadioGroup c;
  protected View d;
  public View e;
  protected ViewGroup f;
  public LeftRedDotRadioButton g;
  public RedDotRadioButton h;
  public RelativeLayout i;
  public ImageView j;
  public TextView k;
  public TextView l;
  public TextView m;
  public TextView n;
  protected View.OnClickListener o = new ReadInJoyBaseActivity.1(this);
  
  @TargetApi(11)
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private View d()
  {
    this.m = ((TextView)findViewById(2131436227));
    return this.m;
  }
  
  protected View a()
  {
    this.k = ((TextView)findViewById(2131436180));
    this.k.setOnClickListener(this.o);
    a(this.k);
    if (AppSetting.e) {
      AccessibilityUtil.b(this.k, Button.class.getName());
    }
    return this.k;
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130852235));
    if (this.k == null)
    {
      this.f = ((ViewGroup)findViewById(2131444899));
      a(this.f);
      d();
      a();
      b();
      c();
      b(paramIntent);
    }
  }
  
  protected ViewGroup b()
  {
    this.c = ((RadioGroup)findViewById(2131436219));
    this.g = ((LeftRedDotRadioButton)findViewById(2131436231));
    this.g.setFocusable(true);
    this.h = ((RedDotRadioButton)findViewById(2131436232));
    this.h.setFocusable(true);
    a(this.c);
    return this.c;
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.k;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = this.l;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.k;
      localObject = paramIntent.getExtras().getString("leftViewText");
      int i1 = paramIntent.getExtras().getInt("individuation_url_type");
      paramIntent = (Intent)localObject;
      if (i1 >= 40300)
      {
        paramIntent = (Intent)localObject;
        if (i1 <= 40313)
        {
          paramIntent = (Intent)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramIntent = (Intent)localObject;
            if (((String)localObject).contains(HardCodeUtil.a(2131910592))) {
              paramIntent = getString(2131887625);
            }
          }
        }
      }
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = getString(2131887625);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject = this.k.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131887625)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(getString(2131887625));
          paramIntent.append((String)localObject);
          paramIntent = paramIntent.toString();
        }
        this.k.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  protected View c()
  {
    this.j = ((ImageView)findViewById(2131436194));
    a(this.j);
    return this.n;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
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
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      this.b = paramInt;
      getWindow().setFeatureInt(7, 2131624579);
    }
    else
    {
      Object localObject3 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject3).inflate(2131626251, null);
      int i1 = 1;
      try
      {
        localObject3 = ((LayoutInflater)localObject3).inflate(paramInt, (ViewGroup)localObject1, false);
        this.i = ((RelativeLayout)((View)localObject1).findViewById(2131447595));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.i.setFitsSystemWindows(true);
          this.i.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131444899);
        this.i.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        this.d = ((View)localObject3);
        super.setContentView(this.i);
        i1 = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      catch (InflateException localInflateException)
      {
        localInflateException.printStackTrace();
      }
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject2).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject2).toString());
        }
        super.setContentView(paramInt);
        this.b = paramInt;
        getWindow().setFeatureInt(7, 2131624579);
        localObject2 = this.e;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        this.a = getResources().getDisplayMetrics().density;
        a(getIntent());
        return;
      }
    }
    Object localObject2 = this.e;
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    this.a = getResources().getDisplayMetrics().density;
    a(getIntent());
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.m;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyBaseActivity
 * JD-Core Version:    0.7.0.1
 */