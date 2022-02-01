package com.tencent.widget.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemTouchUIUtilImpl$Honeycomb
  implements ItemTouchUIUtil
{
  public void clearView(View paramView)
  {
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void onSelected(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl.Honeycomb
 * JD-Core Version:    0.7.0.1
 */