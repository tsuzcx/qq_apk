package com.tencent.mobileqq.receipt;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class ReceiptMessageReadMemberListFragment$DividerItemDecoration
  extends RecyclerView.ItemDecoration
{
  private Drawable a;
  private int b;
  private int c;
  
  private ReceiptMessageReadMemberListFragment$DividerItemDecoration(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.a = paramDrawable;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.set(0, 0, 0, this.a.getIntrinsicHeight());
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = this.b;
    int m = paramRecyclerView.getWidth();
    int n = paramRecyclerView.getPaddingRight();
    int i1 = this.c;
    int i2 = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < i2)
    {
      paramState = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      int i3 = paramState.getBottom() + localLayoutParams.bottomMargin;
      int i4 = this.a.getIntrinsicHeight();
      this.a.setBounds(j + k, i3, m - n - i1, i4 + i3);
      this.a.draw(paramCanvas);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.DividerItemDecoration
 * JD-Core Version:    0.7.0.1
 */