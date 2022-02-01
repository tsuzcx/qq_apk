package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.MultiImageTextView;

public class FormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  protected static boolean b;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Drawable a;
  protected MultiImageTextView a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  protected Drawable b;
  private Drawable c;
  protected boolean c;
  protected TextView d;
  protected CharSequence d;
  private int g;
  private int h;
  private int i;
  private int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  private int p;
  private int q;
  private int r;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131296766);
    double d1 = getResources().getDisplayMetrics().density * 35.0F;
    Double.isNaN(d1);
    this.q = ((int)(d1 + 0.5D));
    d1 = getResources().getDisplayMetrics().density * 15.0F;
    Double.isNaN(d1);
    this.r = ((int)(d1 + 0.5D));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839270);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.p = paramContext.getDimensionPixelSize(2, getResources().getDimensionPixelSize(2131298275));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.j = paramContext.getDimensionPixelSize(1, i1);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(9);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.h = paramContext.getInt(10, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(6);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(8, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.g = paramContext.getDimensionPixelSize(7, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.g = Math.min(this.j, this.g);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(16);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.m = paramContext.getInt(17, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(13);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.k = paramContext.getDimensionPixelSize(15, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = paramContext.getDimensionPixelSize(14, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = Math.min(this.j, this.l);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_Boolean = paramContext.getBoolean(19, false);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.i = paramContext.getInt(0, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        jdField_b_of_type_Boolean = paramContext.getBoolean(11, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_c_of_type_Boolean = paramContext.getBoolean(12, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        FormResHelper.a(jdField_b_of_type_Boolean);
        if (paramContext == null) {
          break label486;
        }
      }
      finally
      {
        if (localContext2 != null) {
          localContext2.recycle();
        }
      }
    }
    catch (Throwable paramContext)
    {
      label474:
      break label474;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label486:
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
    c();
  }
  
  private boolean a()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    FormResHelper.a(paramBoolean);
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt);
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, a());
  }
  
  public TextView a()
  {
    return this.jdField_d_of_type_AndroidWidgetTextView;
  }
  
  public MultiImageTextView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView == null) {
      return;
    }
    b();
    Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setMaxWidth(this.o);
    }
    int i1;
    int i2;
    int i3;
    int i4;
    if (a())
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        i1 = ((Drawable)localObject).getIntrinsicWidth();
        i2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
      i3 = e;
      i4 = f;
    }
    else
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        i3 = ((Drawable)localObject).getIntrinsicWidth();
        i4 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
        i1 = 0;
        i2 = 0;
      }
      else
      {
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(this.jdField_d_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setContentDescription(this.jdField_d_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setMaxWidth(this.n);
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
      {
        i1 = this.k;
        if (i1 > 0)
        {
          i2 = this.l;
          if (i2 > 0)
          {
            ((Drawable)localObject).setBounds(0, 0, i1, i2);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
            break label425;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        label425:
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        int i5 = this.k;
        if (i5 > 0)
        {
          int i6 = this.l;
          if (i6 > 0)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i5, i6);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
            break label709;
          }
        }
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        label709:
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        i1 = this.k;
        if (i1 > 0)
        {
          i2 = this.l;
          if (i2 > 0)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
            break label801;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        label801:
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  protected void b()
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i1 = this.p;
    i2 -= i1 * 2;
    Object localObject = this.jdField_d_of_type_JavaLangCharSequence;
    int i5 = 0;
    if (localObject == null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        i3 = this.q;
        i1 = this.r + (i3 + i1);
      }
      else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        i1 = this.q;
      }
      else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        i1 = this.r;
      }
      else
      {
        i1 = 0;
      }
      this.o = (i2 - i1);
      this.n = 0;
      return;
    }
    int i6 = i2 - i1;
    localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      i2 = this.jdField_a_of_type_Int;
      i1 = i2;
      if (i2 == 0) {
        i1 = ((Drawable)localObject).getIntrinsicWidth();
      }
      i1 = this.p + i1;
    }
    else
    {
      i1 = 0;
    }
    localObject = this.jdField_d_of_type_AndroidWidgetTextView.getPaint();
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    if (localCharSequence != null) {
      i1 += (int)((Paint)localObject).measureText(localCharSequence.toString());
    } else {
      i1 = 0;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      i3 = this.k;
      i2 = i3;
      if (i3 == 0) {
        i2 = ((Drawable)localObject).getIntrinsicWidth();
      }
      i2 = this.p + (i2 + 0);
    }
    else
    {
      i2 = 0;
    }
    int i3 = i2;
    if (this.jdField_a_of_type_Boolean) {
      i3 = i2 + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + this.p;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaint();
    localObject = new StaticLayout(this.jdField_d_of_type_JavaLangCharSequence, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    int i7 = ((StaticLayout)localObject).getLineCount();
    int i4 = 0;
    i2 = i5;
    while (i2 < i7)
    {
      i4 = (int)((StaticLayout)localObject).getLineWidth(i2) + (int)((StaticLayout)localObject).getLineWidth(i2);
      i2 += 1;
    }
    i4 = i3 + i4 + this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaddingLeft();
    i5 = i6 / 2;
    if ((i1 >= i5) && (i4 >= i5))
    {
      i2 = i5;
      i3 = i2;
    }
    else if ((i1 > i5) && (i4 < i5))
    {
      i2 = i6 - i4;
      i3 = i4;
    }
    else
    {
      i2 = i1;
      i3 = i4;
      if (i1 < i5)
      {
        i2 = i1;
        i3 = i4;
        if (i4 > i5)
        {
          i3 = i6 - i1;
          i2 = i1;
        }
      }
    }
    this.o = i2;
    this.n = i3;
  }
  
  protected void c()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setId(2131367173);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_d_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Int, this.g);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    i1 = this.p;
    localLayoutParams.leftMargin = i1;
    if (!this.jdField_c_of_type_Boolean)
    {
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      setMinimumHeight(this.j);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(this.o);
    addView(this.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = new MultiImageTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setId(2131367175);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
    i1 = getContext().getResources().getDimensionPixelSize(2131296773);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextSize(0, i1);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setGravity(19);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView, localLayoutParams);
    a();
    setBackgroundDrawable(a(getResources(), this.i));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.i;
    if ((i1 == 1) || (i1 == 2))
    {
      if (a()) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      }
      i1 = getMeasuredWidth();
      int i2 = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(jdField_d_of_type_Int, i2 - jdField_b_of_type_Int, i1, i2);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.j);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.i = paramInt;
    setBackgroundDrawable(a(getResources(), this.i));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_c_of_type_Boolean))
    {
      this.j = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.j)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.j);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_d_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.jdField_a_of_type_Int = paramInt1;
        this.g = Math.min(this.j, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.g);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setLeftIcon(paramDrawable);
      }
    }
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        localTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.h = paramInt;
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        localTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextSize(paramFloat);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      this.k = paramInt1;
      this.l = Math.min(this.j, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      a();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_d_of_type_JavaLangCharSequence = paramCharSequence;
    a();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    MultiImageTextView localMultiImageTextView = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
    if (localMultiImageTextView != null)
    {
      this.m = paramInt;
      localMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */