package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.qqui.R.styleable;

public class FormEditItem
  extends RelativeLayout
  implements FormItemConstants
{
  private final Paint A = new Paint();
  private ViewTreeObserver.OnGlobalLayoutListener B = new FormEditItem.1(this);
  protected boolean a;
  private CharSequence b;
  private int c;
  private CharSequence d;
  private int e;
  private int f;
  private int l;
  private TextView m;
  private Drawable n;
  private int o;
  private int p;
  private TextView q;
  private EditText r;
  private CharSequence s;
  private int t = -2;
  private int u = -2;
  private int v;
  private int w;
  private int x = 0;
  private final boolean y;
  private final Rect z = new Rect();
  
  public FormEditItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormEditItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131298976);
    int j = getResources().getDimensionPixelSize(2131297097);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aS);
    this.l = paramAttributeSet.getDimensionPixelSize(R.styleable.aV, i);
    this.f = paramAttributeSet.getDimensionPixelSize(R.styleable.aU, j);
    this.b = paramAttributeSet.getString(R.styleable.bb);
    this.n = paramAttributeSet.getDrawable(R.styleable.aY);
    this.o = paramAttributeSet.getDimensionPixelSize(R.styleable.ba, 0);
    this.p = paramAttributeSet.getDimensionPixelSize(R.styleable.aZ, 0);
    this.p = Math.min(this.f, this.p);
    this.d = paramAttributeSet.getString(R.styleable.bi);
    this.e = paramAttributeSet.getInt(R.styleable.bj, 0);
    this.c = paramAttributeSet.getInt(R.styleable.aT, -1);
    this.a = paramAttributeSet.getBoolean(R.styleable.be, true);
    this.s = paramAttributeSet.getString(R.styleable.aW);
    try
    {
      i = paramContext.getResources().getDimensionPixelSize(2131297090);
    }
    catch (Resources.NotFoundException paramContext)
    {
      paramContext.printStackTrace();
      i = 300;
    }
    this.v = paramAttributeSet.getDimensionPixelSize(R.styleable.aX, i);
    paramAttributeSet.recycle();
    QQUIDelegate.b();
    this.y = QQUIDelegate.a();
    this.A.setAntiAlias(true);
    this.A.setColor(h);
    a();
  }
  
  @TargetApi(16)
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    this.q = new TextView(getContext());
    this.q.setId(2131433631);
    this.q.setTextColor(FormResHelper.a(getResources(), this.e));
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.q.setTextSize(0, i);
    this.q.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.rightMargin = this.l;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    if (this.a)
    {
      this.q.setSingleLine(true);
      this.q.setEllipsize(TextUtils.TruncateAt.END);
      this.q.setDuplicateParentStateEnabled(true);
    }
    else
    {
      i = this.l;
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
    }
    addView(this.q, localLayoutParams);
    this.r = new EditText(getContext());
    this.r.setId(2131433628);
    this.r.setMinWidth(this.v);
    i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.r.setTextSize(0, i);
    this.r.setTextColor(-16777216);
    this.r.setGravity(21);
    this.r.setBackgroundDrawable(null);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = this.l;
    localLayoutParams.addRule(0, 2131433631);
    localLayoutParams.addRule(15);
    addView(this.r, localLayoutParams);
    if (!TextUtils.isEmpty(this.s))
    {
      this.r.setHintTextColor(-7829368);
      this.r.setHint(this.s);
    }
    this.m = new TextView(getContext());
    this.m.setId(2131433629);
    i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.m.setTextColor(getResources().getColorStateList(2131167993));
    this.m.setTextSize(0, i);
    this.m.setGravity(19);
    setLeftIcon(this.n, this.o, this.p);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = this.l;
    localLayoutParams.leftMargin = i;
    if (this.a)
    {
      this.m.setSingleLine(true);
      this.m.setEllipsize(TextUtils.TruncateAt.END);
      this.m.setDuplicateParentStateEnabled(true);
    }
    else
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      setMinimumHeight(this.f);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(0, 2131433628);
    localLayoutParams.addRule(15);
    this.m.setMaxWidth(this.t);
    addView(this.m, localLayoutParams);
    getViewTreeObserver().addOnGlobalLayoutListener(this.B);
    if (this.c >= 0) {
      setBackgroundDrawable(FormResHelper.a(getResources(), this.c, this.y));
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramTextView != null)
    {
      paramTextView.setWidth(paramInt);
      boolean bool = TextUtils.isEmpty(paramCharSequence);
      if (bool) {
        paramCharSequence = "";
      }
      if ((bool) && (!paramBoolean)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      paramTextView.setText(paramCharSequence);
      paramTextView.setContentDescription(paramCharSequence);
      paramTextView.setVisibility(paramInt);
    }
  }
  
  private void b()
  {
    if (this.x > 0)
    {
      c();
      TextView localTextView = this.m;
      int i = this.t;
      CharSequence localCharSequence = this.b;
      boolean bool;
      if (this.n != null) {
        bool = true;
      } else {
        bool = false;
      }
      a(localTextView, i, localCharSequence, bool);
      a(this.q, this.u, this.d, false);
      this.r.setMaxWidth(this.w);
    }
  }
  
  private void c()
  {
    int i2 = this.x - this.v - this.l * 2;
    Drawable localDrawable = this.n;
    int k = 0;
    int i;
    if (localDrawable != null)
    {
      j = this.o;
      i = j;
      if (j == 0) {
        i = localDrawable.getIntrinsicWidth();
      }
      i = this.l + i;
    }
    else
    {
      i = 0;
    }
    if (!TextUtils.isEmpty(this.b)) {
      j = (int)this.m.getPaint().measureText(this.b.toString());
    } else {
      j = 0;
    }
    int i1 = i + j;
    int j = i2;
    if (i1 > 0) {
      j = i2 - this.l;
    }
    if (!TextUtils.isEmpty(this.d)) {
      i = (int)this.q.getPaint().measureText(this.d.toString());
    } else {
      i = 0;
    }
    i2 = j / 2;
    if ((i1 >= i2) && (i >= i2))
    {
      j = i2;
      i = j;
    }
    else if ((i1 > i2) && (i < i2))
    {
      j -= i;
      if (i1 < j)
      {
        k = j - i1;
        j = i1;
      }
    }
    else
    {
      if ((i1 < i2) && (i > i2))
      {
        j -= i1;
        if (i >= j)
        {
          i = j;
          j = i1;
          break label262;
        }
      }
      else
      {
        j -= i1;
      }
      k = j - i;
      j = i1;
    }
    label262:
    this.t = j;
    this.u = i;
    this.w = (this.v + k);
  }
  
  public EditText getEdit()
  {
    return this.r;
  }
  
  public TextView getLeftTextView()
  {
    return this.m;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.y)
    {
      int i = this.c;
      if ((i == 1) || (i == 2))
      {
        i = getMeasuredWidth();
        int j = getMeasuredHeight();
        this.z.set(i, j - g, i, j);
        paramCanvas.drawRect(this.z, this.A);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a) {}
    try
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.f);
      return;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    setMinimumHeight(this.f);
    super.onMeasure(paramInt1, paramInt2);
    return;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.c = paramInt;
    setBackgroundDrawable(FormSwitchItem.a(getResources(), this.c, this.y));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.a))
    {
      this.f = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.m;
    if (localTextView != null)
    {
      this.n = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.f)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.f);
        this.m.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.m.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.m.setCompoundDrawablePadding(this.l);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.m != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.n = paramDrawable;
        this.o = paramInt1;
        this.p = Math.min(this.f, paramInt2);
        paramDrawable.setBounds(0, 0, this.o, this.p);
        this.m.setCompoundDrawables(paramDrawable, null, null, null);
        this.m.setCompoundDrawablePadding(this.l);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setLeftIcon(paramDrawable);
      }
    }
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (this.m != null)
    {
      this.b = paramCharSequence;
      b();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem
 * JD-Core Version:    0.7.0.1
 */