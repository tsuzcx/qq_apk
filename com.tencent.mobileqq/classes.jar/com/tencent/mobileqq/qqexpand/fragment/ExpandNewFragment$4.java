package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;

class ExpandNewFragment$4
  implements QZoneApiProxy.QZoneLoadCallback
{
  ExpandNewFragment$4(ExpandNewFragment paramExpandNewFragment) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLoadData qzone plugin onLoadOver : ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendNewFragment", 1, localStringBuilder.toString());
    ExpandNewFragment.a(paramBoolean);
    if (!paramBoolean) {
      ExpandNewFragment.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment.4
 * JD-Core Version:    0.7.0.1
 */