package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendFragment$1
  extends RedpointObserver
{
  ExtendFriendFragment$1(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendFragment", 2, String.format("onDataChange success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ExtendFriendFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.1
 * JD-Core Version:    0.7.0.1
 */