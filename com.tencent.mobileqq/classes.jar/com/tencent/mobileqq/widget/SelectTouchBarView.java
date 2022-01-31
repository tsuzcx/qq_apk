package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baxn;
import bbdh;

public class SelectTouchBarView
  extends RelativeLayout
{
  protected int a;
  private Context a;
  protected TextView a;
  protected MutliSeletedBottomLine a;
  protected CharSequence a;
  private int b;
  protected MutliSeletedBottomLine b;
  
  public SelectTouchBarView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131558576, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362360));
    a((RelativeLayout)findViewById(2131362359));
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    int i = (int)bbdh.a(true);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.measure(j, j);
    j = (i - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() - baxn.a(this.jdField_a_of_type_AndroidContentContext, 16.0F)) / 2;
    i = j;
    if (j < 0) {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine = new MutliSeletedBottomLine(this.jdField_a_of_type_AndroidContentContext, i, false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine = new MutliSeletedBottomLine(this.jdField_a_of_type_AndroidContentContext, i, true);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams1.addRule(9);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams2.addRule(11);
    paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine, localLayoutParams1);
    paramRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine, localLayoutParams2);
  }
  
  public SelectTouchBarView a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = 30;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = this.jdField_a_of_type_Int;
    localLayoutParams.width = -1;
    setLayoutParams(localLayoutParams);
    a();
    return this;
  }
  
  public SelectTouchBarView a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt <= 0) {
      this.jdField_a_of_type_Int = 0;
    }
    setMinimumHeight(this.jdField_a_of_type_Int);
    return this;
  }
  
  public SelectTouchBarView a(CharSequence paramCharSequence)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramCharSequence);
    }
    return this;
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131362359);
    localRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine);
    localRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetMutliSeletedBottomLine);
    a(localRelativeLayout);
    invalidate();
  }
  
  public void setCheckedNum(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      localStringBuilder.append("选择到这里");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localStringBuilder.toString());
      a();
      return;
      localStringBuilder.append("选择到这里(已选" + paramInt + "条)");
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SelectTouchBarView
 * JD-Core Version:    0.7.0.1
 */