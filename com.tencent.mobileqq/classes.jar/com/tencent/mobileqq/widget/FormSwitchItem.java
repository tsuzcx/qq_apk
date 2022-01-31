package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements FormItemConstants
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131558914);
    int j = getResources().getDimensionPixelSize(2131559314);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.c = paramContext.getDimensionPixelSize(6, i);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(5, j);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(16);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(8);
    this.d = paramContext.getDimensionPixelSize(3, 0);
    this.e = paramContext.getDimensionPixelSize(4, 0);
    this.e = Math.min(this.jdField_b_of_type_Int, this.e);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(11);
    this.f = paramContext.getDimensionPixelSize(12, 0);
    this.g = paramContext.getDimensionPixelSize(13, 0);
    this.g = Math.min(this.jdField_b_of_type_Int, this.g);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(17, false);
    this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130845873);
    case 0: 
      return paramResources.getDrawable(2130845873);
    case 1: 
      return paramResources.getDrawable(2130845893);
    case 2: 
      return paramResources.getDrawable(2130845887);
    }
    return paramResources.getDrawable(2130845878);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362051);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    int i = getContext().getResources().getDimensionPixelSize(2131559305);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494207));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.d, this.e);
    setRightIcon(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.f, this.g);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.c;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    if ((AppSetting.b) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, false);
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetSwitch, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setId(2131362052);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.c;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public Switch a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwitch;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentWidgetSwitch == null) || (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() == 0))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, getResources()), AIOUtils.a(24.0F, getResources()));
      localLayoutParams.rightMargin = this.c;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838589));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked();
    }
    return false;
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
    try
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.jdField_b_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormSwitchItem", 2, localException.toString());
      }
      setMinimumHeight(this.jdField_b_of_type_Int);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.b) && (this.jdField_a_of_type_ComTencentWidgetSwitch != null) && (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() == 0))
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
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
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
      this.jdField_b_of_type_Int = paramInt;
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
    if (paramDrawable.getIntrinsicHeight() > this.jdField_b_of_type_Int)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
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
        this.d = paramInt1;
        this.e = Math.min(this.jdField_b_of_type_Int, paramInt2);
        paramDrawable.setBounds(0, 0, this.d, this.e);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
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
    if (paramDrawable.getIntrinsicHeight() > this.jdField_b_of_type_Int)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
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
        this.f = paramInt1;
        this.g = Math.min(this.jdField_b_of_type_Int, paramInt2);
        paramDrawable.setBounds(0, 0, this.f, this.g);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494207));
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