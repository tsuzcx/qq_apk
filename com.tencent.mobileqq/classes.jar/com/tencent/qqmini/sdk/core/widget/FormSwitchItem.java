package com.tencent.qqmini.sdk.core.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Switch;
import android.widget.TextView;
import besl;
import bfgx;
import com.tencent.mobileqq.R.styleable;

public class FormSwitchItem
  extends RelativeLayout
{
  int jdField_a_of_type_Int = Color.parseColor("#EBEDF5");
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected Switch a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  int jdField_b_of_type_Int = bfgx.a(16.0F);
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  int c = bfgx.a(0.5F);
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int k = getResources().getDimensionPixelSize(2131297218);
    int m = getResources().getDimensionPixelSize(2131297220);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MiniSdkFormItem);
    this.f = paramContext.getDimensionPixelSize(3, k);
    this.e = paramContext.getDimensionPixelSize(2, m);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(23);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(8);
    this.g = paramContext.getDimensionPixelSize(9, 0);
    this.h = paramContext.getDimensionPixelSize(7, 0);
    this.h = Math.min(this.e, this.h);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(15);
    this.i = paramContext.getDimensionPixelSize(16, 0);
    this.j = paramContext.getDimensionPixelSize(14, 0);
    this.j = Math.min(this.e, this.j);
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(21, false);
    this.d = paramContext.getInt(1, 0);
    paramContext.recycle();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return paramResources.getDrawable(2130849239);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    int k = getContext().getResources().getDimensionPixelSize(2131297219);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, k);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165750));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.g, this.h);
    setRightIcon(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.i, this.j);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.f;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_AndroidWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.f;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.d, a()));
  }
  
  private boolean a()
  {
    return true;
  }
  
  public Switch a()
  {
    return this.jdField_a_of_type_AndroidWidgetSwitch;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.d == 1) || (this.d == 2))
    {
      if (!a()) {
        break label76;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      int k = getMeasuredWidth();
      int m = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_Int, m - this.c, k, m);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label76:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.jdField_a_of_type_AndroidWidgetSwitch != null) && (this.jdField_a_of_type_AndroidWidgetSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.jdField_a_of_type_AndroidWidgetSwitch.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.e);
        return;
      }
      catch (Exception localException)
      {
        if (besl.a()) {
          besl.a("FormSwitchItem", localException.toString());
        }
        setMinimumHeight(this.e);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetSwitch != null)
    {
      this.jdField_a_of_type_AndroidWidgetSwitch.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidWidgetSwitch != null) {
      this.jdField_a_of_type_AndroidWidgetSwitch.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.e)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.e);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.g = paramInt1;
        this.h = Math.min(this.e, paramInt2);
        paramDrawable.setBounds(0, 0, this.g, this.h);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setRightIcon(paramDrawable);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetSwitch != null) {
      this.jdField_a_of_type_AndroidWidgetSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.e)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.e);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.i = paramInt1;
        this.j = Math.min(this.e, paramInt2);
        paramDrawable.setBounds(0, 0, this.i, this.j);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setRightIcon(paramDrawable);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165750));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */