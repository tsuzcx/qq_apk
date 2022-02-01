package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.mobileqq.utils.ViewUtils;

class BirthdayHbFragment$6
  extends RecyclerView.ItemDecoration
{
  BirthdayHbFragment$6(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if (i % 3 == 0)
    {
      paramRect.left = ViewUtils.dip2px(16.0F);
      paramRect.right = ViewUtils.dip2px(4.0F);
    }
    else if ((i + 1) % 3 == 0)
    {
      paramRect.left = ViewUtils.dip2px(4.0F);
      paramRect.right = ViewUtils.dip2px(16.0F);
    }
    else
    {
      paramRect.left = ViewUtils.dip2px(4.0F);
      paramRect.right = ViewUtils.dip2px(4.0F);
    }
    paramRect.bottom = ViewUtils.dip2px(8.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.6
 * JD-Core Version:    0.7.0.1
 */