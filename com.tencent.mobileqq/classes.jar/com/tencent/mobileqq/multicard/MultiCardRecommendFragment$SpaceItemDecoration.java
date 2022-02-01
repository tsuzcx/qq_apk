package com.tencent.mobileqq.multicard;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class MultiCardRecommendFragment$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final int jdField_a_of_type_Int = AIOUtils.b(12.0F, this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources());
  
  private MultiCardRecommendFragment$SpaceItemDecoration(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.top = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */