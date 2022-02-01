package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;

public class ReadInJoyPicWaterFallFragment$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int b;
  
  public ReadInJoyPicWaterFallFragment$SpaceItemDecoration(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0)
    {
      i = this.b;
      paramRect.left = (i * 2);
      paramRect.right = i;
      return;
    }
    int i = this.b;
    paramRect.left = (i / 2);
    paramRect.right = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */