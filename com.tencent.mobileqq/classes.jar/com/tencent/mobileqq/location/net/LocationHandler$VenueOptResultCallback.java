package com.tencent.mobileqq.location.net;

import android.util.Pair;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;

public abstract interface LocationHandler$VenueOptResultCallback
{
  public abstract Pair<LocationRoom.RoomKey, LocationRoom.Venue> a();
  
  public abstract void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.VenueOptResultCallback
 * JD-Core Version:    0.7.0.1
 */