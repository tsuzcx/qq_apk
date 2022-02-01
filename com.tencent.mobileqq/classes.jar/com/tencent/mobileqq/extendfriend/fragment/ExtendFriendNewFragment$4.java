package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;

class ExtendFriendNewFragment$4
  implements QZoneApiProxy.QZoneLoadCallback
{
  ExtendFriendNewFragment$4(ExtendFriendNewFragment paramExtendFriendNewFragment) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("ExtendFriendNewFragment", 1, "preLoadData qzone plugin onLoadOver : " + paramBoolean);
    ExtendFriendNewFragment.a(paramBoolean);
    if (!paramBoolean) {
      ExtendFriendNewFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment.4
 * JD-Core Version:    0.7.0.1
 */