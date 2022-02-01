package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import java.util.Iterator;
import java.util.LinkedList;

class NewFriendServiceImpl$6
  implements Runnable
{
  NewFriendServiceImpl$6(NewFriendServiceImpl paramNewFriendServiceImpl, int paramInt) {}
  
  public void run()
  {
    synchronized (NewFriendServiceImpl.access$100(this.this$0))
    {
      Iterator localIterator = NewFriendServiceImpl.access$100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((INewFriendListener)localIterator.next()).i_(this.a);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */