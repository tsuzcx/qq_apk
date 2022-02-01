package com.tencent.mobileqq.location;

import com.tencent.mobileqq.friend.observer.FriendObserver;

class LocationShareRepository$2
  extends FriendObserver
{
  LocationShareRepository$2(LocationShareRepository paramLocationShareRepository) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    LocationShareRepository.a(this.a).a(paramBoolean, String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository.2
 * JD-Core Version:    0.7.0.1
 */