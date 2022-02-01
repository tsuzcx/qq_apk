package com.tencent.mobileqq.forward;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ForwardTroopMemberControllerForMiniPie$TroopMemberRecyclerViewAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ForwardTroopMemberControllerForMiniPie$TroopMemberRecyclerViewAdapter$1(ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter paramTroopMemberRecyclerViewAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == ForwardTroopMemberControllerForMiniPie.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */