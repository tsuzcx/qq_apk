package com.tencent.mobileqq.location.util;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;

public class LocationReportUtil
{
  public static int a(LocationRoom.RoomKey paramRoomKey)
  {
    if (paramRoomKey == null) {}
    do
    {
      do
      {
        return 0;
        paramRoomKey = LocationHandler.a().a(paramRoomKey);
      } while (paramRoomKey == null);
      if (paramRoomKey.a() == null) {
        return 1;
      }
      if (paramRoomKey.a() == -1) {
        return 2;
      }
    } while (paramRoomKey.a() == -1);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.util.LocationReportUtil
 * JD-Core Version:    0.7.0.1
 */