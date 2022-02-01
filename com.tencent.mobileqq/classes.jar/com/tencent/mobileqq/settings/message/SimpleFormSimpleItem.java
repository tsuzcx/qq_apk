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
  protected static boolean a;
  protected int a;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Drawable a;
  protected TextView a;
  protected CharSequence a;
  protected TextView b;
  private CharSequence b;
  private int g;
  private int h;
  private int i;
  
  public SimpleFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getResources().getDimensionPixelSize(2131296766);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839270);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.i = paramContext.getDimensionPixelSize(2, getResources().getDimensionPixelSize(2131298275));
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(9);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.g = paramContext.getInt(10, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(16);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_Int = paramContext.getInt(17, 3);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.h = paramContext.getInt(0, 0);
        localContext2 = paramContext;
        localContext1 = paramContext;
        jdField_a_of_type_Boolean = paramContext.getBoolean(11, true);
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(c);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839433);
      }
      return paramResources.getDrawable(2130850703);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839433);
          }
          if (jdField_a_of_type_Boolean) {
            return paramResources.getDrawable(2130839440);
          }
          return paramResources.getDrawable(2130850708);
        }
        if (jdField_a_of_type_Boolean) {
          return paramResources.getDrawable(2130839443);
        }
        return paramResources.getDrawable(2130850717);
      }
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839443);
      }
      return paramResources.getDrawable(2130850717);
    }
    if (jdField_a_of_type_Boolean) {
      return paramResources.getDrawable(2130839433);
    }
    return paramResources.getDrawable(2130850703);
  }
  
  private boolean a()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public static ColorStateList b(Resources paramResources, int paramInt)
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
              return paramResources.getColorStateList(2131167056);
            }
            return paramResources.getColorStateList(2131167190);
          }
          return paramResources.getColorStateList(2131167152);
        }
        return paramResources.getColorStateList(2131167138);
      }
      return paramResources.getColorStateList(2131167064);
    }
    return paramResources.getColorStateList(2131167056);
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return b(paramResources, paramInt);
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, a());
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
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
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.g));
    int j = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.i;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367175);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_a_of_type_Int));
    j = getContext().getResources().getDimensionPixelSize(2131296773);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.i;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    b();
    setBackgroundDrawable(a(getResources(), this.h));
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int j;
    int k;
    if (a())
    {
      j = e;
      k = f;
    }
    else
    {
      j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_a_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (a())
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (a())
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = this.h;
    if ((j == 1) || (j == 2))
    {
      if (a()) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(c);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      }
      j = getMeasuredWidth();
      int k = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, k - jdField_b_of_type_Int, j, k);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.g));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.SimpleFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */