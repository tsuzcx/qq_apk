package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

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
    paramRect.left = this.a;
    int i;
    if (paramRecyclerView.getAdapter() != null) {
      i = paramRecyclerView.getAdapter().getItemCount();
    } else {
      i = 0;
    }
    if ((i != 0) && (paramRecyclerView.getChildLayoutPosition(paramView) == i - 1)) {
      paramRect.right = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */