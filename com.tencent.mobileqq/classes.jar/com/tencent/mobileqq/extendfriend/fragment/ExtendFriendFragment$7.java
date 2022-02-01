package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Handler;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class ExtendFriendFragment$7
  implements Runnable
{
  ExtendFriendFragment$7(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void run()
  {
    if (QZoneApiProxy.needLoadQZoneEnv()) {
      ExtendFriendFragment.a(QZoneApiProxy.needShowSchoolExtendFeed(this.this$0.getActivity(), ExtendFriendFragment.a(this.this$0)));
    }
    QzoneHandlerThreadFactory.getMainHandler().post(ExtendFriendFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.7
 * JD-Core Version:    0.7.0.1
 */