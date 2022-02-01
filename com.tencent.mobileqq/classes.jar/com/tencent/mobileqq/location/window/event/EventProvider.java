package com.tencent.mobileqq.location.window.event;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import mqq.app.AppRuntime;

public class EventProvider
{
  private static final LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = new LocationRoom.RoomKey(-1, "-1");
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private LocationRoom.RoomKey b = jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  
  public EventProvider(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public LocationRoom.RoomKey a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.b = jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    this.b = paramRoomKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.event.EventProvider
 * JD-Core Version:    0.7.0.1
 */