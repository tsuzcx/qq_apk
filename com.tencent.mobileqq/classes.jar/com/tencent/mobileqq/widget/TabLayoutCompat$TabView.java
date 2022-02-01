package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

class TabLayoutCompat$TabView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 2;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TabLayoutCompat.Tab jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public TabLayoutCompat$TabView(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    if (paramTabLayoutCompat.f != 0) {
      setBackgroundDrawable(paramContext.getResources().getDrawable(paramTabLayoutCompat.f));
    }
    ViewCompat.setPaddingRelative(this, paramTabLayoutCompat.jdField_a_of_type_Int, paramTabLayoutCompat.jdField_b_of_type_Int, paramTabLayoutCompat.c, paramTabLayoutCompat.d);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
  }
  
  private float a(Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }
  
  private void a(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localObject1 != null) {
      localObject1 = ((TabLayoutCompat.Tab)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localObject2 != null) {
      localObject2 = ((TabLayoutCompat.Tab)localObject2).a();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localObject3 != null) {
      localObject3 = ((TabLayoutCompat.Tab)localObject3).b();
    } else {
      localObject3 = null;
    }
    int j = 0;
    if (paramImageView != null)
    {
      if (localObject1 != null)
      {
        paramImageView.setImageDrawable((Drawable)localObject1);
        paramImageView.setVisibility(0);
        setVisibility(0);
      }
      else
      {
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
      }
      paramImageView.setContentDescription((CharSequence)localObject3);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
    if (paramTextView != null)
    {
      if (bool)
      {
        paramTextView.setText((CharSequence)localObject2);
        paramTextView.setVisibility(0);
        setVisibility(0);
      }
      else
      {
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
      paramTextView.setContentDescription((CharSequence)localObject3);
    }
    if (paramImageView != null)
    {
      paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
      int i = j;
      if (bool)
      {
        i = j;
        if (paramImageView.getVisibility() == 0) {
          i = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(8);
        }
      }
      if (i != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = i;
        paramImageView.requestLayout();
      }
    }
  }
  
  void a()
  {
    a(null);
    setSelected(false);
  }
  
  void a(@Nullable TabLayoutCompat.Tab paramTab)
  {
    if (paramTab != this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab = paramTab;
      b();
    }
  }
  
  final void b()
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localTab != null) {
      localObject1 = localTab.a();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getParent();
      if (localObject2 != this)
      {
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView((View)localObject1);
        }
        addView((View)localObject1);
      }
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(16908308));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        if (Build.VERSION.SDK_INT >= 16) {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidWidgetTextView.getMaxLines();
        } else {
          this.jdField_a_of_type_Int = -1;
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(16908294));
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        removeView((View)localObject1);
        this.jdField_a_of_type_AndroidViewView = null;
      }
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    boolean bool = true;
    if (localObject1 == null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        localObject1 = new ImageView(getContext());
        ((ImageView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(48, 48));
        addView((View)localObject1, 0);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject1 = new TextView(getContext());
        ((TextView)localObject1).setMaxLines(2);
        ((TextView)localObject1).setGravity(1);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView((View)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        if (Build.VERSION.SDK_INT >= 16) {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getMaxLines();
        } else {
          this.jdField_a_of_type_Int = -1;
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject1).setTextAppearance(((TextView)localObject1).getContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.e);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList);
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
    }
    else
    {
      if ((TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList != null))
      {
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextAppearance(((TextView)localObject1).getContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.e);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList);
        }
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) || (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView);
      }
    }
    if ((localTab == null) || (!localTab.a())) {
      bool = false;
    }
    setSelected(bool);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.c();
    int i = paramInt1;
    if (m > 0) {
      if (k != 0)
      {
        i = paramInt1;
        if (j <= m) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.g, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      getResources();
      float f2 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_a_of_type_Float;
      j = this.jdField_a_of_type_Int;
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      k = 1;
      float f1;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        paramInt1 = 1;
        f1 = f2;
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        f1 = f2;
        paramInt1 = j;
        if (localObject != null)
        {
          f1 = f2;
          paramInt1 = j;
          if (((TextView)localObject).getLineCount() > 1)
          {
            f1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.jdField_b_of_type_Float;
            paramInt1 = j;
          }
        }
      }
      f2 = this.jdField_a_of_type_AndroidWidgetTextView.getTextSize();
      m = this.jdField_a_of_type_AndroidWidgetTextView.getLineCount();
      if (Build.VERSION.SDK_INT >= 16) {
        j = this.jdField_a_of_type_AndroidWidgetTextView.getMaxLines();
      } else {
        j = -1;
      }
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.i == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayout();
              if (localObject != null)
              {
                j = k;
                if (a((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f1);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
    }
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab != null)
    {
      int i = 0;
      if (!bool) {
        playSoundEffect(0);
      }
      TabLayoutCompat.Tab localTab = TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat);
      if (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat) == this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab) {
        i = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab.a();
      if ((TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat) != null) && (i == 0)) {
        TabLayoutCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat).a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab, localTab, 1);
      }
      return true;
    }
    return bool;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    int i;
    if (isSelected() != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    super.setSelected(paramBoolean);
    if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
      sendAccessibilityEvent(4);
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramBoolean);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.TabView
 * JD-Core Version:    0.7.0.1
 */