package com.tencent.mobileqq.onlinestatus.location;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import bkpg;
import bqcd;

public class LocationHeadSetView
  extends LinearLayout
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public LocationHeadSetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    b();
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131376788);
    if (bkpg.a())
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bqcd.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      if (bqcd.jdField_a_of_type_Boolean)
      {
        View localView = a(2131371808);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localLayoutParams.height = bqcd.jdField_a_of_type_Int;
        localView.setLayoutParams(localLayoutParams);
        localView.setVisibility(0);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = inflate(getContext(), 2131559296, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368947));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378600));
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public void setHeadSetClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setImmersiveHeight(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.setPadding(0, paramInt, 0, 0);
  }
  
  public void setTitleText(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHeadSetView
 * JD-Core Version:    0.7.0.1
 */