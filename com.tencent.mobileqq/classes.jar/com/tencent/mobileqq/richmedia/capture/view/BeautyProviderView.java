package com.tencent.mobileqq.richmedia.capture.view;

import alud;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axom;
import axsd;

public class BeautyProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 6;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private int b;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130845512);
    paramTextView.setTextColor(Color.parseColor("#12B7F5"));
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130845511);
    paramTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
  
  public void a(Bundle paramBundle)
  {
    setNeedTabBar(false);
    super.a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561240, this, false));
    }
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363151));
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramBundle = new RelativeLayout(getContext());
      Object localObject = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBundle.setGravity(17);
      paramBundle.setOnClickListener(this);
      paramBundle.setTag(Integer.valueOf(i));
      localObject = new TextView(getContext());
      ((TextView)localObject).setBackgroundResource(2130845511);
      ((TextView)localObject).setText(i + "");
      ((TextView)localObject).setTextSize(18.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramBundle.addView((View)localObject);
      paramBundle.setContentDescription(alud.a(2131701465) + i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
      i += 1;
    }
    setBeautyLevel(this.b);
  }
  
  public void aJ_()
  {
    super.aJ_();
    axom.a().b(getContext());
  }
  
  public void onClick(View paramView)
  {
    setBeautyLevel(((Integer)paramView.getTag()).intValue());
    this.jdField_a_of_type_Axsd.a(((Integer)paramView.getTag()).intValue());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    int j = (int)paramFloat;
    if ((j < 0) || (j >= this.jdField_a_of_type_Int)) {}
    do
    {
      return;
      this.b = j;
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      b((TextView)((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).getChildAt(0));
      i += 1;
    }
    a((TextView)((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j)).getChildAt(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */