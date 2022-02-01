package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.network.ExpandObserver;

class ExtendFriendNewEditFragment$18
  extends ExpandObserver
{
  ExtendFriendNewEditFragment$18(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      ExtendFriendNewEditFragment.a(this.a);
      ExtendFriendNewEditFragment.b(this.a, (String)paramObject);
      ExtendFriendNewEditFragment.u(this.a);
      return;
    }
    this.a.a(1, "获取个人信息失败", false);
    ExtendFriendNewEditFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.18
 * JD-Core Version:    0.7.0.1
 */