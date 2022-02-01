package com.tencent.mobileqq.qqexpand.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class ExtendFriendSearchFragment$7
  extends RecyclerView.AdapterDataObserver
{
  ExtendFriendSearchFragment$7(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.7
 * JD-Core Version:    0.7.0.1
 */