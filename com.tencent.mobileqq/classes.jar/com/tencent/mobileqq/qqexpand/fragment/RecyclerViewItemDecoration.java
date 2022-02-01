package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.util.DisplayUtil;

class RecyclerViewItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public RecyclerViewItemDecoration(QBaseFragment paramQBaseFragment)
  {
    this.a = DisplayUtil.a(paramQBaseFragment.getContext(), 11.0F);
    this.b = DisplayUtil.a(paramQBaseFragment.getContext(), 11.0F);
    this.c = DisplayUtil.a(paramQBaseFragment.getContext(), 8.0F);
    this.d = DisplayUtil.a(paramQBaseFragment.getContext(), 8.0F);
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getAdapter().getItemCount();
    if (paramRecyclerView.getAdapter().getItemViewType(paramInt) == 6)
    {
      paramRect.set(0, this.a, 0, 0);
      return;
    }
    if (paramInt == i - 1)
    {
      paramRect.set(this.c, this.a, this.d, this.b);
      return;
    }
    paramRect.set(this.c, this.a, this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.RecyclerViewItemDecoration
 * JD-Core Version:    0.7.0.1
 */