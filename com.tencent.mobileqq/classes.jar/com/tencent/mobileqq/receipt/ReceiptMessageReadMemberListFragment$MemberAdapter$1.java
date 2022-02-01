package com.tencent.mobileqq.receipt;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class ReceiptMessageReadMemberListFragment$MemberAdapter$1
  extends RecyclerView.OnScrollListener
{
  ReceiptMessageReadMemberListFragment$MemberAdapter$1(ReceiptMessageReadMemberListFragment.MemberAdapter paramMemberAdapter) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a, paramInt);
    if (ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a) == 0)
    {
      if (ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).isPausing()) {
        ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).resume();
      }
      int i = ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (ReceiptMessageReadMemberListFragment.MemberViewHolder)ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).getChildViewHolder(paramRecyclerView);
        ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramRecyclerView).setImageBitmap(ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a, ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).cancelPendingRequests();
    ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberAdapter.1
 * JD-Core Version:    0.7.0.1
 */