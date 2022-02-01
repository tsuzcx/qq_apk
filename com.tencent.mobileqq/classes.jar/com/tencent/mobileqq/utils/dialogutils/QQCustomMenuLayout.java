package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anni;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQCustomMenuLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  
  public QQCustomMenuLayout(Context paramContext)
  {
    super(paramContext);
    Object localObject = paramContext.getResources();
    this.jdField_c_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_c_of_type_Int -= (int)(this.jdField_a_of_type_Float * 10.0F);
    int i = 12;
    if (this.jdField_a_of_type_Float >= 2.0F) {
      i = 20;
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(TypedValue.applyDimension(2, 15.0F, ((Resources)localObject).getDisplayMetrics()));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838931);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131708971));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(i * this.jdField_a_of_type_Float), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(i * this.jdField_a_of_type_Float), (int)(this.jdField_a_of_type_Float * 10.0F));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, 0);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838915);
    if (!AppSetting.c) {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("leftIcon");
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_c_of_type_AndroidWidgetImageView, 1);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838915);
    if (!AppSetting.c) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription("rightIcon");
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_d_of_type_AndroidWidgetImageView, 2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838936);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131708957));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding((int)(i * this.jdField_a_of_type_Float), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(i * this.jdField_a_of_type_Float), (int)(this.jdField_a_of_type_Float * 10.0F));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, 3);
  }
  
  private int a()
  {
    int m = getChildCount();
    onMeasure(0, 0);
    int j = 0;
    int i = 0;
    View localView;
    int k;
    if (j < m)
    {
      localView = getChildAt(j);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label212;
      }
      if ((localView instanceof TextView))
      {
        k = (int)Layout.getDesiredWidth(((TextView)localView).getText(), this.jdField_a_of_type_AndroidTextTextPaint);
        if (QLog.isDevelopLevel()) {
          QLog.d("QQCustomMenuLayout", 4, "child  TextView text " + ((TextView)localView).getText() + " measureWidth = " + k + " padding = " + localView.getPaddingLeft());
        }
        i = i + k + this.jdField_d_of_type_Int;
        label138:
        i = i + localView.getPaddingLeft() + localView.getPaddingRight();
      }
    }
    label212:
    for (;;)
    {
      j += 1;
      break;
      int n = localView.getMeasuredWidth();
      k = i + n;
      i = k;
      if (!QLog.isDevelopLevel()) {
        break label138;
      }
      QLog.d("QQCustomMenuLayout", 4, "child  nonTextView measureWidth = " + n);
      i = k;
      break label138;
      return i;
    }
  }
  
  public void a()
  {
    if (getChildCount() > 3)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_b_of_type_Int = (getChildCount() - 3);
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (i < getChildCount() - 2)
    {
      if ((i < paramInt1) || (i > paramInt2)) {
        getChildAt(i).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        getChildAt(i).setVisibility(0);
      }
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView, getChildCount() - 2);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    addView(paramView, localLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void b()
  {
    int i = -1;
    for (;;)
    {
      int j = a();
      if (QLog.isDevelopLevel()) {
        QLog.d("QQCustomMenuLayout", 4, "totalWidth = " + j + " startPosition = " + this.jdField_a_of_type_Int + " endPosition = " + this.jdField_b_of_type_Int);
      }
      if (j <= this.jdField_c_of_type_Int)
      {
        label70:
        if (this.jdField_a_of_type_Int <= 3) {
          break label566;
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label103:
        if (this.jdField_b_of_type_Int >= getChildCount() - 4) {
          break label597;
        }
        if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != this.jdField_a_of_type_AndroidWidgetImageView.getVisibility())) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
        }
        if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != this.jdField_b_of_type_AndroidWidgetImageView.getVisibility())) {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_b_of_type_AndroidWidgetImageView.getVisibility());
        }
        return;
        if (i == j) {
          break label70;
        }
        setMinimumWidth(this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_Int -= 2;
          label262:
          if (this.jdField_b_of_type_Int < 0) {
            this.jdField_b_of_type_Int = 0;
          }
          if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {
            this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          }
          a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_Int <= 3) {
            break label504;
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          label338:
          if (this.jdField_b_of_type_Int >= getChildCount() - 4) {
            break label535;
          }
          if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        for (;;)
        {
          if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != this.jdField_a_of_type_AndroidWidgetImageView.getVisibility())) {
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
          }
          if ((this.jdField_d_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == this.jdField_b_of_type_AndroidWidgetImageView.getVisibility())) {
            break label628;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_b_of_type_AndroidWidgetImageView.getVisibility());
          i = j;
          break;
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_Int += 2;
            break label262;
          }
          this.jdField_b_of_type_Int -= 2;
          break label262;
          label504:
          if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
            break label338;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label338;
          label535:
          if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        label566:
        if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          break label103;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label103;
        label597:
        if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      label628:
      i = j;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      if (this.jdField_a_of_type_Int > 3)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int - 2);
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        b();
        this.jdField_b_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Int < getChildCount() - 4)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int + 2);
        this.jdField_b_of_type_Int = (getChildCount() - 3);
        if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        b();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout
 * JD-Core Version:    0.7.0.1
 */