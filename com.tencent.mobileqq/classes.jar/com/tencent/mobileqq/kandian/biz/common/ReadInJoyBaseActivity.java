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
  protected int a;
  protected View.OnClickListener a;
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  public RadioGroup a;
  public RelativeLayout a;
  public TextView a;
  public LeftRedDotRadioButton a;
  public RedDotRadioButton a;
  public View b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public ReadInJoyBaseActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoyBaseActivity.1(this);
  }
  
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
  
  private View c()
  {
    this.c = ((TextView)findViewById(2131369249));
    return this.c;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.d) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected ViewGroup a()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131369241));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton = ((LeftRedDotRadioButton)findViewById(2131369253));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)findViewById(2131369254));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    a(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    return this.jdField_a_of_type_AndroidWidgetRadioGroup;
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130850439));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376638));
      a(this.jdField_a_of_type_AndroidViewViewGroup);
      c();
      a();
      a();
      b();
      b(paramIntent);
    }
  }
  
  protected View b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    a(this.jdField_a_of_type_AndroidWidgetImageView);
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
            if (((String)localObject).contains(HardCodeUtil.a(2131713030))) {
              paramIntent = getString(2131690706);
            }
          }
        }
      }
      localObject = paramIntent;
      if (paramIntent == null) {
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
      this.jdField_a_of_type_Int = paramInt;
      getWindow().setFeatureInt(7, 2131558946);
    }
    else
    {
      Object localObject3 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject3).inflate(2131560204, null);
      int i = 1;
      try
      {
        localObject3 = ((LayoutInflater)localObject3).inflate(paramInt, (ViewGroup)localObject1, false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131378893));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131376638);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidViewView = ((View)localObject3);
        super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
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
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject2).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject2).toString());
        }
        super.setContentView(paramInt);
        this.jdField_a_of_type_Int = paramInt;
        getWindow().setFeatureInt(7, 2131558946);
        localObject2 = this.jdField_b_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        a(getIntent());
        return;
      }
    }
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
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
    TextView localTextView = this.c;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyBaseActivity
 * JD-Core Version:    0.7.0.1
 */