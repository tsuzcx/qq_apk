package com.tencent.mobileqq.widget.navbar;

import aepi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausp;
import autf;
import autj;
import bexc;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import nav;

public class NavBarAIO
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bexc jdField_a_of_type_Bexc;
  private boolean jdField_a_of_type_Boolean;
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
    int k = -2147483647;
    int i1 = getChildCount();
    int m = 0;
    if (m < i1)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label143;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      int n = a(localLayoutParams, "mLeft");
      int i2 = a(localLayoutParams, "mRight");
      int i3 = getMeasuredWidth() / 2;
      if ((n >= i3) || (i2 >= i3)) {
        break label143;
      }
      n = Math.max(k, i2);
      k = n;
      if (QLog.isColorLevel())
      {
        QLog.d("NavBarAIO", 2, "getLeftRegionWidth() called left max = " + n + " left child " + localView);
        k = n;
      }
    }
    label143:
    for (;;)
    {
      m += 1;
      break;
      return k;
    }
  }
  
  private static int a(RelativeLayout.LayoutParams paramLayoutParams, String paramString)
  {
    try
    {
      paramString = paramLayoutParams.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      int k = paramString.getInt(paramLayoutParams);
      return k;
    }
    catch (NoSuchFieldException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
      return 0;
    }
    catch (IllegalAccessException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131558912, this);
    setBackgroundResource(2130849536);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368662));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369389));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368979));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378616));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377989));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365530));
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131695360));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377979));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377980));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377981));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365320));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377938));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378022));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368679));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375874));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375871));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377198);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378632));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378631));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368633));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368638));
    this.j = ((ImageView)findViewById(2131375551));
    this.i = ((ImageView)findViewById(2131375552));
  }
  
  private static void a(View paramView)
  {
    if ((paramView.getVisibility() == 4) && (QLog.isColorLevel())) {
      QLog.d("NavBarAIO", 2, "printInvisibleView() called with: view = [" + paramView + "]");
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int k = 0;
      while (k < paramView.getChildCount())
      {
        a(paramView.getChildAt(k));
        k += 1;
      }
    }
  }
  
  private static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavBarAIO", 2, "setRelativeLayoutLayoutParamsDimension() called with: lp = [" + paramLayoutParams + "], l = [" + paramInt1 + "], t = [" + paramInt2 + "], r = [" + paramInt3 + "], b = [" + paramInt4 + "]");
    }
    a(paramLayoutParams, "mLeft", paramInt1);
    a(paramLayoutParams, "mTop", paramInt2);
    a(paramLayoutParams, "mRight", paramInt3);
    a(paramLayoutParams, "mBottom", paramInt4);
  }
  
  private static void a(RelativeLayout.LayoutParams paramLayoutParams, String paramString, int paramInt)
  {
    try
    {
      paramString = paramLayoutParams.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramLayoutParams, Integer.valueOf(paramInt));
      return;
    }
    catch (NoSuchFieldException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  private int b()
  {
    int k = getMeasuredWidth() / 2;
    int i1 = getChildCount();
    int m = 0;
    if (m < i1)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label153;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      int n = a(localLayoutParams, "mLeft");
      int i2 = a(localLayoutParams, "mRight");
      int i3 = getMeasuredWidth() / 2;
      if ((n <= i3) || (i2 <= i3)) {
        break label153;
      }
      n = Math.min(k, getMeasuredWidth() - n);
      k = n;
      if (QLog.isColorLevel())
      {
        QLog.d("NavBarAIO", 2, "getRightRegionWidth() called right max = " + n + " right child " + localView);
        k = n;
      }
    }
    label153:
    for (;;)
    {
      m += 1;
      break;
      return k;
    }
  }
  
  private void f()
  {
    int m = 8;
    float f2 = 6.0F;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label53:
    label120:
    double d1;
    if (!this.jdField_a_of_type_Boolean)
    {
      k = 0;
      ((TextView)localObject).setVisibility(k);
      e();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean) {
        break label343;
      }
      k = m;
      ((ImageView)localObject).setVisibility(k);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      k = aepi.a(46.0F, getResources());
      m = aepi.a(41.0F, getResources());
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label349;
      }
      ((RelativeLayout.LayoutParams)localObject).width = k;
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
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aepi.a(f1, getResources());
      this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (this.jdField_a_of_type_Boolean) {
        break label373;
      }
      f1 = 41.0F;
      label232:
      ((RelativeLayout.LayoutParams)localObject).width = aepi.a(f1, getResources());
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
      ((RelativeLayout)localObject).setPadding(aepi.a(f1, getResources()), 0, 0, 0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
      f1 = f2;
      if (!this.jdField_a_of_type_Boolean) {
        f1 = 4.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aepi.a(f1, getResources());
      this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      k = 8;
      break;
      k = 0;
      break label53;
      ((RelativeLayout.LayoutParams)localObject).width = m;
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
    a(this);
  }
  
  public void a()
  {
    if (this.jdField_f_of_type_AndroidWidgetImageView != null) {}
    while (this.jdField_e_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView = new CommonImageView(getContext());
    this.jdField_f_of_type_AndroidWidgetImageView.setId(2131377982);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(5.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = (ViewGroup)this.jdField_e_of_type_AndroidWidgetImageView.getParent();
    int k = ((ViewGroup)localObject).indexOfChild(this.jdField_e_of_type_AndroidWidgetImageView);
    ((ViewGroup)localObject).addView(this.jdField_f_of_type_AndroidWidgetImageView, k + 1);
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
      paramSessionInfo = getResources().getColorStateList(2131166900);
      if (!nav.a().a((String)localObject))
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
      if (!nav.a().a((String)localObject))
      {
        paramSessionInfo = getResources().getColorStateList(2131166901);
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
    for (int k = 0;; k = 8)
    {
      localImageView.setVisibility(k);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      setEarIconVisible(paramBoolean);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3000))
    {
      setEarIconVisible(paramBoolean);
      return;
    }
    setEarIconVisible(false);
  }
  
  @Deprecated
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    int k;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      k = aepi.a(6.0F, getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      if (!paramBoolean) {
        break label82;
      }
      localLayoutParams.addRule(7, 2131368633);
      localLayoutParams.addRule(6, 2131368633);
      k = -aepi.a(3.0F, getResources());
      localLayoutParams.rightMargin = k;
      localLayoutParams.leftMargin = k;
    }
    for (;;)
    {
      this.j.setLayoutParams(localLayoutParams);
      return;
      k = -2;
      break;
      label82:
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = aepi.a(4.0F, getResources());
      localLayoutParams.topMargin = aepi.a(8.0F, getResources());
    }
  }
  
  @Deprecated
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.jdField_a_of_type_Boolean)
    {
      setBackgroundResource(2130849536);
      return;
    }
    setBackgroundResource(2130849537);
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
    int k = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((k != 0) && (this.jdField_a_of_type_Bexc != null)) {
        this.jdField_a_of_type_Bexc.a(paramView, k);
      }
      return;
      k = 1;
      continue;
      k = 3;
      continue;
      k = 2;
      continue;
      k = 5;
      continue;
      k = 4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    g();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = 0;
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = a();
    int k = b();
    paramInt2 = getMeasuredWidth() - paramInt1 - k;
    if (QLog.isColorLevel()) {
      QLog.d("NavBarAIO", 2, "onMeasure() called with: leftRegionWidth = [" + paramInt1 + "], rightRegionWidth = [" + k + "] middleRegionWidth = [" + paramInt2 + "]");
    }
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = k;
    localLayoutParams.topMargin = (((int)getResources().getDimension(2131298914) - this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) / 2);
    k = localLayoutParams.topMargin + this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    a(localLayoutParams, paramInt1, localLayoutParams.topMargin, paramInt2 + paramInt1, k);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    a(localLayoutParams, "mTop", k);
    a(localLayoutParams, "mBottom", k + this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
  }
  
  public void setEarIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int k = 0;; k = 8)
    {
      localImageView.setVisibility(k);
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
  
  public void setOnSelectListener(bexc parambexc)
  {
    this.jdField_a_of_type_Bexc = parambexc;
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
    aepi.a(this.jdField_h_of_type_AndroidWidgetTextView, aepi.a(7.0F, getResources()), aepi.a(7.0F, getResources()), aepi.a(4.0F, getResources()), aepi.a(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    aepi.a(this.jdField_h_of_type_AndroidWidgetImageView, aepi.a(7.0F, getResources()), aepi.a(7.0F, getResources()), aepi.a(4.0F, getResources()), aepi.a(8.0F, getResources()));
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
    aepi.a(this.jdField_h_of_type_AndroidWidgetImageView, aepi.a(7.0F, getResources()), aepi.a(7.0F, getResources()), aepi.a(4.0F, getResources()), aepi.a(8.0F, getResources()));
  }
  
  public void setRight2(String paramString)
  {
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    aepi.a(this.jdField_g_of_type_AndroidWidgetTextView, aepi.a(7.0F, getResources()), aepi.a(7.0F, getResources()), aepi.a(8.0F, getResources()), aepi.a(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    aepi.a(this.jdField_g_of_type_AndroidWidgetImageView, aepi.a(7.0F, getResources()), aepi.a(7.0F, getResources()), aepi.a(8.0F, getResources()), aepi.a(4.0F, getResources()));
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
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166900));
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
    int n = 1;
    int k;
    int m;
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      k = 1;
      if (paramInt1 == 0) {
        break label108;
      }
      m = 1;
      label22:
      if (k == m) {
        break label114;
      }
      k = 1;
      label30:
      if (k == 0)
      {
        if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label119;
        }
        k = 1;
        label46:
        if (paramInt2 == 0) {
          break label124;
        }
        m = n;
        label54:
        if (k == m) {}
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt1);
      if (paramInt1 != 0) {
        break label130;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt2);
      if (paramInt2 != 0) {
        break label200;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      k = 0;
      break;
      label108:
      m = 0;
      break label22;
      label114:
      k = 0;
      break label30;
      label119:
      k = 0;
      break label46;
      label124:
      m = 0;
      break label54;
      label130:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      aepi.a(this.jdField_c_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
    }
    label200:
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    aepi.a(this.jdField_d_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
  }
  
  public void setTitleIconLeftForMutualMark(autj paramautj1, autj paramautj2)
  {
    ImageView[] arrayOfImageView = new ImageView[2];
    arrayOfImageView[0] = this.jdField_c_of_type_AndroidWidgetImageView;
    arrayOfImageView[1] = this.jdField_d_of_type_AndroidWidgetImageView;
    int k = 0;
    if (k < arrayOfImageView.length)
    {
      autj localautj = new autj[] { paramautj1, paramautj2 }[k];
      ImageView localImageView = arrayOfImageView[k];
      int m = localImageView.getVisibility();
      ausp localausp;
      if ((localautj != null) && (localautj.d())) {
        if (!TextUtils.isEmpty(localautj.jdField_c_of_type_JavaLangString))
        {
          localausp = new ausp(getContext(), localautj.jdField_c_of_type_JavaLangString);
          label102:
          if (TextUtils.isEmpty(localautj.b)) {
            break label250;
          }
          autf.a(getResources(), localImageView, localautj.b, localausp);
          localImageView.setAlpha(localautj.a());
          localImageView.setContentDescription(localautj.a);
          localImageView.setVisibility(0);
          aepi.a(localImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
        }
      }
      for (;;)
      {
        if (m != localImageView.getVisibility()) {}
        k += 1;
        break;
        localausp = new ausp(getContext(), localautj.jdField_c_of_type_Int);
        break label102;
        label250:
        localImageView.setImageDrawable(null);
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        if (localausp.getIntrinsicWidth() > 0) {}
        for (localLayoutParams.width = localausp.getIntrinsicWidth();; localLayoutParams.width = -2)
        {
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setImageDrawable(localausp);
          break;
        }
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void setTitleIconRight(String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      VipUtils.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramString, localDrawable);
    }
    if (paramInt == 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    aepi.a(this.jdField_e_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */