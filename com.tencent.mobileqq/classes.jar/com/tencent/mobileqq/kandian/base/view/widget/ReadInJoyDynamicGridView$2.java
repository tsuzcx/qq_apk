package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class ReadInJoyDynamicGridView$2
  implements TypeEvaluator<Rect>
{
  ReadInJoyDynamicGridView$2(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + paramFloat * (paramInt2 - paramInt1));
  }
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(a(paramRect1.left, paramRect2.left, paramFloat), a(paramRect1.top, paramRect2.top, paramFloat), a(paramRect1.right, paramRect2.right, paramFloat), a(paramRect1.bottom, paramRect2.bottom, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.2
 * JD-Core Version:    0.7.0.1
 */