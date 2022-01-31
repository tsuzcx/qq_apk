package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baww;
import bcml;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements bcml
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected Switch a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int m = getResources().getDimensionPixelSize(2131298015);
    int n = getResources().getDimensionPixelSize(2131296639);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.h = paramContext.getDimensionPixelSize(3, m);
    this.g = paramContext.getDimensionPixelSize(2, n);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(23);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(7);
    this.i = paramContext.getDimensionPixelSize(9, 0);
    this.j = paramContext.getDimensionPixelSize(8, 0);
    this.j = Math.min(this.g, this.j);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(14);
    this.k = paramContext.getDimensionPixelSize(16, 0);
    this.l = paramContext.getDimensionPixelSize(15, 0);
    this.l = Math.min(this.g, this.l);
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(21, false);
    this.jdField_a_of_type_Int = paramContext.getInt(1, 0);
    paramContext.recycle();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(c);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramResources.getDrawable(2130849248);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130849248);
    case 0: 
      return paramResources.getDrawable(2130849248);
    case 1: 
      return paramResources.getDrawable(2130849268);
    case 2: 
      return paramResources.getDrawable(2130849262);
    }
    return paramResources.getDrawable(2130849253);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131366629);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    int m = getContext().getResources().getDimensionPixelSize(2131296637);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, m);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166854));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.i, this.j);
    setRightIcon(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.k, this.l);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.h;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16))
    {
      baww.a(this.jdField_a_of_type_AndroidWidgetTextView, false);
      baww.a(this.jdField_a_of_type_ComTencentWidgetSwitch, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setId(2131366628);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.h;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int, b()));
  }
  
  private boolean b()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public Switch a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwitch;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
    {
      if (!b()) {
        break label73;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(c);
    }
    for (;;)
    {
      int m = getMeasuredWidth();
      int n = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, n - jdField_b_of_type_Int, m, n);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label73:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.jdField_a_of_type_ComTencentWidgetSwitch != null) && (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.g);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FormSwitchItem", 2, localException.toString());
        }
        setMinimumHeight(this.g);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.d) && (this.jdField_a_of_type_ComTencentWidgetSwitch != null) && (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() == 0))
    {
      if (paramMotionEvent.getAction() == 0) {
        super.onTouchEvent(paramMotionEvent);
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (!this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMotionEvent.setChecked(bool);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.jdField_a_of_type_Int = paramInt;
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int, b()));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.g = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setEnabled(paramBoolean);
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
    if (paramDrawable.getIntrinsicHeight() > this.g)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.g);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
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
        this.i = paramInt1;
        this.j = Math.min(this.g, paramInt2);
        paramDrawable.setBounds(0, 0, this.i, this.j);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setRightIcon(paramDrawable);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
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
    if (paramDrawable.getIntrinsicHeight() > this.g)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.g);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
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
        this.k = paramInt1;
        this.l = Math.min(this.g, paramInt2);
        paramDrawable.setBounds(0, 0, this.k, this.l);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166854));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */