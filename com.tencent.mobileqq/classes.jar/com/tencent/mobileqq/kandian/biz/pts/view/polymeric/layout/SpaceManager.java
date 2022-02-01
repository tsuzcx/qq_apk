package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.layout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpaceManager
  extends RecyclerView.ItemDecoration
{
  boolean a = true;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public SpaceManager(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramBoolean;
    this.c = paramInt1;
    this.e = paramInt2;
    this.b = paramInt3;
    this.d = paramInt4;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (this.a)
    {
      paramRect.top = this.b;
      paramRect.bottom = this.d;
      if (i == 0) {
        paramRect.left = this.c;
      }
      if (i == paramState.getItemCount() - 1) {
        paramRect.right = this.e;
      }
    }
    else
    {
      paramRect.left = this.c;
      paramRect.right = this.e;
      if (i == 0) {
        paramRect.top = this.b;
      }
      if (i == paramState.getItemCount() - 1) {
        paramRect.bottom = this.d;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.layout.SpaceManager
 * JD-Core Version:    0.7.0.1
 */