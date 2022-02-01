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
  private boolean a;
  private View.OnClickListener b;
  private boolean c;
  
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
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    this.a = true;
  }
  
  public void onClick(View paramView)
  {
    if (this.a)
    {
      this.a = false;
    }
    else
    {
      View.OnClickListener localOnClickListener = this.b;
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
    this.c = true;
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.c = false;
    return bool;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
    super.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ClickPreventableTextView
 * JD-Core Version:    0.7.0.1
 */