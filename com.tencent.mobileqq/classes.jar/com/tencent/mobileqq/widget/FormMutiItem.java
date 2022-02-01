package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class FormMutiItem
  extends FormSimpleItem
{
  protected LinearLayout a;
  protected TextView b;
  protected TextView c;
  protected int d = 0;
  protected int e = 2;
  protected int f;
  protected int l;
  protected CharSequence m;
  protected CharSequence n;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public FormMutiItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.m = paramContext.getString(5);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.n = paramContext.getString(18);
        if (paramContext == null) {
          break label89;
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
      label79:
      break label79;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label89:
    b();
  }
  
  private void b()
  {
    this.a = new LinearLayout(getContext());
    this.a.setOrientation(1);
    this.b = new TextView(getContext());
    this.b.setSingleLine(true);
    this.b.setTextColor(FormResHelper.a(getResources(), this.d));
    int i = getResources().getDimensionPixelSize(2131297095);
    this.b.setTextSize(0, i);
    this.b.setGravity(19);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.b.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.m)) {
      this.b.setText(this.m);
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.c = new TextView(getContext());
    if (this.B)
    {
      this.c.setSingleLine(true);
      this.c.setEllipsize(TextUtils.TruncateAt.END);
      this.c.setDuplicateParentStateEnabled(true);
    }
    else
    {
      this.c.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131297089);
    }
    i = getResources().getDimensionPixelSize(2131297104);
    this.c.setTextColor(FormResHelper.a(getResources(), this.e));
    this.c.setTextSize(0, i);
    this.c.setGravity(19);
    if (!TextUtils.isEmpty(this.n)) {
      this.c.setText(this.n);
    }
    this.a.addView(this.b, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131297078);
    if (!this.B) {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131297084);
    }
    this.a.addView(this.c, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131433629);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131433631);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.a, (ViewGroup.LayoutParams)localObject);
    setCustomHeight(getResources().getDimensionPixelSize(2131299077));
  }
  
  public void setFirstLineRightDrawalbe(Drawable paramDrawable)
  {
    this.b.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void setFirstLineText(int paramInt)
  {
    this.m = getResources().getString(paramInt);
    this.b.setText(this.m);
  }
  
  public void setFirstLineText(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    this.b.setText(this.m);
  }
  
  public void setFirstLineTextColor(int paramInt)
  {
    this.d = paramInt;
    this.b.setTextColor(this.d);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.f = paramInt;
    this.b.setTextSize(this.f);
  }
  
  public void setSecondLineText(int paramInt)
  {
    this.n = getResources().getString(paramInt);
    this.c.setText(this.n);
  }
  
  public void setSecondLineText(CharSequence paramCharSequence)
  {
    this.n = paramCharSequence;
    this.c.setText(this.n);
  }
  
  public void setSecondLineTextColor(int paramInt)
  {
    this.c.setTextColor(this.e);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.c.setTextSize(this.l);
  }
  
  public void setSecondLineTextViewPaddingRight(int paramInt)
  {
    TextView localTextView = this.c;
    localTextView.setPadding(localTextView.getPaddingLeft(), this.c.getPaddingTop(), paramInt, this.c.getPaddingBottom());
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool1 = this.c.getVisibility();
    boolean bool2 = false;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool1 ^ paramBoolean))
    {
      TextView localTextView = this.c;
      int i;
      if (paramBoolean) {
        bool1 = bool2;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
      if (paramBoolean) {
        i = getResources().getDimensionPixelSize(2131299077);
      } else {
        i = getResources().getDimensionPixelSize(2131298974);
      }
      setCustomHeight(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */