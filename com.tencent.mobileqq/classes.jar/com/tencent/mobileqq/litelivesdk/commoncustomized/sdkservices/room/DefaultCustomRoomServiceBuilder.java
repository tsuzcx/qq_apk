package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class DefaultCustomRoomServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    DefaultCustomRoomService localDefaultCustomRoomService = new DefaultCustomRoomService();
    localDefaultCustomRoomService.init(new DefaultCustomRoomServiceBuilder.1(this, paramServiceAccessor));
    return localDefaultCustomRoomService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomServiceBuilder
 * JD-Core Version:    0.7.0.1
 */