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
  protected float a;
  protected View.OnClickListener a;
  public View a;
  protected ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected ImmersiveTitleBar2 a;
  protected View b;
  public ViewGroup b;
  public ImageView b;
  public TextView b;
  public int c;
  public TextView c;
  protected boolean c;
  public TextView d;
  
  public ReadInJoyNewBaseActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoyNewBaseActivity.1(this);
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
  
  private View c()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369251));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369250));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.d) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130850439));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376638));
    b(this.jdField_a_of_type_AndroidViewViewGroup);
    c();
    a();
    b();
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
  
  protected View b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.d;
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
            if (((String)localObject).contains(HardCodeUtil.a(2131712660))) {
              paramIntent = getString(2131690706);
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
        localObject = getString(2131690706);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.d)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131690706)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(getString(2131690706));
          paramIntent.append((String)localObject);
          paramIntent = paramIntent.toString();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  protected void d(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
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
  
  public void f(int paramInt)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (paramInt != localImageView.getVisibility()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_c_of_type_Int == paramInt) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDisplayMode from ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" to ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.d("ReadInJoyBaseActivity", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Int = paramInt;
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt == 0)
    {
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        super.getWindow().addFlags(67108864);
        if (this.mSystemBarComp == null) {
          this.mSystemBarComp = new SystemBarCompact(this, true, -1);
        }
        this.mSystemBarComp.init();
        if (this.jdField_c_of_type_Boolean)
        {
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
          }
          else
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
            this.mSystemBarComp.setStatusBarDarkMode(true);
          }
        }
        else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          a(true);
          this.mSystemBarComp.setStatusBarColor(-1);
        }
        else if (!SystemUtil.d())
        {
          this.mSystemBarComp.setStatusBarColor(-2368549);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-1);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-14408926);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-14408926);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849814);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849812);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
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
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
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
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849815);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849813);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-14408926);
    }
  }
  
  protected void h(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131378892)).inflate();
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
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
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      getWindow().setFeatureInt(7, 2131558946);
    }
    else
    {
      Object localObject2 = LayoutInflater.from(this);
      View localView = ((LayoutInflater)localObject2).inflate(2131560250, null);
      int i = 1;
      try
      {
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131378893));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131378881));
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, this.jdField_b_of_type_AndroidViewViewGroup, false);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject2, 0, localLayoutParams);
        super.setContentView(localView);
        this.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(this.app);
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
        getWindow().setFeatureInt(7, 2131558946);
        localObject1 = this.jdField_a_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        a(getIntent());
        return;
      }
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getIntent());
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoyNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */