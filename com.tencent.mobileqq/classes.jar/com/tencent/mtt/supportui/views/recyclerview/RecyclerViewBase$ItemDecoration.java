package com.tencent.mtt.supportui.views.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class RecyclerViewBase$ItemDecoration
{
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerViewBase paramRecyclerViewBase)
  {
    paramRect.set(0, 0, 0, 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerViewBase paramRecyclerViewBase) {}
  
  public void onDrawOver(Canvas paramCanvas, RecyclerViewBase paramRecyclerViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ItemDecoration
 * JD-Core Version:    0.7.0.1
 */