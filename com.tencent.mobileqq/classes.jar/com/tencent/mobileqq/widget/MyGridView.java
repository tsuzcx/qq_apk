package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class MyGridView
  extends GridView
{
  private boolean a = false;
  
  public MyGridView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.a) {
      bool = false;
    }
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MyGridView
 * JD-Core Version:    0.7.0.1
 */