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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  private int jdField_d_of_type_Int = 0;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  
  public QQCustomMenuLayout(Context paramContext)
  {
    super(paramContext);
    Object localObject = paramContext.getResources();
    this.jdField_c_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = ((Resources)localObject).getDisplayMetrics().density;
    int i = this.jdField_c_of_type_Int;
    float f1 = this.jdField_a_of_type_Float;
    this.jdField_c_of_type_Int = (i - (int)(f1 * 10.0F));
    if (f1 >= 2.0F) {
      i = 20;
    } else {
      i = 12;
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(TypedValue.applyDimension(2, 15.0F, ((Resources)localObject).getDisplayMetrics()));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838914);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131710156));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    f1 = i;
    float f2 = this.jdField_a_of_type_Float;
    ((ImageView)localObject).setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(f1 * f2), (int)(f2 * 10.0F));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, 0);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838899);
    if (!AppSetting.d) {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("leftIcon");
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_c_of_type_AndroidWidgetImageView, 1);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838899);
    if (!AppSetting.d) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription("rightIcon");
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_d_of_type_AndroidWidgetImageView, 2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838921);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131710142));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramContext = this.jdField_b_of_type_AndroidWidgetImageView;
    f2 = this.jdField_a_of_type_Float;
    paramContext.setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(f1 * f2), (int)(f2 * 10.0F));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, 3);
  }
  
  private int a()
  {
    int m = getChildCount();
    int i = 0;
    onMeasure(0, 0);
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView != null)
      {
        k = j;
        if (localView.getVisibility() != 8)
        {
          Object localObject;
          if ((localView instanceof TextView))
          {
            localObject = (TextView)localView;
            k = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), this.jdField_a_of_type_AndroidTextTextPaint);
            if (QLog.isDevelopLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("child  TextView text ");
              localStringBuilder.append(((TextView)localObject).getText());
              localStringBuilder.append(" measureWidth = ");
              localStringBuilder.append(k);
              localStringBuilder.append(" padding = ");
              localStringBuilder.append(localView.getPaddingLeft());
              QLog.d("QQCustomMenuLayout", 4, localStringBuilder.toString());
            }
            j = j + k + this.jdField_d_of_type_Int;
          }
          else
          {
            int n = localView.getMeasuredWidth();
            k = j + n;
            j = k;
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("child  nonTextView measureWidth = ");
              ((StringBuilder)localObject).append(n);
              QLog.d("QQCustomMenuLayout", 4, ((StringBuilder)localObject).toString());
              j = k;
            }
          }
          k = j + localView.getPaddingLeft() + localView.getPaddingRight();
        }
      }
      i += 1;
    }
    return j;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int > 3)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (localImageView.getVisibility() != 0)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_Int < getChildCount() - 4)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (localImageView.getVisibility() != 0)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (localImageView.getVisibility() != this.jdField_a_of_type_AndroidWidgetImageView.getVisibility())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
    }
    localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null) && (localImageView.getVisibility() != this.jdField_b_of_type_AndroidWidgetImageView.getVisibility())) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_b_of_type_AndroidWidgetImageView.getVisibility());
    }
  }
  
  public void a()
  {
    int j;
    for (int i = -1;; i = j)
    {
      j = a();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("totalWidth = ");
        localStringBuilder.append(j);
        localStringBuilder.append(" startPosition = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" endPosition = ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        QLog.d("QQCustomMenuLayout", 4, localStringBuilder.toString());
      }
      int k = this.jdField_c_of_type_Int;
      if ((j <= k) || (i == j))
      {
        b();
        return;
      }
      setMinimumWidth(k);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int -= 2;
      } else if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Int += 2;
      } else {
        this.jdField_b_of_type_Int -= 2;
      }
      if (this.jdField_b_of_type_Int < 0) {
        this.jdField_b_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      if (i > k) {
        this.jdField_a_of_type_Int = k;
      }
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 2;
    while (i < getChildCount() - 2)
    {
      if ((i >= paramInt1) && (i <= paramInt2)) {
        getChildAt(i).setVisibility(0);
      } else {
        getChildAt(i).setVisibility(8);
      }
      i += 1;
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
  
  public void onClick(View paramView)
  {
    int i;
    int j;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      i = this.jdField_a_of_type_Int;
      if (i > 3)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_Int = (i - 2);
        this.jdField_a_of_type_Int = 2;
        i = this.jdField_a_of_type_Int;
        j = this.jdField_b_of_type_Int;
        if (i > j) {
          this.jdField_a_of_type_Int = j;
        }
        a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        a();
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else if (this.jdField_a_of_type_Int < getChildCount() - 4)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int + 2);
      this.jdField_b_of_type_Int = (getChildCount() - 3);
      i = this.jdField_a_of_type_Int;
      j = this.jdField_b_of_type_Int;
      if (i > j) {
        this.jdField_a_of_type_Int = j;
      }
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      a();
      this.jdField_a_of_type_Boolean = false;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout
 * JD-Core Version:    0.7.0.1
 */