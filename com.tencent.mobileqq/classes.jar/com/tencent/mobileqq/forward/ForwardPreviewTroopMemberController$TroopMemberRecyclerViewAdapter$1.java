package com.tencent.mobileqq.forward;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter$1(ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter paramTroopMemberRecyclerViewAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == ForwardPreviewTroopMemberController.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */