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
  protected static boolean A;
  protected boolean B;
  protected TextView C;
  protected MultiImageTextView D;
  protected int E;
  protected int F;
  private CharSequence a;
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int l;
  private int m;
  private final Rect n = new Rect();
  private final Paint o = new Paint();
  private int p;
  private int q;
  protected CharSequence t;
  protected Drawable u;
  protected int v;
  protected int w;
  protected int x;
  protected boolean y;
  protected Drawable z;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131297097);
    double d1 = getResources().getDisplayMetrics().density * 35.0F;
    Double.isNaN(d1);
    this.p = ((int)(d1 + 0.5D));
    d1 = getResources().getDisplayMetrics().density * 15.0F;
    Double.isNaN(d1);
    this.q = ((int)(d1 + 0.5D));
    this.z = getResources().getDrawable(2130839446);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.m = paramContext.getDimensionPixelSize(2, getResources().getDimensionPixelSize(2131298976));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = paramContext.getDimensionPixelSize(1, i);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.a = paramContext.getString(9);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.e = paramContext.getInt(10, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.b = paramContext.getDrawable(6);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.c = paramContext.getDimensionPixelSize(8, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.d = paramContext.getDimensionPixelSize(7, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.d = Math.min(this.l, this.d);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.t = paramContext.getString(16);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.x = paramContext.getInt(17, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.u = paramContext.getDrawable(13);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.v = paramContext.getDimensionPixelSize(15, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.w = paramContext.getDimensionPixelSize(14, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.w = Math.min(this.l, this.w);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.y = paramContext.getBoolean(19, false);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.f = paramContext.getInt(0, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        A = paramContext.getBoolean(11, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.B = paramContext.getBoolean(12, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        FormResHelper.a(A);
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
    this.o.setAntiAlias(true);
    this.o.setColor(h);
    d();
  }
  
  private boolean b()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    A = paramBoolean;
    FormResHelper.a(paramBoolean);
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt);
  }
  
  protected void a()
  {
    if (this.D == null) {
      return;
    }
    c();
    Object localObject = this.C;
    if (localObject != null) {
      ((TextView)localObject).setMaxWidth(this.F);
    }
    int i;
    int j;
    int k;
    int i1;
    if (b())
    {
      localObject = this.u;
      if (localObject != null)
      {
        i = ((Drawable)localObject).getIntrinsicWidth();
        j = this.u.getIntrinsicHeight();
      }
      else
      {
        i = 0;
        j = 0;
      }
      k = j;
      i1 = k;
    }
    else
    {
      localObject = this.z;
      if (localObject != null)
      {
        k = ((Drawable)localObject).getIntrinsicWidth();
        i1 = this.z.getIntrinsicHeight();
        i = 0;
        j = 0;
      }
      else
      {
        i = 0;
        j = 0;
        k = 0;
        i1 = 0;
      }
    }
    if (!TextUtils.isEmpty(this.t))
    {
      this.D.setVisibility(0);
      this.D.setText(this.t);
      this.D.setTextColor(a(getResources(), this.x));
      this.D.setContentDescription(this.t);
      this.D.setMaxWidth(this.E);
      if ((this.u != null) && (this.y))
      {
        if ((this.v > 0) && (this.w > 0))
        {
          this.z.setBounds(0, 0, k, i1);
          this.u.setBounds(0, 0, this.v, this.w);
          this.D.setCompoundDrawables(this.u, null, this.z, null);
        }
        else if (b())
        {
          this.z.setBounds(0, 0, k, i1);
          this.u.setBounds(0, 0, i, j);
          this.D.setCompoundDrawables(this.u, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, this.z, null);
        }
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      localObject = this.u;
      if ((localObject != null) && (!this.y))
      {
        i = this.v;
        if (i > 0)
        {
          j = this.w;
          if (j > 0)
          {
            ((Drawable)localObject).setBounds(0, 0, i, j);
            this.D.setCompoundDrawables(this.u, null, null, null);
            break label425;
          }
        }
        this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, null, null);
        label425:
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u == null) && (this.y))
      {
        if (b())
        {
          this.z.setBounds(0, 0, k, i1);
          this.D.setCompoundDrawables(null, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, this.z, null);
        }
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u == null) && (!this.y))
      {
        this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.D.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.D.setText("");
      if ((this.u != null) && (this.y))
      {
        this.D.setVisibility(0);
        int i2 = this.v;
        if (i2 > 0)
        {
          int i3 = this.w;
          if (i3 > 0)
          {
            this.u.setBounds(0, 0, i2, i3);
            this.z.setBounds(0, 0, k, i1);
            this.D.setCompoundDrawables(this.u, null, this.z, null);
            break label709;
          }
        }
        if (b())
        {
          this.z.setBounds(0, 0, k, i1);
          this.u.setBounds(0, 0, i, j);
          this.D.setCompoundDrawables(this.u, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, this.z, null);
        }
        label709:
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u != null) && (!this.y))
      {
        this.D.setVisibility(0);
        i = this.v;
        if (i > 0)
        {
          j = this.w;
          if (j > 0)
          {
            this.u.setBounds(0, 0, i, j);
            this.D.setCompoundDrawables(this.u, null, null, null);
            break label801;
          }
        }
        this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, null, null);
        label801:
        this.D.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.u == null) && (this.y))
      {
        this.D.setVisibility(0);
        if (b())
        {
          this.z.setBounds(0, 0, k, i1);
          this.D.setCompoundDrawables(null, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, this.z, null);
        }
        this.D.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.u == null) && (!this.y)) {
        this.D.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
    a();
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, b());
  }
  
  protected void c()
  {
    int j = getResources().getDisplayMetrics().widthPixels;
    int i = this.m;
    j -= i * 2;
    Object localObject = this.t;
    int i2 = 0;
    if (localObject == null)
    {
      if ((this.u != null) && (this.y))
      {
        k = this.p;
        i = this.q + (k + i);
      }
      else if ((this.u != null) && (!this.y))
      {
        i = this.p;
      }
      else if ((this.u == null) && (this.y))
      {
        i = this.q;
      }
      else
      {
        i = 0;
      }
      this.F = (j - i);
      this.E = 0;
      return;
    }
    int i3 = j - i;
    localObject = this.b;
    if (localObject != null)
    {
      j = this.c;
      i = j;
      if (j == 0) {
        i = ((Drawable)localObject).getIntrinsicWidth();
      }
      i = this.m + i;
    }
    else
    {
      i = 0;
    }
    localObject = this.C.getPaint();
    CharSequence localCharSequence = this.a;
    if (localCharSequence != null) {
      i += (int)((Paint)localObject).measureText(localCharSequence.toString());
    } else {
      i = 0;
    }
    localObject = this.u;
    if (localObject != null)
    {
      k = this.v;
      j = k;
      if (k == 0) {
        j = ((Drawable)localObject).getIntrinsicWidth();
      }
      j = this.m + (j + 0);
    }
    else
    {
      j = 0;
    }
    int k = j;
    if (this.y) {
      k = j + this.z.getIntrinsicWidth() + this.m;
    }
    localObject = this.D.getPaint();
    localObject = new StaticLayout(this.t, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    int i4 = ((StaticLayout)localObject).getLineCount();
    int i1 = 0;
    j = i2;
    while (j < i4)
    {
      i1 = (int)((StaticLayout)localObject).getLineWidth(j) + (int)((StaticLayout)localObject).getLineWidth(j);
      j += 1;
    }
    i1 = k + i1 + this.D.getPaddingLeft();
    i2 = i3 / 2;
    if ((i >= i2) && (i1 >= i2))
    {
      j = i2;
      k = j;
    }
    else if ((i > i2) && (i1 < i2))
    {
      j = i3 - i1;
      k = i1;
    }
    else
    {
      j = i;
      k = i1;
      if (i < i2)
      {
        j = i;
        k = i1;
        if (i1 > i2)
        {
          k = i3 - i;
          j = i;
        }
      }
    }
    this.F = j;
    this.E = k;
  }
  
  protected void d()
  {
    setFocusable(true);
    setClickable(true);
    this.C = new TextView(getContext());
    if (!TextUtils.isEmpty(this.a))
    {
      this.C.setText(this.a);
      this.C.setContentDescription(this.a);
    }
    this.C.setId(2131433629);
    if (this.B)
    {
      this.C.setSingleLine(true);
      this.C.setEllipsize(TextUtils.TruncateAt.END);
      this.C.setDuplicateParentStateEnabled(true);
    }
    this.C.setTextColor(a(getResources(), this.e));
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.C.setTextSize(0, i);
    this.C.setGravity(19);
    setLeftIcon(this.b, this.c, this.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    i = this.m;
    localLayoutParams.leftMargin = i;
    if (!this.B)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      setMinimumHeight(this.l);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.C.setMaxWidth(this.F);
    addView(this.C, localLayoutParams);
    this.D = new MultiImageTextView(getContext());
    this.D.setId(2131433631);
    this.D.setSingleLine(true);
    this.D.setTextColor(a(getResources(), this.x));
    i = getContext().getResources().getDimensionPixelSize(2131297104);
    this.D.setTextSize(0, i);
    this.D.setGravity(19);
    this.D.setEllipsize(TextUtils.TruncateAt.END);
    this.D.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.m;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.D, localLayoutParams);
    a();
    setBackgroundDrawable(b(getResources(), this.f));
  }
  
  public TextView getLeftTextView()
  {
    return this.C;
  }
  
  public Drawable getRightIcon()
  {
    return this.u;
  }
  
  public MultiImageTextView getRightTextView()
  {
    return this.D;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.f;
    if ((i == 1) || (i == 2))
    {
      if (b()) {
        this.o.setColor(h);
      } else {
        this.o.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.n.set(i, j - g, i, j);
      paramCanvas.drawRect(this.n, this.o);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.B)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.l);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.z = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.f = paramInt;
    setBackgroundDrawable(b(getResources(), this.f));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.B))
    {
      this.l = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.C;
    if (localTextView != null)
    {
      this.b = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.l)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.l);
        this.C.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.C.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.C.setCompoundDrawablePadding(this.m);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.C != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.b = paramDrawable;
        this.c = paramInt1;
        this.d = Math.min(this.l, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.d);
        this.C.setCompoundDrawables(paramDrawable, null, null, null);
        this.C.setCompoundDrawablePadding(this.m);
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
      TextView localTextView = this.C;
      if (localTextView != null)
      {
        this.a = paramCharSequence;
        localTextView.setText(this.a);
        this.C.setTextColor(a(getResources(), this.e));
        this.C.setContentDescription(this.a);
      }
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.a != null)
    {
      this.e = paramInt;
      this.C.setTextColor(a(getResources(), this.e));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.C;
      if (localTextView != null)
      {
        this.a = paramCharSequence;
        localTextView.setText(this.a);
        this.C.setContentDescription(this.a);
      }
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    TextView localTextView = this.C;
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
      this.v = paramInt1;
      this.w = Math.min(this.l, paramInt2);
      this.u = paramDrawable;
      a();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.t = paramCharSequence;
    a();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    MultiImageTextView localMultiImageTextView = this.D;
    if (localMultiImageTextView != null)
    {
      this.x = paramInt;
      localMultiImageTextView.setVisibility(0);
      this.D.setTextColor(a(getResources(), this.x));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */