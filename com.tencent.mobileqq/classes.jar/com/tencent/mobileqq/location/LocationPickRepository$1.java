package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import java.util.List;

class LocationPickRepository$1
  implements OnUpdateUserLocationListener
{
  LocationPickRepository$1(LocationPickRepository paramLocationPickRepository) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    LocationPickRepository.a(this.a).a(paramRoomKey);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    LocationPickRepository.a(this.a).a(paramRoomKey, paramInt1, paramInt2);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    LocationPickRepository.a(this.a).a(paramRoomKey, paramVenue, paramList);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    LocationPickRepository.a(this.a).a(paramRoomKey, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickRepository.1
 * JD-Core Version:    0.7.0.1
 */