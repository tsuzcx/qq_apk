package com.tencent.mobileqq.qqexpand.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class ExtendFriendSquareFragment$4
  extends RecyclerView.AdapterDataObserver
{
  ExtendFriendSquareFragment$4(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onChanged()
  {
    if (this.a.m.b() == 0)
    {
      this.a.p.removeItemDecoration(this.a.r);
      return;
    }
    this.a.p.removeItemDecoration(this.a.r);
    this.a.p.addItemDecoration(this.a.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.4
 * JD-Core Version:    0.7.0.1
 */