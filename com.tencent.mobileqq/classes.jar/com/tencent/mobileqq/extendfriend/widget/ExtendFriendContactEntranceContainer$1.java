package com.tencent.mobileqq.extendfriend.widget;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import mqq.os.MqqHandler;

class ExtendFriendContactEntranceContainer$1
  extends ExpandObserver
{
  ExtendFriendContactEntranceContainer$1(ExtendFriendContactEntranceContainer paramExtendFriendContactEntranceContainer) {}
  
  protected void a(int paramInt)
  {
    ExtendFriendContactEntranceContainer.a(this.a, paramInt);
  }
  
  protected void c(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new ExtendFriendContactEntranceContainer.1.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.1
 * JD-Core Version:    0.7.0.1
 */