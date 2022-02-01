package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemConstants;

public class SimpleFormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  protected static boolean d;
  protected CharSequence a;
  protected int b;
  protected Drawable c;
  protected TextView e;
  protected TextView f;
  private CharSequence l;
  private int m;
  private int n;
  private int o;
  private final Rect p = new Rect();
  private final Paint q = new Paint();
  
  public SimpleFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getResources().getDimensionPixelSize(2131297097);
    this.c = getResources().getDrawable(2130839446);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.o = paramContext.getDimensionPixelSize(2, getResources().getDimensionPixelSize(2131298976));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.l = paramContext.getString(9);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.m = paramContext.getInt(10, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.a = paramContext.getString(16);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.b = paramContext.getInt(17, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.n = paramContext.getInt(0, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        d = paramContext.getBoolean(11, true);
        if (paramContext == null) {
          break label210;
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
      label200:
      break label200;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label210:
    this.q.setAntiAlias(true);
    this.q.setColor(h);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (d) {
        return paramResources.getDrawable(2130839622);
      }
      return paramResources.getDrawable(2130852507);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839622);
          }
          if (d) {
            return paramResources.getDrawable(2130839629);
          }
          return paramResources.getDrawable(2130852512);
        }
        if (d) {
          return paramResources.getDrawable(2130839632);
        }
        return paramResources.getDrawable(2130852521);
      }
      if (d) {
        return paramResources.getDrawable(2130839632);
      }
      return paramResources.getDrawable(2130852521);
    }
    if (d) {
      return paramResources.getDrawable(2130839622);
    }
    return paramResources.getDrawable(2130852507);
  }
  
  public static ColorStateList c(Resources paramResources, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return paramResources.getColorStateList(2131167993);
            }
            return paramResources.getColorStateList(2131168175);
          }
          return paramResources.getColorStateList(2131168133);
        }
        return paramResources.getColorStateList(2131168118);
      }
      return paramResources.getColorStateList(2131168002);
    }
    return paramResources.getColorStateList(2131167993);
  }
  
  private boolean c()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return c(paramResources, paramInt);
  }
  
  protected void a()
  {
    setFocusable(true);
    setClickable(true);
    this.e = new TextView(getContext());
    if (!TextUtils.isEmpty(this.l))
    {
      this.e.setText(this.l);
      this.e.setContentDescription(this.l);
    }
    this.e.setId(2131433629);
    this.e.setTextColor(a(getResources(), this.m));
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.e.setTextSize(0, i);
    this.e.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.o;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.e, localLayoutParams);
    this.f = new TextView(getContext());
    if (!TextUtils.isEmpty(this.a))
    {
      this.f.setText(this.a);
      this.f.setContentDescription(this.a);
    }
    this.f.setId(2131433631);
    this.f.setTextColor(a(getResources(), this.b));
    i = getContext().getResources().getDimensionPixelSize(2131297104);
    this.f.setTextSize(0, i);
    this.f.setGravity(19);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    this.f.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.o;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.f, localLayoutParams);
    b();
    setBackgroundDrawable(b(getResources(), this.n));
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, c());
  }
  
  protected void b()
  {
    if (this.f == null) {
      return;
    }
    int i;
    int j;
    if (c())
    {
      i = j;
      j = k;
    }
    else
    {
      i = this.c.getIntrinsicWidth();
      j = this.c.getIntrinsicHeight();
    }
    if (!TextUtils.isEmpty(this.a))
    {
      this.f.setVisibility(0);
      this.f.setText(this.a);
      this.f.setTextColor(a(getResources(), this.b));
      this.f.setContentDescription(this.a);
      if (c())
      {
        this.c.setBounds(0, 0, i, j);
        this.f.setCompoundDrawables(null, null, this.c, null);
      }
      else
      {
        this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
      }
      this.f.setCompoundDrawablePadding(8);
      return;
    }
    this.f.setText("");
    this.f.setVisibility(0);
    if (c())
    {
      this.c.setBounds(0, 0, i, j);
      this.f.setCompoundDrawables(null, null, this.c, null);
    }
    else
    {
      this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
    }
    this.f.setCompoundDrawablePadding(0);
  }
  
  public TextView getLeftTextView()
  {
    return this.e;
  }
  
  public TextView getRightTextView()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.n;
    if ((i == 1) || (i == 2))
    {
      if (c()) {
        this.q.setColor(h);
      } else {
        this.q.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.p.set(i, j - g, i, j);
      paramCanvas.drawRect(this.p, this.q);
    }
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      TextView localTextView = this.e;
      if (localTextView != null)
      {
        this.l = paramCharSequence;
        localTextView.setText(this.l);
        this.e.setTextColor(a(getResources(), this.m));
        this.e.setContentDescription(this.l);
      }
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.SimpleFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */