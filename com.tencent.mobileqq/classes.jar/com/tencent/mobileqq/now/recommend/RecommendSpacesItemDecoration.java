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
    int j = 0;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof VideoCardHolder)))
    {
      int k = ((VideoCardHolder)paramView.getTag()).a;
      int i = -1;
      if ((paramView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
        i = ((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex();
      }
      if (i >= 0)
      {
        if (i % 2 == 0)
        {
          paramRect.left = this.a;
          if (k == 2) {}
          for (i = this.a;; i = 0)
          {
            paramRect.top = i;
            paramRect.right = (this.a / 2);
            paramRect.bottom = this.a;
            return;
          }
        }
        paramRect.left = (this.a / 2);
        i = j;
        if (k == 3) {
          i = this.a;
        }
        paramRect.top = i;
        paramRect.right = this.a;
        paramRect.bottom = this.a;
        return;
      }
      paramRect.left = (this.a / 2);
      paramRect.top = 0;
      paramRect.right = (this.a / 2);
      paramRect.bottom = this.a;
      return;
    }
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendSpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */