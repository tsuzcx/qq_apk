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
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
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
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private ImageView D;
  private OnItemSelectListener E;
  private float a;
  private boolean b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private ImageView f;
  private TextView g;
  private LinearLayout h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private RelativeLayout v;
  private RelativeLayout w;
  private View x;
  private TextView y;
  private TextView z;
  
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
  
  private static int a(RelativeLayout.LayoutParams paramLayoutParams, String paramString)
  {
    try
    {
      paramString = ReflectionUtil.a("android.widget.RelativeLayout$LayoutParams", paramString);
      paramString.setAccessible(true);
      int i1 = paramString.getInt(paramLayoutParams);
      return i1;
    }
    catch (Throwable paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131624580, this);
    this.a = paramContext.getResources().getDisplayMetrics().density;
    this.b = ThemeUtil.isDefaultOrDIYTheme(false);
    this.c = ((TextView)findViewById(2131436180));
    this.d = ((TextView)findViewById(2131436218));
    this.e = ((LinearLayout)findViewById(2131437136));
    this.f = ((ImageView)findViewById(2131436666));
    this.g = ((TextView)findViewById(2131448219));
    this.h = ((LinearLayout)findViewById(2131447534));
    this.i = ((ImageView)findViewById(2131432290));
    this.j = ((ImageView)findViewById(2131432291));
    if (AppSetting.e)
    {
      this.i.setContentDescription(paramContext.getResources().getString(2131892649));
      this.j.setContentDescription(paramContext.getResources().getString(2131892649));
    }
    this.k = ((ImageView)findViewById(2131447511));
    this.l = ((ImageView)findViewById(2131447516));
    this.m = ((ImageView)findViewById(2131447512));
    this.n = ((ImageView)findViewById(2131447513));
    this.o = ((ImageView)findViewById(2131447514));
    this.q = ((TextView)findViewById(2131431971));
    this.r = ((TextView)findViewById(2131447463));
    this.s = ((TextView)findViewById(2131447572));
    this.t = ((TextView)findViewById(2131447573));
    this.u = ((RelativeLayout)findViewById(2131436236));
    this.v = ((RelativeLayout)findViewById(2131444906));
    this.w = ((RelativeLayout)findViewById(2131444904));
    this.x = findViewById(2131446540);
    this.y = ((TextView)findViewById(2131448238));
    this.z = ((TextView)findViewById(2131448237));
    this.A = ((ImageView)findViewById(2131436189));
    this.B = ((ImageView)findViewById(2131436194));
    this.D = ((ImageView)findViewById(2131444531));
    this.C = ((ImageView)findViewById(2131444532));
    setNotDefaultThemeBackground();
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
      int i1 = 0;
      while (i1 < paramView.getChildCount())
      {
        a(paramView.getChildAt(i1));
        i1 += 1;
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
  
  private void a(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, ImageView paramImageView)
  {
    if ((paramMutualMarkForDisplayInfo != null) && (paramMutualMarkForDisplayInfo.c()))
    {
      Object localObject2 = new ColorDrawable(0);
      Object localObject1;
      if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.s))
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramMutualMarkForDisplayInfo.r))
        {
          paramMutualMarkForDisplayInfo.r = paramMutualMarkForDisplayInfo.s;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new MutualMarkIconProxyDrawable(getContext(), paramMutualMarkForDisplayInfo.q);
      }
      if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.r))
      {
        RelationVipHelper.a(getResources(), paramImageView, paramMutualMarkForDisplayInfo.r, (Drawable)localObject1);
      }
      else
      {
        paramImageView.setImageDrawable(null);
        localObject2 = paramImageView.getLayoutParams();
        if (((Drawable)localObject1).getIntrinsicWidth() > 0) {
          ((ViewGroup.LayoutParams)localObject2).width = ((Drawable)localObject1).getIntrinsicWidth();
        } else {
          ((ViewGroup.LayoutParams)localObject2).width = -2;
        }
        paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramImageView.setImageDrawable((Drawable)localObject1);
      }
      paramImageView.setAlpha(paramMutualMarkForDisplayInfo.d());
      paramImageView.setContentDescription(paramMutualMarkForDisplayInfo.o);
      paramImageView.setVisibility(0);
      float f1 = this.a;
      AIOUtils.a(paramImageView, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  private void f()
  {
    Object localObject = this.c;
    boolean bool = this.b;
    int i3 = 8;
    int i2 = 0;
    if (!bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    e();
    localObject = this.f;
    if (!this.b) {
      i1 = i3;
    } else {
      i1 = 0;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
    int i1 = AIOUtils.b(46.0F, getResources());
    Resources localResources = getResources();
    float f2 = 41.0F;
    i3 = AIOUtils.b(41.0F, localResources);
    if ((!this.b) && (this.z.getVisibility() != 0)) {
      ((RelativeLayout.LayoutParams)localObject).width = i3;
    } else {
      ((RelativeLayout.LayoutParams)localObject).width = i1;
    }
    this.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.v;
    double d1;
    if (!this.b) {
      d1 = 4.0D;
    } else {
      d1 = 2.5D;
    }
    double d2 = this.a;
    Double.isNaN(d2);
    ((RelativeLayout)localObject).setPadding((int)(d1 * d2 + 0.5D), 0, 0, 0);
    localObject = (RelativeLayout.LayoutParams)this.B.getLayoutParams();
    if (!this.b) {
      f1 = 0.0F;
    } else {
      f1 = 12.5F;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f1, getResources());
    this.B.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.w.getLayoutParams();
    if (!this.b) {
      f1 = f2;
    } else {
      f1 = 36.0F;
    }
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(f1, getResources());
    this.w.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.w;
    bool = this.b;
    f2 = 6.0F;
    if (!bool) {
      f1 = 8.0F;
    } else {
      f1 = 6.0F;
    }
    ((RelativeLayout)localObject).setPadding(AIOUtils.b(f1, getResources()), 0, 0, 0);
    localObject = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
    float f1 = f2;
    if (!this.b) {
      f1 = 4.0F;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f1, getResources());
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
    if (QQTheme.isNowSimpleUI()) {
      i1 = i2;
    } else {
      i1 = -1;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(14, i1);
    this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g()
  {
    a(this);
  }
  
  private int getLeftRegionWidth()
  {
    int i4 = getChildCount();
    int i1 = -2147483647;
    int i2 = 0;
    int i3;
    while (i2 < i4)
    {
      View localView = getChildAt(i2);
      i3 = i1;
      if (localView.getVisibility() != 8) {
        if ((QQTheme.isNowSimpleUI()) && (localView == this.x))
        {
          i3 = i1;
        }
        else
        {
          Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          int i5 = a((RelativeLayout.LayoutParams)localObject, "mLeft");
          int i6 = a((RelativeLayout.LayoutParams)localObject, "mRight");
          int i7 = getMeasuredWidth() / 2;
          i3 = i1;
          if (i5 < i7)
          {
            i3 = i1;
            if (i6 < i7)
            {
              i1 = Math.max(i1, i6);
              i3 = i1;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("getLeftRegionWidth() called left max = ");
                ((StringBuilder)localObject).append(i1);
                ((StringBuilder)localObject).append(" left child ");
                ((StringBuilder)localObject).append(localView);
                QLog.d("NavBarAIO", 2, ((StringBuilder)localObject).toString());
                i3 = i1;
              }
            }
          }
        }
      }
      i2 += 1;
      i1 = i3;
    }
    i2 = i1;
    if (QQTheme.isNowSimpleUI())
    {
      i4 = a((RelativeLayout.LayoutParams)this.c.getLayoutParams(), "mRight");
      i2 = i1;
      if (i4 == i1)
      {
        i2 = i1;
        if (TextUtils.isEmpty(this.c.getText())) {
          if (this.d.getVisibility() == 0)
          {
            i3 = a((RelativeLayout.LayoutParams)this.d.getLayoutParams(), "mRight");
            i2 = i1;
            if (i3 < i4) {
              i2 = i3;
            }
          }
          else
          {
            i2 = ViewUtils.dip2px(35.0F);
          }
        }
      }
      i2 += ViewUtils.dip2px(9.0F);
    }
    return i2;
  }
  
  private int getRightRegionWidth()
  {
    int i3 = getMeasuredWidth() / 2;
    int i4 = getChildCount();
    int i1 = 0;
    while (i1 < i4)
    {
      View localView = getChildAt(i1);
      int i2 = i3;
      if (localView.getVisibility() != 8) {
        if ((QQTheme.isNowSimpleUI()) && (localView == this.x))
        {
          i2 = i3;
        }
        else
        {
          Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          int i5 = a((RelativeLayout.LayoutParams)localObject, "mLeft");
          int i6 = a((RelativeLayout.LayoutParams)localObject, "mRight");
          int i7 = getMeasuredWidth() / 2;
          i2 = i3;
          if (i5 > i7)
          {
            i2 = i3;
            if (i6 > i7)
            {
              i3 = Math.min(i3, getMeasuredWidth() - i5);
              i2 = i3;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("getRightRegionWidth() called right max = ");
                ((StringBuilder)localObject).append(i3);
                ((StringBuilder)localObject).append(" right child ");
                ((StringBuilder)localObject).append(localView);
                QLog.d("NavBarAIO", 2, ((StringBuilder)localObject).toString());
                i2 = i3;
              }
            }
          }
        }
      }
      i1 += 1;
      i3 = i2;
    }
    return i3;
  }
  
  public void a()
  {
    if (this.p != null) {
      return;
    }
    if (this.o == null) {
      return;
    }
    this.p = new CommonImageView(getContext());
    this.p.setId(2131447515);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.p.setVisibility(8);
    localObject = (ViewGroup)this.o.getParent();
    int i1 = ((ViewGroup)localObject).indexOfChild(this.o);
    ((ViewGroup)localObject).addView(this.p, i1 + 1);
  }
  
  public void a(int paramInt)
  {
    this.A.setImageResource(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b) {
      paramInt1 = paramInt2;
    }
    a(paramInt1);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramSessionInfo.b;
    if (!this.b)
    {
      Object localObject = getResources();
      int i1 = 2131167990;
      localObject = ((Resources)localObject).getColorStateList(2131167990);
      if (QQTheme.isNowSimpleUI()) {
        i1 = 2131168194;
      }
      ColorStateList localColorStateList = getResources().getColorStateList(i1);
      if (!AnonymousChatHelper.a().a(paramSessionInfo))
      {
        this.q.setTextColor((ColorStateList)localObject);
        this.r.setTextColor((ColorStateList)localObject);
        this.s.setTextColor(localColorStateList);
        this.d.setTextColor(localColorStateList);
      }
      if (SimpleModeHelper.b())
      {
        SimpleModeHelper.a(this.d, localColorStateList);
      }
      else
      {
        paramSessionInfo = (GradientDrawable)this.d.getBackground();
        if (paramSessionInfo != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            paramSessionInfo.setColor((ColorStateList)localObject);
          } else {
            paramSessionInfo.setColor(((ColorStateList)localObject).getDefaultColor());
          }
          paramSessionInfo.setAlpha(46);
        }
      }
      this.g.setVisibility(8);
    }
    else
    {
      if (!AnonymousChatHelper.a().a(paramSessionInfo))
      {
        paramSessionInfo = getResources().getColorStateList(2131167991);
        this.q.setTextColor(paramSessionInfo);
        this.r.setTextColor(paramSessionInfo);
        this.s.setTextColor(paramSessionInfo);
      }
      if (!TextUtils.isEmpty(this.g.getText())) {
        this.g.setVisibility(0);
      } else {
        this.g.setVisibility(8);
      }
    }
    paramSessionInfo = this.r;
    boolean bool = QQTheme.isNowSimpleUI();
    float f2 = 16.0F;
    float f1;
    if (bool) {
      f1 = 16.0F;
    } else {
      f1 = 17.0F;
    }
    paramSessionInfo.setTextSize(1, f1);
    paramSessionInfo = this.q;
    if (QQTheme.isNowSimpleUI()) {
      f1 = f2;
    } else {
      f1 = 17.0F;
    }
    paramSessionInfo.setTextSize(1, f1);
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.D;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
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
  
  @Deprecated
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = AIOUtils.b(6.0F, getResources());
    } else {
      i1 = -2;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
    if (paramBoolean)
    {
      localLayoutParams.addRule(7, 2131436189);
      localLayoutParams.addRule(6, 2131436189);
      i1 = -AIOUtils.b(3.0F, getResources());
      localLayoutParams.rightMargin = i1;
      localLayoutParams.leftMargin = i1;
    }
    else
    {
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = AIOUtils.b(4.0F, getResources());
      localLayoutParams.topMargin = AIOUtils.b(8.0F, getResources());
    }
    this.D.setLayoutParams(localLayoutParams);
  }
  
  @Deprecated
  public void c() {}
  
  public void d()
  {
    this.b = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.b)
    {
      setNotDefaultThemeBackground();
      return;
    }
    setBackgroundResource(2130852229);
  }
  
  public void e()
  {
    if (this.b)
    {
      this.d.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.d.getText()))
    {
      this.d.setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.c.getText()))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public View getSubTitleLayout()
  {
    return this.x;
  }
  
  public TextView getSubTitleText()
  {
    return this.s;
  }
  
  public TextView getSubTitleText2()
  {
    return this.t;
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      break;
    case 2131448238: 
      i1 = 3;
      break;
    case 2131448237: 
      i1 = 2;
      break;
    case 2131436194: 
      i1 = 4;
      break;
    case 2131436189: 
      i1 = 5;
      break;
    case 2131436180: 
    case 2131437136: 
      i1 = 1;
    }
    if (i1 != 0)
    {
      OnItemSelectListener localOnItemSelectListener = this.E;
      if (localOnItemSelectListener != null) {
        localOnItemSelectListener.onItemSelect(paramView, i1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    g();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = 0;
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getLeftRegionWidth();
    int i1 = getRightRegionWidth();
    paramInt2 = getMeasuredWidth() - paramInt1 - i1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure() called with: leftRegionWidth = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], rightRegionWidth = [");
      localStringBuilder.append(i1);
      localStringBuilder.append("] middleRegionWidth = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d("NavBarAIO", 2, localStringBuilder.toString());
    }
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = i1;
    localLayoutParams.topMargin = (((int)getResources().getDimension(2131299920) - this.h.getMeasuredHeight() - this.x.getMeasuredHeight()) / 2);
    i1 = localLayoutParams.topMargin + this.h.getMeasuredHeight();
    this.h.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    a(localLayoutParams, paramInt1, localLayoutParams.topMargin, paramInt2 + paramInt1, i1);
    localLayoutParams = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
    a(localLayoutParams, "mTop", i1);
    a(localLayoutParams, "mBottom", i1 + this.x.getMeasuredHeight());
    if (!QQTheme.isNowSimpleUI()) {
      paramInt1 = localLayoutParams.leftMargin;
    }
    localLayoutParams.leftMargin = paramInt1;
  }
  
  public void setEarIconVisible(boolean paramBoolean)
  {
    boolean bool = QQTheme.isNowSimpleUI();
    int i2 = 0;
    int i1 = 0;
    if (bool)
    {
      localImageView = this.j;
      if (!paramBoolean) {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
      this.i.setVisibility(8);
      return;
    }
    ImageView localImageView = this.i;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
    this.j.setVisibility(8);
  }
  
  public void setIsDefaultTheme(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setLeftContentDescription(String paramString)
  {
    this.e.setContentDescription(paramString);
    this.c.setContentDescription(paramString);
  }
  
  public void setNotDefaultThemeBackground()
  {
    if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
    {
      setBackgroundColor(0);
      return;
    }
    setBackgroundResource(2130852228);
  }
  
  public void setOnSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.E = paramOnItemSelectListener;
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
  }
  
  public void setRight1(String paramString)
  {
    this.z.setText(paramString);
    this.z.setContentDescription(paramString);
    this.z.setVisibility(0);
    this.B.setVisibility(8);
    AIOUtils.a(this.z, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.B.setVisibility(0);
    this.B.setImageResource(paramInt);
    this.z.setVisibility(8);
    AIOUtils.a(this.B, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt1, int paramInt2)
  {
    if (this.b) {
      paramInt1 = paramInt2;
    }
    setRight1Icon(paramInt1);
  }
  
  public void setRight1Icon(Drawable paramDrawable)
  {
    this.B.setVisibility(0);
    this.B.setImageDrawable(paramDrawable);
    this.z.setVisibility(8);
    AIOUtils.a(this.B, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(8.0F, getResources()));
  }
  
  public void setRight2(String paramString)
  {
    this.y.setText(paramString);
    this.y.setContentDescription(paramString);
    this.y.setVisibility(0);
    this.A.setVisibility(8);
    AIOUtils.a(this.y, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(8.0F, getResources()), AIOUtils.b(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt)
  {
    this.A.setVisibility(0);
    this.A.setImageResource(paramInt);
    this.y.setVisibility(8);
    AIOUtils.a(this.A, AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()), AIOUtils.b(8.0F, getResources()), AIOUtils.b(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt1, int paramInt2)
  {
    if (this.b) {
      paramInt1 = paramInt2;
    }
    setRight2Icon(paramInt1);
  }
  
  public void setRightIcon1Desc(String paramString)
  {
    this.B.setContentDescription(paramString);
  }
  
  public void setRightIcon2Desc(String paramString)
  {
    this.A.setContentDescription(paramString);
  }
  
  public void setRightRootVisibility(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.u;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void setRightToStr(String paramString, View.OnClickListener paramOnClickListener)
  {
    setRight1(paramString);
    this.B.setBackgroundDrawable(null);
    this.B.setImageDrawable(null);
    this.z.setSingleLine();
    this.z.setTextSize(1, 17.0F);
    this.z.setTextColor(getResources().getColor(2131167990));
    this.z.setOnClickListener(paramOnClickListener);
    this.w.setVisibility(8);
    this.C.setVisibility(8);
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("fight_Text is setRightToStr and rw =  ");
      paramString.append(this.u.getMeasuredWidth());
      QLog.d("NavBarAIO", 4, paramString.toString());
    }
  }
  
  public void setTitleIcon(int paramInt)
  {
    this.k.setImageResource(paramInt);
    this.l.setImageResource(paramInt);
  }
  
  public void setTitleIconLeft()
  {
    this.k.setImageResource(0);
    this.l.setImageResource(0);
    this.k.setVisibility(8);
    this.l.setVisibility(8);
    this.m.setImageResource(0);
    this.n.setImageResource(0);
    this.m.setVisibility(8);
    this.n.setVisibility(8);
  }
  
  public void setTitleIconLeftForMutualMark(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo2)
  {
    a(paramMutualMarkForDisplayInfo1, this.k);
    a(paramMutualMarkForDisplayInfo1, this.l);
    a(paramMutualMarkForDisplayInfo2, this.m);
    a(paramMutualMarkForDisplayInfo2, this.n);
    if (QQTheme.isNowSimpleUI())
    {
      this.k.setVisibility(8);
      this.m.setVisibility(8);
      return;
    }
    this.l.setVisibility(8);
    this.n.setVisibility(8);
  }
  
  public void setTitleIconRight(String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      VipUtils.a(getResources(), this.o, paramString, localDrawable);
    }
    if (paramInt == 0)
    {
      this.o.setVisibility(8);
      return;
    }
    this.o.setVisibility(0);
    paramString = this.o;
    float f1 = this.a;
    AIOUtils.a(paramString, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */