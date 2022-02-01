package com.tencent.mobileqq.mini.entry.search.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class SearchRecommendAdapter$TitleDecoration
  extends RecyclerView.ItemDecoration
{
  private Paint paint = new Paint();
  
  public SearchRecommendAdapter$TitleDecoration()
  {
    this.paint.setColor(-1315339);
    this.paint.setAntiAlias(true);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i < 0) {
      return;
    }
    if ((paramRecyclerView.getAdapter().getItemViewType(i) == 1) && (i > 0))
    {
      paramRect.set(0, ViewUtils.dpToPx(20.0F), 0, 0);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      if (paramState != null)
      {
        int k = paramRecyclerView.getChildAdapterPosition(paramState);
        if (k < 0) {
          return;
        }
        if ((paramRecyclerView.getAdapter().getItemViewType(k) == 1) && (k > 0)) {
          paramCanvas.drawRect(paramState.getLeft(), paramState.getTop() - ViewUtils.dpToPx(20.0F), paramRecyclerView.getWidth(), paramState.getTop() - ViewUtils.dpToPx(20.0F) + 2, this.paint);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.TitleDecoration
 * JD-Core Version:    0.7.0.1
 */