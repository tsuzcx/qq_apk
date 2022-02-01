package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bbje;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BeautyProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 6;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private int d;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130845913);
    paramTextView.setTextColor(Color.parseColor("#12B7F5"));
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130845912);
    paramTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
  
  public void onClick(View paramView)
  {
    setBeautyLevel(((Integer)paramView.getTag()).intValue());
    this.jdField_a_of_type_Bbje.a(((Integer)paramView.getTag()).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
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
      this.d = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */