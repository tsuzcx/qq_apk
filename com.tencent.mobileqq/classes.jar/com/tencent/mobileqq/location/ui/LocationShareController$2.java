package com.tencent.mobileqq.location.ui;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;

class LocationShareController$2
  extends FriendObserver
{
  LocationShareController$2(LocationShareController paramLocationShareController) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(LocationShareController.a(this.a).a())))
    {
      LocationShareController.a(LocationShareController.a(this.a), 0, String.valueOf(paramObject));
      if (LocationShareController.a(this.a) != null) {
        LocationShareController.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.2
 * JD-Core Version:    0.7.0.1
 */