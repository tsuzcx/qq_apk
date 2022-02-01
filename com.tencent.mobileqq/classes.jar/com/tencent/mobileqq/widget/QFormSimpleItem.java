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
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.QMultiImageTextView;

public class QFormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  protected static boolean b;
  protected int a;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Drawable a;
  protected TextView a;
  protected QMultiImageTextView a;
  protected CharSequence a;
  protected boolean a;
  protected Drawable b;
  private CharSequence b;
  private Drawable c;
  protected boolean c;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  
  public QFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131296766);
    double d = getResources().getDisplayMetrics().density * 35.0F;
    Double.isNaN(d);
    this.q = ((int)(d + 0.5D));
    d = getResources().getDisplayMetrics().density * 15.0F;
    Double.isNaN(d);
    this.r = ((int)(d + 0.5D));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839270);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_U_of_type_ArrayOfInt);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.p = paramContext.getDimensionPixelSize(R.styleable.P, getResources().getDimensionPixelSize(2131298275));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.o = paramContext.getDimensionPixelSize(R.styleable.O, i1);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(R.styleable.V);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.m = paramContext.getInt(R.styleable.W, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(R.styleable.S);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.k = paramContext.getDimensionPixelSize(R.styleable.jdField_U_of_type_Int, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = paramContext.getDimensionPixelSize(R.styleable.T, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = Math.min(this.o, this.l);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(R.styleable.ac);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.h = paramContext.getInt(R.styleable.ad, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(R.styleable.Z);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.ab, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.g = paramContext.getDimensionPixelSize(R.styleable.aa, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.g = Math.min(this.o, this.g);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.ae, false);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.n = paramContext.getInt(R.styleable.N, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        jdField_b_of_type_Boolean = paramContext.getBoolean(R.styleable.X, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_c_of_type_Boolean = paramContext.getBoolean(R.styleable.Y, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        FormResHelper.a(jdField_b_of_type_Boolean);
        if (paramContext == null) {
          break label505;
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
      label493:
      break label493;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label505:
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
    b();
  }
  
  private boolean a()
  {
    return QQTheme.b();
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
  
  public QMultiImageTextView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView;
  }
  
  protected void a()
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i1 = this.p;
    i2 -= i1 * 2;
    Object localObject = this.jdField_a_of_type_JavaLangCharSequence;
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
      this.j = (i2 - i1);
      this.i = 0;
      return;
    }
    int i6 = i2 - i1;
    localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      i2 = this.k;
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
    localObject = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    CharSequence localCharSequence = this.jdField_b_of_type_JavaLangCharSequence;
    if (localCharSequence != null) {
      i1 += (int)((Paint)localObject).measureText(localCharSequence.toString());
    } else {
      i1 = 0;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      i3 = this.jdField_a_of_type_Int;
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
    localObject = this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.getPaint();
    localObject = new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    int i7 = ((StaticLayout)localObject).getLineCount();
    int i4 = 0;
    i2 = i5;
    while (i2 < i7)
    {
      i4 = (int)((StaticLayout)localObject).getLineWidth(i2) + (int)((StaticLayout)localObject).getLineWidth(i2);
      i2 += 1;
    }
    i4 = i3 + i4 + this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.getPaddingLeft();
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
    this.j = i2;
    this.i = i3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  protected void b()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367173);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.k, this.l);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    i1 = this.p;
    localLayoutParams.leftMargin = i1;
    if (!this.jdField_c_of_type_Boolean)
    {
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      setMinimumHeight(this.o);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.j);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView = new QMultiImageTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setId(2131367175);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
    i1 = getContext().getResources().getDimensionPixelSize(2131296773);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextSize(0, i1);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setGravity(19);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView, localLayoutParams);
    c();
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView == null) {
      return;
    }
    a();
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setMaxWidth(this.j);
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setMaxWidth(this.i);
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_Int > 0) && (this.g > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.g);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
      {
        i1 = this.jdField_a_of_type_Int;
        if (i1 > 0)
        {
          i2 = this.g;
          if (i2 > 0)
          {
            ((Drawable)localObject).setBounds(0, 0, i1, i2);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
            break label425;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        label425:
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        int i5 = this.jdField_a_of_type_Int;
        if (i5 > 0)
        {
          int i6 = this.g;
          if (i6 > 0)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i5, i6);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
            break label709;
          }
        }
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        label709:
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        i1 = this.jdField_a_of_type_Int;
        if (i1 > 0)
        {
          i2 = this.g;
          if (i2 > 0)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i2);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
            break label801;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        label801:
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i4);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(8);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.n;
    if ((i1 == 1) || (i1 == 2))
    {
      if (a()) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      }
      i1 = getMeasuredWidth();
      int i2 = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, i2 - jdField_b_of_type_Int, i1, i2);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.o);
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
    this.n = paramInt;
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_c_of_type_Boolean))
    {
      this.o = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.o)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.o);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.k = paramInt1;
        this.l = Math.min(this.o, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.l);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
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
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
        localTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_b_of_type_JavaLangCharSequence != null)
    {
      this.m = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
        localTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
      this.jdField_a_of_type_Int = paramInt1;
      this.g = Math.min(this.o, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      c();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    c();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    QMultiImageTextView localQMultiImageTextView = this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView;
    if (localQMultiImageTextView != null)
    {
      this.h = paramInt;
      localQMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */