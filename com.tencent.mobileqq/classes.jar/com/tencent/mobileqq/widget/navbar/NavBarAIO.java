package com.tencent.mobileqq.widget.navbar;

import aciy;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asbd;
import asbe;
import asbt;
import asbx;
import bajr;
import bbpt;
import bbpu;
import bbpv;
import bbpw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.qphone.base.util.QLog;
import mnf;

public class NavBarAIO
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  asbe jdField_a_of_type_Asbe = new bbpu(this);
  private bbpw jdField_a_of_type_Bbpw;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  
  public NavBarAIO(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a()
  {
    int m = 0;
    int n = 0;
    int i1 = (int)(10.0F * this.jdField_a_of_type_Float + 0.5F);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        n = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + (int)(5.0F * this.jdField_a_of_type_Float + 0.5F) + i1;
      }
      m = n;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        str = String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        m = (int)(this.jdField_a_of_type_Float * 16.0F + 0.5F);
        m = Math.max(n, (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(str) + m + (int)(28.0F * this.jdField_a_of_type_Float + 0.5F));
      }
    }
    for (;;)
    {
      n = m;
      if (m > 0) {
        n = m + i1;
      }
      return n;
      n = m;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        n = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth() + (int)(this.jdField_a_of_type_Float * 16.0F + 0.5F);
      }
      m = n;
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        str = String.valueOf(this.jdField_c_of_type_AndroidWidgetTextView.getText());
        m = (int)(this.jdField_a_of_type_Float * 16.0F + 0.5F);
        m = n + ((int)this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText(str) + m + (int)(2.0F * this.jdField_a_of_type_Float + 0.5F));
      }
    }
  }
  
  private View a()
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return this.jdField_b_of_type_AndroidWidgetImageView;
    }
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return this.jdField_c_of_type_AndroidWidgetImageView;
    }
    if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return this.jdField_d_of_type_AndroidWidgetImageView;
    }
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131493316, this);
    setBackgroundResource(2130848801);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302839));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303471));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303102));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312188));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131311586));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299865));
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131629518));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311576));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311577));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311578));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299666));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311534));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311618));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131302856));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309585));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309583));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131310824);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312204));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312203));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302811));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302816));
    this.j = ((ImageView)findViewById(2131309284));
    this.i = ((ImageView)findViewById(2131309285));
    this.k = ((ImageView)findViewById(2131299829));
  }
  
  private int b()
  {
    int m = 4;
    int i2 = 0;
    int n;
    if (this.jdField_g_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      int i1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth();
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        n = (int)(m * this.jdField_a_of_type_Float + 0.5F);
        m = i1 + 0;
        i1 = m;
        if (this.jdField_h_of_type_AndroidWidgetImageView.getVisibility() == 0) {
          i1 = m + this.jdField_b_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth();
        }
        m = i2;
        if (i1 > 0) {
          m = i1 + n;
        }
        return m;
        m = 2;
      }
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      n = (int)(m * this.jdField_a_of_type_Float + 0.5F);
      m = 0;
      break;
      m = 6;
    }
  }
  
  private View b()
  {
    if ((this.jdField_e_of_type_AndroidWidgetImageView != null) && (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return this.jdField_e_of_type_AndroidWidgetImageView;
    }
    if ((this.jdField_f_of_type_AndroidWidgetImageView != null) && (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return this.jdField_f_of_type_AndroidWidgetImageView;
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      return this.jdField_d_of_type_AndroidWidgetTextView;
    }
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  private int c()
  {
    int m;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      n = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredWidth();
      m = n;
      if (n <= 0) {
        m = aciy.a(21.0F, getResources());
      }
    }
    for (int n = m + 0;; n = 0)
    {
      m = n;
      ViewGroup.LayoutParams localLayoutParams;
      int i1;
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        m = n;
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          m = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
          localLayoutParams = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
          if (localLayoutParams.width > 0) {
            m = localLayoutParams.width;
          }
          i1 = m;
          if (m <= 0) {
            i1 = aciy.a(21.0F, getResources());
          }
          m = n + i1;
        }
      }
      n = m;
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        n = m;
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          n = this.jdField_d_of_type_AndroidWidgetImageView.getMeasuredWidth();
          localLayoutParams = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
          if (localLayoutParams.width > 0) {
            n = localLayoutParams.width;
          }
          i1 = n;
          if (n <= 0) {
            i1 = aciy.a(21.0F, getResources());
          }
          n = m + i1;
        }
      }
      m = n;
      if (n > 0) {
        m = n + aciy.a(3.0F, getResources());
      }
      return m;
    }
  }
  
  private void c(int paramInt)
  {
    int n = 0;
    if (this.k.getVisibility() == 0) {}
    for (int m = this.k.getMeasuredWidth();; m = 0)
    {
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        n = this.jdField_f_of_type_AndroidWidgetTextView.getMeasuredWidth();
      }
      if (m + 0 + n > paramInt)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.width = paramInt;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  private int d()
  {
    int m;
    if ((this.jdField_e_of_type_AndroidWidgetImageView != null) && (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      n = this.jdField_e_of_type_AndroidWidgetImageView.getMeasuredWidth();
      m = n;
      if (n <= 0) {
        m = aciy.a(27.0F, getResources());
      }
    }
    for (int n = m + 0;; n = 0)
    {
      m = n;
      if (n > 0) {
        m = n + aciy.a(3.0F, getResources());
      }
      n = m;
      if (this.jdField_f_of_type_AndroidWidgetImageView != null)
      {
        n = m;
        if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          int i1 = this.jdField_f_of_type_AndroidWidgetImageView.getMeasuredWidth();
          n = i1;
          if (i1 <= 0) {
            n = aciy.a(27.0F, getResources());
          }
          n = m + n;
        }
      }
      m = n;
      if (n > 0) {
        m = n + aciy.a(3.0F, getResources());
      }
      return m;
    }
  }
  
  private void f()
  {
    int n = 8;
    float f2 = 6.0F;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int m;
    label53:
    label120:
    double d1;
    if (!this.jdField_a_of_type_Boolean)
    {
      m = 0;
      ((TextView)localObject).setVisibility(m);
      e();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean) {
        break label343;
      }
      m = n;
      ((ImageView)localObject).setVisibility(m);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      m = aciy.a(46.0F, getResources());
      n = aciy.a(41.0F, getResources());
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label349;
      }
      ((RelativeLayout.LayoutParams)localObject).width = m;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_Boolean) {
        break label359;
      }
      d1 = 4.0D;
      label146:
      ((RelativeLayout)localObject).setPadding((int)(d1 * this.jdField_a_of_type_Float + 0.5D), 0, 0, 0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
      if (this.jdField_a_of_type_Boolean) {
        break label366;
      }
      f1 = 0.0F;
      label187:
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aciy.a(f1, getResources());
      this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (this.jdField_a_of_type_Boolean) {
        break label373;
      }
      f1 = 41.0F;
      label232:
      ((RelativeLayout.LayoutParams)localObject).width = aciy.a(f1, getResources());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_Boolean) {
        break label380;
      }
    }
    label343:
    label349:
    label359:
    label366:
    label373:
    label380:
    for (float f1 = 8.0F;; f1 = 6.0F)
    {
      ((RelativeLayout)localObject).setPadding(aciy.a(f1, getResources()), 0, 0, 0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
      f1 = f2;
      if (!this.jdField_a_of_type_Boolean) {
        f1 = 4.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aciy.a(f1, getResources());
      this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      m = 8;
      break;
      m = 0;
      break label53;
      ((RelativeLayout.LayoutParams)localObject).width = n;
      break label120;
      d1 = 2.5D;
      break label146;
      f1 = 12.5F;
      break label187;
      f1 = 36.0F;
      break label232;
    }
  }
  
  private void g()
  {
    int m = aciy.a(3.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = 0;
        if ((this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0) || (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          break label305;
        }
        localLayoutParams.rightMargin = m;
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = 0;
        if ((this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) || (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          break label313;
        }
        localLayoutParams.rightMargin = m;
      }
    }
    label129:
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = 0;
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label321;
        }
        localLayoutParams.rightMargin = m;
      }
    }
    label171:
    if (this.jdField_e_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.rightMargin = 0;
      }
    }
    if (this.jdField_f_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.rightMargin = 0;
        if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label329;
        }
      }
    }
    label305:
    label313:
    label321:
    label329:
    for (localLayoutParams.leftMargin = m;; localLayoutParams.leftMargin = 0)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.rightMargin = 0;
          localLayoutParams.leftMargin = 0;
        }
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.rightMargin = 0;
          localLayoutParams.leftMargin = 0;
        }
      }
      return;
      localLayoutParams.rightMargin = 0;
      break;
      localLayoutParams.rightMargin = 0;
      break label129;
      localLayoutParams.rightMargin = 0;
      break label171;
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.postDelayed(new NavBarAIO.4(this), 200L);
    }
  }
  
  public void a()
  {
    if (this.jdField_f_of_type_AndroidWidgetImageView != null) {}
    while (this.jdField_e_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView = new CommonImageView(getContext());
    this.jdField_f_of_type_AndroidWidgetImageView.setId(2131311579);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = aciy.a(5.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = (ViewGroup)this.jdField_e_of_type_AndroidWidgetImageView.getParent();
    int m = ((ViewGroup)localObject).indexOfChild(this.jdField_e_of_type_AndroidWidgetImageView);
    ((ViewGroup)localObject).addView(this.jdField_f_of_type_AndroidWidgetImageView, m + 1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    Object localObject = paramSessionInfo.a;
    if (!this.jdField_a_of_type_Boolean)
    {
      paramSessionInfo = getResources().getColorStateList(2131101257);
      if (!mnf.a().a((String)localObject))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      }
      localObject = (GradientDrawable)this.jdField_b_of_type_AndroidWidgetTextView.getBackground();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          ((GradientDrawable)localObject).setColor(paramSessionInfo);
          ((GradientDrawable)localObject).setAlpha(46);
        }
      }
      else {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      f();
      return;
      ((GradientDrawable)localObject).setColor(paramSessionInfo.getDefaultColor());
      break;
      if (!mnf.a().a((String)localObject))
      {
        paramSessionInfo = getResources().getColorStateList(2131101258);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.j;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localImageView.setVisibility(m);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 0)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        bool1 = true;
        if (bool1 == paramBoolean) {
          break label46;
        }
      }
      label46:
      for (bool1 = bool2;; bool1 = false)
      {
        setEarIconVisible(paramBoolean);
        c(bool1);
        return;
        bool1 = false;
        break;
      }
    }
    if ((paramInt == 1) || (paramInt == 3000))
    {
      setEarIconVisible(paramBoolean);
      c();
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        bool1 = true;
        if (bool1 == paramBoolean) {
          break label103;
        }
      }
      label103:
      for (paramBoolean = bool3;; paramBoolean = false)
      {
        c(paramBoolean);
        return;
        bool1 = false;
        break;
      }
    }
    setEarIconVisible(false);
  }
  
  public void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1 = a();
    int i2 = b();
    int m = (int)(3.0F * this.jdField_a_of_type_Float + 0.5F);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    int n;
    if ((i1 > 0) && (i2 > 0)) {
      if ((i2 > i1) && (localLayoutParams.leftMargin != i2))
      {
        m += i1;
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Int = (i2 - i1);
        n = m;
      }
    }
    for (;;)
    {
      c(getResources().getDisplayMetrics().widthPixels - Math.max(n, m) * 2);
      if (QLog.isDevelopLevel()) {
        QLog.d("NavBarAIO", 4, "adjustTitleDimension lp.leftMargin:" + localLayoutParams.leftMargin + " leftMargin:" + n + " lp.rightMargin:" + localLayoutParams.rightMargin + " rightMargin:" + m + " lw:" + i1 + " rw:" + i2);
      }
      if ((n != localLayoutParams.leftMargin) || (m != localLayoutParams.rightMargin))
      {
        localLayoutParams.setMargins(n, 0, m, 0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        h();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("NavBarAIO", 4, "fight_Text is adjustTitleDimension and lw =  " + i1 + " rw = " + i2);
      }
      return;
      m += i2;
      this.jdField_a_of_type_Int = (i1 - i2);
      this.jdField_b_of_type_Int = 0;
      n = m;
      continue;
      n = (int)(105.0F * this.jdField_a_of_type_Float + 0.5F);
      m = (int)(91.0F * this.jdField_a_of_type_Float + 0.5F);
      getViewTreeObserver().addOnGlobalLayoutListener(new bbpt(this, i2, i1));
    }
  }
  
  public void b(int paramInt)
  {
    int n = 0;
    g();
    int i4 = c();
    int i5 = d();
    Object localObject;
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText())) {
        localObject = "";
      }
    }
    for (int i2 = (int)(this.jdField_d_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject) + 0.5F);; i2 = 0)
    {
      label89:
      int i3;
      int i1;
      int i6;
      int m;
      if (TextUtils.isEmpty(this.jdField_e_of_type_AndroidWidgetTextView.getText()))
      {
        localObject = "";
        i3 = (int)(this.jdField_e_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject) + i2 + 0.5F);
        i1 = this.jdField_a_of_type_Int + i4;
        i6 = i5 + this.jdField_b_of_type_Int;
        m = paramInt - Math.max(i1, i6) * 2;
        if (m <= i3) {
          break label408;
        }
        if (i4 <= i5) {
          break label398;
        }
        i1 = 0;
        n = i4 - i5;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NavBarAIO", 2, "adjustTitleTextMaxWidth titleLayoutWidth:" + paramInt + " maxTitleTextWidth:" + m + " leftItemsWidth:" + i4 + " rightItemsWidth:" + i5 + " mLeftMarginExtraOccupy:" + this.jdField_a_of_type_Int + " mRightMarginExtraOccupy:" + this.jdField_b_of_type_Int + " titleCountWidth:" + i2);
        }
        if (i1 > 0)
        {
          localObject = (LinearLayout.LayoutParams)a().getLayoutParams();
          if (localObject != null) {
            ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
          }
        }
        if (n > 0)
        {
          localObject = (LinearLayout.LayoutParams)b().getLayoutParams();
          if (localObject != null) {
            ((LinearLayout.LayoutParams)localObject).rightMargin = n;
          }
        }
        n = (int)(3.0F * this.jdField_e_of_type_AndroidWidgetTextView.getTextSize() + 0.5F) + i2;
        paramInt = m;
        if (m < n) {
          paramInt = n;
        }
        if (paramInt > 0) {
          this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(paramInt - i2);
        }
        return;
        localObject = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
        break;
        localObject = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
        break label89;
        label398:
        i1 = i5 - i4;
        continue;
        label408:
        m = paramInt - i1 - i6;
        if (m > i3)
        {
          if (i1 > i6) {
            n = this.jdField_a_of_type_Int;
          }
          for (m = m - i3 + this.jdField_b_of_type_Int;; m = this.jdField_b_of_type_Int)
          {
            i1 = n;
            n = m;
            m = i3;
            break;
            n = this.jdField_a_of_type_Int + (m - i3);
          }
        }
        i1 = this.jdField_a_of_type_Int;
        n = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int m;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      m = aciy.a(6.0F, getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(m, m);
      if (!paramBoolean) {
        break label81;
      }
      localLayoutParams.addRule(7, 2131302811);
      localLayoutParams.addRule(6, 2131302811);
      m = -aciy.a(3.0F, getResources());
      localLayoutParams.rightMargin = m;
      localLayoutParams.leftMargin = m;
    }
    for (;;)
    {
      this.j.setLayoutParams(localLayoutParams);
      return;
      m = -2;
      break;
      label81:
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = aciy.a(4.0F, getResources());
      localLayoutParams.topMargin = aciy.a(8.0F, getResources());
    }
  }
  
  public void c()
  {
    b();
  }
  
  public void c(boolean paramBoolean)
  {
    int m = this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
    if (QLog.isColorLevel()) {
      QLog.i("NavBarAIO", 2, "adjustTitleTextMaxWidth titleWidth:" + m);
    }
    if (m == 0)
    {
      int n;
      LinearLayout.LayoutParams localLayoutParams;
      if (paramBoolean)
      {
        g();
        m = c();
        n = d();
        if (m <= n) {
          break label112;
        }
        localLayoutParams = (LinearLayout.LayoutParams)b().getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.rightMargin = (m - n);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new bbpv(this));
        return;
        label112:
        if (n > m)
        {
          localLayoutParams = (LinearLayout.LayoutParams)a().getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.leftMargin = (n - m);
          }
        }
      }
    }
    b(m);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.jdField_a_of_type_Boolean)
    {
      setBackgroundResource(2130848801);
      return;
    }
    setBackgroundResource(2130848802);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    int m = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((m != 0) && (this.jdField_a_of_type_Bbpw != null)) {
        this.jdField_a_of_type_Bbpw.a(paramView, m);
      }
      return;
      m = 1;
      continue;
      m = 3;
      continue;
      m = 2;
      continue;
      m = 5;
      continue;
      m = 4;
    }
  }
  
  public void setEarIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localImageView.setVisibility(m);
      return;
    }
  }
  
  public void setIsDefaultTheme(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLeftContentDescription(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
  }
  
  public void setOnSelectListener(bbpw parambbpw)
  {
    this.jdField_a_of_type_Bbpw = parambbpw;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void setRight1(String paramString)
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    aciy.a(this.jdField_h_of_type_AndroidWidgetTextView, aciy.a(7.0F, getResources()), aciy.a(7.0F, getResources()), aciy.a(4.0F, getResources()), aciy.a(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    aciy.a(this.jdField_h_of_type_AndroidWidgetImageView, aciy.a(7.0F, getResources()), aciy.a(7.0F, getResources()), aciy.a(4.0F, getResources()), aciy.a(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      setRight1Icon(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setRight1Icon(Drawable paramDrawable)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    aciy.a(this.jdField_h_of_type_AndroidWidgetImageView, aciy.a(7.0F, getResources()), aciy.a(7.0F, getResources()), aciy.a(4.0F, getResources()), aciy.a(8.0F, getResources()));
  }
  
  public void setRight2(String paramString)
  {
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    aciy.a(this.jdField_g_of_type_AndroidWidgetTextView, aciy.a(7.0F, getResources()), aciy.a(7.0F, getResources()), aciy.a(8.0F, getResources()), aciy.a(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    aciy.a(this.jdField_g_of_type_AndroidWidgetImageView, aciy.a(7.0F, getResources()), aciy.a(7.0F, getResources()), aciy.a(8.0F, getResources()), aciy.a(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      setRight2Icon(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setRightIcon1Desc(String paramString)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightIcon2Desc(String paramString)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightToStr(String paramString, View.OnClickListener paramOnClickListener)
  {
    setRight1(paramString);
    this.jdField_h_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101257));
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.i.setVisibility(8);
    if (QLog.isDevelopLevel()) {
      QLog.d("NavBarAIO", 4, "fight_Text is setRightToStr and rw =  " + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth());
    }
  }
  
  public void setTitleIcon(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setTitleIconLeft(int paramInt)
  {
    setTitleIconLeft(paramInt, 0);
  }
  
  public void setTitleIconLeft(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int m;
    int n;
    label22:
    label30:
    boolean bool1;
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      m = 1;
      if (paramInt1 == 0) {
        break label121;
      }
      n = 1;
      if (m == n) {
        break label127;
      }
      m = 1;
      bool1 = bool2;
      if (m == 0)
      {
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label132;
        }
        m = 1;
        label50:
        if (paramInt2 == 0) {
          break label137;
        }
        n = 1;
        label57:
        if (m == n) {
          break label143;
        }
        bool1 = bool2;
      }
      label67:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt1);
      if (paramInt1 != 0) {
        break label149;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      label88:
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt2);
      if (paramInt2 != 0) {
        break label211;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      c(bool1);
      return;
      m = 0;
      break;
      label121:
      n = 0;
      break label22;
      label127:
      m = 0;
      break label30;
      label132:
      m = 0;
      break label50;
      label137:
      n = 0;
      break label57;
      label143:
      bool1 = false;
      break label67;
      label149:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      aciy.a(this.jdField_c_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
      break label88;
      label211:
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      aciy.a(this.jdField_d_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
    }
  }
  
  public void setTitleIconLeftForMutualMark(asbx paramasbx1, asbx paramasbx2)
  {
    ImageView[] arrayOfImageView = new ImageView[2];
    arrayOfImageView[0] = this.jdField_c_of_type_AndroidWidgetImageView;
    arrayOfImageView[1] = this.jdField_d_of_type_AndroidWidgetImageView;
    boolean bool = false;
    int m = 0;
    if (m < arrayOfImageView.length)
    {
      asbx localasbx = new asbx[] { paramasbx1, paramasbx2 }[m];
      ImageView localImageView = arrayOfImageView[m];
      int n = localImageView.getVisibility();
      asbd localasbd;
      if ((localasbx != null) && (localasbx.d())) {
        if (!TextUtils.isEmpty(localasbx.jdField_c_of_type_JavaLangString))
        {
          localasbd = new asbd(getContext(), localasbx.jdField_c_of_type_JavaLangString);
          label105:
          if (TextUtils.isEmpty(localasbx.b)) {
            break label248;
          }
          asbt.a(getResources(), localImageView, localasbx.b, localasbd);
          localImageView.setAlpha(localasbx.a());
          localImageView.setContentDescription(localasbx.a);
          localImageView.setVisibility(0);
          aciy.a(localImageView, (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), (int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
        }
      }
      for (;;)
      {
        if (n != localImageView.getVisibility()) {
          bool = true;
        }
        m += 1;
        break;
        localasbd = new asbd(getContext(), localasbx.jdField_c_of_type_Int);
        break label105;
        label248:
        localImageView.setImageDrawable(null);
        localasbd.a(this.jdField_a_of_type_Asbe);
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        if (localasbd.getIntrinsicWidth() > 0) {}
        for (localLayoutParams.width = localasbd.getIntrinsicWidth();; localLayoutParams.width = -2)
        {
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setImageDrawable(localasbd);
          break;
        }
        localImageView.setVisibility(8);
      }
    }
    c(bool);
  }
  
  public void setTitleIconRight(String paramString, int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      bajr.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramString, localDrawable);
    }
    int m;
    int n;
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      m = 1;
      if (paramInt == 0) {
        break label81;
      }
      n = 1;
      label50:
      if (m == n) {
        break label87;
      }
      label56:
      if (paramInt != 0) {
        break label93;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      c(bool);
      return;
      m = 0;
      break;
      label81:
      n = 0;
      break label50;
      label87:
      bool = false;
      break label56;
      label93:
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      aciy.a(this.jdField_e_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */