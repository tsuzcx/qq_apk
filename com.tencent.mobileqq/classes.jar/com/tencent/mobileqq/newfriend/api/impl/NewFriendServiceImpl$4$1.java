package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import java.util.Iterator;
import java.util.LinkedList;

class NewFriendServiceImpl$4$1
  implements Runnable
{
  NewFriendServiceImpl$4$1(NewFriendServiceImpl.4 param4, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      synchronized (NewFriendServiceImpl.access$100(this.b.a))
      {
        Iterator localIterator = NewFriendServiceImpl.access$100(this.b.a).iterator();
        while (localIterator.hasNext()) {
          ((INewFriendListener)localIterator.next()).bR_();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */