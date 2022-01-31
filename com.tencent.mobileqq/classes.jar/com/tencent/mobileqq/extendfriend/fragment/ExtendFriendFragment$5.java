package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Handler;
import bjho;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class ExtendFriendFragment$5
  implements Runnable
{
  ExtendFriendFragment$5(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void run()
  {
    if (bjho.c()) {
      ExtendFriendFragment.a(bjho.b(this.this$0.getActivity(), ExtendFriendFragment.a(this.this$0)));
    }
    QzoneHandlerThreadFactory.getMainHandler().post(new ExtendFriendFragment.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.5
 * JD-Core Version:    0.7.0.1
 */