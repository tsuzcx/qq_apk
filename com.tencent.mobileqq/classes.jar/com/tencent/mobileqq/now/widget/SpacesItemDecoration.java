package com.tencent.mobileqq.now.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public SpacesItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = this.a;
    paramRect.top = i;
    paramRect.bottom = 0;
    paramRect.left = (i / 2);
    paramRect.right = (i / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */