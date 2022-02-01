package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class KandianCustomSwitchRoomBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    KandianRoomSwitchService localKandianRoomSwitchService = new KandianRoomSwitchService();
    localKandianRoomSwitchService.onCreate(BaseApplicationImpl.context);
    localKandianRoomSwitchService.a(new KandianCustomSwitchRoomBuilder.1(this, paramServiceAccessor));
    return localKandianRoomSwitchService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianCustomSwitchRoomBuilder
 * JD-Core Version:    0.7.0.1
 */