package com.tencent.mobileqq.now.recommend;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.mobileqq.now.VideoCardHolder;

public class RecommendSpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public RecommendSpacesItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = paramView.getTag();
    int j = 0;
    if ((paramRecyclerView != null) && ((paramView.getTag() instanceof VideoCardHolder)))
    {
      int m = ((VideoCardHolder)paramView.getTag()).j;
      int i = -1;
      if ((paramView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
        i = ((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex();
      }
      if (i >= 0)
      {
        if (i % 2 == 0)
        {
          int k = this.a;
          paramRect.left = k;
          i = j;
          if (m == 2) {
            i = k;
          }
          paramRect.top = i;
          i = this.a;
          paramRect.right = (i / 2);
          paramRect.bottom = i;
          return;
        }
        i = this.a;
        paramRect.left = (i / 2);
        if (m != 3) {
          i = 0;
        }
        paramRect.top = i;
        i = this.a;
        paramRect.right = i;
        paramRect.bottom = i;
        return;
      }
      i = this.a;
      paramRect.left = (i / 2);
      paramRect.top = 0;
      paramRect.right = (i / 2);
      paramRect.bottom = i;
      return;
    }
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendSpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */