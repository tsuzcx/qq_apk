package com.tencent.mobileqq.profile;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class CustomCoverFragment$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  
  public CustomCoverFragment$SpaceItemDecoration(CustomCoverFragment paramCustomCoverFragment, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (!(paramView.getTag() instanceof CustomCoverFragment.ItemViewHolder))
    {
      paramRect.left = 0;
      return;
    }
    int i = paramRecyclerView.getChildLayoutPosition(paramView) - 1;
    float f = this.jdField_a_of_type_Int * 2 * 1.0F / 3.0F;
    paramRect.left = ((int)(i % 3 * (this.jdField_a_of_type_Int - f)));
    paramRect.right = ((int)(f - i % 3 * (this.jdField_a_of_type_Int - f)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */