package com.tencent.mobileqq.extendfriend.fragment;

import cooperation.qzone.api.QZoneApiProxy;

class ExtendFriendFragment$8
  implements Runnable
{
  ExtendFriendFragment$8(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void run()
  {
    if (ExtendFriendFragment.a()) {
      QZoneApiProxy.initSchoolExtendListCreator();
    }
    ExtendFriendFragment.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.8
 * JD-Core Version:    0.7.0.1
 */