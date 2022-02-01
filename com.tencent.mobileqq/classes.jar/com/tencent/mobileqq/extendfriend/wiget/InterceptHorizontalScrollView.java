package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

public class InterceptHorizontalScrollView
  extends HorizontalScrollView
{
  public InterceptHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public InterceptHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    paramInt7 = (int)(paramInt1 * 0.3F);
    if ((paramInt3 + paramInt1 == 0) || (paramInt3 - paramInt5 + paramInt1 == 0)) {
      paramInt7 = paramInt1;
    }
    return super.overScrollBy(paramInt7, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 180, paramInt8, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.InterceptHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */