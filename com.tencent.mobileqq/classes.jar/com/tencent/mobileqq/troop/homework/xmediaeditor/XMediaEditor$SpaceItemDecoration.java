package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class XMediaEditor$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public XMediaEditor$SpaceItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getChildAdapterPosition(paramView) != 0) {
      paramRect.top = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */