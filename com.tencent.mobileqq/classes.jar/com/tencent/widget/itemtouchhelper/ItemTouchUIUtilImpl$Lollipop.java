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
    int i = 0;
    float f1 = 0.0F;
    if (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      float f2;
      if (localView == paramView) {
        f2 = f1;
      }
      for (;;)
      {
        i += 1;
        f1 = f2;
        break;
        float f3 = ViewCompat.getElevation(localView);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
    }
    return f1;
  }
  
  public void clearView(View paramView)
  {
    Object localObject = paramView.getTag(2131369436);
    if ((localObject != null) && ((localObject instanceof Float))) {
      ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
    }
    paramView.setTag(2131369436, null);
    super.clearView(paramView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramView.getTag(2131369436) == null))
    {
      float f = ViewCompat.getElevation(paramView);
      ViewCompat.setElevation(paramView, 1.0F + findMaxElevation(paramRecyclerView, paramView));
      paramView.setTag(2131369436, Float.valueOf(f));
    }
    super.onDraw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl.Lollipop
 * JD-Core Version:    0.7.0.1
 */