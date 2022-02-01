package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class AnonymousView$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int firstItemLeftSpace;
  private int space;
  
  public AnonymousView$SpacesItemDecoration(int paramInt1, int paramInt2)
  {
    this.space = paramInt1;
    this.firstItemLeftSpace = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getChildPosition(paramView) == 0)
    {
      paramRect.left = this.firstItemLeftSpace;
      return;
    }
    paramRect.left = this.space;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */