package com.tencent.mobileqq.newfriend.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class NewFriendNotifyPokeObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.observer.NewFriendNotifyPokeObserver
 * JD-Core Version:    0.7.0.1
 */