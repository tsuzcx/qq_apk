package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.LocationShareViewModel;

class LocationHandler$2
  extends FriendObserver
{
  LocationHandler$2(LocationHandler paramLocationHandler) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if ((paramBoolean) && ((paramObject instanceof Long))) {
      LocationShareViewModel.a(LocationHandler.a(this.a), 0, String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.2
 * JD-Core Version:    0.7.0.1
 */