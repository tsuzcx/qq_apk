package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.widget.SwipListView;

public class FitHeightListView
  extends SwipListView
{
  float a = 0.0F;
  
  public FitHeightListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitHeightListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FitHeightListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked() & 0xFF;
    if (i == 0) {
      this.a = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (i == 2) {
        paramMotionEvent.offsetLocation(0.0F, this.a - paramMotionEvent.getRawY());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FitHeightListView
 * JD-Core Version:    0.7.0.1
 */