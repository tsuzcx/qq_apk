package com.tencent.mobileqq.winkpublish.preview.itemtouchhelper;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ItemTouchUIUtilImpl$Honeycomb
  implements ItemTouchUIUtil
{
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void a(View paramView)
  {
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void b(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.itemtouchhelper.ItemTouchUIUtilImpl.Honeycomb
 * JD-Core Version:    0.7.0.1
 */