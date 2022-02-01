package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Handler;
import blvu;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class ExtendFriendFragment$7
  implements Runnable
{
  ExtendFriendFragment$7(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void run()
  {
    if (blvu.c()) {
      ExtendFriendFragment.a(blvu.b(this.this$0.getActivity(), ExtendFriendFragment.a(this.this$0)));
    }
    QzoneHandlerThreadFactory.getMainHandler().post(new ExtendFriendFragment.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.7
 * JD-Core Version:    0.7.0.1
 */