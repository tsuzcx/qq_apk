package com.tencent.widget.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemTouchUIUtilImpl$Lollipop
  extends ItemTouchUIUtilImpl.Honeycomb
{
  private float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
  {
    int j = paramRecyclerView.getChildCount();
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      float f2;
      if (localView == paramView)
      {
        f2 = f1;
      }
      else
      {
        float f3 = ViewCompat.getElevation(localView);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
    }
    return f1;
  }
  
  public void clearView(View paramView)
  {
    Object localObject = paramView.getTag(2131369164);
    if ((localObject != null) && ((localObject instanceof Float))) {
      ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
    }
    paramView.setTag(2131369164, null);
    super.clearView(paramView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramView.getTag(2131369164) == null))
    {
      float f = ViewCompat.getElevation(paramView);
      ViewCompat.setElevation(paramView, findMaxElevation(paramRecyclerView, paramView) + 1.0F);
      paramView.setTag(2131369164, Float.valueOf(f));
    }
    super.onDraw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl.Lollipop
 * JD-Core Version:    0.7.0.1
 */