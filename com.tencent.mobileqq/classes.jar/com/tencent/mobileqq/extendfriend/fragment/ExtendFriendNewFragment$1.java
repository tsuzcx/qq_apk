package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendNewFragment$1
  extends RedpointObserver
{
  ExtendFriendNewFragment$1(ExtendFriendNewFragment paramExtendFriendNewFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, String.format("onDataChange success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ExtendFriendNewFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment.1
 * JD-Core Version:    0.7.0.1
 */