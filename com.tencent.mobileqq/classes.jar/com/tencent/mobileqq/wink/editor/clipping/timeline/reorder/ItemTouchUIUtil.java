package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract interface ItemTouchUIUtil
{
  public abstract void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract void a(View paramView);
  
  public abstract void b(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract void b(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchUIUtil
 * JD-Core Version:    0.7.0.1
 */