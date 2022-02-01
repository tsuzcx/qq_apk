package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class NowSwitchRoomBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    NowRoomSwitchService localNowRoomSwitchService = new NowRoomSwitchService();
    localNowRoomSwitchService.onCreate(BaseApplicationImpl.context);
    localNowRoomSwitchService.a(new NowSwitchRoomBuilder.1(this, paramServiceAccessor));
    return localNowRoomSwitchService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowSwitchRoomBuilder
 * JD-Core Version:    0.7.0.1
 */