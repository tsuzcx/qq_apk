package com.tencent.mobileqq.widget.navbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;

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
  private OnItemSelectListener jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener;
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
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
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
    int i1 = getChildCount();
    int n = -2147483647;
    int k = 0;
    while (k < i1)
    {
      View localView = getChildAt(k);
      int m = n;
      if (localView.getVisibility() != 8)
      {
        Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int i2 = a((RelativeLayout.LayoutParams)localObject, "mLeft");
        int i3 = a((RelativeLayout.LayoutParams)localObject, "mRight");
        int i4 = getMeasuredWidth() / 2;
        m = n;
        if (i2 < i4)
        {
          m = n;
          if (i3 < i4)
          {
            n = Math.max(n, i3);
            m = n;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getLeftRegionWidth() called left max = ");
              ((StringBuilder)localObject).append(n);
              ((StringBuilder)localObject).append(" left child ");
              ((StringBuilder)localObject).append(localView);
              QLog.d("NavBarAIO", 2, ((StringBuilder)localObject).toString());
              m = n;
            }
          }
        }
      }
      k += 1;
      n = m;
    }
    return n;
  }
  
  private static int a(RelativeLayout.LayoutParams paramLayoutParams, String paramString)
  {
    try
    {
      paramString = ReflectionUtil.a("android.widget.RelativeLayout$LayoutParams", paramString);
      paramString.setAccessible(true);
      int k = paramString.getInt(paramLayoutParams);
      return k;
    }
    catch (Throwable paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131558947, this);
    setBackgroundResource(2130850433);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369240));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369985));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369563));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379476));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378837));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366019));
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131694922));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378828));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378829));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378830));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365729));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378872));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378873));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369258));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376645));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376643));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378040);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379491));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379490));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369211));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.j = ((ImageView)findViewById(2131376320));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376321));
  }
  
  private static void a(View paramView)
  {
    if ((paramView.getVisibility() == 4) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printInvisibleView() called with: view = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("]");
      QLog.d("NavBarAIO", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRelativeLayoutLayoutParamsDimension() called with: lp = [");
      localStringBuilder.append(paramLayoutParams);
      localStringBuilder.append("], l = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], t = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], r = [");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], b = [");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("]");
      QLog.d("NavBarAIO", 2, localStringBuilder.toString());
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
      paramString = ReflectionUtil.a("android.widget.RelativeLayout$LayoutParams", paramString);
      paramString.setAccessible(true);
      paramString.set(paramLayoutParams, Integer.valueOf(paramInt));
      return;
    }
    catch (Throwable paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  private int b()
  {
    int n = getMeasuredWidth() / 2;
    int i1 = getChildCount();
    int k = 0;
    while (k < i1)
    {
      View localView = getChildAt(k);
      int m = n;
      if (localView.getVisibility() != 8)
      {
        Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int i2 = a((RelativeLayout.LayoutParams)localObject, "mLeft");
        int i3 = a((RelativeLayout.LayoutParams)localObject, "mRight");
        int i4 = getMeasuredWidth() / 2;
        m = n;
        if (i2 > i4)
        {
          m = n;
          if (i3 > i4)
          {
            n = Math.min(n, getMeasuredWidth() - i2);
            m = n;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getRightRegionWidth() called right max = ");
              ((StringBuilder)localObject).append(n);
              ((StringBuilder)localObject).append(" right child ");
              ((StringBuilder)localObject).append(localView);
              QLog.d("NavBarAIO", 2, ((StringBuilder)localObject).toString());
              m = n;
            }
          }
        }
      }
      k += 1;
      n = m;
    }
    return n;
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool = this.jdField_a_of_type_Boolean;
    int m = 8;
    if (!bool) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    e();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (!this.jdField_a_of_type_Boolean) {
      k = m;
    } else {
      k = 0;
    }
    ((ImageView)localObject).setVisibility(k);
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int k = AIOUtils.b(46.0F, getResources());
    Resources localResources = getResources();
    float f2 = 41.0F;
    m = AIOUtils.b(41.0F, localResources);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_i_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      ((RelativeLayout.LayoutParams)localObject).width = m;
    } else {
      ((RelativeLayout.LayoutParams)localObject).width = k;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    double d1;
    if (!this.jdField_a_of_type_Boolean) {
      d1 = 4.0D;
    } else {
      d1 = 2.5D;
    }
    double d2 = this.jdField_a_of_type_Float;
    Double.isNaN(d2);
    ((RelativeLayout)localObject).setPadding((int)(d1 * d2 + 0.5D), 0, 0, 0);
    localObject = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    if (!this.jdField_a_of_type_Boolean) {
      f1 = 0.0F;
    } else {
      f1 = 12.5F;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f1, getResources());
    this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (!this.jdField_a_of_type_Boolean) {
      f1 = f2;
    } else {
      f1 = 36.0F;
    }
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(f1, getResources());
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
    bool = this.jdField_a_of_type_Boolean;
    f2 = 6.0F;
    if (!bool) {
      f1 = 8.0F;
    } else {
      f1 = 6.0F;
    }
    ((RelativeLayout)localObject).setPadding(AIOUtils.b(f1, getResources()), 0, 0, 0);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
    float f1 = f2;
    if (!this.jdField_a_of_type_Boolean) {
      f1 = 4.0F;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f1, getResources());
    this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g()
  {
    a(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
      return;
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView = new CommonImageView(getContext());
    this.jdField_f_of_type_AndroidWidgetImageView.setId(2131378831);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
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
    if (this.jdField_a_of_type_Boolean) {
      paramInt1 = paramInt2;
    }
    a(paramInt1);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    Object localObject = paramSessionInfo.a;
    if (!this.jdField_a_of_type_Boolean)
    {
      paramSessionInfo = getResources().getColorStateList(2131167053);
      if (!AnonymousChatHelper.a().a((String)localObject))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      }
      localObject = (GradientDrawable)this.jdField_b_of_type_AndroidWidgetTextView.getBackground();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          ((GradientDrawable)localObject).setColor(paramSessionInfo);
        } else {
          ((GradientDrawable)localObject).setColor(paramSessionInfo.getDefaultColor());
        }
        ((GradientDrawable)localObject).setAlpha(46);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      if (!AnonymousChatHelper.a().a((String)localObject))
      {
        paramSessionInfo = getResources().getColorStateList(2131167054);
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
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_i_of_type_AndroidWidgetImageView;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localImageView.setVisibility(k);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      setEarIconVisible(paramBoolean);
      return;
    }
    if ((paramInt != 1) && (paramInt != 3000))
    {
      setEarIconVisible(false);
      return;
    }
    setEarIconVisible(paramBoolean);
  }
  
  public TextView b()
  {
    return this.jdField_g_of_type_AndroidWidgetTextView;
  }
  
  @Deprecated
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView = this.j;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localImageView.setVisibility(k);
  }
  
  @Deprecated
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = AIOUtils.b(6.0F, getResources());
    } else {
      k = -2;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    if (paramBoolean)
    {
      localLayoutParams.addRule(7, 2131369211);
      localLayoutParams.addRule(6, 2131369211);
      k = -AIOUtils.b(3.0F, getResources());
      localLayoutParams.rightMargin = k;
      localLayoutParams.leftMargin = k;
    }
    else
    {
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = AIOUtils.b(4.0F, getResources());
      localLayoutParams.topMargin = AIOUtils.b(8.0F, getResources());
    }
    this.j.setLayoutParams(localLayoutParams);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.jdField_a_of_type_Boolean)
    {
      setBackgroundResource(2130850433);
      return;
    }
    setBackgroundResource(2130850434);
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
    int k;
    switch (paramView.getId())
    {
    default: 
      k = 0;
      break;
    case 2131379491: 
      k = 3;
      break;
    case 2131379490: 
      k = 2;
      break;
    case 2131369216: 
      k = 4;
      break;
    case 2131369211: 
      k = 5;
      break;
    case 2131369202: 
    case 2131369985: 
      k = 1;
    }
    if (k != 0)
    {
      OnItemSelectListener localOnItemSelectListener = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener;
      if (localOnItemSelectListener != null) {
        localOnItemSelectListener.onItemSelect(paramView, k);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure() called with: leftRegionWidth = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], rightRegionWidth = [");
      localStringBuilder.append(k);
      localStringBuilder.append("] middleRegionWidth = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d("NavBarAIO", 2, localStringBuilder.toString());
    }
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = k;
    localLayoutParams.topMargin = (((int)getResources().getDimension(2131299168) - this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) / 2);
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
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localImageView.setVisibility(k);
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
  
  public void setOnSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener = paramOnItemSelectListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void setRight1(String paramString)
  {
    this.jdField_i_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    AIOUtils.a(this.jdField_i_of_type_AndroidWidgetTextView, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    AIOUtils.a(this.jdField_h_of_type_AndroidWidgetImageView, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt1 = paramInt2;
    }
    setRight1Icon(paramInt1);
  }
  
  public void setRight1Icon(Drawable paramDrawable)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    AIOUtils.a(this.jdField_h_of_type_AndroidWidgetImageView, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight2(String paramString)
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    AIOUtils.a(this.jdField_h_of_type_AndroidWidgetTextView, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(8.0F, getResources()), AIOUtils.b(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    AIOUtils.a(this.jdField_g_of_type_AndroidWidgetImageView, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(8.0F, getResources()), AIOUtils.b(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt1 = paramInt2;
    }
    setRight2Icon(paramInt1);
  }
  
  public void setRightIcon1Desc(String paramString)
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightIcon2Desc(String paramString)
  {
    this.jdField_g_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightRootVisibility(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void setRightToStr(String paramString, View.OnClickListener paramOnClickListener)
  {
    setRight1(paramString);
    this.jdField_h_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_i_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167053));
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(8);
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("fight_Text is setRightToStr and rw =  ");
      paramString.append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth());
      QLog.d("NavBarAIO", 4, paramString.toString());
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
    int k;
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (paramInt1 != 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (k != m) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k == 0) && ((this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) || (paramInt2 == 0))) {}
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt1);
    if (paramInt1 == 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      f1 = this.jdField_a_of_type_Float;
      AIOUtils.a(localImageView, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt2);
    if (paramInt2 == 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    float f1 = this.jdField_a_of_type_Float;
    AIOUtils.a(localImageView, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
  }
  
  public void setTitleIconLeftForMutualMark(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo2)
  {
    ImageView[] arrayOfImageView = new ImageView[2];
    arrayOfImageView[0] = this.jdField_c_of_type_AndroidWidgetImageView;
    arrayOfImageView[1] = this.jdField_d_of_type_AndroidWidgetImageView;
    int k = 0;
    while (k < arrayOfImageView.length)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = new MutualMarkForDisplayInfo[] { paramMutualMarkForDisplayInfo1, paramMutualMarkForDisplayInfo2 }[k];
      ImageView localImageView = arrayOfImageView[k];
      localImageView.getVisibility();
      if ((localMutualMarkForDisplayInfo != null) && (localMutualMarkForDisplayInfo.c()))
      {
        Object localObject2 = new ColorDrawable(0);
        Object localObject1;
        if (!TextUtils.isEmpty(localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString))
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty(localMutualMarkForDisplayInfo.b))
          {
            localMutualMarkForDisplayInfo.b = localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString;
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = new MutualMarkIconProxyDrawable(getContext(), localMutualMarkForDisplayInfo.jdField_c_of_type_Int);
        }
        if (!TextUtils.isEmpty(localMutualMarkForDisplayInfo.b))
        {
          RelationVipHelper.a(getResources(), localImageView, localMutualMarkForDisplayInfo.b, (Drawable)localObject1);
        }
        else
        {
          localImageView.setImageDrawable(null);
          localObject2 = localImageView.getLayoutParams();
          if (((Drawable)localObject1).getIntrinsicWidth() > 0) {
            ((ViewGroup.LayoutParams)localObject2).width = ((Drawable)localObject1).getIntrinsicWidth();
          } else {
            ((ViewGroup.LayoutParams)localObject2).width = -2;
          }
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        localImageView.setAlpha(localMutualMarkForDisplayInfo.a());
        localImageView.setContentDescription(localMutualMarkForDisplayInfo.a);
        localImageView.setVisibility(0);
        float f1 = this.jdField_a_of_type_Float;
        AIOUtils.a(localImageView, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
      }
      else
      {
        localImageView.setVisibility(8);
      }
      localImageView.getVisibility();
      k += 1;
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
    paramString = this.jdField_e_of_type_AndroidWidgetImageView;
    float f1 = this.jdField_a_of_type_Float;
    AIOUtils.a(paramString, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */