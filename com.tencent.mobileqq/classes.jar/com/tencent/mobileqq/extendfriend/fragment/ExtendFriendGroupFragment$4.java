package com.tencent.mobileqq.extendfriend.fragment;

import aohs;
import bbfj;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;

class ExtendFriendGroupFragment$4
  implements Runnable
{
  ExtendFriendGroupFragment$4(ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void run()
  {
    if (bbfj.g(ExtendFriendGroupFragment.a(this.this$0)))
    {
      if (ExtendFriendGroupFragment.a(this.this$0) != null)
      {
        ExtendFriendGroupFragment.a(this.this$0).setRefreshing();
        ExtendFriendGroupFragment.a(this.this$0).a(0, true);
      }
      return;
    }
    ExtendFriendGroupFragment.a(this.this$0, this.this$0.getString(2131694972), 1);
    ExtendFriendGroupFragment.a(this.this$0).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment.4
 * JD-Core Version:    0.7.0.1
 */