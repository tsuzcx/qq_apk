package com.tencent.mobileqq.newfriend.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.newfriend.observer.NewFriendNotifyPokeObserver;

class NewFriendServiceImpl$3
  extends NewFriendNotifyPokeObserver
{
  NewFriendServiceImpl$3(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (NewFriendServiceImpl.access$000(this.a) != null)) {
      NewFriendServiceImpl.access$000(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */