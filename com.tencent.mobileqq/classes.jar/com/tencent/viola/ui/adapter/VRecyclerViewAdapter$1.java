package com.tencent.viola.ui.adapter;

import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.diff.DomDiffUtils.OnComponentDiffListener;

class VRecyclerViewAdapter$1
  implements DomDiffUtils.OnComponentDiffListener
{
  VRecyclerViewAdapter$1(VRecyclerViewAdapter paramVRecyclerViewAdapter, VRecyclerViewAdapter.VH paramVH) {}
  
  public void onCellChange(VCell paramVCell1, VCell paramVCell2)
  {
    this.val$holder.mVCell = paramVCell2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VRecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */