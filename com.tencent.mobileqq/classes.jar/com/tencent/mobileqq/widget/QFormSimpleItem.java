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
  protected static boolean m;
  private final Rect A = new Rect();
  private final Paint B = new Paint();
  private int C;
  private int D;
  protected CharSequence a;
  protected Drawable b;
  protected int c;
  protected int d;
  protected int e;
  protected boolean f;
  protected Drawable l;
  protected boolean n;
  protected TextView o;
  protected QMultiImageTextView p;
  protected int q;
  protected int r;
  private CharSequence s;
  private Drawable t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public QFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131297097);
    double d1 = getResources().getDisplayMetrics().density * 35.0F;
    Double.isNaN(d1);
    this.C = ((int)(d1 + 0.5D));
    d1 = getResources().getDisplayMetrics().density * 15.0F;
    Double.isNaN(d1);
    this.D = ((int)(d1 + 0.5D));
    this.l = getResources().getDrawable(2130839446);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aS);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.z = paramContext.getDimensionPixelSize(R.styleable.aV, getResources().getDimensionPixelSize(2131298976));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.y = paramContext.getDimensionPixelSize(R.styleable.aU, i);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.s = paramContext.getString(R.styleable.bb);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.w = paramContext.getInt(R.styleable.bc, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.t = paramContext.getDrawable(R.styleable.aY);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.u = paramContext.getDimensionPixelSize(R.styleable.ba, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.v = paramContext.getDimensionPixelSize(R.styleable.aZ, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.v = Math.min(this.y, this.v);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.a = paramContext.getString(R.styleable.bi);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.e = paramContext.getInt(R.styleable.bj, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.b = paramContext.getDrawable(R.styleable.bf);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.c = paramContext.getDimensionPixelSize(R.styleable.bh, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.d = paramContext.getDimensionPixelSize(R.styleable.bg, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.d = Math.min(this.y, this.d);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.f = paramContext.getBoolean(R.styleable.bk, false);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.x = paramContext.getInt(R.styleable.aT, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        m = paramContext.getBoolean(R.styleable.bd, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.n = paramContext.getBoolean(R.styleable.be, true);
        localContext2 = paramContext;
        localContext1 = paramContext;
        FormResHelper.a(m);
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
    this.B.setAntiAlias(true);
    this.B.setColor(h);
    c();
  }
  
  private boolean b()
  {
    return QQTheme.isDefaultOrDIYTheme();
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    m = paramBoolean;
    FormResHelper.a(paramBoolean);
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt);
  }
  
  protected void a()
  {
    int j = getResources().getDisplayMetrics().widthPixels;
    int i = this.z;
    j -= i * 2;
    Object localObject = this.a;
    int i2 = 0;
    if (localObject == null)
    {
      if ((this.b != null) && (this.f))
      {
        k = this.C;
        i = this.D + (k + i);
      }
      else if ((this.b != null) && (!this.f))
      {
        i = this.C;
      }
      else if ((this.b == null) && (this.f))
      {
        i = this.D;
      }
      else
      {
        i = 0;
      }
      this.r = (j - i);
      this.q = 0;
      return;
    }
    int i3 = j - i;
    localObject = this.t;
    if (localObject != null)
    {
      j = this.u;
      i = j;
      if (j == 0) {
        i = ((Drawable)localObject).getIntrinsicWidth();
      }
      i = this.z + i;
    }
    else
    {
      i = 0;
    }
    localObject = this.o.getPaint();
    CharSequence localCharSequence = this.s;
    if (localCharSequence != null) {
      i += (int)((Paint)localObject).measureText(localCharSequence.toString());
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null)
    {
      k = this.c;
      j = k;
      if (k == 0) {
        j = ((Drawable)localObject).getIntrinsicWidth();
      }
      j = this.z + (j + 0);
    }
    else
    {
      j = 0;
    }
    int k = j;
    if (this.f) {
      k = j + this.l.getIntrinsicWidth() + this.z;
    }
    localObject = this.p.getPaint();
    localObject = new StaticLayout(this.a, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    int i4 = ((StaticLayout)localObject).getLineCount();
    int i1 = 0;
    j = i2;
    while (j < i4)
    {
      i1 = (int)((StaticLayout)localObject).getLineWidth(j) + (int)((StaticLayout)localObject).getLineWidth(j);
      j += 1;
    }
    i1 = k + i1 + this.p.getPaddingLeft();
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
    this.r = j;
    this.q = k;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    d();
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, b());
  }
  
  protected void c()
  {
    setFocusable(true);
    setClickable(true);
    this.o = new TextView(getContext());
    if (!TextUtils.isEmpty(this.s))
    {
      this.o.setText(this.s);
      this.o.setContentDescription(this.s);
    }
    this.o.setId(2131433629);
    if (this.n)
    {
      this.o.setSingleLine(true);
      this.o.setEllipsize(TextUtils.TruncateAt.END);
      this.o.setDuplicateParentStateEnabled(true);
    }
    this.o.setTextColor(a(getResources(), this.w));
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.o.setTextSize(0, i);
    this.o.setGravity(19);
    setLeftIcon(this.t, this.u, this.v);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    i = this.z;
    localLayoutParams.leftMargin = i;
    if (!this.n)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      setMinimumHeight(this.y);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.o.setMaxWidth(this.r);
    addView(this.o, localLayoutParams);
    this.p = new QMultiImageTextView(getContext());
    this.p.setId(2131433631);
    this.p.setSingleLine(true);
    this.p.setTextColor(a(getResources(), this.e));
    i = getContext().getResources().getDimensionPixelSize(2131297104);
    this.p.setTextSize(0, i);
    this.p.setGravity(19);
    this.p.setEllipsize(TextUtils.TruncateAt.END);
    this.p.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.z;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.p, localLayoutParams);
    d();
    setBackgroundDrawable(b(getResources(), this.x));
  }
  
  protected void d()
  {
    if (this.p == null) {
      return;
    }
    a();
    Object localObject = this.o;
    if (localObject != null) {
      ((TextView)localObject).setMaxWidth(this.r);
    }
    int i;
    int j;
    int k;
    int i1;
    if (b())
    {
      localObject = this.b;
      if (localObject != null)
      {
        i = ((Drawable)localObject).getIntrinsicWidth();
        j = this.b.getIntrinsicHeight();
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
      localObject = this.l;
      if (localObject != null)
      {
        k = ((Drawable)localObject).getIntrinsicWidth();
        i1 = this.l.getIntrinsicHeight();
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
    if (!TextUtils.isEmpty(this.a))
    {
      this.p.setVisibility(0);
      this.p.setText(this.a);
      this.p.setTextColor(a(getResources(), this.e));
      this.p.setContentDescription(this.a);
      this.p.setMaxWidth(this.q);
      if ((this.b != null) && (this.f))
      {
        if ((this.c > 0) && (this.d > 0))
        {
          this.l.setBounds(0, 0, k, i1);
          this.b.setBounds(0, 0, this.c, this.d);
          this.p.setCompoundDrawables(this.b, null, this.l, null);
        }
        else if (b())
        {
          this.l.setBounds(0, 0, k, i1);
          this.b.setBounds(0, 0, i, j);
          this.p.setCompoundDrawables(this.b, null, this.l, null);
        }
        else
        {
          this.p.setCompoundDrawablesWithIntrinsicBounds(this.b, null, this.l, null);
        }
        this.p.setCompoundDrawablePadding(8);
        return;
      }
      localObject = this.b;
      if ((localObject != null) && (!this.f))
      {
        i = this.c;
        if (i > 0)
        {
          j = this.d;
          if (j > 0)
          {
            ((Drawable)localObject).setBounds(0, 0, i, j);
            this.p.setCompoundDrawables(this.b, null, null, null);
            break label425;
          }
        }
        this.p.setCompoundDrawablesWithIntrinsicBounds(this.b, null, null, null);
        label425:
        this.p.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.b == null) && (this.f))
      {
        if (b())
        {
          this.l.setBounds(0, 0, k, i1);
          this.p.setCompoundDrawables(null, null, this.l, null);
        }
        else
        {
          this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, this.l, null);
        }
        this.p.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.b == null) && (!this.f))
      {
        this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.p.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.p.setText("");
      if ((this.b != null) && (this.f))
      {
        this.p.setVisibility(0);
        int i2 = this.c;
        if (i2 > 0)
        {
          int i3 = this.d;
          if (i3 > 0)
          {
            this.b.setBounds(0, 0, i2, i3);
            this.l.setBounds(0, 0, k, i1);
            this.p.setCompoundDrawables(this.b, null, this.l, null);
            break label709;
          }
        }
        if (b())
        {
          this.l.setBounds(0, 0, k, i1);
          this.b.setBounds(0, 0, i, j);
          this.p.setCompoundDrawables(this.b, null, this.l, null);
        }
        else
        {
          this.p.setCompoundDrawablesWithIntrinsicBounds(this.b, null, this.l, null);
        }
        label709:
        this.p.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.b != null) && (!this.f))
      {
        this.p.setVisibility(0);
        i = this.c;
        if (i > 0)
        {
          j = this.d;
          if (j > 0)
          {
            this.b.setBounds(0, 0, i, j);
            this.p.setCompoundDrawables(this.b, null, null, null);
            break label801;
          }
        }
        this.p.setCompoundDrawablesWithIntrinsicBounds(this.b, null, null, null);
        label801:
        this.p.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.b == null) && (this.f))
      {
        this.p.setVisibility(0);
        if (b())
        {
          this.l.setBounds(0, 0, k, i1);
          this.p.setCompoundDrawables(null, null, this.l, null);
        }
        else
        {
          this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, this.l, null);
        }
        this.p.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.b == null) && (!this.f)) {
        this.p.setVisibility(8);
      }
    }
  }
  
  public TextView getLeftTextView()
  {
    return this.o;
  }
  
  public Drawable getRightIcon()
  {
    return this.b;
  }
  
  public QMultiImageTextView getRightTextView()
  {
    return this.p;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.x;
    if ((i == 1) || (i == 2))
    {
      if (b()) {
        this.B.setColor(h);
      } else {
        this.B.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.A.set(i, j - g, i, j);
      paramCanvas.drawRect(this.A, this.B);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.n)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.y, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.y);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.x = paramInt;
    setBackgroundDrawable(b(getResources(), this.x));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.n))
    {
      this.y = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.o;
    if (localTextView != null)
    {
      this.t = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.y)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.y);
        this.o.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.o.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.o.setCompoundDrawablePadding(this.z);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.o != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.t = paramDrawable;
        this.u = paramInt1;
        this.v = Math.min(this.y, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.v);
        this.o.setCompoundDrawables(paramDrawable, null, null, null);
        this.o.setCompoundDrawablePadding(this.z);
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
      TextView localTextView = this.o;
      if (localTextView != null)
      {
        this.s = paramCharSequence;
        localTextView.setText(this.s);
        this.o.setTextColor(a(getResources(), this.w));
        this.o.setContentDescription(this.s);
      }
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.s != null)
    {
      this.w = paramInt;
      this.o.setTextColor(a(getResources(), this.w));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.o;
      if (localTextView != null)
      {
        this.s = paramCharSequence;
        localTextView.setText(this.s);
        this.o.setContentDescription(this.s);
      }
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    TextView localTextView = this.o;
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
      this.c = paramInt1;
      this.d = Math.min(this.y, paramInt2);
      this.b = paramDrawable;
      d();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    d();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    QMultiImageTextView localQMultiImageTextView = this.p;
    if (localQMultiImageTextView != null)
    {
      this.e = paramInt;
      localQMultiImageTextView.setVisibility(0);
      this.p.setTextColor(a(getResources(), this.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */