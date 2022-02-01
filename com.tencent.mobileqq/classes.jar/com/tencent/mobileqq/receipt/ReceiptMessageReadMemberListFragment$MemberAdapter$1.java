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
      if (ReceiptMessageReadMemberListFragment.MemberAdapter.b(this.a).isPausing()) {
        ReceiptMessageReadMemberListFragment.MemberAdapter.b(this.a).resume();
      }
      int i = ReceiptMessageReadMemberListFragment.MemberAdapter.c(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = ReceiptMessageReadMemberListFragment.MemberAdapter.c(this.a).getChildAt(paramInt);
        paramRecyclerView = (ReceiptMessageReadMemberListFragment.MemberViewHolder)ReceiptMessageReadMemberListFragment.MemberAdapter.c(this.a).getChildViewHolder(paramRecyclerView);
        ReceiptMessageReadMemberListFragment.MemberViewHolder.b(paramRecyclerView).setImageBitmap(ReceiptMessageReadMemberListFragment.MemberAdapter.a(this.a, ReceiptMessageReadMemberListFragment.MemberViewHolder.c(paramRecyclerView)));
        paramInt += 1;
      }
    }
    ReceiptMessageReadMemberListFragment.MemberAdapter.b(this.a).cancelPendingRequests();
    ReceiptMessageReadMemberListFragment.MemberAdapter.b(this.a).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberAdapter.1
 * JD-Core Version:    0.7.0.1
 */