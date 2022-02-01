package com.tencent.mobileqq.guild.privatechannel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class TouchCrossLinearLayout
  extends LinearLayout
{
  private int a = 0;
  
  public TouchCrossLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchCrossLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchCrossLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RequiresApi(api=21)
  public TouchCrossLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onInterceptTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.width == -1) {
      paramLayoutParams.width = this.a;
    } else {
      this.a = paramLayoutParams.width;
    }
    super.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.TouchCrossLinearLayout
 * JD-Core Version:    0.7.0.1
 */