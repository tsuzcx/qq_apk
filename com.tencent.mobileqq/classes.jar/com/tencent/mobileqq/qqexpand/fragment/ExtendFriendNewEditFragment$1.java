package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

class ExtendFriendNewEditFragment$1
  implements ConditionSearchManager.IConfigListener
{
  ExtendFriendNewEditFragment$1(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ExtendFriendNewEditFragment.a(this.a);
    if (!paramBoolean)
    {
      this.a.a(1, "获取地区失败，请稍后再试。", true);
      return;
    }
    if ((this.a.isVisible()) && (paramInt == 2)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.1
 * JD-Core Version:    0.7.0.1
 */