package com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ODSwitchRoomBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ODRoomSwitchService localODRoomSwitchService = new ODRoomSwitchService();
    localODRoomSwitchService.onCreate(BaseApplicationImpl.context);
    localODRoomSwitchService.a(new ODSwitchRoomBuilder.1(this, paramServiceAccessor));
    return localODRoomSwitchService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODSwitchRoomBuilder
 * JD-Core Version:    0.7.0.1
 */