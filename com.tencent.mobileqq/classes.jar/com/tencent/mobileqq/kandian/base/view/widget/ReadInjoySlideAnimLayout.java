package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class ReadInjoySlideAnimLayout
  extends FrameLayout
{
  public View a;
  public FrameLayout b;
  private TextView c;
  private boolean d;
  
  public ReadInjoySlideAnimLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131626331, this, true);
    this.b = ((FrameLayout)paramContext.findViewById(2131431340));
    this.c = ((TextView)paramContext.findViewById(2131444559));
  }
  
  public void a()
  {
    View localView = this.a;
    if (localView != null) {
      this.b.removeView(localView);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(View paramView)
  {
    View localView = this.a;
    if ((localView != null) && (localView != paramView)) {
      this.b.removeView(localView);
    }
    this.a = paramView;
    paramView = new FrameLayout.LayoutParams(-1, -1);
    this.b.addView(this.a, 0, paramView);
    this.b.setBackgroundColor(0);
  }
  
  public void setDisableContentTouch(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setMessage(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      this.c.setText(paramString);
      return;
    }
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout
 * JD-Core Version:    0.7.0.1
 */