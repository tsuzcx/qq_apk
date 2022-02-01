package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import java.util.List;

public abstract interface OnUpdateUserLocationListener
{
  public abstract void a(LocationRoom.RoomKey paramRoomKey, int paramInt);
  
  public abstract void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2);
  
  public abstract void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList);
  
  public abstract void b(LocationRoom.RoomKey paramRoomKey, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.OnUpdateUserLocationListener
 * JD-Core Version:    0.7.0.1
 */