package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.widget.XPanelContainer;

class HongBaoPanel$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  public HongBaoPanel$SpaceItemDecoration(HongBaoPanel paramHongBaoPanel)
  {
    boolean bool;
    if (XPanelContainer.a > paramHongBaoPanel.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 196.0F) {
      bool = true;
    } else {
      bool = false;
    }
    paramHongBaoPanel.jdField_a_of_type_Boolean = bool;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).getItemCount();
    if (this.a.jdField_a_of_type_Boolean) {
      paramRect.top = this.a.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */