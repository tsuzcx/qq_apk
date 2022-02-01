package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ClickPreventableTextView
  extends TextView
  implements View.OnClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ClickPreventableTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickPreventableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickPreventableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getMovementMethod() != null) {
      getMovementMethod().onTouchEvent(this, (Spannable)getText(), paramMotionEvent);
    }
    this.b = true;
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.b = false;
    return bool;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    super.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ClickPreventableTextView
 * JD-Core Version:    0.7.0.1
 */