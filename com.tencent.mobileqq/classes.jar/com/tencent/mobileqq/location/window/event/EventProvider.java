package com.tencent.mobileqq.location.window.event;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import mqq.app.AppRuntime;

public class EventProvider
{
  private static final LocationRoom.RoomKey b = new LocationRoom.RoomKey(-1, "-1");
  private final AppRuntime a;
  private LocationRoom.RoomKey c = b;
  
  public EventProvider(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void a()
  {
    this.c = b;
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    this.c = paramRoomKey;
  }
  
  public LocationRoom.RoomKey b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.event.EventProvider
 * JD-Core Version:    0.7.0.1
 */