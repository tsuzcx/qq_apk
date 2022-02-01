package com.tencent.mobileqq.location.net;

import android.util.Pair;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;

public abstract interface LocationShareVenueManager$VenueOptResultCallback
{
  public abstract Pair<LocationRoom.RoomKey, LocationRoom.Venue> a();
  
  public abstract void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareVenueManager.VenueOptResultCallback
 * JD-Core Version:    0.7.0.1
 */