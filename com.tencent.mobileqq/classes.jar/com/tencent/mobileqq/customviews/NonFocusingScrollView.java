package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class NonFocusingScrollView
  extends ScrollView
{
  public NonFocusingScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollTo(0, 0);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.NonFocusingScrollView
 * JD-Core Version:    0.7.0.1
 */