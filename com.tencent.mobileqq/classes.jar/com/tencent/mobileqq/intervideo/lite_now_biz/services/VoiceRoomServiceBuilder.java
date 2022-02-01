package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class VoiceRoomServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    VoiceRoomService localVoiceRoomService = new VoiceRoomService();
    localVoiceRoomService.init(new VoiceRoomServiceBuilder.1(this, paramServiceAccessor));
    return localVoiceRoomService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomServiceBuilder
 * JD-Core Version:    0.7.0.1
 */